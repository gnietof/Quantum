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
### Plot histogram
The ```plot_histogram``` function visualizes the result of sampling a quantum circuit on a QPU.
```python
from qiskit.visualizations import plot_histogram

data = {'00':712,'01':10,'10':9'11':269}
plot_histogram(data)
```
<img width="480" height="383" alt="image" src="https://github.com/user-attachments/assets/1547c6ad-1302-4ca1-9ba4-3b650c2b1e4a" />

## Distribution Visualizations
This section contains functions that visualize quantum states.

## State Visualizations

### State City
- The ```plot_state_city``` displays the density matrix of a state $\ket{psi}$.
#### Example
- The density matrix can be calculated as $\rho = \ket{\psi}\bra{\psi}$. That is calculating the outer product of the state by its complex conjugate transpose.

$`\ket{\psi} = \begin{pmatrix} a_0 \\ a_1 \\ a_2 \\ a_3 \end{pmatrix} ; 
\bra{\psi} = \begin{pmatrix} a_0^* & a_1^* & a_2^* & a_3^* \end{pmatrix} ; 
\rho = \ket{\psi}\bra{\psi} = 
\begin{pmatrix} a_0 \\ a_1 \\ a_2 \\ a_3 \end{pmatrix} \begin{pmatrix} a_0^* & a_1^* & a_2^* & a_3^* \end{pmatrix} =
\begin{pmatrix} a_0 * a_0^* & a_0 * a_1^* & a_0 * a_2^* & a_0 * a_3^* \\ 
a_1 * a_0^* & a_1 * a_1^* & a_1 * a_2^* & a_1 * a_3^* \\
a_2 * a_0^* & a_2 * a_1^* & a_2 * a_2^* & a_2 * a_3^* \\
a_3 * a_0^* & a_3 * a_1^* & a_3 * a_2^* & a_3 * a_3^* \end{pmatrix}`$  

$`\ket{\psi} = \frac{1}{\sqrt{2}} \begin{pmatrix} 1 \\ 0 \\ 0 \\ i \end{pmatrix} ; 
\bra{\psi} = \frac{1}{\sqrt{2}} \begin{pmatrix} 1 & 0 & 0 & -i \end{pmatrix} ; 
\rho = \ket{\psi}\bra{\psi} = 
\frac{1}{\sqrt{2}}\begin{pmatrix} 1 \\ 0 \\ 0 \\ i \end{pmatrix} \frac{1}{\sqrt{2}} \begin{pmatrix} 1 & 0 & 0 & -i \end{pmatrix} =
\frac{1}{2}\begin{pmatrix} 1 & 0 & 0 & -i \\ 
0 & 0 & 0 & 0 \\
0 & 0 & 0 & 0 \\
i & 0 & 0 & 1 \end{pmatrix}`$  

<img width="1539" height="770" alt="image" src="https://github.com/user-attachments/assets/869247ba-96b3-403a-ab0c-3a5e9f55b455" />

### State Hinton

### Bloch Sphere

$\ket{\psi}=cos(\frac{\theta}{2})\ket{0}+e^{i\phi}sin(\frac{\theta}{2})\ket{1}$

$x = sin(\theta)cos(\phi)$  
$y = sin(\theta)sin(\phi)$  
$z = cos(\theta)$  

<img width="250" height="265" alt="Bloch_sphere svg" src="https://github.com/user-attachments/assets/71869977-9941-4eeb-983d-8ea61e02611b" />

