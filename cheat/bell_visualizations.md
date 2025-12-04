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

## $\ket{\phi^-}$ 

$\ket{\phi^-}=\frac{1}{\sqrt{2}}(\ket{00}-\ket{11})$

```python
from qiskit import QuantumCircuit 
from qiskit.quantum_info import Statevector
from qiskit.visualization import plot_state_city

qc2 = QuantumCircuit(2)
qc2.h(0)
qc2.cx(0,1)
qc2.z(1)

sv2 = Statevector.from_instruction(qc2)
plot_state_city(sv2)
```

<img width="619" height="339" alt="image" src="https://github.com/user-attachments/assets/ded91bd6-52d7-4250-b633-a7df2d067665" />

## $\ket{\psi^+}$

$\ket{\psi^+}=\frac{1}{\sqrt{2}}(\ket{01}+\ket{10})$

```python
from qiskit import QuantumCircuit 
from qiskit.quantum_info import Statevector
from qiskit.visualization import plot_state_city

qc3 = QuantumCircuit(2)
qc3.h(0)
qc3.cx(0,1)
qc3.x(0)

sv3 = Statevector.from_instruction(qc3)
plot_state_city(sv3)
```

<img width="619" height="339" alt="image" src="https://github.com/user-attachments/assets/eb902121-2886-4394-94b2-f100165b448e" />

## $\ket{\psi^-}$ 

$\ket{\psi^-}=\frac{1}{\sqrt{2}}(\ket{01}-\ket{10})$

```python
from qiskit import QuantumCircuit 
from qiskit.quantum_info import Statevector
from qiskit.visualization import plot_state_city

qc4 = QuantumCircuit(2)
qc4.h(0)
qc4.cx(0,1)
qc4.x(0)
qc4.z(1)

sv4 = Statevector.from_instruction(qc4)
plot_state_city(sv4)
```

<img width="619" height="339" alt="image" src="https://github.com/user-attachments/assets/bd83d71f-88dc-45e1-8554-117587010d24" />


