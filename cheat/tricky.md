# Tricky
A compilation of questions which I have found to be tricky.

# Gates

## Rx / Ry / Rz rotations

When finding the probabilities to find $\ket{0}$ or $\ket{1}$ after applying one of those gates:  
1. Check if the rotation is being applied to $\ket{0}$ or $\ket{1}$  
1. Then check which operation is being applied!
   
Keep in mind that ...
- **Rz** *does not* change the probabilities of finding any of those when applied to $\ket{0}$ or $\ket{1}$.
  
So, when applied to $\ket{0}$:

$P(0)=1$  
$P(1)=0$    

And, when applied to $\ket{1}$  

$P(1)=1$  
$P(0)=0$    

- **Ry** changes the value of $\theta$. The unitary matrix is:
  
$`\begin{bmatrix} cos(\frac{\theta}{2}) & -sin(\frac{\theta}{2})  \\ sin(\frac{\theta}{2}) & cos(\frac{\theta}{2})  \end{bmatrix}`$

So, when applied to $\ket{0}$:

$R_y(\theta)\ket{0} = cos(\frac{\theta}{2})\ket{0}+sin(\frac{\theta}{2})\ket{1}$  
$P(0)=cos(\frac{\theta}{2})^2$  
$P(1)=sin(\frac{\theta}{2})^2$    

And, when applied to $\ket{1}$  

$R_y(\theta)\ket{1} = -sin(\frac{\theta}{2})\ket{0}+cos(\frac{\theta}{2})\ket{1}$  
$P(0)=sin(\frac{\theta}{2})^2$   
$P(1)=cos(\frac{\theta}{2})^2$  

For example, if the gate is $R_{y}(\frac{3*\pi}{4})$ then, when applied to **$\ket{0}$**, the probabilities are:

$\theta=\frac{3*\pi}{4} \rightarrow cos(\frac{\theta}{2}) = cos(\frac{3*\pi}{8}) \approx 0.382; sin(\frac{\theta}{2}) = sin(\frac{3*\pi}{8}) \approx 0.923; $

$\ket{0} \Rightarrow P(0)=cos(\frac{\theta}{2})^2 \approx 0.146; P(1)=sin(\frac{\theta}{2})^2 \approx 0.854$  
$\ket{1} \Rightarrow P(0)=sin(\frac{\theta}{2})^2 \approx 0.854; P(1)=cos(\frac{\theta}{2})^2 \approx 0.146$  

- **Rx** changes the value of $\theta$. The unitary matrix is:
  
$`\begin{bmatrix} cos(\frac{\theta}{2}) & -isin(\frac{\theta}{2})  \\ -isin(\frac{\theta}{2}) & cos(\frac{\theta}{2})  \end{bmatrix}`$

So, when applied to $\ket{0}$:

$R_y(\theta)\ket{0} = cos(\frac{\theta}{2})\ket{0}-isin(\frac{\theta}{2})\ket{1}$  
$P(0)=cos(\frac{\theta}{2})^2$  
$P(1)=sin(\frac{\theta}{2})^2$    

And, when applied to $\ket{1}$  

$R_y(\theta)\ket{1} = -isin(\frac{\theta}{2})\ket{0}+cos(\frac{\theta}{2})\ket{1}$  
$P(0)=sin(\frac{\theta}{2})^2$   
$P(1)=cos(\frac{\theta}{2})^2$  

For example, if the gate is $R_{y}(\frac{3*\pi}{4})$ then, when applied to **$\ket{0}$**, the probabilities are:

$\theta=\frac{3*\pi}{4} \rightarrow cos(\frac{\theta}{2}) = cos(\frac{3*\pi}{8}) \approx 0.382; sin(\frac{\theta}{2}) = sin(\frac{3*\pi}{8}) \approx 0.923; $

$\ket{0} \Rightarrow P(0)=cos(\frac{\theta}{2})^2 \approx 0.146; P(1)=sin(\frac{\theta}{2})^2 \approx 0.854$  
$\ket{1} \Rightarrow P(0)=sin(\frac{\theta}{2})^2 \approx 0.854; P(1)=cos(\frac{\theta}{2})^2 \approx 0.146$  

**Note1**: When applying the gates $R_x$ and $R_y$ to $\ket{0}$ and $\ket{1}$, the probabilities P(0) and P(1) are the same.  
**Note2**: $\frac{3*\pi}{8} = 66.7º$ luego si $60º<\frac{3*\pi}{8}<90º$ entonces $\frac{1}{2}>cos(\frac{3*\pi}{8})>0$ y $\frac{\sqrt{3}}{2}<sin(\frac{3*\pi}{8})<1$.  

## Methods
Questions related with unexisting methods.  
This is specially tricky when dealing with questions which were having Qiskit 1.x (or Qiskit 0.x) in mind.

- What will occur when the following code is executed?
```python
c = ClassicalRegister(2)
c.draw()
```
Neither ClassicalRegister nor QuantumRegister have a draw method. So, an error is returned.

## Visualizations

### Bloc Sphere

When answering a question, keep in mind that spheres in the bloch_multivector show the qubits in reverse order compared to qubit notation. So, the following diagram shows state $\ket{10}$ and therefore the correct state vector would be **[0,0,1,0]** (and not [0,1,0,0] or any other).

!['entangled bloch'](../images/bloch_10.png)  

### Entanglement 

When two (or more) qubits are entangled, it is not possible to display their status in a bloch sphere and so the sphheres are displayed with no vector.

!['entangled bloch'](../images/entangled.png)  





