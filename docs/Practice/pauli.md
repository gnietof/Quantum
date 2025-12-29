---
layout: default
title: Qiskit 2.x Practice Exam (Rotations)
---

<h1>Qiskit 2.x Practice Exam (Pauli)</h1>

1. Which Pauli operator can a user expect when running the following circuit?
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Pauli

qc = QuantumCircuit(1)
qc.z(0)
qc.x(0)
qc.y(0)
qc.y(0)
qc.x(0)
qc.z(0)
```
<div style="margin-left: 2em;">
  <ol type="A">
    <li>Pauli("I")</li> <-
    <li>Pauli("X")</li> 
    <li>Pauli("Y")</li> 
    <li>Pauli("Z")</li> 
  </ol>
</div>

2. Which Pauli operator can a user expect when running the following circuit?
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Pauli

qc = QuantumCircuit(1)
qc.z(0)
qc.x(0)
qc.y(0)
qc.y(0)
qc.x(0)
qc.z(0)
```
<div style="margin-left: 2em;">
  <ol type="A">
    <li>Pauli("I")</li> 
    <li>Pauli("X")</li> 
    <li>Pauli("Y")</li> 
    <li>Pauli("Z")</li> 
  </ol>
</div>


3. Which Pauli operator can a user expect when running the following circuit?
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Pauli

qc = QuantumCircuit(1)
qc.y(0)
qc.x(0)
qc.y(0)
qc.x(0)
qc.y(0)
qc.x(0)
qc.y(0)
```
<div style="margin-left: 2em;">
  <ol type="A">
    <li>Pauli("I")</li> 
    <li>Pauli("X")</li> <-
    <li>Pauli("Y")</li> 
    <li>Pauli("Z")</li> 
  </ol>
</div>

4. Which Pauli operator can a user expect when running the following circuit?
```python
from qiskit import QuantumCircuit
from qiskit.quantum_info import Pauli

qc = QuantumCircuit(1)
qc.x(0)
qc.y(0)
qc.z(0)
```
<div style="margin-left: 2em;">
  <ol type="A">
    <li>Pauli("I")</li> 
    <li>Pauli("-iI")</li> <-
    <li>Pauli("Y")</li> 
    <li>Pauli("H")</li> 
  </ol>
</div>
