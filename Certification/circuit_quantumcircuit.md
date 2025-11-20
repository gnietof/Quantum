# Circuit QuantumCircuit
I will just cover here properties or methods which might be useful for the certification. 
- data. Prints a structure with all the information stored in the QuantumCircuit.
- global_phase. The global phase of the current circuit scope in radians.
- name. The name of the circuit. Provided as a named parameter in the constructor.
- qregs / qubits. A list of qubits in the order they were added.
- num_qubits. The number of qubits.
- cregs / clbits.  A list of classical bits in the order they were added.
- num_cregs. The number of classical bits.
- ancillas. A list of ancilla qubits in the order they were added.
- num_ancillas. The number of ancilla qubits.
- parameters. The parameters defined in this circuit sorted alphabetically.
- layout. The layout of this circuit once the transpilation has been performed.

## Creation
- QuantumCircuits can be created from scratch using the constructor or from a QASM circuit or string (**load** / **loads**).

- The **from_instructions** allows the creation of the circuit by providing a list of instructions. Even if qubit names are provided I have not been able to have them visualised.
```python
from qiskit import QuantumRegister,QuantumCircuit
from qiskit.circuit.library import HGate,CXGate
qr = QuantumRegister(2,"q")
h_gate = (HGate(),[qr[0]],[])
cx_gate = (CXGate(),[qr[0],qr[1]],[])
instructions=[]
instructions.append(h_gate)
instructions.append(cx_gate)

qc = QuantumCircuit.from_instructions(instructions)
qc.draw('mpl')
```
<img width="180" height="125" alt="image" src="https://github.com/user-attachments/assets/eccc3e88-9c2c-472d-a31f-1faa9d5da6ab" />

- We can also **copy** / **copy_empty_like**. copy copies the whole circuit while copy_empty_like copies only the properties. In this case the name of the qubits is maintained.
```python
qc2 = qc1.copy_empty_like()
qc2.draw('mpl')
```
<img width="98" height="104" alt="image" src="https://github.com/user-attachments/assets/b52d41d7-ce13-4849-9724-6a9647e78933" />

## Data Objects

### Adding

