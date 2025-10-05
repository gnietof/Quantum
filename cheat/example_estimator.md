# Estimator Hello World

For this Hello World example we will be using the Hello World of Quantum Circuits:

```python
from qiskit import QuantumCircuit

qc = QuantumCircuit(2)
qc.h(0)
qc.cx(0,1)
```  
![Quantum Circuit](../images/bell1.png)

And we will also be using a Hello World of observables which can be defined in Qiskit in one of these two ways:

```python
O = SparsePauliOp.from_sparse_list([('XX',[0,1],1)],num_qubits=2)
O = SparsePauliOp('XX')
```

## Algebra
The expectation value of an observable $O$ in state $\ket{\psi}$ is:  

$$\braket{O}=\braket{\psi|O|\psi}$$

Where $\ket{\psi}$ is the result of applying our circuit to the initial state vector $\ket{0}$:

$$\ket{\psi} = U\ket{0}$$

In our example:  

$$U = (I \otimes \ket{0} + X \otimes \ket{1})(I \otimes H) = $$
$$ \left(\left[\begin{array}{cc}1 & 0 \\ 
0 & 1\end{array}\right] 
\otimes 
\left[\begin{array}{cc}1 & 0 \\ 
0 & 0\end{array}\right]+\left[\begin{array}{cc}0 & 1 \\ 
1 & 0\end{array}\right] 
\otimes 
\left[\begin{array}{cc}0 & 0 \\ 
0 & 1\end{array}\right]\right)
\left(\left[\begin{array}{cc}1 & 0 \\ 
0 & 1\end{array}\right] 
\otimes 
\frac{1}{\sqrt{2}}\left[\begin{array}{cc}1 & 1 \\ 
1 & -1\end{array}\right]
\right) =$$

$$\left(\left[\begin{array}{cc}1 & 0 & 0 & 0\\ 
0 & 1 & 0 & 0\\ 
0 & 0 & 0 & 0\\ 
0 & 0 & 0 & 0\end{array}\right]+
\left[\begin{array}{cc}0 & 0 & 0 & 0\\ 
0 & 0 & 0 & 0\\ 
0 & 0 & 0 & 1\\ 
0 & 0 & 1 & 0\end{array}\right]\right(
$$  

$$\left(\left[\begin{array}{cc}2 & 0 & 0 & 0\\ 
0 & 1 & 0 & 0\\ 
0 & 0 & 0 & 0\\ 
0 & 0 & 0 & 0\end{array}\right]\right)$$


$$U = \frac{1}{\sqrt{2}}\left[\begin{array}{cc}1 & 1 \\ 
1 & 1\end{array}\right]$$
