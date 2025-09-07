# ⚠️ Work in Progress!
I still have to figure out which are the ones still available in Qiskit 2.x!

# Changes in Qiskit 2.x 

## Simulation
Simulation has changed in each release of Qiskit. So the code required for each version is shown below.

### Qiskit 0.x

```python
from qiskit import QuantumCircuit, Aer, execute

backend = Aer.get_backend("qasm_simulator")
job = execute(qc, backend=backend, shots=1024)
result = job.result()
```

### Qiskit 1.x

```python
from qiskit_aer import AerSimulator

simulator = AerSimulator()
job = simulator.run(qc, shots=1024)
result = job.result()
```

### Qiskit 2.x
```python
from qiskit_aer import AerSimulator

simulator = AerSimulator(method="automatic") 
job = simulator.run(qc, shots=1024)
result = job.result()
```` 
