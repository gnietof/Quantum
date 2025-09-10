# Visualizations
In this page we are going to explore some of the available visualizations for Quantum circuits with Qiskit.
We will be using the same basic circuit for each of them:
```python  
from qiskit import QuantumCircuit
from qiskit_aer import AerSimulator

qc = QuantumCircuit(2, 2)
qc.h(0)
qc.cx(0, 1)
```
![Basic Circuit](./images/basic0.png)  

## City
In order to display the histogram for our circuit in a 3D histogram, we only need to import the plot_state_city and provide the QuantumCircuit we want to visualize.  
Now we generate the visualization for the circuit:
```python  
from qiskit.visualization import plot_state_city

plot_state_city(qc)
```
The statevector for this circuit is:  
$`\ket{\psi}=\frac{1}{\sqrt{2}}(\ket{00}+\ket{11})`$  
And so the generated image is:
![City](./images/city.png)

## Hinton
Another visualization which is available is the Hinton one which uses a couple of grayed out squares instead of a 3D histogram. In this case, the values are represented using different shades of grey.
With this code:
```python  
from qiskit.visualization import plot_state_hinton

plot_state_hinton(qc)
```
The Hinton visualization would be:  
![Hinton](./images/Hinton0.png)  

## Pauli
The required code is:
```python  
from qiskit.visualization import plot_state_paulivec

plot_state_paulivec(qc)
```
The Pauli visualization would be:  
![Pauli](./images/Pauli0.png)  

## QSphere
The QSphere visualization shows the output from one circuit in the bloch sphere. 
Now the required code is this:
```python  
from qiskit.visualization import plot_state_qsphere

plot_state_qsphere(qc)
```
The QSphere visualization would be:  
![QSphere](./images/QSphere0.png)  



