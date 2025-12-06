# Visualize circuits
## Drawing a quantum circuit
A circuit can be rendered in different ways. 
```python
from qiskit import QuantumCircuit
qc = QuantumCircuit(2,2)
qc.h(0)
qc.cx(0,1)
qc.measure([0,1],[1,0])
```
By default an ASCII version is rendered: _text_. 
```python
qc.draw() # or qc.print()
```
<img width="199" height="123" alt="image" src="https://github.com/user-attachments/assets/30a3579b-89bf-44f3-b286-d34ba07db57c" />

There are two alternative renderings: _mpl_ (MatplotLib).
```python
qc.draw('mpl') 
```
<img width="333" height="182" alt="image" src="https://github.com/user-attachments/assets/0d1aa2d6-9c9e-4254-9734-6f697be1988a" />

And _latex_ (which I personally find horrible).
```python
qc.draw('latex') 
```
<img width="293" height="110" alt="image" src="https://github.com/user-attachments/assets/e5cb3f0a-73ac-42ab-ad7a-10d35deaa5d1" />

**Note**: Using the **print()** method returns also an ASCII rendering. The print() method returns nothing but draw() returns the figure which has been created. The type of object depends on the type of rendering.

## Saving
There are two ways to save the rendered image:
- Providing a filename. This is valid for all rendering types: text (ASCII), latex (PDF) and mpl (jpg, png, tif ... based on the provided file extension).
```python
qc.draw(output="mpl", filename="mpl.jpeg")
```

- When using the *mpl* type, the object returned is a MatplotLib object. So all features from MatplotLib are available.
```python
fig = qc.draw(output="mpl")
fig.savefig("mpl.png",dpi=300)
```

- When using *latex* and *text*, the file can also be saved using the classical Python approach.
```python
text = qc.draw(output="text")
with open('text.txt','w') as f:
  f.write(str(text))
```
## Options

There are several other options which allow us to customize the output of the diagram. The most interesting for the certification are:
- **reverse_bits** [False/True]. Displays the qubits in normal or reversed order.
- **plot_barriers** [True/False]. Includes or hides the barriers.
- **fold** [0, n]. The width of the diagram in characters (text) or layers (mpl) before folding to a new line. Not applicable to latex.
- **scale** [1/n]. The percentage of scaling of the diagram. Not applicable to text.
- **style**. Allows a set of stylings to be applied which includes changing the color of backgroup and circuits, line styles ...




