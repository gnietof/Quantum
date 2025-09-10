# Backend Information

## Error Map
In order to display the error map, GraphViz (https://graphviz.org/download/) must be installed in the system where Jupyter Lab is running. 
```python
from qiskit.visualization import plot_error_map
from qiskit_ibm_runtime import QiskitRuntimeService

service = QiskitRuntimeService()

plot_error_map(service.backends()[0], figsize=(20,10))
fig.savefig('./circuits/torino_error.png')
```  

The error map output for Torino IBM Quantum computer using the above code is:  

![Torino](./circuits/ibm_torino_error.png)

And the error map for Brisbane IBM Quantum computer is:

![Brisbane](./circuits/ibm_brisbane_error.png)

In eaach of these images, the geometric figure is the result of diksplaying the couplings between the different qbits.
