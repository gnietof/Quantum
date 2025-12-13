# Operator Class

## Convert classes to Operators
- Several other classes in Qiskit can be directly converted to an Operator object using the operator initialization method. 
  - Pauli objects
  - Gate and Instruction objects
  - QuantumCircuit objects

- Note that the last point means you can use the Operator class as a unitary simulator to compute the final unitary matrix for a quantum circuit, without having to call a simulator backend.
- If the circuit contains any unsupported operations, an exception is raised. Unsupported operations are: measure, reset, conditional operations, or a gate that does not have a matrix definition or decomposition in terms of gate with matrix definitions.

## Use Operators in circuits
- Unitary Operators can be directly inserted into a QuantumCircuit using the QuantumCircuit.append method.
- This converts the Operator into a UnitaryGate object, which is added to the circuit.
- If the operator is not unitary, an exception is raised. This can be checked using the Operator.is_unitary() function, which returns True if the operator is unitary and False otherwise.

## Combine Operators
- Operators may be combined using several methods.
### Tensor product
- Two operators $A$ and $B$ can be combined into a tensor product operator $A \otimes B$ using the Operator.tensor function. 
- Note that if both $A$ and $B$ are single-qubit operators, then A.tensor(B) = $A \otimes B$ will have the subsystems indexed as matrix $B$ on subsystem 0, and matrix $A$ on subsystem 1.
### Tensor expansion
- A closely related operation is Operator.expand, which acts like a tensor product but in the reverse order.
- Hence, for two operators $A$ and $B$ you have A.expand(B) = $B \otimes A$ where the subsystems are indexed as matrix $A$ on subsystem 0, and matrix $B$ on subsystem 1.
### Composition
- You can also compose two operators $A$ and $B$ to implement matrix multiplication using the Operator.compose method. A.compose(B) returns the operator with matrix B.A.
- You can also compose in the reverse order by applying $B$ in front of $A$ using the front kwarg of compose: A.compose(B, front=True) = A.B:
### Subsystem composition
- Note that the previous compose requires that the total output dimension of the first operator $A$ is equal to the total input dimension of the composed operator $B$ (and similarly, the output dimension of $B$ must be equal to the input dimension of $A$ when composing with front=True).
- You can also compose a smaller operator with a selection of subsystems on a larger operator using the qargs kwarg of compose, either with or without front=True.
- In this case, the relevant input and output dimensions of the subsystems being composed must match. Note that the smaller operator must always be the argument of the compose method.
### Linear combinations
- Operators may also be combined using standard linear operators for addition, subtraction, and scalar multiplication by complex numbers.
- An important point is that while tensor, expand, and compose preserves the unitarity of unitary operators, linear combinations do not; hence, adding two unitary operators will, in general, result in a non-unitary operator.
### Implicit conversion to Operators
- Note that for all the following methods, if the second object is not already an Operator object, it is implicitly converted into one by the method.
- This means that matrices can be passed in directly without being explicitly converted to an Operator first.
- If the conversion is not possible, an exception is raised.

## Compare Operators
- Operators implement an equality method that can be used to check if two operators are approximately equal.
- Note that this checks that each matrix element of the operators is approximately equal; two unitaries that differ by a global phase are not considered equal.
### Process fidelity
- You can also compare operators using the ```process_fidelity``` function from the Quantum Information module.
- This is an information-theoretic quantity for how close two quantum channels are to each other, and in the case of unitary operators it does not depend on global phase.
