<span style='color:red;'><h1>Work in Progress</h1></span>
<h1 style='color:red'>Work in Progress</h1>

## Barriers

The valid ways to create barrier are (supposing we have a three qbit circuit):  
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

## Gates

### 1 QBit

| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | :-----: | -------- |
| H |   | ![Hadamard]( ./circuits/S_circuit.png ) | $`\frac{1}{\sqrt{2}}\begin{pmatrix} 1 & 1  \\ 1 & -1  \end{pmatrix}`$  |  |
| X |  |  <img width="40%" height="40%" alt="X Gate" src="./circuits/S_circuit.png"> | $`\begin{pmatrix} 0 & 1  \\ 1 & 0  \end{pmatrix}`$  |  |
| Y |  |  ![Y](/circuits/Y_circuit.png) | $`\begin{pmatrix} 0 & -i  \\ i & 0  \end{pmatrix}`$ |  |
| Z |  |  | $`\begin{pmatrix} 1 & 0  \\ 0 & -1  \end{pmatrix}`$ |  |
| T |  |  |  |  |
| S |  |  |  |  |
### 2 QBit
| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | :-----: | -------- |
| CX/CNOT |  | ![CX01](/circuits/CX01_circuit.png) | $`\begin{pmatrix} 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 1 \\ 0 & 0 & 1 & 0 \\ 0 & 1 & 0 & 0 \end{pmatrix}`$ <br> $`\begin{pmatrix} 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 1 \\ 0 & 0 & 1 & 0 \\ 0 & 1 & 0 & 0 \end{pmatrix}`$ | |
| CX/CNOT |  | ![CX10](/circuits/CX10_circuit.png) | $`\begin{pmatrix} 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 1 \\ 0 & 0 & 1 & 0 \\ 0 & 1 & 0 & 0 \end{pmatrix}`$ <br> $`\begin{pmatrix} 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 1 \\ 0 & 0 & 1 & 0 \\ 0 & 1 & 0 & 0 \end{pmatrix}`$ | |
| CZ |  | ![CZ](/circuits/CZ_circuit.png) | $`\begin{pmatrix} 1 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & \text{-}1 \end{pmatrix} `$ | |
### 3 QBit
| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | :-----: | -------- |
| CCX / Toffoli |  | ![CCX012](/circuits/CCX012_circuit.png) | $`\begin{pmatrix} 1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 1 & 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 0 & 0 & \textcolor{red}{1} \\ 0 & 0 & 0 & 0 & 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & \textcolor{red}{1} & 0 & 0 & 0 & 0 \end{pmatrix}`$ | |
| CCZ |  | ![CCZ210](/circuits/CCZ210_circuit.png) | $`\begin{pmatrix} 1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 1 & 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 1 & 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 & 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 0 & 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & 0 & 0 & 0 & 0 & \textcolor{red}{\text{-}1} \end{pmatrix}`$ | |

