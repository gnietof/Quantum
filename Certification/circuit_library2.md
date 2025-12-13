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

### Example
- I am providing a different example here (than the one in the documentation. I have seen that, after the number of qubits, the first set are rotation blocks and the second one entanglenment blocks. So I have other two gates in each.
- I have set the number of qubits to 3 and reduced the number of repetitions to 2 (to generate a smaller circuit as each bit has to be entangled with the others) and also enabled barriers to better see the different sections (rotations and entanglements).
```python
from qiskit.circuit.library import n_local
 
qc = n_local(3, {'ry', 'rx'},{'cx','cy'},insert_barriers=True,reps=2)
qc.draw("mpl")
```
<img width="1528" height="238" alt="image" src="https://github.com/user-attachments/assets/78eb3d42-6bec-45b9-a321-f88118e07178" />

- Then I use a different formula for assigning 'random' values.
```python
import numpy as np

qc1 = qc.assign_parameters({p: i*np.pi/len(qc.parameters) for i,p in enumerate(qc.parameters)})
qc1.draw('mpl',fold = False)
```
<img width="1528" height="238" alt="image" src="https://github.com/user-attachments/assets/cd0b9917-1635-4633-a993-5560c1bee3b2" />

## Data-encoding circuits
- These parameterized circuits encode data onto quantum states for processing by quantum machine learning algorithms. Some circuits supported by Qiskit are:
    - Amplitude encoding, which encodes each number into the amplitude of a basis state. This can store $2^n$ numbers in a single state, but can be costly to implement.
    - Basis encoding, which encodes an integer $k$ by preparing the corresponding basis state $\ket{k}$.
    - Angle encoding, which sets each number in the data as a rotation angle in a parameterized circuit.
- The best approach depends upon the specifics of your application. On current quantum computers, however, we often use angle-encoding circuits such as the ```zz_feature_map```.

## Time-evolution circuits
- These circuits simulate a quantum state evolving in time.
- Use time-evolution circuits to investigate physical effects such as heat transfer or phase transitions in a system.
- Time-evolution circuits are also a fundamental building block of chemistry wave functions (such as unitary coupled-cluster trial states) and of the QAOA algorithm we use for optimization problems.

## Benchmarking and complexity-theory circuits
- Benchmarking circuits give us a sense of how well our hardware is actually working, and complexity-theory circuits help us understand how difficult the problems we want to solve are.
- For example, the "quantum volume" benchmark measures how accurately a quantum computer executes a type of random quantum circuit.
- The score of the quantum computer increases with the size of the circuit it can reliably run.
- This takes into account all aspects of the computer, including qubit count, instruction fidelity, qubit connectivity, and the software stack transpiling and post-processing results.

## Arithmetic circuits
- Arithmetic operations are classical functions, such as adding integers and bit-wise operations.
- These may be useful with algorithms such as amplitude estimation for finance applications, and in algorithms like the HHL algorithm, which solves linear systems of equations.
