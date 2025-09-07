# Work in Progress

## Concepts

### States
$`\ket{+} = \frac{\ket{0}+\ket{1}}{\sqrt{2}}`$  
$`H\otimes\ket{0} = \ket{+}`$  
```python
qc = QuantumCircuit()
qc.h(0)
```
$`\ket{-} = \frac{\ket{0}-\ket{1}}{\sqrt{2}}`$  
$`H\otimes\ket{1} = \ket{-}`$
```python
qc = QuantumCircuit()
qc.x(0)
qc.h(0)
```
#### Bell States
There are four 'bell states'. Although in one test exams refers to the 'perfect' Bell state there is no such 'perfect Bell state'
$`\ket{\phi^+} = \frac{\ket{00}+\ket{11}}{\sqrt{2}}`$  
$`\ket{\phi^-} = \frac{\ket{00}-\ket{11}}{\sqrt{2}}`$  
$`\ket{\psi^+} = \frac{\ket{01}+\ket{10}}{\sqrt{2}}`$  
$`\ket{\psi^-} = \frac{\ket{01}-+\ket{10}}{\sqrt{2}}`$  

In order to generat these states with Qiskit you need a Hadamard (for superposition) and one CX (for entanglement). Then you need a combination of X and Z gates to obtain each of the four possible states.

$`\ket{\phi^+}`$  
```python
qc = QuantumCircuit()
qc.h(0)
qc.cx(0,1)
```
$`\ket{\phi^-} = \frac{\ket{00}-\ket{11}}{\sqrt{2}}`$  
```python
qc = QuantumCircuit()
qc.h(0)
qc.cx(0,1)
qc.z(1)
```
$`\ket{\psi^+} = \frac{\ket{01}+\ket{10}}{\sqrt{2}}`$  
```python
qc = QuantumCircuit()
qc.h(0)
qc.x(1)
qc.cx(0,1)
```
$`\ket{\psi^-} = \frac{\ket{01}-+\ket{10}}{\sqrt{2}}`$  
```python
qc = QuantumCircuit()
qc.h(0)
qc.x(1)
qc.cx(0,1)
qc.z(1)
```
#### GHZ States
$`\ket{GHZ} = \frac{\ket{000}+\ket{111}}{\sqrt{2}}`$  
```python
qc = QuantumCircuit(3)
qc.h(0)
qc.cx([0,0],[1,2])
```

## Barriers
The valid ways to create barrier are (considering we have a three qbit circuit):  
-	qc.barrier(): barrier for all qbits  
-	qc.barrier(0,1) / qc.barrier([0,1]): barrier in q0 and q1  
-	qc.barrier(0,2) / qc.barrier([0,2]): barrier in q0 and q2  
-	qc.barrier(range(3)): barrier between q0 and q2  

These are not valid ways:
-	qc.barrier_all(): non existing method  

## Measures
The valid ways to create measures are (supposing we have a three qbit circuit):  
-	qc.measure_all(): meausres all qbits. Also adds a new set of classical bits (meas).  
-	qc.measure_all(add_bits=False): same as prevpious one but does not add the classical bits and uses the existing ones. If the circuit has no classical bits defined (or less than required) an exception is being raised.   
-	qc.measure([0,1,2],[0,1,2]) / qc.measure([0,2],[0,2]) / qc.measure(0,0): qbits and bits are mapped and they should be already defined in the circuit.  

These are not valid ways:  
-	qc.measure(): the mapping between qbits and classical bits is always required.
