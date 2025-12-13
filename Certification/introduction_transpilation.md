# Introduction to transpilation
- Transpilation is the process of rewriting a given input circuit to match the topology of a specific quantum device, and optimize the circuit instructions for execution on noisy quantum computers.
- A central component of the Qiskit SDK, the transpiler is designed for modularity and extensibility.
- Its main use is to write new circuit transformations (known as transpiler passes), and combine them with other existing passes, greatly reducing the depth and complexity of quantum circuits.
- Which passes are chained together and in which order has a major effect on the final outcome.
- This pipeline is determined by the PassManager and StagedPassManager objects.
- The StagedPassManager orchestrates the execution of one or more PassManagers and determines the order in which they are executed, while the PassManager object is merely a collection of one or more passes.

## Instruction set architecture
- In addition to reducing the depth and complexity of quantum circuits, the transpiler is designed to transform the instructions contained in a given QuantumCircuit to obey the Instruction Set Architecture (ISA) of a particular backend.
- Circuits obeying the ISA consist only of instructions that are supported by the backend's Target, such as the hardware's available basis gates, measurements, resets, and control flow operations, and comply with the constraints specified by the connectivity of the hardware, that is, the target's CouplingMap.
- When submitting a job to an IBM Quantum® backend, the circuits must adhere to the backend's ISA.
## Transpiler stages
- Qiskit's prebuilt transpiler pipeline consists of six fundamental stages:
  - **init**. This pass runs any initial passes that are required before the circuit can be embedded. This typically involves unrolling custom instructions and converting the circuit to all single- and two-qubit gates.  
    By default, this validates the circuit instructions and translates multi-qubit gates into single- and two-qubit gates.
  - **layout**. This pass applies a layout, mapping the virtual qubits in your circuit to the QPU's physical qubits.
  - **routing**. This pass runs after a layout has been applied and will inject gates (that is, SWAPs) in the original circuit to make it compatible with the QPU's connectivity (coupling map).
  - **translation**. This pass translates the gates in the circuit to the QPU's basis set of instructions.
  - **optimization**. This pass runs an optimization loop to find more efficient decompositions of the quantum circuit until a condition is met (such as a fixed depth).
  - **scheduling**. This stage is for any hardware-aware scheduling passes. If the user specifies a scheduling method, this stage accounts for all idle time in the circuit.

## Transpile with pass managers
- The recommended way to transpile a circuit is to create a staged pass manager and then execute its run method with your circuit as input.
- You can use the ```generate_preset_pass_manager``` function to generate a staged pass manager with reasonable defaults.

- More advanced users can customize a set of PassManager and StagedPassManager objects and determine the order in which each stage is run.
- This can dramatically change the final output circuit.
- In fact, a custom approach to transpiling a quantum algorithm often produces more efficient error suppression than the default approach.
- A custom approach involves rewriting quantum circuits to match hardware constraints and suppress the effects of noise.
- The flow of logic for this tool chain is customizable and need not be linear.
- The transpilation process can prepare iterative loops, conditional branches, and other complex behaviors.
- A good starting place when developing a set of custom passes is to examine the default sequence of transformations.

## Default transpilation
- For a simpler, but less customizable, "out-of-the-box" way to use the transpiler, use the qiskit.compiler.transpile function.
- This generates and runs one of the preset StagedPassManagers based on, among other options, an optimization_level flag that can be set to 0, 1, 2, or 3.
- Higher levels generate more optimized circuits at the expense of longer transpilation times.

