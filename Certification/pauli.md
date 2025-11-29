# Pauli
This is a representation of an operator from a n-qubit Pauli group.

$$ P = (-i)^q P_{n-1} \otimes ...\otimes P_0$$

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

Keeping $q \in \mathbb{Z^4}$ means that q $\in$ {0,1,2,3} and so the phase term will only have four possible values: 1, -i, -1, i.

## Initialization

- **Pauli(obj)**. Where obj is a Pauli string, Pauli or ```ScalarOp```operator, or a Pauli gate or ``QuantumCircuit ````containing only Pauli gates.
    - Using a Pauli string which represents $$ P = (-i)^1 X \otimes Y \otimes Z $$.
      ```python
      P = Pauli('-iXYZ') 
      ```
    - Using a QuantumCircuit composed only of Pauli gates which represents $$ P = X \otimes Y \otimes Z $$ and is equivalent to ```Pauli('XYZ')```.
      ```python
      ```
      <img width="126" height="195" alt="image" src="https://github.com/user-attachments/assets/767eca20-f8c6-42cb-9530-14fe0115fd60" />
      Now, the expression returns 

    - 

- **Pauli(z,x,phase)**. Where z and x are boolean ```numpy.ndarrays``` and phase is an integer in {0,1,2,3}.
- **Pauli(z,x)**. Same as above having trivial phase.
