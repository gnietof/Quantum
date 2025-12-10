This is just a brief overview about Stabilizers in case they are mentioned in the certification.

# Stabilizes / Clifford 
- Stabilizer circuits, also known as Clifford circuits, are an important restricted class of quantum circuits that can be efficiently simulated classically.
- There are several equivalent ways to define stabilizer circuits. One definition is that a stabilizer circuit is a quantum circuit that consists solely of the following gates: CX, H, S, Measure.
- Using H and S any Pauli roation gate can be obtained ($R_X$, $R_Y$, $R_Z$) having an angle in the set {$`0,\frac{\pi}{2},\pi,\frac{3\pi}{2}`$}.
- Stabilizer circuits are important to the study of quantum error correction. Their classical simulability also makes them useful for verifying the output of quantum computers as it allows the simulation of a number of qubits that otherwise would be out of reach for a classical computer.
- A Stabilizer is a Pauli circuit such, for a given state $\psi$:  $S\ket{\psi} = \ket{\psi}$
- A Destabilizer is a Pauli circuit such, for a given state $\psi$:  $D\ket{\psi} = -\ket{\psi}$
