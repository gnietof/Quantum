# QASM3 Semantics
There is not much content in this section for the certification. Most of the content is related with experimental features in QASM3.
So, the only important sections are the serialization and deserialization ones. 
Regarding other features in the QASM language and differences between QASM2 and QASM3, I compiled more details in this document [QASM Tips](../cheat/tips_qasm.md).

⚠️ While in the 'exploratory release period' for QASM 3.0, the optional module qiskit-qasm3-import must be installed.  

## Exporting to QASM3
The are two options for exporting a Qiskit code into QASM 3.0:

- qiskit.qasm3.dump*s*(qc): This one serializes in a string.
- qiskit.qasm3.dump(qc,f): This one serializes the circuit into a file.

An example for dumping into a file:  
```python
from qiskit.qasm3 import dump

with open('basic.qasm','w') as f:
    dump(qc,f)
```

## Importing from QASM3
The are only two options for importing QASM 3.0 into a Qiskit circuit:
- qc = qiskit.qasm3.load*s*(program): This one deserializes from a string.
- qc = qiskit.qasm3.load(f): This one deserializes the circuit from a file.
The number of qubits in the backend can be provided as num_qubits parameter.

An example for loading from a file. In this case we must provide a path and not a file handle.

```python
from qiskit.qasm3 import load

qc = load('basic.qasm')
```
The load and loads methods have an optional **num_qubits** parameter which provides the number of physical/virtual qubits.
