# Circuit Library
- The Qiskit SDK includes a library of popular circuits to use as building blocks in your own programs.
- Using pre-defined circuits saves time researching, writing code, and debugging.
- The library includes popular circuits in quantum computing, circuits that are difficult to simulate classically, and circuits useful for quantum hardware benchmarking.

## Standard Gates
- The circuit library also includes standard quantum gates.
- Some are more fundamental gates (such as the UGate), and others are multi-qubit gates that usually need building from single- and two-qubit gates.
- To add imported gates to your circuit, use the append method; the first argument is the gate, and the next argument is a list of qubits to apply the gate to.

## N-local circuits

- These circuits alternate layers of single-qubit rotation gates with layers of multi-qubit entangling gates.
- This family of circuits is popular in variational quantum algorithms because they can produce a wide range of quantum states.
- Variational algorithms adjust the gate parameters to find states that have certain properties (such as states that represent a good solution to an optimization problem). For this purpose, many circuits in the library are parameterized, which means you can define them without fixed values.

## Data-encoding circuits

These parameterized circuits encode data onto quantum states for processing by quantum machine learning algorithms. Some circuits supported by Qiskit are:

    Amplitude encoding, which encodes each number into the amplitude of a basis state. This can store 2n2n numbers in a single state, but can be costly to implement.
    Basis encoding, which encodes an integer kk by preparing the corresponding basis state ∣k⟩∣k⟩.
    Angle encoding, which sets each number in the data as a rotation angle in a parameterized circuit.

The best approach depends upon the specifics of your application. On current quantum computers, however, we often use angle-encoding circuits such as the zz_feature_map.
