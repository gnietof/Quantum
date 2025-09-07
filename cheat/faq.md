- How obtain the unitary matrix of a given circuit?
```python
from qiskit.quantum_info import Operator

U = Operator(qc)
U / U.data / U.draw(‘text’ / ‘latex’ / ’latex_source’)
```
- How many simulator types are included in Aer?
statevector_simulator, qasm_simulator
