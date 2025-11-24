# Classical feedforward and control flow
-Dynamic circuits are powerful tools with which you can measure qubits in the middle of a quantum circuit execution and then perform classical logic operations within the circuit, based on the outcome of those mid-circuit measurements. This process is also known as classical feedforward. 
- These improvements brought by dynamic circuits, however, come with trade-offs. Mid-circuit measurements and classical operations typically have longer execution time than two-qubit gates, and this increase in time might negate the benefits of reduced circuit depth.
- The OpenQASM 3 specification defines a number of control-flow structures, but Qiskit Runtime currently only supports the conditional if statement.

## if statement
- The if statement is used to conditionally perform operations based on the value of a classical bit or register.
```python
A very simple example:
from qiskit import QuantumCircuit

qc = QuantumCircuit(1,1)
qc.h(0)
qc.measure(0,0)
with qc.if_test((qc.clbits[0],0)):
    qc.x(0)
qc.measure(0,0)
qc.draw('mpl')
```
<img width="382" height="133" alt="image" src="https://github.com/user-attachments/assets/8673e133-283b-4bf1-a582-9f7c6f428074" />

Interestingly, this circuits generates a 1 with 100% probability. In case the Hadamard output is a 0, the circuit swaps that into a 1.
```python
from qiskit_aer import AerSimulator
from qiskit.visualization import plot_histogram
from qiskit import transpile

sim = AerSimulator()
qct = transpile(qc,sim)
job = sim.run(qct)
result = job.result()
plot_histogram(result.get_counts(),figsize=(5,4))
```
<img width="480" height="383" alt="image" src="https://github.com/user-attachments/assets/d4e25094-4d22-44a4-916c-d60b21a88f4c" />

Another slightly more complex example adding an else clause:

```python
from qiskit import QuantumCircuit

qc = QuantumCircuit(2,1)
qc.h(0)
qc.measure(0,0)
with qc.if_test((qc.clbits[0],0)) as else_:
    qc.x(1)
with else_:
    qc.h(1)
qc.measure(0,0)
qc.draw('mpl')
```
<img width="519" height="202" alt="image" src="https://github.com/user-attachments/assets/047c5fc6-8433-43e3-820b-ece8bb313d19" />

### Bonus - QuantumCircuit.if_else
The same circuit can be generated using the ```QuantumCircuit.if_else()```method. I have not found any good examples and the docuentation just covers it briefly. So I am including my findings here.

```python
from qiskit import QuantumCircuit

qc = QuantumCircuit(2,1)
qc.h(0)
qc.measure(0,0)

# IF block
if_block = QuantumCircuit(1, 1)
if_block.x(0)
# ELSE block
else_block = QuantumCircuit(1, 1)
else_block.h(0)

qc.if_else(
    (0, 0),               # condition
    if_block,             # if branch
    else_block,           # else branch
    [1],                  # qubits used 
    [0]                    # classical bits used 
)

qc.measure(0,0)
qc.draw('mpl')
```
<img width="547" height="203" alt="image" src="https://github.com/user-attachments/assets/89c0e6f6-9868-4a06-8387-dd487aced678" />

⚠️ I have found a problem when adding more classical registers to the quantum circuit. The following change fails when trying to draw the circuit whether we use the circuit or not.
```python
qc = QuantumCircuit(2,**2**)
```


## Classical expressions
- Due to hardware limitations, only QuantumCircuit.if_test() conditions are currently supported.
