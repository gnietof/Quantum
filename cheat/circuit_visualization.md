# Circuit Visualization

## Circuit Layout
- Circuit layout displays how the transpiled circuit will be mapped either to physical or virtual qubits.
  
### Example
- We generate a big random cirtuit.

```python
from qiskit.circuit.random import random_circuit

qc = random_circuit(32,8, max_operands=2)
qc.draw('mpl',fold = False)
```

<img width="3067" height="1062" alt="image" src="https://github.com/user-attachments/assets/a5b4e09c-37d8-41d5-9af3-2142ed97bc2e" />

- We look for an available QPU server.

```python
from qiskit_ibm_runtime import QiskitRuntimeService

service = QiskitRuntimeService()
backend = service.least_busy()
```

- Now we transpile the circuit for that QPU.

```python
from qiskit import transpile

qt = transpile(qc,backend=backend)
qt.draw('mpl',fold = False)
```

<img width="30885" height="2310" alt="image" src="https://github.com/user-attachments/assets/773b1114-d417-468f-87cb-c05ecc08b207" />

Just out of curiosity, this circuit which initially had a depth of 8 (as requested) after transpilation has a depth of 415!!

- And finally we display the layout of this circuit in our QPU.

```python
from qiskit.visualization import plot_circuit_layout

plot_circuit_layout(qt,backend)
```

<img width="1427" height="1322" alt="image" src="https://github.com/user-attachments/assets/cc6e55ec-94d8-4430-a07e-3675ef927dc3" />




