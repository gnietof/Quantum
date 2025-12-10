# Primitive inputs and outputs

- Primitives provide with the ability to efficiently define vectorized workloads by using a data structure known as a Primitive Unified Bloc (PUB).
- PUBs are the fundamental unit of work a QPU needs to execute these workloads.
- They are used as inputs to the run() method for the Sampler and Estimator primitives, which execute the defined workload as a job.
- After the job has completed, the results are returned in a format that is dependent on both the PUBs used as well as the runtime options specified from the Sampler or Estimator primitives.

## Overview of PUBs

- When invoking a primitive's run() method, the main argument that is required is a list of one or more tuples -- one for each circuit being executed by the primitive.
- Each of these tuples is considered a PUB
- The required elements of each tuple in the list depends on the primitive used.
- The data provided to these tuples can also be arranged in a variety of shapes to provide flexibility in a workload through broadcasting.

### Estimator PUB
- For the Estimator primitive, the format of the PUB should contain at most four values:
  - A single QuantumCircuit, which may contain one or more Parameter objects.
  - A list of one or more observables, which specify the expectation values to estimate, arranged into an array. The data can be in any one of the ObservablesArrayLike format such as Pauli, SparsePauliOp, PauliList, or str.
  - A collection of parameter values to bind the circuit against. This can be specified as a single array-like object where the last index is over circuit Parameter objects, or omitted if the circuit has no Parameter objects.
  - (Optionally) a target precision for expectation values to estimate

### Sampler PUB
- For the Sampler primitive, the format of the PUB tuple contains at most three values:
  - A single QuantumCircuit, which may contain one or more Parameter objects. These circuits should also include measurement instructions for each of the qubits to be sampled.
  - A collection of parameter values to bind the circuit against. This can be omitted if no Parameter objects are used.
  - (Optionally) a number of shots to measure the circuit with

### Broadcasting rules
- Input arrays do not need to have the same number of dimensions.
  - The resulting array will have the same number of dimensions as the input array with the largest dimension.
  - The size of each dimension is the largest size of the corresponding dimension.
  - Missing dimensions are assumed to have size one.
- Shape comparisons start with the rightmost dimension and continue to the left.
- Two dimensions are compatible if their sizes are equal or if one of them is 1.

<img width="701" height="392" alt="image" src="https://github.com/user-attachments/assets/041b0092-73e5-404e-a069-93473c8ee531" />

# Overview of primitive outputs
- Once one or more PUBs are sent to a QPU for execution and a job successfully completes, the data is returned as a ```PrimitiveResult``` container object accessed by calling the RuntimeJobV2.result() method.
- The PrimitiveResult contains an iterable list of PubResult objects that contain the execution results for each PUB.
- Depending on the primitive used, these data will be either expectation values and their error bars in the case of the Estimator, or samples of the circuit output in the case of the Sampler.
- Each of these PubResult objects possess both a data and a metadata attribute.
  - The data attribute is a customized DataBin that contains the actual measurement values, standard deviations, and so forth.
  - This DataBin has various attributes depending on the shape or structure of the associated PUB as well as the error mitigation options specified by the primitive used to submit the job (for example, ZNE or PEC).
  - The metadata attribute contains information about the runtime and error mitigation options used.

## Estimator output
- Each PubResult for the Estimator primitive contains at least an array of expectation values (PubResult.data.evs) and associated standard deviations, but can contain more data depending on the error mitigation options that were specified.

## Sampler output
- When a Sampler job is completed successfully, the returned PrimitiveResult object contains a list of SamplerPubResults, one per PUB.
- The data bins of these SamplerPubResults are dict-like objects that contain one BitArray per ClassicalRegister in the circuit.
- The BitArray class is a container for ordered shot data. 

## Result metadata
- In addition to the execution results, both the PrimitiveResult and PubResult objects contain a metadata attribute about the job that was submitted.
- The metadata containing information for all submitted PUBs can be found in the PrimitiveResult.metatada, while the metadata specific to each PUB is found in PubResult.metadata.
