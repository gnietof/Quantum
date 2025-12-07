# Custom & Noisy Backends
In this document I will be creating a custom backend with a small number of qubits and different basis, coupling and error rates to see how the transpiler deals with those restrictions.
First we will be defining our custom Backend. Hadamard, CNOT, Swap gates have be

```python
from qiskit.providers import BackendV2, Options
from qiskit.transpiler import Target, InstructionProperties, CouplingMap
from qiskit.circuit.library import CXGate, CZGate, HGate, Measure, SwapGate

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

        # Add CX
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

With that definition we get the following gate plot.

```python
from qiskit.visualization import plot_gate_map

plot_gate_map(backend)
```
<img width="154" height="154" alt="image" src="https://github.com/user-attachments/assets/b55da57f-a639-4612-9b3e-b41d8bfdf35d" />

We will use this simple circuit for testing.
```python
from qiskit import QuantumCircuit

qc = QuantumCircuit(2)
qc.h(0)
qc.cx(0,1)
qc.cx(1,0)
qc.draw('mpl')
```
<img width="305" height="174" alt="image" src="https://github.com/user-attachments/assets/1d358c15-43aa-4a5e-9892-f5aac80dc6a1" />

We will now prepare our PassManager.

```from qiskit.transpiler import generate_preset_pass_manager

pm = generate_preset_pass_manager(backend)
qct = pm.run(qc)
qct.draw('mpl')
```
That was a nice gate plot ... but is too restrictive.

<img width="811" height="62" alt="image" src="https://github.com/user-attachments/assets/989e5e8d-9ba8-42cf-bdfa-2141e2fd53d1" />

We will be adding a slightly less restrictive coupling.
```python
        CXGate(),
            {
                (0,4): InstructionProperties(error=0.001), 
                (4,0): InstructionProperties(error=0.001), 
                (2,6): InstructionProperties(error=0.001),
                (6,2): InstructionProperties(error=0.001) 
            }            
        )
```
The transpiled circuit shows how the physical bits have been reassigned to match the layout.
<img width="346" height="174" alt="image" src="https://github.com/user-attachments/assets/19141a49-2c10-40f2-b75f-3bde39f9dba1" />

If we set a higher error rate to the CX(0,4) and CX(4,0) than CX(2,6) and CX(6,2) the transpiler automatically reassigns the physical qubits
```python
        CXGate(),
            {
                (0,4): InstructionProperties(error=0.001), 
                (4,0): InstructionProperties(error=0.001), 
                (2,6): InstructionProperties(error=0.0001),
                (6,2): InstructionProperties(error=0.0001) 
            }            
        )
```
<img width="346" height="174" alt="image" src="https://github.com/user-attachments/assets/b2d7abdd-64f5-4399-b8c0-3cdd148b675e" />

We will now be redefining the basis in our backend by removing the CNOT gates (# Add CX) and adding CZ gates instead.
```python
        # Add CZ
        CXGate(),
            {
                (0,4): InstructionProperties(error=0.001), 
                (4,0): InstructionProperties(error=0.001), 
                (2,6): InstructionProperties(error=0.001),
                (6,2): InstructionProperties(error=0.001) 
            }            
        )
```

The transpiled circuit adapts to the new restrictions:
<img width="474" height="174" alt="image" src="https://github.com/user-attachments/assets/7e121c9e-313d-4269-bd99-b45b9e93f4b7" />


