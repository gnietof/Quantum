⚠️Keep in mind that **only those** control flow instructions **which use mid-circuit measurements** are considered **feedforward**. So, **if_else**, **switch** and **while_loop** are feedfordward but **for_loop** is not.

# Classical feedforward and control flow
-Dynamic circuits are powerful tools with which you can measure qubits in the middle of a quantum circuit execution and then perform classical logic operations within the circuit, based on the outcome of those mid-circuit measurements. This process is also known as classical feedforward. 
- These improvements brought by dynamic circuits, however, come with trade-offs. Mid-circuit measurements and classical operations typically have longer execution time than two-qubit gates, and this increase in time might negate the benefits of reduced circuit depth.
- The OpenQASM 3 specification defines a number of control-flow structures, but Qiskit Runtime currently only supports the conditional if statement.

# Examples
- Below I am including much more details and examples than in the documentation (which I have not found elsewhere).
- Each control flow instruction has a context-manager and method way of being used (except for if-else). I am including each of those here. 

## if statement 
### Using a context manager
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

### Using the if_test method
In this case, there is no option for a **false** branch. The context manager form should be used or the if_test method instead.

```python
from qiskit import QuantumCircuit

qc = QuantumCircuit(2,1)
qc.h(0)
qc.measure(0,0)

#IF block
if_block = QuantumCircuit(1,1)
if_block.x(0)

qc.if_test(
    (0,0),                # condition
    if_block,             # if branch
    [1],                  # qubits used                         
    [0]                   # classical bits used
) 

qc.measure(0,0)
qc.draw('mpl')
```
<img width="417" height="197" alt="image" src="https://github.com/user-attachments/assets/992a6389-1454-49f3-b7f5-cb54d18f5bff" />

## if_else
The same circuit can be generated using the ```QuantumCircuit.if_else()```method. 

⚠️**if_else** does not have a context-manager form because that is handled by if_test.

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
    [0]                   # classical bits used 
)

qc.measure(0,0)
qc.draw('mpl')
```
<img width="547" height="203" alt="image" src="https://github.com/user-attachments/assets/89c0e6f6-9868-4a06-8387-dd487aced678" />

⚠️ I have found a problem when adding more classical registers to the quantum circuit. The following change fails when trying to draw the circuit whether we use the circuit or not.
```python
qc = QuantumCircuit(2,**2**)
```
## switch
⚠️ Important. The circuits for each switch case are displayed **in the same order** they have been defined.
- A switch is just a if_else on steroids. Multiple conditions can be specified.
- There is the option to add a ```with case(case.DEFAULT):``` to handle situations not covered.

### Using a context manager
```python
from qiskit import QuantumCircuit,ClassicalRegister,QuantumRegister

qr = QuantumRegister(3)
cr = ClassicalRegister(3)
qc = QuantumCircuit(qr,cr)
qc.h(0)
qc.h(1)
qc.measure([0,1],[0,1])

with qc.switch(cr) as case:
    with case(0,3):
        qc.x(qc.qubits[2])
    with case(1,2):
        qc.z(qc.qubits[2])

qc.measure([0,1,2],[0,1,2])
qc.draw('mpl')
```
<img width="627" height="207" alt="image" src="https://github.com/user-attachments/assets/52aeabf0-198b-4d6e-8e4e-8b818519c8f5" />

### Using the switch method
```python
from qiskit import QuantumCircuit,ClassicalRegister,QuantumRegister

qr = QuantumRegister(3)
cr = ClassicalRegister(3)
qc = QuantumCircuit(qr,cr)
qc.h(0)
qc.h(1)
qc.measure([0,1],[0,1])

#CASE 0,3
case03 = QuantumCircuit(1) 
#CASE 1,2
case03.x(0)
case12 = QuantumCircuit(1)
case12.z(0)
qc.switch(cr,
    [((0,3), case03),     # case branches
     ((1,2), case12)],
    [2],                  # qubits used 
    []                    # classical bits used
)

qc.measure(qr,cr)
qc.draw('mpl')
```
<img width="627" height="207" alt="image" src="https://github.com/user-attachments/assets/6ef71d5f-662b-4d73-a440-9df0177c119a" />

## while_loop
Executes a set instructions a **variable** number of times until the output of a condition is true.

⚠️ Never forget to add a ```QuantumCircuit.measure``` inside the loop. Otherwise, the circuit keeps spinning forever (or might execute just once).

### Using a context-manager
```python
from qiskit import QuantumCircuit

#WHILE block
while_block = QuantumCircuit(2,1)
while_block.h(0)
while_block.cx(0,1)
while_block.measure(0,0)


qc = QuantumCircuit(2,1)
with qc.while_loop((0,0)):
    qc.h(0)
    qc.cx(0,1)
    qc.measure(0,0)

qc.measure(0,0)
qc.draw('mpl')
```
<img width="392" height="201" alt="image" src="https://github.com/user-attachments/assets/28a08819-70c3-4aec-82d4-e96f33302a24" />

As expected the output for this circuit is $\ket{1}$ with a 100% probability.
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

<img width="483" height="389" alt="image" src="https://github.com/user-attachments/assets/898b8d75-c2dd-4991-a5e9-73b0a3a0b71d" />

This is just an example. But, yes, the same results would have been obtained moving the NOT out from the loop.
```python
from qiskit import QuantumCircuit

#WHILE block
while_block = QuantumCircuit(1,1)
while_block.h(0)
while_block.measure(0,0)

qc = QuantumCircuit(2,1)
qc.while_loop((0,0),
    while_block,
    [0],
    [0]
)

qc.cx(0,1)
qc.measure(0,0)
qc.draw('mpl')
```
<img width="397" height="203" alt="image" src="https://github.com/user-attachments/assets/6c041a1b-6bc3-4d52-b442-c3a5c72682a1" />

### Using the while_loop method
```python
from qiskit import QuantumCircuit

#WHILE block
while_block = QuantumCircuit(2,1)
while_block.h(0)
while_block.cx(0,1)
while_block.measure(0,0)

qc = QuantumCircuit(2,1)
qc.while_loop((0,0),
    while_block,
    [0,1],
    [0]
)

qc.measure(0,0)
qc.draw('mpl')
```
<img width="392" height="201" alt="image" src="https://github.com/user-attachments/assets/8a84e6c9-3d45-4569-86ec-de99b01ae9f2" />

## for_loop
- Executes a set instructions an **fixed number** of times until the output of a condition is true.

⚠️The for_loop is not a feedforward circuit. A ```ParameterExpression``` is being used to apply the gate with four different values.


### Using a context manager
```python
from qiskit import QuantumCircuit,__version__
from qiskit.circuit import Parameter
import numpy as np

i =Parameter('i')
theta = np.pi*i/8

qc = QuantumCircuit(1,1)
with qc.for_loop(range(4)) as i:
    qc.rx(theta,0)
qc.measure(0,0)
qc.draw('mpl')
```
<img width="253" height="124" alt="image" src="https://github.com/user-attachments/assets/f6e98b4e-e14d-43ee-8177-f45200453a8b" />

### Using the for_loop method
In this case the for_loop is used passing all parameters instead of using a context as before.

```python
from qiskit import QuantumCircuit
from qiskit.circuit import Parameter
import numpy as np

i=Parameter('i')
theta = np.pi*i/8

loop_block = QuantumCircuit(1)
loop_block.rx(theta,0)

qc = QuantumCircuit(1,1)
qc.for_loop(
    range(4),              # iterations
    i,                     # parameter for iteration
    loop_block,            # loop body
    [0],                   # qubiys used
    []                     # classical bits used
)
qc.measure(0,0)
qc.draw('mpl')
```
<img width="253" height="124" alt="image" src="https://github.com/user-attachments/assets/f6e98b4e-e14d-43ee-8177-f45200453a8b" />

The output for this circuit is:

```python
from qiskit_aer import AerSimulator
from qiskit.visualization import plot_histogram

sim = AerSimulator()
job = sim.run(qc)

result = job.result()
plot_histogram(result.get_counts(),figsize=(5,4))
```
<img width="482" height="381" alt="image" src="https://github.com/user-attachments/assets/88900607-3e85-4de8-acba-9cd8c4b2ef7f" />

#### No loop (check)
The same circuit without the loop but still using ```Parameter``` and ```ParameterExpression```.
```python
from qiskit import QuantumCircuit
from qiskit.circuit import Parameter
import numpy as np

p = Parameter('i')
qc = QuantumCircuit(1,1)
qc.rx(0,0)
qc.rx(i,0)
qc.rx(2*i,0)
qc.rx(3*i,0)
qc.measure([0],[0])
qc.draw('mpl')
```
<img width="381" height="122" alt="image" src="https://github.com/user-attachments/assets/dc8c9d08-d542-4361-ac52-c1f584e32ea6" />

When the parameter is assigned to the circuit.
```python
qcp = qc.assign_parameters({i:np.pi/8})
qcp.draw('mpl')
```
<img width="371" height="114" alt="image" src="https://github.com/user-attachments/assets/c5be924c-c173-42d6-b478-8014983553d0" />

The results -as expected - are the same (statistically) than the previous ones.
<img width="487" height="379" alt="image" src="https://github.com/user-attachments/assets/b6fdd882-cd62-4148-aa97-9d815522608e" />




## Classical expressions
- Due to hardware limitations, only QuantumCircuit.if_test() conditions are currently supported.
