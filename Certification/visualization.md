# Visualization
- The visualization module contain functions that visualizes measurement outcome counts, quantum states, circuits, devices and more.
- Visualization functions must be installed as an optional module with ```pip install 'qiski[visualization]'```.

## Common keywords
- Many figures are created by Matplotlib and accept a subset of common arguments.
  - title: a text string to use for the title.
  - legend: a list of strings to label the data.
  - figsize: a tuple indicating the figure size in inches.
  - color: a list of colors for plotting.
  - ax: an optional axes for the visualization output.
  - filename: file path to save image to.
 
  - Figures can be saved either by passing the filename parameter or using the ```savefig```method on the returned figure object.

## Count visualizations
This section contains functions that visualize measurements outcome counts.
```python
from qiskit.visualizations import plot_histogram

data = {'00':712,'01':10,'10':9'11':269}
plot_histogram(data)
```
<img width="480" height="383" alt="image" src="https://github.com/user-attachments/assets/1547c6ad-1302-4ca1-9ba4-3b650c2b1e4a" />

## Distribution Visualizations

## State Visualizations

### State City

### Bloch Sphere

$\ket{\psi}=cos(\frac{\theta}{2})\ket{0}+e^{i\phi}sin(\frac{\theta}{2})\ket{1}$

$x = sin(\theta)cos(\phi)$  
$y = sin(\theta)sin(\phi)$  
$z = cos(\theta)$  

<img width="250" height="265" alt="Bloch_sphere svg" src="https://github.com/user-attachments/assets/71869977-9941-4eeb-983d-8ea61e02611b" />

