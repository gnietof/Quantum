# ⚠️ Work in Progress!

# Basic

First of all. I have found that many questions which seem complex can be really simple or even reduced to a single valid answer by just having a look at the options.

**Pending find a good example**


## Random information

### Versions
The Qiskit 2.x version can be found using the __version__ instance:
```python
from qiskit import __version__
__version__
```
Qiskit 2.x is no longer a monolithic SDK. So this is also valid for other modules such as qiskit_aer or qiskit_ibm_runtime. For example, the runtime version can be found using:

```python
from qiskit_ibm_runtime import __version__
__version__
```

In **Qiskit 1.x** the version coul be found by using:
```python
import qiskit
print(qiskit.__qiskit_version__)
```
And returned a JSON with the versions for each of the modules. But that is no longer the case. Any other exam answer is wrong.

## Circuits

### Composition
There are different ways to combine two different QuantumCircuits. If we have these circuits:  

```python
q1 = QuantumCircuit(1) 
q2a = QuantumCircuit(2) 
q2b = QuantumCircuit(2) 
```  
Then these are valid ways to combine those circuits 
- qc2.append(qc1.to_instruction(),[1])
- qc2.append(qc2b.to_instruction(),[0,1])
- qc2.compose(qc2b)

Additionally we have the option:
- qc2.tensor(qc2b)

While append/compose combine the circuits sequentially, tensor combines them in parallel.

The following options are not valid for combining circuits:
- pc2 + pc2b
- pc2.add(pc2b)

### Inverse
The only valid way to inverse a circuit is using:
- q.inverse()

These are not valid ways to get the inverse of a circuit:
- q.get_inverse()
- q.get_invert()

### Barriers
The valid ways to create barrier are (considering we have a three qubit circuit):  
-	qc.barrier(): barrier for all qubits  
-	qc.barrier(0,1) / qc.barrier([0,1]): barrier in q0 and q1  
-	qc.barrier(0,2) / qc.barrier([0,2]): barrier in q0 and q2  
-	qc.barrier(range(3)): barrier between q0 and q2  

These are not valid ways:
-	qc.barrier_all(): non existing method  

### Measures
The valid ways to create measures are (supposing we have a three qubit circuit):  
-	qc.measure_all(): measures all qubits. Also adds a new set of classical bits (meas).  
-	qc.measure_all(add_bits=False): same as previous one but does not add the classical bits and uses the existing ones. If the circuit has no classical bits defined (or less than required) an exception is being raised.   
-	qc.measure([0,1,2],[0,1,2]) / qc.measure([0,2],[0,2]) / qc.measure(0,0): qubits and bits are mapped and they should be already defined in the circuit.  
- qc.measure_active(): only the qubits being used are measured.
  
These are not valid ways:  
-	qc.measure(): the mapping between qubits and classical bits is always required.

### Properties
There is a set of methods to get information about the circuit:
- qc.depth(): The depth of the circuit. That is how many “layers” of quantum gates, executed in parallel, it takes to complete the computation defined by the circuit.
- qc.size(): The number of gates required to implement the circuit .
- qc.count_ops(): Returns a dictionary which the number of each of the operations used in the circuit.
- qc.width(): The number of qubits and classical bits required to implement the circuit. The number is provided as a total including **both** types of circuits and **unused circuits are included**.

### Drawing
The qc.draw() method accepts 'text', 'mpl' (which stands for Matplotlib library), 'latex' and 'latex_source'.

### Decompose
The method qc.decompose() transforms a circuit into basic one and tqo-qubit gates. For example for a 'simple' Toffoli gate (CCX):
```python
from qiskit import QuantumCircuit

qc = QuantumCircuit(3)
qc.ccx(0,1,2)
qc.draw('mpl')
```
![Toffoli](../images/Toffoli.png)  
After decomposition we get:
```python
qcd = qc.decompose()
qcd.draw('mpl')
```
![Toffoli](../images/Toffoli2.png)  
A single Toffoli gate has been decomposed in a 9 one-qubit and 6 two-qubit gates in a circuit having now a depth of 11.

### Execution

#### Simulation
This is the big problem with Qiskit 1.x: most questions in exams and tutorials still refer to the old way of running the simulator. In Qiskit 2.x there is no longer the execute() method.  
There are two ways to access the simulator:  

1. Using the Aer class.  
```python
from qiskit_aer import Aer

sim = Aer.get_backend('unitary_simulator') # Or statevector_simulator, qasm_simulator, aer simulator...
job = sim.run(qc,shots = 1024)
result = job.result()
```
2. Using the AerSimulator class.  
```python
from qiskit_aer import AerSimulator

sim = AerSimulator()
job = sim.run(qc,shots = 1024)
result = job.result()
```
Depending on the simulator used, there will be different information provided in **result()**.

#### QPU
Execution in QPU in Qiskit 2.x has changed as the backend.run() method is no longer available. The use of Estimators and Samplers is the new way of accessing a QPU.  
**Note:** Using the real hardware requires having a token configured.  

##### Sampler
```python
from qiskit_ibm_runtime import QiskitRuntimeService
from qiskit_ibm_runtime import SamplerV2
from qiskit import transpile

service = QiskitRuntimeService()
backend = service.least_busy()

sampler = Sampler(mode=backend)

qct = transpile(qc,backend)
job = sampler.run([(qct,{})])
result = job.result()
```

## Fidelity

### State Fidelity
State fidelity compares outputs for an operator for a **specific state** and is measured as: 

$F(\psi,\phi) = \left|\braket{\psi|\phi}\right|^2$

Staste fidelity values are between 0 and 1 (1 means states are identical).

🔑 **Note:** Two operators that differ only by a global phase are physically indistinguishable. That means they produce the same final states (up to a global phase), and global phase has no effect on measurement outcomes. So the fidelity would be 1.

### Process Fidelity
Compare ouputs for two operators but, in this case, independent of the input state.

### Average Fidelity
Average fidelity compares a gate/channel to its ideal version, **averaged over all possible** states. The formula is much more complex. 

### Qiksit
All three measures can be found using Qiskit. The following code evaluates the three magnitudes by comparing two X gates (one of them with a global phase) and one X gate with a H gate.

```python
from qiskit.quantum_info import Operator, Statevector
from qiskit.circuit.library import XGate,HGate
from qiskit.quantum_info import state_fidelity,average_gate_fidelity,process_fidelity
import numpy as np

op_a = Operator(XGate())
op_b = np.exp(1j * 0.5) * Operator(XGate())
op_c = Operator(HGate())

def fidelities(a,b):
    pf = process_fidelity(a,b)
    agf = average_gate_fidelity(a,b)

    psi = Statevector.from_label('0')
    sv_a = psi.evolve(a)
    sv_b = psi.evolve(b)
    sf = state_fidelity(sv_a,sv_b)

    print(f'State fidelity: {sf}')
    print(f'Average gate fidelity: {agf}')
    print(f'Process fidelity: {pf}\n\n')

fidelities(op_a,op_b)
fidelities(op_a,op_c)
```

The output shows that fidelity is 1 when there is just a global phase difference. And less than one when gates are not identical.

```
State fidelity: 1.0  
Average gate fidelity: 1.0  
Process fidelity: 1.0  


State fidelity: 0.4999999999999999  
Average gate fidelity: 0.6666666666666666  
Process fidelity: 0.4999999999999999  
```



