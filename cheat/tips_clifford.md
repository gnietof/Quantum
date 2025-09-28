# Clifford 

Clifford circuits are a special class of quantum circuits built entirely from Clifford gates, which are gates that map Pauli operators to other Pauli operators under conjugation: H, S, X, Y, Z, CNOT.

An N-qubit unitary operator from the Clifford group is stored as a length 2N × (2N+1) boolean tableau using the convention:
    - Rows 0 to N-1 are the destabilizer group generators
    - Rows N to 2N-1 are the stabilizer group generators.

An example of a Clifford random circuit generated with the random_clifford statement:

```python
from qiskit.quantum_info import random_clifford

clifford = random_clifford(3)
qc = clifford.to_circuit()
qc.draw('mpl')
```
!['random clifford'](../images/Clifford.png)

A *print* of this variable displays the stabilizer and destabilizer. They can also be retrieved using the **to_labels(mode='S')** and **to_labels(mode='D')** methods.

```python
print(clifford)
```

```
Clifford: Stabilizer = ['-ZZX', '-YYI', '-XZY'], Destabilizer = ['+ZZZ', '+IZI', '-YIY']
```

Whereas a display shows the tableau:
```python
display(clifford)
```

```
Clifford(array([[False, False, False,  True,  True,  True, False],
       [False, False, False, False,  True, False, False],
       [ True, False,  True,  True, False,  True,  True],
       [ True, False, False, False,  True,  True,  True],
       [False,  True,  True, False,  True,  True,  True],
       [ True, False,  True,  True,  True, False,  True]]))
```
