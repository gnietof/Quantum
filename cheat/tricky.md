# Tricky
A compilation of questions which I have found to be tricky.

## Methods
Questions related with unexisting methods.  
This is specially tricky when dealing with questions which were having Qiskit 1.x (or Qiskit 0.x) in mind.

- What will occur when the following code is executed?
```python
c = ClassicalRegister(2)
c.draw()
```
Neither ClassicalRegister nor QuantumRegister have a draw method. So, an error is returned.

## Visualizations

### Bloc Sphere
When two qubits are entangled, it is not possible to display their status in a bloch sphere and so the spheheres are displayed with no vector.

!['entangled bloch']('../images/entangled.png')  




