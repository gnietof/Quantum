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


