# Qiskit 2.x Certification

**Note**: I have used different icons to indicate different information about each of the sections. These are my **own** estimates.  
  🚧: The document is still being written or not even started.  
  📝: Most important details included but additional work might be required.  
  ✅: Document complete.  
  ⭐: The number of stars indicate my guess on the importance of that section. More stars means more important. For example, I think that the 'Job Status' provides not much value other than knowing which values are valid or not.  
  🔴: The contents in this section are complex.  
  🟠: The contents in this section are intermediate.  
  🟢: The contents in this section are easy.  
  
## 1. Perform Quantum Operations (16% $`\equiv`$ 11 questions)
### 1.1. Define Pauli Operators
- [Pauli](./pauli.md) ✅⭐⭐🟠
### 1.2. Apply quantum operations :
- [Circuit library](./circuit_library.md) ✅⭐🟠
- [QuantumCircuit](./quantumcircuit.md) 🚧 *Doc in progress*
- **Bonus**. [Operators](./operators.md) 🚧 *Doc in progress*
## 2. Visualize Quantum circuits, measurements and states (11% $`\equiv`$ 8 questions)
### 2.1. Visualize quantum circuits
- [Visualize circuits](./visualize_circuits.md) ✅⭐🟢
### 2.2. Visualize quantum measurements
- [Classical feedforward and control flow](./classical_feedforward_and_control_flow.md) (same as 3.1's)✅⭐⭐🟢
- [Visualization](./visualization.md) ✅⭐⭐🟠
- [Plot gate map](./plot_gate_map.md) ✅⭐🟢
### 2.3. Visualize quantum states
- [Plot bloch multivector](./visualization.md#bloch-multivector) ✅⭐⭐🟠
- [Plot state qsphere](./visualization.md#bloch-vector) ✅⭐⭐🟠

## 3. Create quantum circuits (18% $`\equiv`$ 12 questions)
### 3.1. Construct dynamic circuits
- [Feedforward and control flow](./classical_feedforward_and_control_flow.md) (same as 2.2's) ✅⭐⭐🟢
### 3.2. Construct parameterized circuits
- [Circuit Parameter](./circuit_parameter.md) ✅⭐⭐🟢
- [Circuit QuantumCircuit](./circuit_quantumcircuit.md) (same as 3.4's) 🚧 *Doc in progress*
- [Circuit Parameter Expression](./circuit_expression.md) ✅⭐🟢
### 3.3. Transpile and optimize circuits
- [Transpiler Stages](./transpiler_stages.md) 📝*Needs more detail*⭐⭐⭐🔴
- [Transpiler with Passs Managers](./transpiler_with_pass_managers.md) ✅⭐⭐🟢
- [Transpiler passes](./transpiler_passes.md) 📝*Needs more detail*⭐🟠
### 3.4. Construct basic quantum circuits
- [Circuit](./circuit.md) 📝*Needs more detail*
- [Circuit QuantumCircuit](./circuit_quantumcircuit.md) (same as 3.2's) 🚧 *Doc in progress*

## 4. Run quantum circuits (15% $`\equiv`$ 10 questions)
### 4.1. Demonstrate an understanding of execution modes such as: session with dedicated, priority, and batch mode
- [Execute on hardware](./execute_on_hardware.md) (same as 4.2's) ✅⭐🟢
- [Execution modes](./execution_modes.md) ✅⭐🟢
- [Choose execution mode](./choose_execution_mode.md) ✅⭐🟢
- [Run jobs in batch](./run_jobs_batch.md) ✅⭐⭐🟢
### 4.2. Demonstrate understanding of how to run quantum circuits with real hardware using Qiskit Runtime primitives and applying broadcasting rules
- [Execute on hardware](./execute_on_hardware.md) (same as 4.1's) ✅⭐🟢
- [Primitives](./primitives.md) ✅⭐⭐🟢
- [Primitive inputs and outputs](./primitive_input_output.md) ✅⭐⭐🟠
- [Run jobs in session](./run_jobs_session.md) ✅⭐⭐🟢

## 5. Use the sampler primitive (12% $`\equiv`$ 8 questions)
### 5.1. Set sampler primitive options such as dynamical decoupling
- [Get started with primitives](./get_started_with_primitives.md) (same as 5.2's) ✅⭐⭐⭐🔴
- [Sampler options](./sampler_options.md) ✅⭐🟢
- [Twirling options](./twirling_options.md) (same as 6.1's) :soon: *Not yet*
- [Error mitigation and supression techniques](./error_mitigation.md) (same as 6.2's) ✅⭐⭐🟠
### 5.2. Understand the theoretical background behind the sampler primitive
- [Get started with primitives](./get_started_with_primitives.md) (same as 5.1's) ✅⭐⭐⭐🔴
- [Sampler v2](./sampler_v2.md) ✅⭐🟢
- [Primitives v2](./primitives_v2.md) (related to 6.2's) ✅⭐🟠

## 6. Use the estimator primitive (12% $`\equiv`$ 8 questions)
### 6.1 Set estimator primitive options (such as resilience levels)
- [Estimator options](./estimator_options.md) 🚧 *Doc in progress*
- [Twirling options](./twirling_options.md) (same as 5.1's) :soon: *Not yet*
- [Resilience options v2](./resilience_options_v2.md) :soon: *Not yet*
- [ZNE options](./zne_options.md) :soon: *Not yet*
### 6.2. Understand the theoretical background behind the estimator primitive                   
- [Primitives](./primitives.md) (related to 5.2's) ✅⭐⭐⭐🟠
- [Error mitigation and supression techniques](./error_mitigation.md) (same as 5.1's) ✅⭐⭐🟠

## 7. Retrieve and analyze the results of quantum circuits (10% $`\equiv`$ 7 questions)
### 7.1. Retrieve previous experiment results (session/Qiskit Runtime)
- [SamplerPubResult](./sampler_pub_result.md) :soon: *Not yet*
- [Retrieve and save jobs](./save_jobs.md) ✅⭐🟢
- [Runtime job](./runtime_job.md) :soon: *Not yet*
- [Base Primitive](./base_primitive.md) ✅⭐🟢
### 7.2. Monitor jobs
- [Providers](./providers.md) ✅⭐🟠
- [Job Status](./job_status.md) ✅⭐🟢
- [Session](./session.md) ✅⭐🟢

## 8. Operate witn OpenQASM (6%  $`\equiv`$ 4 questions)
### 8.1. Structure types in OpenQASM 3 programs
- [QASM3 structures](./qasm3_structures.md) 🚧 *Incomplete*
### 8.2. Interpret OpenQASM semantics
- [QASM3 semantics](./qasm3_semantics.md) ✅⭐🟢
### 8.3. Interoperate different versions of OpenQASM with Qiskit
- [QASM3 versions](./qasm3_versions.md) ✅⭐🟢
### 8.4. Interact with the Qiskit IBM Runtime REST API
- [QASM3 runtime](./qasm3_runtime.md) 🚧 *Incomplete*⭐🟢
