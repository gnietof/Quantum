---
layout: default
title: Qiskit 2.x Practice Exam (Rotations)
---

1. Given the following code fragment what is the approximate probability that a measurement would result in a bit value of 1?
   
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Statevector
import numpy as np

qc = QuantumCircuit(1,1)
qc.rx(np.pi/2,0)
```

sv = Statevector.from_instruction(qc)
sv3. 
