# ⚠️ Work in Progress!

# Transpilers

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

