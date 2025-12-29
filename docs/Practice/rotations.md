---
layout: default
title: Qiskit 2.x Practice Exam (Rotations)
---

<h1>Qiskit 2.x Practice Exam (Rotations)</h1>

1. Given the following code fragment what is the probability that a measurement would result in a value of 1?  
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Statevector
import numpy as np

qc = QuantumCircuit(1)
qc.rx(np.pi/2,0)
```
<div style="margin-left: 2em;">
  <ol type="A">
    <li>0</li>
    <li>0.146</li>
    <li>0.5</li> <-
    <li>0.853</li>
    <li>1</li>
  </ol>
</div>

2. Given the following code fragment what is the probability that a measurement would result in a value of 1?  
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Statevector
import numpy as np

qc = QuantumCircuit(1)
qc.ry(np.pi/4,0)
```
<div style="margin-left: 2em;">
  <ol type="A">
    <li>0</li> 
    <li>0.146</li> <-
    <li>0.5</li>
    <li>0.853</li>
    <li>1</li> 
  </ol>
</div>

3. Given the following code fragment what is the probability that a measurement would result in a value of 1?  
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Statevector
import numpy as np

qc = QuantumCircuit(1)
qc.h(0)
qc.rz(np.pi/4,0)
```
<div style="margin-left: 2em;">
  <ol type="A">
    <li>0</li>
    <li>0.146</li>
    <li>0.5</li> <-
    <li>0.853</li>
    <li>1</li>
  </ol>
</div>

4. Given the following code fragment what is the probability that a measurement would result in a value of 1?  
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Statevector
import numpy as np

qc = QuantumCircuit(1)
qc.z(0)
```
<div style="margin-left: 2em;">
  <ol type="A">
    <li>0</li> <-
    <li>0.146</li> 
    <li>0.5</li>
    <li>0.853</li>
    <li>1</li> 
  </ol>
</div>

5. Given the following code fragment what is the probability that a measurement would result in a value of 0?  
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Statevector
import numpy as np

qc = QuantumCircuit(1)
qc.x(0)
qc.y(0)
```
<div style="margin-left: 2em;">
  <ol type="A">
    <li>0</li> 
    <li>0.146</li> 
    <li>0.5</li>
    <li>0.853</li>
    <li>1</li> <-
  </ol>
</div>






