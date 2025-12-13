# Construct circuits
## What is a quantum circuit?
- A simple quantum circuit is a collection of qubits and a list of instructions that act on those qubits.
- Multiple ```QuantumRegister``` and ```ClassicalRegister``` objects can be combined to create a circuit. Every ```QuantumRegister``` and ```ClassicalRegister``` can also be named.
- You can find a qubit's index and register by using the circuit's find_bit method and its attributes.
- Adding an instruction to the circuit appends the instruction to the circuit's ```data``` attribute.
- The easiest way to view this information is through the draw method, which returns a visualization of a circuit.
- Circuit instruction objects can contain "definition" circuits that describe the instruction in terms of more fundamental instructions.
- Instructions and circuits are similar in that they both describe operations on bits and qubits, but they have different purposes:
  - Instructions are treated as fixed, and their methods will usually return new instructions (without mutating the original object).
  - Circuits are designed to be built over many lines of code, and QuantumCircuit methods often mutate the existing object.

### What is circuit depth?
- The ```depth()``` of a quantum circuit is a measure of the number of “layers” of quantum gates, executed in parallel, it takes to complete the computation defined by the circuit.
- Because quantum gates take time to implement, the depth of a circuit roughly corresponds to the amount of time it takes the quantum computer to execute the circuit. Thus, the depth of a circuit is one important quantity used to measure if a quantum circuit can be run on a device.

## Build circuits
- Methods such as ```QuantumCircuit.h``` and ```QuantumCircuit.cx``` add specific instructions to circuits.
- To add instructions to a circuit more generally, use the ```append``` method. This takes an instruction and a list of qubits to apply the instruction to.
- To combine two circuits, use the ```compose``` method. This accepts another QuantumCircuit and an optional list of qubit mappings.
- I have a complete description of ```compose``` and ```append``` in [Circuits](../cheat/circuits.md).
- You might also want to compile circuits into instructions to keep your circuits organized.
- You can convert a circuit to an instruction by using the to_instruction method, then append this to another circuit as you would any other instruction.
- If your circuit is unitary, you can convert it to a ```Gate``` by using the ```to_gate``` method. ```Gate``` objects are specific types of instructions that have some extra features, such as the control method, which adds a quantum control.
- To see what's going on, you can use the decompose method to expand each instruction into its definition. It does return a new circuit and does not mutate the circuit it acts on.

## Measure Qubits

- Measurements are used to sample the states of individual qubits and transfer the results to a classical register.
- Note that if you are submitting circuits to a **Sampler** primitive, **measurements are required**.
- However, circuits submitted to an **Estimator** primitive **must not contain measurements**.
- Qubits can be measured using three methods: measure, measure_all and measure_active. 
  - ```QuantumCircuit.measure``` : measures each qubit in the first argument onto the classical bit given as the second argument. This method allows full control over where the measurement result is stored.
  - ```QuantumCircuit.measure_all``` : takes no argument and can be used for quantum circuits without pre-defined classical bits. It creates classical wires and stores measurement results in order. It also adds a barrier before the measurement.
  - ```QuantumCircuit.measure_active``` : similar to measure_all, but measures only qubits that have operations.

## Parameterized circuits
- Many near-term quantum algorithms involve executing many variations of a quantum circuit.
- Since constructing and optimizing large circuits can be computationally expensive, Qiskit supports parameterized circuits.
- These circuits have undefined parameters, and their values do not need to be defined until just before executing the circuit.
- This lets you move circuit construction and optimization out of the main program loop. 

## Examples
- I have included several different cases with one or two qubits, with or without parameters, with added control qubit and a measure.
- I have used the ```cregbundle=false``` to display all classical registers.
- **Note**. Even though no errors are returned, Measure() does not properly map multiple qubits/clbits measurements if doing it like ```qc.measure([0,1],[1,0])```. Check in the example two different ways of doing that properly.
```python
from qiskit import QuantumCircuit,QuantumRegister,ClassicalRegister
from qiskit.circuit.library import HGate,CXGate,RXGate,Measure
import numpy as np

qr = QuantumRegister(2)
cr = ClassicalRegister(2)
qc = QuantumCircuit(qr,cr)
qc.append(HGate(),[0]);
qc.append(CXGate(),[0,1]);
qc.append(RXGate(np.pi),[1]);

h = HGate()
ch = h.control(1)
qc.append(ch,[1,0]);

# qc.append(Measure(),[0],[1]);  
# qc.append(Measure(),[1],[0]);
# qc.append(Measure(),[1,0],[0,1]); # No error but not properly executed
# qc.append(Measure(),qr,cr); # No error but not properly executed
qc.append(Measure(),[qr],[cr]);
qc.append(Measure(),[[0,1]],[[1,0]]);
qc.draw('mpl')
```
<img width="655" height="303" alt="image" src="https://github.com/user-attachments/assets/213a21ad-ac5f-4f46-9d55-751168121f0e" />

- This second example shows the different measure options: mapped, active, all and all with no extra classical bits (fails if not enough classical bits are available).
- The ```measure_active```method does not accept the ```add_bits``` parameter.
- Barriers are being added *automagically* by the ```measure_active``` and ```measure_all``` methods.
```python
from qiskit import QuantumCircuit
import numpy as np

qc = QuantumCircuit(3,3)
qc.h(0)
qc.cx(0,1)

qc.measure([1,0],[0,1])
qc.measure_active()
qc.measure_all()
qc.measure_all(add_bits=False)
qc.draw('mpl',cregbundle=False)
```
<img width="1152" height="753" alt="image" src="https://github.com/user-attachments/assets/e1a6a294-b25d-452e-a587-5bd43ecb4659" />

- Finally a simple example with parameters.
```python
from qiskit import QuantumCircuit
from qiskit.circuit import Parameter
import numpy as np

theta = Parameter('theta')
qc = QuantumCircuit(5)
for i in range(4):
    qc.rx(i*theta,i)
    qc.cx(i,i+1)
qc.draw('mpl')
```
<img width="627" height="367" alt="image" src="https://github.com/user-attachments/assets/f3d81200-f9be-4345-8434-060066e7a108" />

-And after assigning the parameters:
```python
qca = qc.assign_parameters({'theta':np.pi/4})
qca.draw('mpl')
```
<img width="627" height="367" alt="image" src="https://github.com/user-attachments/assets/2aa07d55-f9d7-4e8b-930b-d46cee17bcca" />

