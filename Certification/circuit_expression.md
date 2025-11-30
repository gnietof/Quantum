# ParameterExpression
- This document is just an enumeration of the ```ParameterExpression``` class methods and properties.
- The document does not explain that ```ParameterExpression``` are very interesting for operating with ```Parameter``` values.
- Having two ```Parameter``` defined we can create an expression which combines those parameters and use it as a parameter.
  In this example we define two parameters and then combine them using in an ```ParameterExpression```.

  ```python
  a = Parameter('a')
  b = Parameter('b')
  
  c = 2*a+b
  
  qc = QuantumCircuit(1)
  qc.rx(c,0)
  qc.draw('mpl')
  ```
<img width="115" height="69" alt="image" src="https://github.com/user-attachments/assets/f7935c0e-80e8-43b2-a266-dd1bffdf6f13" />

- If we now assign values to those parameters, the gate shows the updated value based on the expression.
  
  ```python
    qc2 = qc.assign_parameters({a:1,b:2})
    qc2.draw('mpl')
  ```
<img width="118" height="68" alt="image" src="https://github.com/user-attachments/assets/b025e67c-1f79-403e-a52d-784d103b208c" />


# Bonus example

In this example circuit [N Divider](../labs/divN.ipynb) a code is shown which is capable of dynamically building a quantum circuit which generates N outputs all with the same probability. The length of the circuit varies with N and so the number of gates. 

The rotation for each $R_y$ gate has to be adjusted based on two integer values, n1 and n2. In the code, each of those angles are calculated an then added to the $R_y$ gate.

```python
a = 2*np.arcsin(np.sqrt((n1-n2)/n1))
...
qc.ry(a,...)
```
In this image we can see the two first $R_y$ gates having angles 1.5 (1.504080...) and 1.43 (1.427448...).
<img width="737" height="354" alt="image" src="https://github.com/user-attachments/assets/4ef0aacc-6ee2-4491-8d3c-1464a2644be3" />

A ```ParameterExpression``` might have been used instead. A very simplified version of the circuit will be used which only includes the $R_y$ gate.
  - Firs we declare the two ```Parameter``` required.
  ```python
  n1 = Parameter('n1')
  n2 = Parameter('n2')
  ```
  - Then the angle is calculated.
  ```python
  d = (n1-n2)/n1
  s = d**0.5
  a = 2*s.arcsin()
  ```
  - The ```ParameterExpression``` is assigned same as any other ```Parameter```in the $R_y$ gate. The full expression is displayed.
  
  ```python
  qc = QuantumCircuit(1)
  qc.ry(a,0)
  qc.draw('mpl')
  ```
<img width="262" height="71" alt="image" src="https://github.com/user-attachments/assets/417bfaae-3f37-43c0-a66a-65928d3b1d94" />

  - The first $R_y$ gate in the circuit is using n1=30 and n2=16. We assign those values to the parameters and display the resulting circuit.

  ```python
  qc2 = qc.assign_parameters({n1:30,n2:16})
  qc2.draw('mpl')
  ```

<img width="128" height="70" alt="image" src="https://github.com/user-attachments/assets/4ffb6061-711e-43a9-ae86-e502a5912848" />

  - The second $R_y$ gate in the circuit is using n1=14 and n2=8.

  ```python
  qc2 = qc.assign_parameters({n1:14,n2:8})
  qc2.draw('mpl')
  ```

<img width="110" height="62" alt="image" src="https://github.com/user-attachments/assets/b70032bd-8821-43a1-9f98-15c2d9bb4501" />

```ParameterExpressions``` are very interesting when a few parameters are required to parameterize multiple gates based on those parameters.


