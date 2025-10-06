# Primitives

Primitives are the smallest processing instruction, the simplest building block from which one can create something useful
for a given abstraction level.
The two most common tasks are sampling quantum states and calculating expectation values. These tasks motivated the design of the Qiskit Estimator and Sampler primitives.

- Base classes
```BaseEstimatorV2``` and ```BaseSamplerV2``` are the abstract classes which define a common interface for implementing primitives.
- Implementations
    - ```EstimatorV2``` and ```SamplerV2``` provide a more sophisticated implementation as a Cloud service (to be run on IBM Quantum hardware).
    - ```StatevectorEstimator``` and ```StatevectorSampler``` are the reference implementations to use on the simulator built into Qiskit. The results are based on ideal statevector simulations
    - ```BackendEstimatorV2``` and ```BackendSamplerV2``` can be used to wrap any quantum computing resource into a primitive.

## Estimator
An Estimator computes expectation values of observables with respect to states prepared by quantum circuits.
The expectation value of an observable $O$ in state $\\ket{\\psi}$ is:  

$$\\braket{O}=\\braket{\\psi|O|\\psi}$$

Where $\\ket{\\psi}$ is the result of applying our circuit to the initial state vector $\\ket{0}$:\n",
    
$$\\ket{\\psi} = U\\ket{0}$$

The input in the Estimator is an array of PUBs (Primitive Unified Bloc) each of them having the format:
```
(<circuit>,<observables>,[<parameters>],[<precision>])
```
The output is a PubResult which includes the computed expectation values per pair and their standar errors.

## Example
In this ![Estimator example](./example_estimator.md) we can see all the calculations using algebra, qiskit operations and an estimator.

## Sampler
A Sampler samples the output regiser from quantum circuit execution.
