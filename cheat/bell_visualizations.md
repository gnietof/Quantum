# Bell Visualizations

## $\ket{\phi^+}$

$\ket{\phi^+}=\frac{1}{\sqrt{2}}(\ket{00}+\ket{11})$

```python
from qiskit import QuantumCircuit 
from qiskit.quantum_info import Statevector
from qiskit.visualization import plot_state_city

qc1 = QuantumCircuit(2)
qc1.h(0)
qc1.cx(0,1)

sv1 = Statevector.from_instruction(qc1)
plot_state_city(sv1)
```
<img width="619" height="339" alt="image" src="https://github.com/user-attachments/assets/9ab03753-99e2-4edd-91e9-d6ae91eaf051" />

```python
from qiskit.visualization import plot_state_hinton

plot_state_city(sv1)
```
<img width="589" height="322" alt="image" src="https://github.com/user-attachments/assets/8b1b62a2-3e46-4c70-98d8-bdf45a2fe69e" />

```python
from qiskit.visualization import plot_state_paulivec

plot_state_paulivec(sv1)
```
<img width="590" height="490" alt="image" src="https://github.com/user-attachments/assets/6a003a4e-292b-4de7-a0d1-c31ee4f1981f" />

```python
from qiskit.visualization import plot_state_qsphere

plot_state_qsphere(sv1)
```
<img width="560" height="559" alt="image" src="https://github.com/user-attachments/assets/caea4158-ec01-40ab-b0dc-ae40a61b6e0f" />

## $\ket{\phi^-}$ 

$\ket{\phi^-}=\frac{1}{\sqrt{2}}(\ket{00}-\ket{11})$

```python
from qiskit import QuantumCircuit 
from qiskit.quantum_info import Statevector
from qiskit.visualization import plot_state_city

qc2 = QuantumCircuit(2)
qc2.h(0)
qc2.z(0)
qc2.cx(0,1)

# Also valid
# qc2b = QuantumCircuit(2)
# qc2b.h(0)
# qc2b.cx(0,1)
# qc2b.z(0) or qc2b.z(1) # <- Difference (entangled?)

sv2 = Statevector.from_instruction(qc2)
plot_state_city(sv2)
```
<img width="619" height="339" alt="image" src="https://github.com/user-attachments/assets/ded91bd6-52d7-4250-b633-a7df2d067665" />

```python
from qiskit.visualization import plot_state_hinton

plot_state_hinton(sv2)
```
<img width="589" height="322" alt="image" src="https://github.com/user-attachments/assets/601ac75b-9a51-489b-8b25-7c99ba8b42c5" />

```python
from qiskit.visualization import plot_state_paulivec

plot_state_paulivec(sv2)
```
<img width="590" height="490" alt="image" src="https://github.com/user-attachments/assets/43458454-7fa8-4702-8b23-abcb78ed2775" />

```python
from qiskit.visualization import plot_state_qsphere

plot_state_qsphere(sv2)
```
<img width="560" height="559" alt="image" src="https://github.com/user-attachments/assets/9d709985-e195-467e-bc4c-6c75c1cba799" />


## $\ket{\psi^+}$

$\ket{\psi^+}=\frac{1}{\sqrt{2}}(\ket{01}+\ket{10})$

```python
from qiskit import QuantumCircuit 
from qiskit.quantum_info import Statevector
from qiskit.visualization import plot_state_city

qc3 = QuantumCircuit(2)
qc3.h(0)
qc3.x(1)
qc3.cx(0,1)

# Also valid
# qc3b = QuantumCircuit(2)
# qc3b.h(0)
# qc3b.cx(0,1)
# qc3b.x(0) or qc2b.x(1) # <- Difference (entangled?)

sv3 = Statevector.from_instruction(qc3)
plot_state_city(sv3)
```
<img width="619" height="339" alt="image" src="https://github.com/user-attachments/assets/eb902121-2886-4394-94b2-f100165b448e" />

```python
from qiskit.visualization import plot_state_hinton

plot_state_hinton(sv3)
```
<img width="589" height="322" alt="image" src="https://github.com/user-attachments/assets/ecfbf919-64da-463e-927b-fefa971b920d" />

```python
from qiskit.visualization import plot_state_paulivec

plot_state_paulivec(sv3)
```
<img width="590" height="490" alt="image" src="https://github.com/user-attachments/assets/cc448404-0e58-4199-b365-482f576c20b7" />

```python
from qiskit.visualization import plot_state_qsphere

plot_state_qsphere(sv3)
```
<img width="560" height="559" alt="image" src="https://github.com/user-attachments/assets/2f363337-b7c9-498b-adea-e9e0fc951c7a" />

## $\ket{\psi^-}$ 

$\ket{\psi^-}=\frac{1}{\sqrt{2}}(\ket{01}-\ket{10})$

```python
from qiskit import QuantumCircuit 
from qiskit.quantum_info import Statevector
from qiskit.visualization import plot_state_city

qc4 = QuantumCircuit(2)
qc4.h(0)
qc4.x(0)
qc4.z(1)
qc4.cx(0,1)

# Also valid
# qc4b = QuantumCircuit(2)
# qc4b.h(0)
# qc4b.cx(0,1)
# qc4b.x(0) or qc4b.x(1) # <- Difference (entangled?)
# qc4b.z(0) or qc4b.z(1) # <- Difference (entangled?)

sv4 = Statevector.from_instruction(qc4)
plot_state_city(sv4)
```

<img width="619" height="339" alt="image" src="https://github.com/user-attachments/assets/bd83d71f-88dc-45e1-8554-117587010d24" />

```python
from qiskit.visualization import plot_state_hinton

plot_state_hinton(sv4)
```

<img width="589" height="322" alt="image" src="https://github.com/user-attachments/assets/d084367c-ceef-450f-80d7-0a0075d5678d" />

```python
from qiskit.visualization import plot_state_paulivec

plot_state_paulivec(sv4)
```
<img width="590" height="490" alt="image" src="https://github.com/user-attachments/assets/51c79a97-758d-4e3c-be52-017fb8d0dc75" />

```python
from qiskit.visualization import plot_state_qsphere

plot_state_qsphere(sv4)
```
<img width="560" height="559" alt="image" src="https://github.com/user-attachments/assets/3414380c-31f3-4e72-bff1-e9a04337335e" />

