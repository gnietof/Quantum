# Certification basics
- Estimators and Samplers provide an abstraction of the backend implementation.
- Samplers return the outputs of executing a circuit multiple times.
- Estimators provide the result of $\\braket{O}=\\braket{\\psi|O|\\psi}$ where $\\ket{O}$ is the observable and $\\ket{\\psi}$ is the result of applying our circuit to the initial state vector $\\ket{0}$.
- There are different implementations of the primitives: ```EstimatorV2```/```SamplerV2``` (for execution on a QPU), ```StatevectorEstimator```/```StatevectorSampler```(execution on the simulator) and ```BaseEstimatorV2```/```BaseSamplerV2``` for execution on other backends (fake ones, for example).
- Both Sampler and Estimator accept PUBs as inputs and provide ```PubResult```as outputs. But the PUB's are slightly different:
  - Estimator: (circuit, observable(s), [parameter(s)], [precision]).
  - Sampler: (circuit, [parameter(s)], [shots]).

# Introdution to primitives
- As access to QPUs became more widespread, and with more quantum algorithms being developed, again the need for a higher-level abstraction emerged. Qiskit introduced the primitives interface, in response to the need for a higher-level abstraction when accessing to QPUs.
- Primitives are optimized for two core tasks in quantum algorithm development: expectation value estimation (Estimator) and circuit sampling (Sampler).

## What is a primitive?
- In this context, a primitive is the smallest processing instruction, the simplest building block from which one can create something useful for a given abstraction level.
- The two most common tasks for quantum computers are sampling quantum states and calculating expectation values. These tasks motivated the design of the Qiskit primitives: Estimator and Sampler.

  - Estimator computes expectation values of observables with respect to states prepared by quantum circuits.
  - Sampler samples the output register from quantum circuit execution.

## Primitive definition and implementations
- There are two types of Qiskit primitives: the base classes, and their implementations.
- The Qiskit primitives are defined by open-source primitive base classes that live in the Qiskit SDK (in the qiskit.primitives module).
- Providers (such as Qiskit Runtime) can use these base classes to derive their own Sampler and Estimator implementations. Most users will interact with provider implementations, not the base primitives.

### Base classes
- ```BaseEstimatorV2``` and ```BaseSamplerV2``` are the abstract classes which define a common interface for implementing primitives.
- General users will not directly use base classes as these are only for those who are interested in creating their own primitives-based execution fopr a specific provider.

### Implementations
- The Qiskit Runtime primitives ```EstimatorV2``` and ```SamplerV2``` provide a more sophisticated implementation (for example, by including error mitigation) as a cloud-based service. This implementation of the base primitives is used to access IBM Quantum hardware. They are accessed through IBM Qiskit Runtime.
- ```StatevectorEstimator``` and ```StatevectorSampler``` are the reference implementations of the primitives that **use the simulator built into Qiskit**. They are built with the Qiskit quantum_info module, producing results based on ideal statevector simulations. They are accessed through Qiskit.
- ```BackendEstimatorV2``` and ```BackendSamplerV2``` are use to “wrap” any quantum computing resource into a primitive. This lets you write primitive-style code for providers that don’t yet have a primitives-based interface. These classes can be used just like the regular Sampler and Estimator, except they should be initialized with an additional backend argument for selecting which quantum computer to run on. They are accessed by using Qiskit.

## Benefits of Qiskit primitives
- Qiskit users can write quantum code for a specific QPU without having to explicitly manage every detail.
- Because of the additional layer of abstraction, you might be able to more easily access advanced hardware capabilities of a given provider.

## Primitive details

### Estimator
- The Estimator primitive computes the expectation values for one or more observables with respect to states prepared by quantum circuits.
- The circuits can be parametrized, as long as the parameter values are also provided as input to the primitive.
- The input is an array of [PUBs](./primitive_input_output.md#Overview-of-PUBs). Each PUB is in the format (circuit, observable(s), [parameter(s)], [precision]).
- The output is a ```PUBResult``` that contains the computed expectation values per pair, and their standard errors, in PubResult form.

### Sampler
- The Sampler samples the output register from the execution of one or more quantum circuits.
- The circuits can be parametrized, as long as the parameter values are also provided as input to the primitive.
- The input is an array of [PUBs](./primitive_input_output.md#Overview-of-PUBs). Each PUB is in the format (circuit, [parameter(s)], [shots]).
- The output is counts or per-shot measurements, as PubResult objects, without weights. 



