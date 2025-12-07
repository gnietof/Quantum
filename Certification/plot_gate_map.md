# Plot Gate Map
- Plots the gate map of a device.

## Examples
Plot the gate map of a real QPU. In this case ibm_fez.
```python
from qiskit_ibm_runtime import QiskitRuntimeService
from qiskit.visualization import plot_gate_map

service = QiskitRuntimeService()
backend = service.backend('ibm_fez')

plot_gate_map(backend)
```

<img width="1427" height="1322" alt="image" src="https://github.com/user-attachments/assets/7f2f98d0-ac5a-4ef2-94cf-ebbd097d4abf" />

```python
from qiskit.providers.fake_provider import GenericBackendV2
from qiskit.visualization import plot_gate_map
 
backend = GenericBackendV2(num_qubits=6)
 
plot_gate_map(backend)
```

<img width="151" height="165" alt="image" src="https://github.com/user-attachments/assets/f9abb52a-e24e-4b21-939b-497378893c06" />

You might even create custom backends. These custom backends are helpful to understand how different basis, coupling and error rates affect the transpiled circuit. Some examples I created for my own use are here [Custom Backends](../fake.ipynb) and here [Custom & Noisy Backends](../labs/custom_backends.md)
Below a simple backend with a custom coupling for a different gate plot.

```python
from qiskit.providers import BackendV2, Options
from qiskit.transpiler import Target, InstructionProperties, CouplingMap
from qiskit.circuit.library import CXGate, HGate, Measure, SwapGate

class MadridBackend(BackendV2):
    def __init__(self, qubits = 8, name = "Madrid"):
        super().__init__(name=name)

        # Target with qubits
        self._target = Target(num_qubits=qubits)

        # Add H (in all qubits)
        self._target.add_instruction(
            HGate(),
            {(i,): InstructionProperties(error=0.001) 
             for i in range(qubits)}
        )

        # Add CX (bidirectional in all qubits)
        self._target.add_instruction(
            CXGate(),
            {
                (0,4): InstructionProperties(error=0.001), 
                (2,6): InstructionProperties(error=0.001) 
            }            
        )
        
        # Add SWAP
        self._target.add_instruction(
            SwapGate(),
            {
                (i,(i+3) % qubits): InstructionProperties(error=0.001) 
                for i in range(qubits)
            } | {
                ((i+3) % qubits,i): InstructionProperties(error=0.001) 
                for i in range(qubits) 
            }        
        )
        
        # Add Measurements (in all qubits)
        self._target.add_instruction(
            Measure(),
            {(i,): InstructionProperties(error=0.001) for i in range(qubits)}
        )

    # Methods requiring implementation
    @classmethod
    def _default_options(cls):
        return Options()

    @property
    def max_circuits(self):
        return None   

    def run(self, run_input, **options):
        raise NotImplementedError("Transpilation-only backend.")

    @property
    def target(self):
        return self._target
```
If the basis or coupling are too restrictive for our circuit, the transpiler will fail.
```python
from qiskit.visualization import plot_gate_map

backend = MadridBackend()
plot_gate_map(backend)
```
<img width="154" height="154" alt="image" src="https://github.com/user-attachments/assets/d9cc5af0-c1b4-4284-8e35-ac923587f9ca" />

Note. These ones below are not included in the Objectives but I will mention then here. 

# Plot Circuit Map
- Plots how a circuit maps in the backend layout once transpiled.

 ## Example
The plot of a simple circuit in our custom backend would be.

```python
from qiskit import QuantumCircuit

qc = QuantumCircuit(2)
qc.h(0)
qc.cx(0,1)
qc.draw('mpl')
```
<img width="241" height="174" alt="image" src="https://github.com/user-attachments/assets/ad8bbf39-d430-44b9-8995-fde3bd5e1770" />

```python
from qiskit.transpiler import generate_preset_pass_manager

pm = generate_preset_pass_manager(backend)
qct = pm.run(qc)
qct.draw('mpl')
```
<img width="281" height="174" alt="image" src="https://github.com/user-attachments/assets/a34296ec-ec6a-431f-bc7d-10fabc324e41" />

This will plot,by default, our **virtual** qubits.
```python
from qiskit.visualization import plot_circuit_layout

plot_circuit_layout(qct,backend)
```
<img width="154" height="154" alt="image" src="https://github.com/user-attachments/assets/8ebb614a-36c2-4855-ab23-2ca1f5e5c2ee" />

We might also plot our **physical** qubits (how the virtual qubits were mapped into physical qubits).
```python
from qiskit.visualization import plot_circuit_layout

plot_circuit_layout(qct,backend,view='physical')
```
<img width="154" height="154" alt="image" src="https://github.com/user-attachments/assets/21fb80a6-5608-458f-8ea9-60f6e3c8cba1" />


# Plot Coupling Map

- Plots an arbitrary coupling map of qubits.

## Examples

We might create any coupling map. For example:
```python
edges = [(0,1),(1,0),(0,2),(2,0),(0,3),(3,0),(0,4),(4,0)]
plot_coupling_map(5,None,edges)
```
<img width="137" height="137" alt="image" src="https://github.com/user-attachments/assets/6211b1b2-e0f9-4bca-9e34-e182f65dba57" />

```python
edges = [(0,1),(0,2),(0,3),(0,4),(1,5),(5,2),(2,6),(6,3),(3,7),(7,4),(4,8),(8,1)]
plot_coupling_map(9,None,edges)
```
<img width="197" height="200" alt="image" src="https://github.com/user-attachments/assets/b4c90c0e-a07a-4e9e-8392-71d85cfedcc9" />

We might also plot the coupling map for a real or custom backend. For example, we might retrieve the coupling map for the previous custom backend. In fact, the ```CouplingMap```also has a ```draw``` method.

```python
from qiskit.transpiler import CouplingMap
from qiskit.visualization import plot_coupling_map

coupling = CouplingMap(backend.target.build_coupling_map())
coupling.draw()
```

<img width="302" height="278" alt="image" src="https://github.com/user-attachments/assets/7cf9732d-d4d5-401a-a3c1-bfa42640c251" />

If we want that coupling map displayed using the ```plot_coupling_map``` then:

```
from qiskit.visualization import plot_coupling_map

plot_coupling_map(coupling.size(),None,coupling.get_edges())
```
<img width="154" height="154" alt="image" src="https://github.com/user-attachments/assets/7c4ddaed-7346-4385-babd-9c590d916a1a" />

# Plot Error Map
- Plots the error map of a given backend.

# Examples
The error map for the real QPU we included above would be:

```python
from qiskit.visualization import plot_error_map

plot_error_map(backend)
```
<img width="1255" height="991" alt="image" src="https://github.com/user-attachments/assets/1bfd2fb5-3c2e-4a8f-9c92-b7bae9593fe3" />

And the error map for the custom backend we created:

<img width="1222" height="991" alt="image" src="https://github.com/user-attachments/assets/f855afe1-9c2c-4930-902a-34b72e6a399f" />

**Note**. Keep in mind that the error rates are displayed in percentage so 0.001 = 0.1%

We have not readout errors.


