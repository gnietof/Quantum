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

### Sampler PUB

### Broadcasting rules
- Input arrays do not need to have the same number of dimensions.
  - The resulting array will have the same number of dimensions as the input array with the largest dimension.
  - The size of each dimension is the largest size of the corresponding dimension.
  - Missing dimensions are assumed to have size one.
- Shape comparisons start with the rightmost dimension and continue to the left.
- Two dimensions are compatible if their sizes are equal or if one of them is 1.

<img width="701" height="392" alt="image" src="https://github.com/user-attachments/assets/041b0092-73e5-404e-a069-93473c8ee531" />


