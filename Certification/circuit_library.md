# Circuit Library

- The circuit library is a collection of circuits and building blocks.
- Elements in the circuit library are either QuantumCircuits or Instructions, allowing them to be easily investigated or plugged into other circuits.

- There are different categories of operations:  
  **Standard gates**
  - These are fundamental quantum gates, a subset of which typically forms a basis gate set on a quantum computer.
  - These are unitary operations represented as Gate.
  - The library also provides standard compiler directives (a Barrier) and non-unitary operations (like Measure).
  
  **Abstract operations**  
  - This category includes operations that are defined by a mathematical action, but can be implemented with different decompositions.
  - An example is the multi-controlled XGate which has a variety of concrete circuits implementing this operation using lower-level gates.

  **Structural operations**
  - This operations have a unique decomposition.
  - They are implemented as functions that return a QuantumCircuit.

## Standard gates
- These operations are reversible unitary gates.
- They all subclass Gate and have the methods to_matrix(), power(), and control().

### 1-qubit standard gates
- Pauli: XGate, YGate, ZGate
- Hadamard: HGate
- Identity: IGate
- Rotation: RGate, RXGate, RYGate, RZGate, SGate, SdgGate, SXGate, SXdgGate, TGate, TdgGate, UGate, U1Gate, U2Gate, U3Gate

### 2-qubit standard gates
- Controlled Pauli: CXGate, CYGate, CZGate
- Controlled Hadamard: CHGate
- Controlled rotations: CRXGate, CRYGate, CRZGate, CSGate, CSdgGate, CSXGate, CSXdgGate, CUGate, CU1Gate, CU2Gate, CU3Gate, RXXGate, RYYGate, RZZGate
- Other: DCXGate (double CNOT), ECRGate (Echoed Cross-Resonance), SwapGate, XXMinusYYGate, XXPlusYYGate

### 3+-qubit standard gates
- C3SXGate, C3XGate, C4XGate, CCXGate (Toffoli), CCZGate, CSwapGate, RCCXGate (Margolous), RC3XGate (simplified 3-controlled Toffoli)
  
### Global Standard gates 
- GlobalPhaseGate (this is the only one which takes no qubit arguments)

## Standard directives
- Directives are operations to the quantum stack that are meant to be interpreted by the backend or the transpiler.
- Barrier

## Standard operations
- Operations which are non-reversible changes in the quantum state of the circuit.
- Measure, Reset

## Generalized gates
- This module extends the standard gates with a broader collection of basic gates. This includes gates that are variadic, meaning that the number of qubits depends on the input. 

## Boolean logic
- These Gates implement boolean logic operations, such as the logical or of a set of qubit states.
- AndGate, OrGate, BitwiseXorGate, InnerProductGate

## Basis changes
- These gates perform basis transformations of the qubit states.
- QFTGate. Quantum Fourier Transform (QFT), transforms between the computational basis and the Fourier basis.

## Arithmetic operations
- These gates and circuits perform classical arithmetic, such as addition or multiplication.
- Adders: ModularAdderGate, HalfAdderGate, FullAdderGate
- Multipliers: MultiplierGate
- Amplitude functions: LinearAmplitudeFunctionGate
- Functional Pauli Rotations: LinearPauliRotationGate, PolynomialPauliRotationsGate, PiecewiseLinearPauliRotationsGate, PiecewisePolynomialPauliRotationsGate, PiecewiseChebyshevGate
- Other: ExactReciprocalGate, IntegerComparatorGate, QuadraticFormGate, WeightedSumGate

## Data encoding
These functions return a parameterized QuantumCircuit to use as data encoding circuits in a series of variational quantum algorithms.

## Data preparation
These operations are used for state preparation.

## Particular operations
These gates and quantum circuits define specific operations of interest such as Grover o Fourier.

## N-local circuits
- The following functions return a parameterized QuantumCircuit to use as ansatz in a broad set of variational quantum algorithms.

## Oracles
- An “oracle” can refer to a variety of black-box operations on quantum states.

## Template circuits
- Templates are functions that return circuits that compute the identity. They are used at circuit optimization where matching part of the template allows the compiler to replace the match with the inverse of the remainder from the template.
