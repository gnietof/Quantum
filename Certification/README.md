h# Qiskit 2.x Certification

## 1. Perform Quantum Operations (16% $`\equiv`$ 11 questions)
### 1.1. Define Pauli Operators
- [Pauli](./pauli.md) 🚧 *Doc in progress*
### 1.2. Apply quantum operations :
- [Circuit library](./circuit_library.md) 🚧 *Doc in progress*
- [QuantumCircuit](./quantumcircuit.md) 🚧 *Doc in progress*
## 2. Visualize Quantum circuits, measurements and states (11% $`\equiv`$ 8 questions)
### 2.1. Visualize quantum circuits
- [Visualize circuits](./visualize_circuits.md) ✅
### 2.2. Visualize quantum measurements
- [Classical feedforward and control flow](./classical_feedforward_and_control_flow.md) ✅
- [Visualization](./visualization.md) 🚧 *Doc in progress*
- [Plot gate map](./plot_gate_map.md) 🚧 *Doc in progress*
### 2.3. Visualize quantum states
- [Classical feedforward and control flow](./classical_feedforward_and_control_flow.md) ✅

## 3. Create quantum circuits (18% $`\equiv`$ 12 questions)
### 3.1. Construct dynamic circuits
- [Feedforward and control flow](./classical_feedforward_and_control_flow.md) (same as 2.2's) ✅
### 3.2. Construct parameterized circuits
- [Circuit Parameter](./circuit_parameter.md) ✅
- [Circuit QuantumCircuit](./circuit_quantumcircuit.md) (same as 3.4's) 🚧 *Doc in progress*
- [Circuit Parameter Expression](./circuit_expression.md) 🚧 *Doc in progress*
### 3.3. Transpile and optimize circuits
- [Transpiler Stages](./transpiler_stages.md) 📝*Needs more detail*
- [Transpiler with Passs Managers](./transpiler_with_pass_managers.md) 🚧 *Doc in progress*
- [Transpiler passes](./transpiler_passes.md) 🚧 *Doc in progress*
### 3.4. Construct basic quantum circuits
- [Circuit](./circuit.md) 📝*Needs more detail*
- [Circuit QuantumCircuit](./circuit_quantumcircuit.md) (same as 3.2's) 🚧 *Doc in progress*

## 4. Run quantum circuits (15% $`\equiv`$ 10 questions)
### 4.1. Demonstrate an understanding of execution modes such as: session with dedicated, priority, and batch mode
- [Execute on hardware](./execute_on_hardweare.md) (same as 4.2's) 🚧 *Doc in progress*
- [Execution modes](./execution_modes.md) 🚧 *Doc in progress*
- [Choose execution modes](./choose_executio_mode.md) 🚧 *Doc in progress*
- [Run jobs in batch](./run_jobs_batch.md) 🚧 *Doc in progress*
### 4.2. Demonstrate understanding of how to run quantum circuits with real hardware using Qiskit Runtime primitives and applying broadcasting rules
- [Execute on hardware](./execute_on_hardweare.md) (same as 4.1's) 🚧 *Doc in progress*
- [Primitives](./primitives.md) 🚧 *Doc in progress*
- [Primitive inputs and outputs](./primitive_input_output.md) 🚧 *Doc in progress*
- [Run jobs in session](./run_jobs_session.md) 🚧 *Doc in progress*

## 5. Use the sampler primitive (12% $`\equiv`$ 8 questions)
### 5.1. Set sampler primitive options such as dynamical decoupling
- [Get started with primitives](./get_started_with_primitives.md) (same as 5.2's) ✅
- [Sampler options](./sampler_options.md) 🚧 *Doc in progress*
- [Twirling options](./twirling_options.md) (same as 6.1's)🚧 *Doc in progress*
- [Error mitigation and supression techniques](./error_mitigation.md) (same as 6.2's) ✅
### 5.2. Understand the theoretical background behind the sampler primitive
- [Get started with primitives](./get_started_with_primitives.md) (same as 5.1's) ✅
- [Sampler v2](./sampler_v2.md) 🚧 *Doc in progress*
- [Primitives v2](./primitives_v2.md) (related to 6.2's)🚧 *Doc in progress*

## 6. Use the estimator primitive (12% $`\equiv`$ 8 questions)
### 6.1 Set estimator primitive options (such as resilience levels)
- [Estimator options](./estimator_options.md) 🚧 *Doc in progress*
- [Twirling options](./twirling_options.md) (same as 5.1's)🚧 *Doc in progress*
- [Resilience options v2](./resilience_options_v2.md)🚧 *Doc in progress*
- [ZNE options](./zne_options.md) 🚧 *Doc in progress*
### 6.2. Understand the theoretical background behind the estimator primitive                   
- [Primitives](./primitives.md) (related to 5.2's) 🚧 *Doc in progress*
- [Error mitigation and supression techniques](./error_mitigation.md) (same as 5.1's) ✅
## 7. Retrieve and analyze the results of quantum circuits (10% $`\equiv`$ 7 questions)
### 7.1. Retrieve previous experiment results (session/Qiskit Runtime)
- [SamplerPubResult](./sampler_pub_result.md)🚧 *Doc in progress*
- [Retrieve and save jobs](./save_jobs.md) ✅
- [Runtime job](./runtime_job.md)🚧 *Doc in progress*
- [Base Primitive](./base_primitive.md)🚧 *Doc in progress*
 
### 7.2. Monitor jobs
- [Providers](./providers.md)🚧 *Doc in progress*
- [Job Status](./job_status.md)🚧 *Doc in progress*
- [Session](./session.md)🚧 *Doc in progress*

## 8. Operate witn OpenQASM (6%  $`\equiv`$ 4 questions)
### 8.1. Structure types in OpenQASM 3 programs
- [QASM3 structures](./qasm3_structures.md) 🚧 *Incomplete*
### 8.2. Interpret OpenQASM semantics
- [QASM3 semantics](./qasm3_semantics.md) ✅
### 8.3. Interoperate different versions of OpenQASM with Qiskit
- [QASM3 versions](./qasm3_versions.md)🚧 *Doc in progress*
### 8.4. Interact with the Qiskit IBM Runtime REST API
- [QASM3 runtime](./qasm3_runtime.md)🚧 *Doc in progress*
