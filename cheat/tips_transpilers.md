# ⚠️ Work in Progress!

# Transpilers

## Stages
There are five stages in the transpilation process:
- **init**  
Used to translate any gates that operate on more than two qubits, into gates that only operate on one or two qubits.
Also useful for custom initializations.

- **layout**  
Maps 'virtual' qubits in a circuit to the 'physical' qubits in a real device and stores the information in a Layout object.
Two passes for this layout step:
    - TrivialLayout: maps one to one.
    - VF2Layout: uses VF2++ algorithm and if multiple solutions are found, a scoring heuristic is run. The heuristic state also includes two passes:
        - DenseLayout: Finds the sub-graph of the device with the greatest connectivity and that has the same number of qubits
as the circuit.
        - SabreLayout: This pass selects a layout by starting from an initial random layout and repeatedly running the
SabreSwap algorithm.

- **routing**
The layout process selects which 'physical' qubits wull be used while the routinh process adds the required SWAP gates to implement the two-qubit bit gates between qubits that are not directly connected.
The SabreSwap algorithm is used for this purpose.

- **translation**
This process translates (or unrolls) the gates specified in a circuit to the native basis gates of a specified backend.

Some operations are especially important: 
- SWAP: If not included natively requires three CNOT/CX gates.
- Toffoli: Requires at least fifteen gates (nine one-qubit gates and six two-qubit gates; see [Decompose](tips_basic.md#Decompose)).
 
- **optimization**
This stage centers around decomposing quantum circuits into the basis gate set of the target device, and must fight against the
increased depth from the layout and routing stages. These methods are so effective that the resulting circuit might even have a lower depth than the inputs!

After all the optimizations, a final check is done so that the circuit is only composed of gates includid in the basis gates in the target backend.

- **scheduling**  

## Error mitigation and suppression
There are several error mitigation techniques. There is a sample question which mentions which is the technique which can be enabled using the resilience options.

### Dynamical Decoupling
Dynamical decoupling can be enabled by setting **enable** to **True** in the dynamical decoupling options.
```python
estimator = Estimator(mode=backend)
estimator.options.dynamical_decoupling.enable = True
estimator.options.dynamical_decoupling.sequence_type = "XpXm"
```

### Pauli Twirling
Pauli twirling can be enabled by setting **enable_gates** to **True** in the twirling options.
```python
estimator = Estimator(mode=backend)
estimator.options.twirling.enable_gates = True
estimator.options.twirling.num_randomizations = 32
estimator.options.twirling.shots_per_randomization = 100
```

### Twirled readout error extinction (TREX)
TREX can be enabled by setting **measure_mitigation** to **True** in the Qiskit Runtime resilience options for Estimator.
```python
estimator = Estimator(mode=backend)
estimator.options.resilience.measure_mitigation = True
estimator.options.resilience.measure_noise_learning.num_randomizations = 32
estimator.options.resilience.measure_noise_learning.shots_per_randomization = 100
```

### Zero-noise extrapolation (ZNE)
Zero-noise extrapolation (ZNE) is a technique for mitigating errors in estimating expectation values of observables. Two stages: Noise amplification and Extrapolation. 
This is the one which is enabled by setting the resilience options.
```python
estimator = Estimator(mode=backend)
estimator.options.resilience.zne_mitigation = True
estimator.options.resilience.zne.noise_factors = (1, 3, 5)
estimator.options.resilience.zne.extrapolator = "exponential"
```

### Probabilistic Error Amplification (PEA)
This option also uses the resilience options ... but was not included in the sample exam question.
```python
estimator = Estimator(mode=backend)
estimator.options.resilience.zne_mitigation = True
estimator.options.resilience.zne.amplifier = "pea"
```

### Probabilistic error cancellation (PEC)
This option also uses the resilience options ... but was not included in the sample exam question.
```python
estimator = Estimator(mode=backend)
estimator.options.resilience.pec_mitigation = True
estimator.options.resilience.pec.max_overhead = 100
```

