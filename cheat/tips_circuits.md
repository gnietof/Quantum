# Circuits
There are different ways of combining circuits. 

We will be using these two circuits for the examples.
```python
from qiskit import QuantumCircuit

qc1 = QuantumCircuit(3,name='qc1')
qc1.h(0)
qc1.cx(0,1)
qc1.cx(1,2)
qc1.draw('mpl')
```
<img width="305" height="238" alt="image" src="https://github.com/user-attachments/assets/02b45b11-066c-49f8-9ad7-e3593295e08f" />

```python
qc2 = QuantumCircuit(2,name='qc2')
qc2.h(1)
qc2.cy(1,0)
qc2.draw('mpl')
```
<img width="241" height="174" alt="image" src="https://github.com/user-attachments/assets/8ea8290d-f0da-48ac-816b-7e5c0809ea88" />

## Copy
- The ```from_instructions``` method allows creating one circuit from an exising one.
- The ```from_instructions``` method **discards** the classical bits in the 'imported' circuit. 

```python
qc3 = QuantumCircuit.from_instructions(qc1)
```
<img width="305" height="238" alt="image" src="https://github.com/user-attachments/assets/02b45b11-066c-49f8-9ad7-e3593295e08f" />

## Composing
- This method just appends one circuit next to the other. By default, the method returns the composed circuit. If ```inplace=True``` then it will behave as the ```append```method.
- If no qubits are provided, the circuit will be conected to the least significant qubits.
```python
qcc = qc1.compose(qc2)
qcc.draw('mpl')
```
<img width="434" height="238" alt="image" src="https://github.com/user-attachments/assets/ce74d15a-6f39-42f4-bae7-f9bb51f74f68" />

- Different qubits mapping can be provided to place the composed circuit as required.
```python
qcc = qc1.compose(qc2,(1,2))
qcc.draw('mpl')
```
<img width="434" height="238" alt="image" src="https://github.com/user-attachments/assets/6bc5db7f-8136-4010-a3b6-cdb7d8eb57ab" />

```python
qcc = qc1.compose(qc2,(2,1))
qcc.draw('mpl')
```
<img width="434" height="238" alt="image" src="https://github.com/user-attachments/assets/19dc53d5-d93a-448c-a240-c844cf4d84de" />

```python
qcc = qc1.compose(qc2,(2,0))
qcc.draw('mpl')
```
<img width="370" height="238" alt="image" src="https://github.com/user-attachments/assets/d6c7d9c2-2684-4efb-b831-ca01df8bd715" />

- By default, the whole composed circuit is displayed. But it can wrapped into a gate using ```wrap=True```. If provided, the name for the circuit is used in the gate. Otherwise a random name is used.
```python
qcc = qc1.compose(qc2,wrap=True)
qcc.draw('mpl')
```
<img width="370" height="238" alt="image" src="https://github.com/user-attachments/assets/db5ff898-bec9-45ef-a464-bd0f340bbffe" />

- By default, the composed circuit is appended at the end. But it can be prepended using ```front=True```.
```python
qcc = qc1.compose(qc2,front=True)
qcc.draw('mpl')
```
<img width="434" height="238" alt="image" src="https://github.com/user-attachments/assets/8c60cddf-9dac-4687-bcf7-cdea70ab4be4" />

- Classical bits can also be considered when composing a circuit. If our circuits have classical bits, then these will also be added and we might map them as required. 
```python
from qiskit import QuantumCircuit

qc1c = QuantumCircuit(3,2)
qc1c.h(0)
qc1c.cx(0,1)
qc1c.cx(1,2)
qc1c.draw('mpl')
```
<img width="305" height="303" alt="image" src="https://github.com/user-attachments/assets/37cbf865-b30d-45a5-929b-05a391a835f7" />

```python
qc2c = QuantumCircuit(2,1)
qc2c.h(1)
qc2c.cy(1,0)
qc2c.measure(0,0)
qc2c.draw('mpl')
```
<img width="305" height="238" alt="image" src="https://github.com/user-attachments/assets/7cb3be07-1003-492e-9f71-f50cb9819d81" />

```python
qcc = qc1c.compose(qc2c,(2,0),(1))
qcc.draw('mpl')
```
<img width="434" height="303" alt="image" src="https://github.com/user-attachments/assets/bc6331c3-d04c-447c-82ca-196a7a726e1b" />

## Appending
- We might think of ```append``` as the 'defaults' version of compose:
  - Append adds the second circuit to the first one **inplace**.
  - Indicating the qubit/classical bits mapping is mandatory.
  - This method **does not** return a modified circuit but an ```Instruction``` object with the contents of the added circuit.    - Appended circuits are shown as a 'black box' including the qubit mapping (```wrap=True``` in compose).
- The names, if provided, are being used for the circuits. Otherwise a random name is used.
```python
qc3.append(qc1,[2,0,1])
qc3.append(qc2,[1,0])
qc3.draw('mpl')
```
<img width="420" height="238" alt="image" src="https://github.com/user-attachments/assets/551711b6-9d2d-435e-9017-a61846c3b1ec" />


