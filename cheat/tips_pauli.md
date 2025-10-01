# Pauli
Pauli gates are $I, X, Y, Z$. Clifford = Pauli + $S,H$.

The combination of Pauli gate returns another Pauli gate (up to a global phase)

$P = (-i)^q P_{n-1}\otimes...\otimes P_0$

Where $q \in \mathbb{Z^4}$ and $P \in {I, X, Y, Z}$ are the single qubit Pauli matrices:  

$$
I = 
\left[\begin{array}{cc}1 & 0 \\ 
0 & 1\end{array}\right]
\quad
X = 
\left[\begin{array}{cc}0 & 1 \\ 
1 & 0\end{array}\right]
\quad
Y = 
\left[\begin{array}{cc}0 & -i \\ 
i & 0\end{array}\right]
\quad
Z = 
\left[\begin{array}{cc}1 & 0 \\ 
0 & -1\end{array}\right]
$$

Keeping $q \in \mathbb{Z^4}$ means that the phase term will only have four possible values: 1, -i, -1, i.

## Qiskit

In Qiskit a Pauli gate can be declared in two ways.

1. Pauli(x,z[,phase])  
   Here we are expressing the sequence of Pauli gates by combining sequences of bits.
   | x | z | Pauli |
   |:-:|:-:|:-----:|
   | 0 | 0 | I |
   | 0 | 1 | Z |
   | 1 | 0 | X |
   | 1 | 1 | Y |
   
   The phase is optional. If not indicated, the phase is zero. Accepted values are 0,1,2,3.

   **Note:** While this might seem a convention, it is true that XZ = Y (up to a global phase)

   For example, Pauli(np.array([0,1]),np.array([0,0]),0) returns the two gate Pauli 'IX'.
   
3. Pauli(obj)  
   In this case obj is a Pauli string, i.e. 'XYZ' or '-iYZI'. 
   
