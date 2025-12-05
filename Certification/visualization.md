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

## Count Visualizations
This section contains functions that visualize measurements outcome counts.

### Plot histogram
The ```plot_histogram``` function visualizes the result of sampling a quantum circuit on a QPU.
```python
from qiskit.visualization import plot_histogram

data = {'00':712,'01':10,'10':9,'11':269}
plot_histogram(data)
```
<img width="480" height="383" alt="image" src="https://github.com/user-attachments/assets/1547c6ad-1302-4ca1-9ba4-3b650c2b1e4a" />

- Samples might be displayed following different criteria. The most interesting are:
  - number_to_keep: number of terms to plot and the rest are group under 'rest'.
  - sort: sorting order ('asc','desc',hamming','value' or 'value_desc'
  - target_string: target string if 'sort' is a distance measure. (??)

## Distribution Visualizations
- This section contains functions that visualize sampled distributions.

### Plot distribution
- Plot a distribution from input sampled data.
- Compared to ```plot_histogram```, the quasi-probability is displayed instead of the number of outcomes.
```python
from qiskit.visualization import plot_distribution

data = {'00':712,'01':10,'10':9,'11':269}
plot_distribution(data)
```
<img width="490" height="390" alt="image" src="https://github.com/user-attachments/assets/7eb14c65-cc3c-4f8c-8e26-360bb8c3d785" />

- Samples might be displayed following different criteria. The most interesting are:
  - number_to_keep: number of terms to plot and the rest are group under 'rest'.
  - sort: sorting order ('asc','desc',hamming','value' or 'value_desc'
  - target_string: target string if 'sort' is a distance measure. (??)
 
```python
from qiskit.visualization import plot_distribution

data = {'00':712,'01':10,'10':9,'11':269}
plot_distribution(data,sort='value_desc')
```
<img width="490" height="390" alt="image" src="https://github.com/user-attachments/assets/b0924d2e-c7e6-4dc4-b50d-6af43fe59549" />

- Same as ```plot_histogram```, multiple datasets, titles, legends or colors and allowed.
```python
from qiskit.visualization import plot_distribution

data = [{'00':712,'01':10,'10':9,'11':269},{'00':308,'01':307,'10':185,'11':200}]
plot_distribution(data,sort='value_desc',title='Dates',legend=['Dates1','Dates2'])
```
<img width="489" height="390" alt="image" src="https://github.com/user-attachments/assets/7d4acc22-c19e-490b-a25b-25cbb90cde99" />

## State Visualizations
- This section contains functions that visualize quantum states.
- I have included examples of state visualizations for all bell states in [Bell states visualizations](../cheat/bell_visualizations.md)

### Bloch Sphere
- The Bloch Sphere is shown below.
- A state is displayed based on its coordinates which can be provided in cartesian or spherical systems.

$\ket{\psi}=cos(\frac{\theta}{2})\ket{0}+e^{i\phi}sin(\frac{\theta}{2})\ket{1}$

$x = sin(\theta)cos(\phi)$  
$y = sin(\theta)sin(\phi)$  
$z = cos(\theta)$  

<img width="250" height="265" alt="Bloch_sphere svg" src="https://github.com/user-attachments/assets/71869977-9941-4eeb-983d-8ea61e02611b" />

#### Example

\left(\frac{\theta}{2}\right)
(\frac{\theta}{2})

If we have the state $\psi = \frac{1}{\sqrt{2}}(\ket{0}-\ket{1})$ then:

$\ket{\psi}=cos(\frac{\theta}{2})\ket{0}+e^{i\phi}sin(\frac{\theta}{2})\ket{1} = \frac{1}{\sqrt{2}}(\ket{0}-\ket{1})$

So: 

$cos(\frac{\theta}{2}) = \frac{1}{\sqrt{2}} ; e^{i\phi}sin(\frac{\theta}{2}) = -\frac{1}{\sqrt{2}}$

$cos(\frac{\theta}{2}) = \frac{1}{\sqrt{2}} \rightarrow \frac{\theta}{2} = \frac{\pi}{4} \rightarrow \theta = \pm\frac{\pi}{2}$

If $\theta = \frac{\pi}{2}$ then:

$e^{i\phi}sin(\frac{\theta}{2}) = -\frac{1}{\sqrt{2}} \rightarrow e^{i\phi}sin(\frac{\pi}{4}) = \frac{e^{i\phi}}{\sqrt{2}} = -\frac{1}{\sqrt{2}} \rightarrow e^{i\phi}=-1 \rightarrow \phi = \pi$

If $\theta = -\frac{\pi}{2}$ then:

$e^{i\phi}sin(\frac{\theta}{2}) = -\frac{1}{\sqrt{2}} \rightarrow e^{i\phi}sin(\frac{\pi}{4}) = -\frac{e^{i\phi}}{\sqrt{2}} = -\frac{1}{\sqrt{2}} \rightarrow e^{i\phi}=1 \rightarrow \phi = 0$

Now we can plot our bloch sphere using spherical coordinates. Both options will display the same vector pointing to -x-axis (although it is complex to guess from the plot).
```python
from qiskit.visualization import plot_bloch_vector
from numpy import sqrt,pi

plot_bloch_vector([1,pi/2,pi],coord_type='spherical')
```

<img width="419" height="419" alt="image" src="https://github.com/user-attachments/assets/b13f37cf-9d75-41f8-b430-668e9b187d38" />

Likewise we migth find the cartesian coordinates now that we have $\theta$ and $\phi$.

$x = sin(\theta)cos(\phi) = sin(\frac{\pi}{2})cos(\pi) = -1$  
$y = sin(\theta)sin(\phi) = sin(\frac{\pi}{2})cos(\pi) = 0$  
$z = cos(\theta) = cos(\frac{\pi}{2}) = 0$

```python
from qiskit.visualization import plot_bloch_vector
from numpy import sqrt,pi

plot_bloch_vector([-1,0,0],coord_type='cartesian') # cartesian is the default so not required
```

<img width="419" height="419" alt="image" src="https://github.com/user-attachments/assets/b13f37cf-9d75-41f8-b430-668e9b187d38" />

### State City
- The ```plot_state_city``` displays the density matrix of a state $\ket{psi}$.

### State Hinton
- The ```plot_state_hinton``` displays the density matrix of a state $\ket{psi}$.
- The hinton diagram represents the values of a matrix using squares, whose size indicate the magnitude of their corresponding value and their color, its sign. A white square means the value is positive and a black one means negative

### State Pauli
- Tensor products of Pauli matrices are all observables that return +1 or -1. This plot displays the expectation values of the state on different Pauli operators as a bar chart.
- All density matrices can be written as a sum of these Pauli matrices, weighted by their expectation values.
- A document explaining where the coeficients for each of the Pauli operators come from is available in [PauliVec coefficients](../cheat/paulivec.md). 

### State QSphere
- Plot the qsphere representation of a quantum state.
- The size of the points is proportional to the probability of the corresponding term in the state and the color represents the phase.

#### Examples
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

- QSphere
<img width="560" height="559" alt="image" src="https://github.com/user-attachments/assets/ee96e273-d244-4f96-a99e-f6bff64d41b7" />


Another example:  

$` \ket{\psi} = \begin{pmatrix} \frac{3\sqrt{2}}{10} \\ -\frac{4\sqrt{2}}{10} \\ -\frac{4\sqrt{2}i}{10} \\ \frac{3\sqrt{2}i}{10} \end{pmatrix};
\rho = \ket{\psi}\bra{\psi} = \begin{pmatrix}\frac{9}{50} & -\frac{6}{25} & \frac{6i}{25} & -\frac{9i}{50} \\ -\frac{6}{25} & \frac{8}{25} & -\frac{8i}{25} & \frac{6i}{25} \\ -\frac{6i}{25} & \frac{8i}{25} & \frac{8}{25} & -\frac{6}{25}  \\ \frac{9i}{50} & -\frac{6i}{25} & -\frac{6}{25} & \frac{9}{50}  \\ \end{pmatrix}`$

- City
<img width="624" height="337" alt="image" src="https://github.com/user-attachments/assets/e562c5d1-5098-4e9b-8900-fa9118aada94" />

- Hinton
<img width="589" height="322" alt="image" src="https://github.com/user-attachments/assets/64efa8de-5bfe-45f7-a32c-9a0f952a5b29" />

- Pauli
<img width="690" height="490" alt="image" src="https://github.com/user-attachments/assets/48b99586-a1e5-49e1-aa17-79d68f38051b" />

- QSphere
<img width="560" height="559" alt="image" src="https://github.com/user-attachments/assets/360a0d64-4fa9-435e-a35f-154cdb6acfa3" />

## Device Visualizations

## Circuit Visualizations
- Draw the quantum circuit. I think it has exactly the same functionality as ```QuantumCircuit.draw```.
- Use the output parameter to choose the drawing format.
  
### Example

```python
from qiskit.visualization import circuit_drawer

circuit_drawer(qc,output='mpl')
```

<img width="3194" height="1062" alt="image" src="https://github.com/user-attachments/assets/9e3b0e5a-f3ba-40a2-a0d3-1fe63bffc334" />

## DAG Visualizations
- Plot the directed acyclic graph (dag) to represent operation dependencies in a quantum circuit.
  
### Example

```python
from qiskit.visualization.dag_visualization import dag_drawer
from qiskit.converters import circuit_to_dag

dag = circuit_to_dag(qc)
dag_drawer(dag)
```

<img width="471" height="1227" alt="image" src="https://github.com/user-attachments/assets/d5d5c1cb-ebbc-461f-89c0-49c9df55810e" />



## Pass Manager Visualizations
- Draws the pass manager.

```python
from qiskit.visualization import pass_manager_drawer
from qiskit.transpiler import generate_preset_pass_manager

pm = generate_preset_pass_manager()
pass_manager_drawer(pm,filename='pm_drawer.png')
```
<img width="12067" height="3668" alt="image" src="https://github.com/user-attachments/assets/0c842083-7330-4047-ace1-4fbef3e9bf96" />

## Timeline Visualizations
- Deprecated since 1.3

## Single Qubit State Transition Visualizations
- Deprecated since 1.2


