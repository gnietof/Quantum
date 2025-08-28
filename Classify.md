# Classify
While learning about Quantum and refreshing my 30-year-old algebra skills, I bumped again with the Unitary/Hermitian/Stochastic concepts. I created this short 'cheat sheet' and also a short script which checks the properties of a matrix.
For Quantum, as a bonus, I have included a check for projection matrices.

## Unitary

A **square matrix** $\mathbf{A}$ is Unitary if **its conjugate transpose $\mathbf{A}^\intercal$ is also its inverse**.

The conjugate transpose of the matrix $\mathbf{A}$:  

$$A=\begin{pmatrix}0&1\cr-1&0\end{pmatrix}$$

Is the matrix $\mathbf{A^\dagger}$:  

$$A^\dagger=\begin{pmatrix}0&-1\cr1&0\end{pmatrix}$$

The product is:

$$A^\dagger A=\begin{pmatrix}0&-1\cr1&0\end{pmatrix}\begin{pmatrix}0&1\cr-1&0\end{pmatrix}=\begin{pmatrix}1&0\cr0&1\end{pmatrix}=I$$

So, the matrix $\mathbf{A}$ is Unitary.

## Hermitian

A **square matrix** is Hermitian if **it is equal to its conjugate transpose**.

We saw in the previous point that the conjugate transpose of the matrix $\mathbf{A}$:  

$$A=\begin{pmatrix}0&1\cr-1&0\end{pmatrix}$$

Is the matrix $\mathbf{A^\dagger}$:  

$$A^\dagger=\begin{pmatrix}0&-1\cr1&0\end{pmatrix}$$

But $\mathbf{A^\dagger\neq A}$ so $\mathbf{A}$ is Unitary but **not Hermitian**.

The conjugate transpose of the matrix $\mathbf{B}$ (which happens to be the Pauli X matrix):  

$$B=\begin{pmatrix}0&1\cr1&0\end{pmatrix}$$

Is the matrix $\mathbf{B^\dagger}$:  

$$B^\dagger=\begin{pmatrix}0&1\cr1&0\end{pmatrix}$$

Because the matrix $\mathbf{B}$ has real entries, it also happens that $\mathbf{B^\dagger = B^T}$.

The product is:

$$B^\dagger B=\begin{pmatrix}0&1\cr1&0\end{pmatrix}\begin{pmatrix}0&1\cr1&0\end{pmatrix}=\begin{pmatrix}1&0\cr0&1\end{pmatrix}=I$$

So, $\mathbf{B}$ is Unitary. And because $\mathbf{B = B^\dagger}$ then $\mathbf{B}$ is **also Hermitian**.

## Stochastic

A **square matrix** is stochastic if **each of its rows sums to 1 and the elements must also be non-negative**.
Because stochastic matrices are associated with probabilities, they are typically real-valued.

In the previous examples, matrix $\mathbf{A}$ is not stochastic because the sum of its rows is not 1. Additionally there are negative values. On the other hand $\mathbf{B}$ is Stochastic.

A more complex example of an Stochastic matrix would be $\mathbf{C}$:

$$C=\begin{pmatrix}0.3&0.2&0.5\cr0&1&0\cr0.8&0&0.2\end{pmatrix}$$

This is an stochastic matrix. All rows sum to 1. While each row must sum to 1, columns might or might not sum to 1 as in this case.

## Projection

In quantum mechanics, a **square matrix** is a projection if **it is an Hermitian matrix which is also idempotent**, meaning that $\pi^2 = \pi$. Being Hermitian, it is also true that $\pi^\dagger = \pi$.

For example, the projection matrix $\mathbf{\pi}$ for the $\ket{0}$ state would be:

$$ \pi = \ket{0}\bra{0} = \begin{pmatrix}1\cr0\end{pmatrix}\begin{pmatrix}1&0\end{pmatrix} = \begin{pmatrix}1&0\cr0&0\end{pmatrix} $$

We can easily see that this matrix is Hermitian because $\pi^\dagger = \pi $:

$$ \pi^\dagger = \begin{pmatrix}1&0\cr0&0\end{pmatrix} = \pi $$

And it is also idempotent because $\pi^2 = \pi$:

$$ \pi^2 = \begin{pmatrix}1&0\cr0&0\end{pmatrix}\begin{pmatrix}1&0\cr0&0\end{pmatrix} = \begin{pmatrix}1&0\cr0&0\end{pmatrix} = \pi $$

### Projecting a state

In order to project a state $\ket{\psi}$ using this projection matrix $\pi$ we compute the product:

$$ \ket{\psi} = \begin{pmatrix}a\cr b\end{pmatrix} $$
$$ \pi\ket{\psi} = \begin{pmatrix}1&0\cr0&0\end{pmatrix}\begin{pmatrix}a\cr b\end{pmatrix} = \begin{pmatrix}a\cr0\end{pmatrix} = a\ket{0} $$

Just out of curiosity, let's project superposition states $\ket{+}$ and $\ket{-}$.

$$ \ket{+} = \frac{1}{\sqrt{2}}\ket{0}+\frac{1}{\sqrt{2}}\ket{1} = \begin{pmatrix}\frac{1}{\sqrt{2}}\cr\frac{1}{\sqrt{2}}\end{pmatrix} $$
$$ \pi\ket{+} = \begin{pmatrix}1&0\cr0&0\end{pmatrix}\begin{pmatrix}\frac{1}{\sqrt{2}}\cr\frac{1}{\sqrt{2}}\end{pmatrix} = \begin{pmatrix}\frac{1}{\sqrt{2}}\cr0\end{pmatrix} $$

$$ \ket{-} = \frac{1}{\sqrt{2}}\ket{0}+\frac{1}{\sqrt{2}}\ket{1} = \begin{pmatrix}\frac{1}{\sqrt{2}}\cr\frac{1}{\sqrt{2}}\end{pmatrix} $$
$$ \pi\ket{-} = \begin{pmatrix}1&0\cr0&0\end{pmatrix}\begin{pmatrix}\frac{1}{\sqrt{2}}\cr-\frac{1}{\sqrt{2}}\end{pmatrix} = \begin{pmatrix}\frac{1}{\sqrt{2}}\cr0\end{pmatrix} $$






