# Overview of operator classes
- In Qiskit, quantum operators are represented using classes from the quantum_info module.
- The most important operator class is SparsePauliOp, which represents a general quantum operator as a linear combination of Pauli strings. SparsePauliOp is the class most commonly used to represent quantum observables.

## SparsePauliOp
- The SparsePauliOp class represents a linear combination of Pauli strings.
- There are several ways to initialize a SparsePauliOp, but the most flexible way is to use the from_sparse_list method. The from_sparse_list accepts a list of (pauli_string, qubit_indices, coefficient) triplets.
- Is it is possible to operate with SparsePauliOp instances (sum, product, matrix product (@) or tensor product).

### Examples
- Using the constructor.
  - All these combinations are valid.
  - The number of bits in each Pauli has to be the same. The number of coefficients and Paulis has also to be one or match the number of Pauli strings.
  - Lists and tuples are accepted.
```python
from qiskit.quantum_info import SparsePauliOp

SparsePauliOp('XYZ',2)

SparsePauliOp(['XYZ','IZX'],2)

SparsePauliOp(('XYZ','IZX'),(1,2))

SparsePauliOp(['XYZ','IZX'],[1,2])

SparsePauliOp(['XYZ','IZX'],(1,2))
```
- Using the ```from_sparese_list```method.
  - All these combinations are valid.
  - Not all the Pauli strings need to be the same length as long as the maximum length is equal or less than the ```num_qubits```. 
```python
from qiskit.quantum_info import SparsePauliOp

SparsePauliOp.from_sparse_list([('XZ',[1,3],2),('ZY',[0,2],1j),],num_qubits=4)
```
SparsePauliOp(['ZIXI', 'IYIZ'],
              coeffs=[2.+0.j, 0.+1.j])
```python
SparsePauliOp.from_sparse_list([('XZY',[1,3,2],2),('ZY',[0,2],1j),],num_qubits=4)
```
SparsePauliOp(['ZYXI', 'IYIZ'],
              coeffs=[2.+0.j, 0.+1.j])



# Pauli
- The Pauli class represents a single Pauli string with an optional phase coefficient from the set ```{ +1,i,−1,−i }```.
- A Pauli can be initialized by passing a string of characters from the set {"I", "X", "Y", "Z"}, optionally prefixed by one of {"", "i", "-", "-i"} to represent the phase coefficient.
- Pauli objects possess a number of other methods to manipulate the operators such as determining its adjoint, whether it (anti)commutes with another Pauli, and computing the dot product with another Pauli.

## Examples
- All these are valid examples for 'XYZ'.
```python
from qiskit.quantum_info import Pauli

Pauli('XYZ')
Pauli(([1,1,0],[0,1,1]))

Pauli(([1,1,0],[0,1,1],0))

```
- All these are valid for Y.
```python
from qiskit.quantum_info import Pauli

Pauli('Y')

Pauli(([1],[1]))

Pauli(([True],[True]))

-1j * Pauli('Z') @ Pauli('X') # ZX = iY -> -iZX = Y
```
# Operator
- The Operator class represents a general linear operator.
- Unlike SparsePauliOp, Operator stores the linear operator as a dense matrix. Because the memory required to store a dense matrix scales exponentially with the number of qubits, the Operator class is only suitable for use with a small number of qubits.
- An Operator can be created by directly passing a Numpy array storing the matrix of the operator.

## Examples
- All these are valid ways to declare 'ZX'.

```python
from qiskit.quantum_info import Operator

Operator.from_label('ZX')

Operator.from_label('Z').tensor(Operator.from_label('X'))

Operator(np.array([[0,1,0,0],[1,0,0,0],[0,0,0,-1],[0,0,-1,0]]))

from qiskit import QuantumCircuit
qc = QuantumCircuit(2)
qc.x(0)
qc.z(1)
Operator.from_circuit(qc)
```
```
Operator([[ 0.+0.j,  1.+0.j,  0.+0.j,  0.+0.j],
          [ 1.+0.j,  0.+0.j,  0.+0.j,  0.+0.j],
          [ 0.+0.j,  0.+0.j,  0.+0.j, -1.+0.j],
          [ 0.+0.j,  0.+0.j, -1.+0.j,  0.+0.j]],
         input_dims=(2, 2), output_dims=(2, 2)
```

- All these are valid ways to declare 'Y'.

```python

Operator.from_label('Z').dot(Operator.from_label('X'))

Operator.from_label('Z') @ Operator.from_label('X')

Operator(np.array([[0,-1j],[1j,0]]))

from qiskit import QuantumCircuit
qc = QuantumCircuit(1)
qc.y(0)
Operator.from_circuit(qc)

```
```
Operator([[0.-0.j, 0.-1.j],
          [0.+1.j, 0.-0.j]],
         input_dims=(2,), output_dims=(2,))
```
