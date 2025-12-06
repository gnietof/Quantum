# ⚠️ Work in Progress!

# Gates

Gates can be added in different ways to a QuantumCircuit. Using the 'classical' style based on QuantumCircuit's own methods.  
```python
qc = QuantumCircuit(2)
qc.cx(0,1)
```

Or defining a gate and appending it to the circuit. This is useful with custom gates or adding 'dynamic' circuits. Pay attention to the way the qubits are provided.
```python
# Create a CX gate
cx = CXGate()
# Add the gate
qc = QuantumCircuit(2)
qc.append(cx,[0,1])
```

#### ⚠️Important!
>  Keep in mind that it is also possible to use Python notation when indicating the qubits. So, for example, in a three  qubit circuit:<br>
qc.cx(0,-1) $\equiv$ qc.cx(0,2)  
qc.cx(-1,-2) $\equiv$ qc.cx(2,1)

Multiple gates of the same type can also be added using lists or ranges. 

```python
# These are all equivalent to:
# qc.x(0)
# qc.x(1)

qc.x([0,1]) 
qc.x(range(2))
qc.x([-1,-2])
```

### Controlled
In Qiskit any gate can be controlled by adding a couple of lines of code. For example, we may create a controlled RX:

```python
from qiskit.circuit.library import RXGate
import numpy as np

# Create the RX gate
rx = RXGate(np.pi/2)
# Add control 
crx = rx.control()

# Append to circuit using [control,target] qubits
qc = QuantumCircuit(2)
qc.append(crx,[0,1])
```
And the output circuit is:  
![CRX](./circuits/CRX01_circuit.png)

It is also possible to add more than one control qubit:

```python
from qiskit.circuit.library import RXGate
import numpy as np 

# Create the RX gate
rx = RXGate(np.pi/2)
# Add control 
crx = rx.control(num_ctrl_qubits=2)
# Append to circuit using [control,target] qubits
qc = QuantumCircuit(3)
qc.append(crx,[0,1,2])
```
And the output circuit in this case is:  
![CCRX](./circuits/CCRX012_circuit.png)

### 1 qubit

| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | :-----: | -------- |
| H/Hadamard | `qc.h(qubit0)` | ![Hadamard]( ./circuits/H_circuit.png ) | $`\frac{1}{\sqrt{2}}\begin{bmatrix} 1 & 1  \\ 1 & -1  \end{bmatrix}`$  | Changes computation basis from $\ket{0},\ket{1}$ to $\ket{+},\ket{-}$ |
| X | `qc.x(qubit0)` |  ![X]( ./circuits/X_circuit.png ) | $`\begin{bmatrix} 0 & 1  \\ 1 & 0  \end{bmatrix}`$  | X-axis $`\pi `$ rotation |
| Y | `qc.y(qubit0)` |  ![Y](./circuits/Y_circuit.png) | $`\begin{bmatrix} 0 & -i  \\ i & 0  \end{bmatrix}`$ | Y-axis $`\pi `$ rotation |
| Z | `qc.z(qubit0)` |  ![Z](./circuits/Z_circuit.png) | $`\begin{bmatrix} 1 & 0  \\ 0 & -1  \end{bmatrix}`$ | Z-axis $`\pi `$ rotation |
| T | `qc.t(qubit0)` |  ![T](./circuits/T_circuit.png) | $`\begin{bmatrix} 1 & 0  \\ 0 & e^{\frac{i\pi}{4}}  \end{bmatrix} = \begin{bmatrix} 1 & 0  \\ 0 & \frac{\sqrt{2}}{2}+\frac{\sqrt{2}i}{2}  \end{bmatrix}`$ | $`S = T^2`$ <br> Z-axis $`\frac{\pi}{4}`$ rotation |
| S | `qc.s(qubit0)` |  ![S](./circuits/S_circuit.png) | $`\begin{bmatrix} 1 & 0  \\ 0 & i \end{bmatrix}`$ | $`Z = S^2`$ <br> Z-axis $`\frac{\pi}{2} `$ rotation |
| S† | `qc.sdg(qubit0)` |  ![SDG](./circuits/SDG_circuit.png) | $`\begin{bmatrix}1 & 0\\0 & -i\end{bmatrix}`$ | Z-axis $`\frac{-\pi}{2} `$ rotation |
| P | `qc.p(phi,qubit0)` |  ![P](./circuits/P_circuit.png) | $`\begin{bmatrix} 1 & 0  \\ 0 & e^{i\phi}  \end{bmatrix} `$ | Z-axis $`\phi`$ rotation |
#### Rotations
| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | :-----: | -------- |
| RX | `qc.rx(theta,qubit0)` |  ![RX](./circuits/RX_circuit.png) | $`\begin{bmatrix} cos\left(\frac{\theta}{2}\right) & -i sin\left(\frac{\theta}{2}\right)  \\ -i sin\left(\frac{\theta}{2}\right) & cos\left(\frac{\theta}{2}\right)  \end{bmatrix}`$ |  |
| RY | `qc.ry(theta,qubit0)` |  ![RY](./circuits/RY_circuit.png) | $`\begin{bmatrix} cos\left(\frac{\theta}{2}\right) & -sin\left(\frac{\theta}{2}\right)  \\ sin\left(\frac{\theta}{2}\right) & cos\left(\frac{\theta}{2}\right)  \end{bmatrix}`$ |  |
| RZ | `qc.rz(theta,qubit0)` |  ![RZ](./circuits/RZ_circuit.png) | $`\begin{bmatrix} e^{\frac{-i\theta}{2}} & 0  \\ 0 & e^{\frac{i\theta}{2}}  \end{bmatrix}`$ |  |
| R | `qc.r(theta,phi,qubit0)` |  ![R](./circuits/R_circuit.png) | $`\begin{bmatrix} cos\left(\frac{\theta}{2}\right) & -ie^{-i\phi}sin\left(\frac{\theta}{2}\right)  \\ -ie^{i\phi}sin\left(\frac{\theta}{2}\right) & cos\left(\frac{\theta}{2}\right)  \end{bmatrix}`$ | Rotations in the XY plane<br>$R\left(\theta,-\frac{\pi}{2}\right) \equiv R_X(\theta)$<br> $R(\theta,0) \equiv R_Y(\theta)$ |
#### Deprecated in Qiskit 2.x (still referenced in some test exams)
| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | :-----: | -------- |
| U | `qc.u(theta,phi,lambda,qubit0)` |  ![U](./circuits/U_circuit.png) | $`\begin{bmatrix} cos\left(\frac{\theta}{2}\right) & -e^{i\lambda}sin\left(\frac{\theta}{2}\right)  \\ e^{i\phi}sin\left(\frac{\theta}{2}\right) & e^{i(\phi+\lambda)}cos\left(\frac{\theta}{2}\right)  \end{bmatrix}`$ |  |

Gates X,Y,Z,S,T and S† are just special cases of RX,RY,RZ (up to a global phase) 
| Name | Rotation |
| ---- | -------- | 
| X | RX($\pi$) |
| Y | RY($\pi$) |
| Z | RZ($\pi$) |
| S | RZ($2\pi$) |
| S | RZ($\pi$) |
| T | RZ($\frac{\pi}{2}$) |


### 2 qubit
| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | :-----: | -------- |
| SWAP | `qc.swap(qubit0,qubit1)` | ![SW01](./circuits/SW01_circuit.png) | $`\begin{bmatrix} 1 & 0 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 1 \end{bmatrix}`$  | |
#### Controlled
| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | :-----: | -------- |
| CX/CNOT | `qc.cx(qubit0,qubit1)` | ![CX01](./circuits/CX01_circuit.png) | $`\begin{bmatrix} 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 1 \\ 0 & 0 & 1 & 0 \\ 0 & 1 & 0 & 0 \end{bmatrix}`$  | |
| CX/CNOT | `qc.cx(qubit1,qubit0)` | ![CX10](./circuits/CX10_circuit.png) | $`\begin{bmatrix} 1 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 1 \\ 0 & 0 & 1 & 0 \end{bmatrix}`$ | |
| CY | `qc.cy(qubit0,qubit1)` | ![CY01](./circuits/CY01_circuit.png) | $`\begin{bmatrix} 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & -i \\ 0 & 0 & 1 & 0 \\ 0 & i & 0 & 0 \end{bmatrix}`$  | |
| CY | `qc.cy(qubit1,qubit0)` | ![CY10](./circuits/CY10_circuit.png) | $`\begin{bmatrix} 1 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & -i \\ 0 & 0 & i & 0 \end{bmatrix}`$ | |
| CZ | `qc.cz(qubit0,qubit1)` <br> `qc.cz(qubit1,qubit0)` | ![CZ01](./circuits/CZ01_circuit.png) | $`\begin{bmatrix} 1 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & \text{-}1 \end{bmatrix} `$ | |
### 3 qubit
| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | :-----: | -------- |
| CCX / Toffoli |  | ![CCX012](./circuits/CCX012_circuit.png) | $`\begin{bmatrix} 1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 1 & 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 0 & 0 & \textcolor{red}{1} \\ 0 & 0 & 0 & 0 & 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & \textcolor{red}{1} & 0 & 0 & 0 & 0 \end{bmatrix}`$ | |
| CCZ |  | ![CCZ210](./circuits/CCZ210_circuit.png) | $`\begin{bmatrix} 1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 1 & 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 1 & 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 & 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & 0 & 0 & 0 & 0 & \textcolor{red}{\text{-}1} \end{bmatrix}`$ | |

