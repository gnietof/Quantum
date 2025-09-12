These are some of the notebooks I have been creating while learning about Quantum and playing with Qiskit.
There might be errors though as I am learning.

# Qiskit

Different examples using Qiskit

The idea for these examples is not using Qiskit just for dealing with circuits but also, in combination with other libraries such as Numpy or SymPy

## Hello World

This is a very simple notebook which runs a 'hello world' circuit both in the simulator and in real hardware. 

In order to run on real hardware you need your IBM Quantum account configured in your machine.

## Visualizations

Qiskit includes several visualizations other than histograms which I wanted to try (City / Hinton / Pauli QSphere).
I have also added a different way of displaying circuits called DAG.

## Qiskit Exam (Cheat sheet)

I am preparing a 'cheat sheet' for the Qiskit exam. The idea is covering in one place the questions I have found in sample exams so that I can study  and fix the concepts better.

# Algorithms

### Deustsch

This is my implementation of the Deutsch algorithm. 

The Oracle is implemented as a custom gate in Qiskit and its implementation is 'hidden' in the circuit diagram.

The output with one single execution of the circuit provides a 100% probability of **1** at the output if the function is balanced or 100% a **0** otherwise.
The number of shots might be increase but the results are always 100% one state or the other.

### Deustsch 0

This is my implementation of the Deutsch algorithm with a slight modification. Instead of qbit1 having state $\ket{1}$, it is being left at its initial $\ket{0}$ state.

In this case, the output with **multiple** executions of the circuit provides a 100% probability of **0** at the output if the function is balanced or 50% probability of **0** and **1** otherwise.

## Tools

### Unit Matrix
This file shows that if a cicuit is purely made of unitary gates (H, Z, CX, ...) the resulting matrix should be unitary.
The notebook shows how to extract the resulting matrix and display it using LaTeX.
Unitary validation is also performed.

### Dirac
This file provides a function which displays matrices in Dirac notation. Qiskit does not currently provide a method to display an Operator using Dirac notation.

### Classify
While learning about Quantum and refreshing my 30-year-old algebra skills, I bumped again with the Unitary/Hermitian/Stochastic concepts. I created this short 'cheat sheet' and also a short script which checks the properties of a matrix.
For Quantum, as a bonus, I have included a check for projection matrices.

[Here](./Classify.md) you can find descriptions and examples of each of the different types of matrices.
