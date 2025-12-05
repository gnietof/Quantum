# Pauli Vector

In this document I will cover how a state vector $\psi$ or its corresponding density matrix $\rho$ is decomposed in a sum of the $4^N$ basis operators formed by the tensor product of N single-qubit Pauli operators (I,X,Y,Z).

If we display a PauliVec plot of the state below we will get this figure.

$`\ket{\psi} = \frac{1}{\sqrt{2}} \begin{pmatrix} 1 \\ 0 \\ 0 \\ -i \end{pmatrix} ; 
\bra{\psi} = \frac{1}{\sqrt{2}} \begin{pmatrix} 1 & 0 & 0 & i \end{pmatrix} ; 
\rho = \ket{\psi}\bra{\psi} = 
\frac{1}{\sqrt{2}}\begin{pmatrix} 1 \\ 0 \\ 0 \\ i \end{pmatrix} \frac{1}{\sqrt{2}} \begin{pmatrix} 1 & 0 & 0 & -i \end{pmatrix} =
\frac{1}{2}\begin{pmatrix} 1 & 0 & 0 & i \\ 
0 & 0 & 0 & 0 \\
0 & 0 & 0 & 0 \\
-i & 0 & 0 & 1 \end{pmatrix}`$  

```python
from qiskit.quantum_info import Statevector
from qiskit.visualization import plot_state_paulivec

sv = Statevector([1/sqrt(2),0,0,-1/sqrt(2)*1j])
plot_state_paulivec(sv)
```
<img width="590" height="490" alt="image" src="https://github.com/user-attachments/assets/54c7c3be-64cd-447a-84c4-9fb1dc1d35cd" />

The basis operators used for this decomposition are: 

$`I = \begin{pmatrix}1 & 0 \\ 0 & 1\end{pmatrix} ; X = \begin{pmatrix}0 & 1 \\ 1 & 0\end{pmatrix} ; Y = \begin{pmatrix}0 & -i \\ i & 0\end{pmatrix} ; Z = \begin{pmatrix}1 & 0 \\ 0 & -1\end{pmatrix} ; `$ 

$`II = \begin{pmatrix}1 & 0 \\ 0 & 1\end{pmatrix} \otimes \begin{pmatrix}1 & 0 \\ 0 & 1\end{pmatrix} = 
\begin{pmatrix}1 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 1 & 0\\ 0 & 0 & 0 & 1\end{pmatrix}`$

$`XY = \begin{pmatrix}0 & 1 \\ 1 & 0\end{pmatrix} \otimes \begin{pmatrix}0 & -i \\ i & 0\end{pmatrix} = 
\begin{pmatrix}0 & 0 & 0 & -i \\ 0 & 0 & i & 0 \\ 0 & -i & 0 & 0\\ i & 0 & 0 & 0\end{pmatrix}`$

$`YX = \begin{pmatrix}0 & -i \\ i & 0\end{pmatrix} \otimes \begin{pmatrix}0 & 1 \\ 1 & 0\end{pmatrix} = 
\begin{pmatrix}0 & 0 & 0 & -i \\ 0 & 0 & -i & 0 \\ 0 & i & 0 & 0\\ i & 0 & 0 & 0\end{pmatrix}`$

$`ZZ = \begin{pmatrix}1 & 0 \\ 0 & -1\end{pmatrix} \otimes \begin{pmatrix}1 & 0 \\ 0 & -1\end{pmatrix} = 
\begin{pmatrix}1 & 0 & 0 & 0 \\ 0 & -1 & 0 & 0 \\ 0 & 0 & -1 & 0\\ 0 & 0 & 0 & 1\end{pmatrix}`$

For each of the basis operators we will find the coeficient $c_k$​ (which is the height of the bar in the Pauli-vector chart for the operator $\sigma_k$​) is the expectation value of that operator in the state $\rho$:

$$c_k = Tr(\rho \sigma_k)$$

$`c_{II} = Tr(\rho \sigma_{II}) = 
Tr\left(\frac{1}{2}\begin{pmatrix} 1 & 0 & 0 & i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ -i & 0 & 0 & 1 \end{pmatrix} 
\begin{pmatrix}1 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 1 & 0\\ 0 & 0 & 0 & 1\end{pmatrix}\right) = 
Tr \left(\frac{1}{2}\begin{pmatrix} 1 & 0 & 0 & i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ -i & 0 & 0 & 1 \end{pmatrix} \right)= 1`$

$`c_{XY} = Tr(\rho \sigma_{XY}) = 
Tr\left(\frac{1}{2}\begin{pmatrix} 1 & 0 & 0 & i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ -i & 0 & 0 & 1 \end{pmatrix} 
\begin{pmatrix}0 & 0 & 0 & -i \\ 0 & 0 & i & 0 \\ 0 & -i & 0 & 0\\ i & 0 & 0 & 0\end{pmatrix}\right) = 
Tr \left(\frac{1}{2}\begin{pmatrix} -1 & 0 & 0 & -i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ i & 0 & 0 & -1 \end{pmatrix} \right)= -1`$

$`c_{YX} = Tr(\rho \sigma_{YX}) = 
Tr\left(\frac{1}{2}\begin{pmatrix} 1 & 0 & 0 & i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ -i & 0 & 0 & 1 \end{pmatrix} 
\begin{pmatrix}0 & 0 & 0 & -i \\ 0 & 0 & -i & 0 \\ 0 & i & 0 & 0\\ i & 0 & 0 & 0\end{pmatrix}\right) = 
Tr \left(\frac{1}{2}\begin{pmatrix} -1 & 0 & 0 & -i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ i & 0 & 0 & -1 \end{pmatrix} \right)= -1`$

$`c_{ZZ} = Tr(\rho \sigma_{ZZ}) = 
Tr\left(\frac{1}{2}\begin{pmatrix} 1 & 0 & 0 & i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ -i & 0 & 0 & 1 \end{pmatrix} 
\begin{pmatrix}1 & 0 & 0 & 0 \\ 0 & -1 & 0 & 0 \\ 0 & 0 & -1 & 0\\ 0 & 0 & 0 & 1\end{pmatrix}\right) = 
Tr \left(\frac{1}{2}\begin{pmatrix} 1 & 0 & 0 & i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ -i & 0 & 0 & 1 \end{pmatrix} \right)= 1`$

$`\rho = \frac{1}{4}(c_{II} II + c_{XY} XY + c_{YX} YX + c_{ZZ} ZZ) = \frac{1}{4}(II - XY - YX + ZZ) = `$

$`= \frac{1}{4} \left(\begin{pmatrix}1 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 1 & 0\\ 0 & 0 & 0 & 1\end{pmatrix} - \begin{pmatrix}0 & 0 & 0 & -i \\ 0 & 0 & i & 0 \\ 0 & -i & 0 & 0\\ i & 0 & 0 & 0\end{pmatrix} - \begin{pmatrix}0 & 0 & 0 & -i \\ 0 & 0 & -i & 0 \\ 0 & i & 0 & 0\\ i & 0 & 0 & 0\end{pmatrix} + \begin{pmatrix}1 & 0 & 0 & 0 \\ 0 & -1 & 0 & 0 \\ 0 & 0 & -1 & 0\\ 0 & 0 & 0 & 1\end{pmatrix}\right) = `$

$`= \frac{1}{4} \begin{pmatrix}2 & 0 & 0 & 2i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0\\ -2i & 0 & 0 & 2\end{pmatrix} = \frac{1}{2} \begin{pmatrix}1 & 0 & 0 & i \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0\\ -i & 0 & 0 & 1\end{pmatrix} `$

















