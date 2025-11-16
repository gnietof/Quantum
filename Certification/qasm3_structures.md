# QASM structures
This is a long document. I will cover here only the points which I think are important for the certification.

## Identifiers
- Valid identifieds are basically all those starting with a letter [A-Z,a-z] or an undescore. The rest of the characters must be [A-Z,a-z,0-9]

## Variables
- The naming follows the same rule than the one for identifiers.
- Variables must be declared one at a time.
- The notation s:m:f is used to denote the width and precission of fixed point numbers (s = sign bits, m = integer bits, f fractional bits).

## Quantum Types
### Qubits
- ```qubit name``` declares a reference to a quantum bit. These are virtual qubits.
- ```qubit[size] name``` declares a reference to a quantum register with size qubits.
- Qubits are initially undefined. A **reset** operation is one way to initialize them.

### Physical qubits
- Hardware qubits are refrenced with the syntax $[NUM] ($0,$1,...). They must not be declared.

## Classical scalar types

### Classical bits and registers
### Integers
###
### Floating point numbers
### Void type
### Angles
### Complex numbers
### Boolean types

## Compile time constants
### Built-in constants

### Built-in constant expression functions

## Literals

## Arrays

## Types related to timing

### Duration

### Stretch

## Aliasing

The **let** keyword allows quantum bits and registers be referred by another name.
```qasm
qubit[5] q;
let myreg = q[1:4] # Now myreg[0] points to q[1]
```


## Index sets and slicing
### Register concatenation and slicing

### Classical value bit slicing

### Array concatenation and slicing

## Casting
I will not cover this section now. I think is too specific for the certification exam.








