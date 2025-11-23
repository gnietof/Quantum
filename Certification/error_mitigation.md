# Error Mitigation
This is an high-level overview of the error supression and mitigation techniques.

## Dynamic Decoupling
- Dynamical decoupling is mainly useful for circuits containing gaps in which some qubits sit idle without any operations acting on them.
- Dynamical decoupling can be enabled by setting enable to True in the dynamical decoupling options.
- The ```sequence_type``` option can be used to pick from different pulse sequences. The default one is 'XX'.
```qasm
estimator = Estimator(mode=backend)
estimator.options.dynamical_decoupling.enable = True
estimator.options.dynamical_decoupling.sequence_type = "XpXm"
```

## Pauli Twirling
- Pauli twirling is a special kind of twirling that uses Pauli operations. It has the effect of transforming any quantum channel into a Pauli channel. Pauli twirling is often combined with other error mitigation techniques that work better with Pauli noise than with arbitrary noise.
- Pauli twirling is implemented by sandwiching a chosen set of gates with randomly chosen single-qubit Pauli gates in such a way that the ideal effect of the gate remains the same.
- When sampling the circuit, samples are drawn from multiple random instances, rather than just a single one.
- This technique is often applied exclusively to (native) two-qubit gates.
- Pauli twirling can be enabled by setting enable_gates to True in the twirling options. Other options include:
  - num_randomizations: The number of circuit instances to draw from the ensemble of twirled circuits.
  - shots_per_randomization: The number of shots to sample from each circuit instance.

```qasm 
estimator = Estimator(mode=backend)
estimator.options.twirling.enable_gates = True
estimator.options.twirling.num_randomizations = 32
estimator.options.twirling.shots_per_randomization = 100
```

## Twirled readout error extinction (TREX)
- Twirled readout error extinction (TREX) mitigates the effect of measurement errors for the estimation of Pauli observable expectation values.
- TREX can be enabled by setting measure_mitigation to True in the Qiskit Runtime resilience options for Estimator.
```qasm 
estimator = Estimator(mode=backend)
estimator.options.resilience.measure_mitigation = True
estimator.options.resilience.measure_noise_learning.num_randomizations = 32
estimator.options.resilience.measure_noise_learning.shots_per_randomization = 100
```

## Zero-noise extrapolation (ZNE)
- Zero-noise extrapolation (ZNE) is a technique for mitigating errors in estimating expectation values of observables. While it often improves results, it is not guaranteed to produce an unbiased result.
- ZNE consists of two stages:
  - Noise amplification: The original quantum circuit is executed multiple times at different noise rates.
  - Extrapolation: The ideal result is estimated by extrapolating the noisy expectation value results to the zero-noise limit.
- ZNE can be enabled by setting zne_mitigation to True in the Qiskit Runtime resilience options for Estimator. Other options include (although they are not required to be set explicitly):
  - noise_factors: The noise factors to use for noise amplification.
  - extrapolator: The functional form to use for the extrapolation.
```qasm 
estimator = Estimator(mode=backend)
estimator.options.resilience.zne_mitigation = True
estimator.options.resilience.zne.noise_factors = (1, 3, 5)
estimator.options.resilience.zne.extrapolator = "exponential"
```
  
## Probabilistic Error Amplification (PEA)
- One of the main challenges in ZNE is to accurately amplify the noise affecting the target circuit. Gate folding provides an easy way to perform this amplification, but is potentially inaccurate and might lead to incorrect results.
- PEA is a more sophisticated technique that performs preliminary experiments to reconstruct the noise and then uses this information to perform an accurate amplification.
- PEA consists of three stages:
  - Learning: The twirled noise model of each layer of entangling gates in the circuit is learned.
  - Noise amplification: The original quantum circuit is executed multiple times at different noise factors.
  - Extrapolation: The ideal result is estimated by extrapolating the noisy expectation value results to the zero-noise limit.
- Because PEA is a ZNE noise amplification technique, you also need to enable ZNE by setting ```resilience.zne_mitigation = True```.
```qasm 
estimator = Estimator(mode=backend)
estimator.options.resilience.zne_mitigation = True
estimator.options.resilience.zne.amplifier = "pea"
```

## Probabilistic error cancellation (PEC)
- Probabilistic error cancellation (PEC) is a technique for mitigating errors in estimating expectation values of observables. Unlike ZNE, it returns an unbiased estimate of the expectation value. However, it generally incurs a greater overhead.
- PEC can be enabled by setting pec_mitigation to True in the Qiskit Runtime resilience options for Estimator. 
```qasm 
estimator = Estimator(mode=backend)
estimator.options.resilience.pec_mitigation = True
estimator.options.resilience.pec.max_overhead = 100
```
