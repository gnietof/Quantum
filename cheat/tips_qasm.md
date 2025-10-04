# QASM
Let's start with an easy one: QASM stands for Quantum Assembler (although it is not as low level as real assembler like the one in 6502/6510 or Z80).

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

- qiskit.qasm3.dump*s*(qc): This one serializes into a string.
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

## Differences between QASM 2.0 and QASM 3.0
Someone said that if you are preparing for the Qiskit 2.x certification, some knowledge of QASM is required and questions covered differences between the two versions of that *language*.

So I have prepared a table with the main differences.

⚠️ The QASM3 support in Qiskit is currently limited. In fact, the Quantum Composer still uses QASM2. So, building a circuit is not an option as many of the *interesting* features are not supported. For example, currently this block is not valid:
```
OPENQASM 3.0;
include "stdgates.inc";
bit[10] c;
qubit[10] q;

for int i in [0:8] {
    ch q[9], q[i];
}
```
This is an interesting resource for understanding current support of different features: [https://qiskit.qotlabs.org/docs/guides/qasm-feature-table](https://quantum.cloud.ibm.com/docs/en/guides/qasm-feature-table)

### General Syntax

| QASM2 | QASM 3 |
|-------|--------|
| OPENQASM 2.0;<br>include "qelib1.inc"; | OPENQASM 3.0;<br>include "stdgates.inc"; |
| The include file is mandatory. | The include file is **optional**. |
| No block scoping, conditionals, or complex typing. | Introduces semicolon-free blocks and better syntax rules. |

### Classical Types & Variables

| QASM2 | QASM 3 |
|-------|--------|
| Only qreg and creg.<br>No classical variable types. | Introduces uint, int, float, bool, bit, angle and complex |
| You can declare arrays of qreg and creq. | Arrays of any type. |

One thing I find confusing in the notation is that you have to declare the precission for each int, float, angle and complex (1,2,4,8,16,32,64... bits). But then, if you have an array ...
```
qubit[5] qq      # A 5-qubit register (treated as an array)
bit[5] bb        # A 5-bit classical register (treated as an array)
int[32] i        # A single 32 bit integer
int[32] ii[10]   # An array of 10 32 bit integers
```
Another thing to take into account is that, for example, the range for a int[4] is [-8, 7] and not [0,15].

Classical registers, bit, uint and angle suppport bitwise operators (and &, or | and xor ^ but also right >> and left << shifts) and assignment operators with reigsters of the same size.

These language has similarities with Java, C and Python. Comments in QASM are like in Java or C/C++ and not like in Python.
Loops are declared in a way more similar to Python (except for the block indicator) but beware that:
```
for int i in [0:5] {  // Loop goes from 0 to **5**
}
```
Is not the same as:
```python
for int i in range(5):  # Loop goes from 0 to **4**
    pass
```








