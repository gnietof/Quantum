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

I have included examples of state visualizations for all bell states in [Bell states visualizations](../cheat/bell_visualizations.md)

### State City
- The ```plot_state_city``` displays the density matrix of a state $\ket{psi}$.

### State Hinton
- The ```plot_state_hinton``` displays the density matrix of a state $\ket{psi}$.
- The hinton diagram represents the values of a matrix using squares, whose size indicate the magnitude of their corresponding value and their color, its sign. A white square means the value is positive and a black one means negative

### State Pauli
- Tensor products of Pauli matrices are all observables that return +1 or -1. This plot displays the expectation values of the state on different Pauli operators as a bar chart.
- All density matrices can be written as a sum of these Pauli matrices, weighted by their expectation values.
- A document explaining where the coeficients for each of the Pauli operators come from is available in [PauliVec coefficients](../cheat/paulivec.md). 

### Examples
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
- City
<img width="623" height="339" alt="image" src="https://github.com/user-attachments/assets/2e129943-aacd-45b7-9b7f-39cc7a49c590" />

- Hinton
<img width="589" height="322" alt="image" src="https://github.com/user-attachments/assets/f163a966-ca8b-4dad-a52a-3f49d1048816" />

- Pauli

<img width="590" height="490" alt="image" src="https://github.com/user-attachments/assets/617626e1-1c90-49d5-bca9-238a9404bdce" />


Another example:  

$` \ket{\psi} = \begin{pmatrix} \frac{3\sqrt{2}}{10} \\ -\frac{4\sqrt{2}}{10} \\ -\frac{4\sqrt{2}i}{10} \\ \frac{3\sqrt{2}i}{10} \end{pmatrix};
\rho = \ket{\psi}\bra{\psi} = \begin{pmatrix}\frac{9}{50} & -\frac{6}{25} & \frac{6i}{25} & -\frac{9i}{50} \\ -\frac{6}{25} & \frac{8}{25} & -\frac{8i}{25} & \frac{6i}{25} \\ -\frac{6i}{25} & \frac{8i}{25} & \frac{8}{25} & -\frac{6}{25}  \\ \frac{9i}{50} & -\frac{6i}{25} & -\frac{6}{25} & \frac{9}{50}  \\ \end{pmatrix}`$

- City
<img width="624" height="337" alt="image" src="https://github.com/user-attachments/assets/e562c5d1-5098-4e9b-8900-fa9118aada94" />

- Hinton
<img width="589" height="322" alt="image" src="https://github.com/user-attachments/assets/64efa8de-5bfe-45f7-a32c-9a0f952a5b29" />

- Pauli

<img width="690" height="490" alt="image" src="https://github.com/user-attachments/assets/48b99586-a1e5-49e1-aa17-79d68f38051b" />

### Bloch Sphere

$\ket{\psi}=cos(\frac{\theta}{2})\ket{0}+e^{i\phi}sin(\frac{\theta}{2})\ket{1}$

$x = sin(\theta)cos(\phi)$  
$y = sin(\theta)sin(\phi)$  
$z = cos(\theta)$  

<img width="250" height="265" alt="Bloch_sphere svg" src="https://github.com/user-attachments/assets/71869977-9941-4eeb-983d-8ea61e02611b" />

