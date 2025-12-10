# Execute on target hardware
- The "execute on hardware" step of a Qiskit pattern involves running your circuits on hardware and produces the outputs of the quantum computation.
- The ISA circuits produced in the previous step can be executed using either a Sampler or Estimator primitive from Qiskit Runtime, initialized locally on your computer or from a cluster or other heterogeneous compute environment.
- These can be executed in a Batch, which allows parallel transpilation for classical computational efficiency - or a Session, which allows iterative tasks to be implemented efficiently without queuing delays. Note: Open Plan users cannot submit session jobs.
- During this step, there is also the option to configure certain error suppression and mitigation techniques provided by Qiskit Runtime.
- Depending on whether the Sampler or Estimator primitives are being used, the outcome of this step will be different.
  - If using the Sampler, the output will be per-shot measurements in the form of bitstrings.
  - If using the Estimator, the output will be expectation values of observables corresponding to physical quantities or cost functions.

**This document is a place holder for many documents which are covered in other sections**
