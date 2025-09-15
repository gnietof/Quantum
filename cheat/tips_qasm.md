# QASM

## Serialization
The are two options for serializing a Qiskit code into QASM 2.0:

- qiskit.qasm2.dump*s*(qc): This one serializes in a string.
- qiskit.qasm2.dump(qc,f): This one serializes the circuit into a file.

An example for dumping into a file:  
```python
from qiskit.qasm2 import dump

with open('basic.qasm','w') as f:
    dump(qc,f)
```

For QASM 3.0, same functions in a different package:

- qiskit.qasm3.dump*s*(qc): This one serializes in a string.
- qiskit.qasm3.dump(qc,f): This one serializes the circuit into a file.

## Deserialization

The are also two options for deserializing QASM 2.0 into a Qiskit circuit:

- qiskit.qasm2.load*s*(qc): This one deserializes from a string.
- qiskit.qasm2.load(qc,f): This one deserializes the circuit from a file.

An example for loading from a file. In this case we must provide a path and not a file handle.

```python
from qiskit.qasm2 import load

qc = load('basic.qasm')
```

⚠️ Keep in mind that although serialization is included in Qiskit 2.x, deserialization for QASM 3.0 requires the installation of an optimal module (```pip install qiskit-qasm3-import```).  

For QASM 3.0, same functions in a **different package** (not just qasm2 → qasm3):

- qiskit_qasm3_import.load*s*(qc): This one deserializes from a string.
- qiskit_qasm3_import.load(qc,f): This one deserializes the circuit from a file.
