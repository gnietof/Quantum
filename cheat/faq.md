- How obtain the unitary matrix of a given circuit?
```python
from qiskit.quantum_info import Operator

U = Operator(qc)
U / U.data / U.draw(‘text’ / ‘latex’ / ’latex_source’)
```
- How many simulator types are included in Aer?
statevector_simulator, qasm_simulator

- How obtain the statevector of one circuit?  
The statevector is the ressult of applying the \ket{0} If we have one circuit defined:
```python
from qiskit import QuantumCircuit

qc = QuantumCircuit(2)
qc.h(0)
qc.cx(0,1)
qc.draw('mpl')
```
Then we can obtain the statevector using this method:  
```python
from qiskit_aer import AerSimulator

backend = AerSimulator()
qc.save_statevector()

job = backend.run(qc)
result = job.result()
output = result.get_statevector(qc)
output.draw('latex')  
```
The ouput will be displayed using Dirac notation:  
<img width="139" height="64" alt="image" src="https://github.com/user-attachments/assets/9f62e75b-7485-4def-83ec-969e2dc437dd" />  
We may also use the array_to_latex method:
```python
from qiskit.visualization import array_to_latex
statevector = array_to_latex(output)
```
In this case we get the vector:  
<img width="140" height="51" alt="image" src="https://github.com/user-attachments/assets/a8f324d9-5f8c-4f52-b1e4-9c8fb2e6e22d" />  
