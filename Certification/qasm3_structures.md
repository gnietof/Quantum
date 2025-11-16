# QASM3 structures
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
- Bolean type takes values **true** or **false**.
- Measurements can be converted from **bit** to boolean using **bool()**.
```qasm
bit bt = 0;
bool bl = bool(bit);
```
## Compile time constants
### Built-in constants
- There are six identifiers automatically defined. Two for each of the constants $\pi$ ($\pi$ or pi), $\tau = 2\pi$ ($\tau$ or tau) and Euler's number e ($\mathcal{E}$ or euler).

### Built-in constant expression functions
- As for this reference, the important point is that there are a set of **compile-time funtions** which take **const** inputs and have a **const** output.

## Literals
- Five type of literals in QASM3: integer, float, boolean, bit string and timing.
- Integers can be written in decimal or hexadecimal, octal and binary adding a leading 0x/0X, 0o or 0b/0B prefix.
- Underscores might be used for readability.

## Arrays
- Arrays are declared using two arguments the first being the type and the second the size.
- Multidimensional arrays are allowed with a maximum of 7 dimensions.
- Arrays must be declared global and not inside a function.
- Negative indexes are allowed (same as Python)
- Valid types are bit, int, uint, float, complex, and angle, bool and duration but not stretch.
```qasm
array[int[32], 2] oneDim = {0, 1};
array[float[32], 3, 2] multiDim = {{1.1, 1.2}, {2.1, 2.2}, {3.1, 3.2}};

oneDim[0]=1
multiDim[1,2]=3

multiDim[0] = oneDim # myArray is copied in first element; sizes must match
oneDim = multiDim[0,0]
```
- The standard way of declaring quantum registers and bit registers are equivalent to the array syntax version.

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








