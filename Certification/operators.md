# Overview of operator classes
- In Qiskit, quantum operators are represented using classes from the quantum_info module.
- The most important operator class is SparsePauliOp, which represents a general quantum operator as a linear combination of Pauli strings. SparsePauliOp is the class most commonly used to represent quantum observables.

## SparsePauliOp
- The SparsePauliOp class represents a linear combination of Pauli strings.
- There are several ways to initialize a SparsePauliOp, but the most flexible way is to use the from_sparse_list method. The from_sparse_list accepts a list of (pauli_string, qubit_indices, coefficient) triplets.
- Is it is possible to operate with SparsePauliOp instances (sum, product, matrix product (@) or tensor product).

# Pauli
- The Pauli class represents a single Pauli string with an optional phase coefficient from the set ```{ +1,i,−1,−i }```.
- A Pauli can be initialized by passing a string of characters from the set {"I", "X", "Y", "Z"}, optionally prefixed by one of {"", "i", "-", "-i"} to represent the phase coefficient.
- Pauli objects possess a number of other methods to manipulate the operators such as determining its adjoint, whether it (anti)commutes with another Pauli, and computing the dot product with another Pauli.

# Operator
- The Operator class represents a general linear operator.
- Unlike SparsePauliOp, Operator stores the linear operator as a dense matrix. Because the memory required to store a dense matrix scales exponentially with the number of qubits, the Operator class is only suitable for use with a small number of qubits.
- An Operator can be created by directly passing a Numpy array storing the matrix of the operator. 
