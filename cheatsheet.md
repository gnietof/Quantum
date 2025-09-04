## Barriers

The valid ways to create barrier are (supposing we have a three qbit circuit):  
•	qc.barrier(): barrier for all qbits  
•	qc.barrier(0,1) / qc.barrier([0,1]): barrier in q0 and q1  
•	qc.barrier(0,2) / qc.barrier([0,2]): barrier in q0 and q2  
•	qc.barrier(range(3)): barrier between q0 and q2  

These are not valid ways:
•	qc.barrier_all(): non existing method  

## Measures

The valid ways to create measures are (supposing we have a three qbit circuit):  
•	qc.measure_all(): meausres all qbits. Also adds a new set of classical bits (meas).  
•	qc.measure_all(add_bits=False): same as prevpious one but does not add the classical bits and uses the existing ones. If the circuit has no classical bits defined (or less than required) an exception is being raised.   
•	qc.measure([0,1,2],[0,1,2]) / qc.measure([0,2],[0,2]) / qc.measure(0,0): qbits and bits are mapped and they should be already defined in the circuit.  

These are not valid ways:  
•	qc.measure(): the mapping between qbits and classical bits is always required.

## Gates

| Name | Qiskit | Picture | Unitary | Comments |
| :--: | ------ | ------- | ------- | -------- |
| H |  |  |\begin{bmatrix}
0 & 1  \\
 1 & 0  \\
 \end{bmatrix}  |  |
| X |  |  |$$\begin{bmatrix}
0 & 1  \\
 1 & 0  \\
 \end{bmatrix}$$  |  |
| Y |  |  |\begin{bmatrix}
0 & 1  \\
 1 & 0  \\
 \end{bmatrix}  |  |
| Z |  |  |  | $\begin{pmatrix}0&1\cr-1&0\end{pmatrix}$ |
| T |  |  |  |  |
| S |  |  |  |  |
| CX/CNOT |  |  |  |  |


| Gate | Unitary Matrix | Circuit |
|------|----------------|---------|
| X | `[0.+0.j 1.+0.j]<br>[1.+0.j 0.+0.j]` | ![](X_circuit.png) |
| Y | `[0.+0.j 0.-1.j]<br>[0.+1.j 0.+0.j]` | ![](Y_circuit.png) |
| Z | `[1.+0.j 0.+0.j]<br>[ 0.+0.j -1.+0.j]` | ![](Z_circuit.png) |
| H | `[0.70710678+0.j 0.70710678+0.j]<br>[ 0.70710678+0.j -0.70710678+0.j]` | ![](H_circuit.png) |
| S | `[1.+0.j 0.+0.j]<br>[0.+0.j 0.+1.j]` | ![](S_circuit.png) |
| T | `[1.+0.j 0.+0.j]<br>[0.        +0.j         0.70710678+0.70710678j]` | ![](T_circuit.png) |
| CX | `[1.+0.j 0.+0.j 0.+0.j 0.+0.j]<br>[0.+0.j 0.+0.j 0.+0.j 1.+0.j]<br>[0.+0.j 0.+0.j 1.+0.j 0.+0.j]<br>[0.+0.j 1.+0.j 0.+0.j 0.+0.j]` | ![](CX_circuit.png) |

| Gate | Unitary Matrix | Circuit |
|------|----------------|---------|
| X | 
:::{=latex}
\left[\begin{bmatrix}0 & 1\\1 & 0\end{bmatrix}\right]
::: 
| ![](X_circuit.png) |
| Y | $\left[\begin{bmatrix}0 & - 1.0 i\\1.0 i & 0\end{bmatrix}\right]$$ | ![](Y_circuit.png) |
| Z | $\left[\begin{bmatrix}1 & 0\\0 & -1\end{bmatrix}\right]$$ | ![](Z_circuit.png) |
| H | $\left[\begin{bmatrix}\frac{\sqrt{2}}{2} & \frac{\sqrt{2}}{2}\\\frac{\sqrt{2}}{2} & - \frac{\sqrt{2}}{2}\end{bmatrix}\right]$$ | ![](H_circuit.png) |
| S | $\left[\begin{bmatrix}1 & 0\\0 & 1.0 i\end{bmatrix}\right]$$ | ![](S_circuit.png) |
| T | $\left[\begin{bmatrix}1 & 0\\0 & 0.707106781186547 + 0.707106781186547 i\end{bmatrix}\right]$$ | ![](T_circuit.png) |
| CX |$\left[\begin{bmatrix}1 & 0 & 0 & 0\\0 & 0 & 0 & 1\\0 & 0 & 1 & 0\\0 & 1 & 0 & 0\end{bmatrix}\right]$$ | ![](CX_circuit.png) |
