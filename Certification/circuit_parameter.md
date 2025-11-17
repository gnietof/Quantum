# Circuit Parameter
- A compile-time symbolic parameter.
- The value must be entirely determined before the circuit begins execution. Values should be supplied for all parameters using the QuantumCircuit.assign_parameters.
```qasm
from qiskit import QuantumCircuit
from qiskit.circuit import Parameter

qc = QuantumCircuit(2)
alpha = Parameter('alpha')
beta = Parameter('beta')

qc.rz(alpha,0)
qc.rx(beta,1)
qc.draw('mpl')
```
<img width="138" height="132" alt="image" src="https://github.com/user-attachments/assets/8f3e1ad6-cb6b-4f59-ad1f-f1f9fe489605" />

```qasm
import numpy as np
bc = qc.assign_parameters({alpha:np.pi,beta:np.pi/2})
bc.draw('mpl')
```
<img width="142" height="130" alt="image" src="https://github.com/user-attachments/assets/6afc63e9-5db8-4c00-8853-5990e6cbd632" />

- Parameters include a set of methods to calculate mathematical expressions such as sin,cos,tan,exp ... The returned value from those methods is an ```Expression``` not the result of that mathematical function. In order to obtain the result, a value has to be bound.
```qasm
expr = alpha.cos()
print(expr.bind({alpha: np.pi}))
```
