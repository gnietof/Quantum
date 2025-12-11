**Note**. This document is huge (95 printed pages). I will cover what I think are the main points for the certification.

# QuantumCircuit
- Core Qiskit representation of a quantum circuit.

## Circuit Attributes
- QuantumCircuit has a small number of public attributes, which are mostly older functionality. Most of its functionality is accessed through methods.
### Mutable
- global_phase. The global phase of the circuit, measured in radians.
- metadata. Arbitrary user mapping, which Qiskit will preserve through the transpiler, but otherwise completely ignore.
- name. An optional name for the circuit.
### Inmutable
- ancillas. List of AncillaQubits tracked by the circuit.
- cregs. List of ClassicalRegisters tracked by the circuit.
- clbits. List of Clbits tracked by the circuit.
- data. List of individual CircuitInstructions that make up the circuit.
- layout. Hardware layout and routing information added by the transpiler.
- num_ancillas. The number of ancilla qubits in the circuit.
- num_clbits. The number of clbits in the circuit.
- num_parameters. Number of compile-time Parameters in the circuit.
- num_qubits. Number of qubits in the circuit.
- parameters. Ordered set-like view of the compile-time Parameters tracked by the circuit.
- qregs. List of QuantumRegisters tracked by the circuit.
- qubits. List of Qubits tracked by the circuit.

- The core attribute is data. This is a sequence-like object that exposes the CircuitInstructions contained in an ordered form.
- You generally should not mutate this object directly; QuantumCircuit is only designed for append-only operations (which should use append()). Most operations that mutate circuits in place should be written as transpiler passes (qiskit.transpiler).

## Creating new circuits
- __init__. Default constructor of no-instruction circuits. Accepts regs (a list of quibits or classical registers), name, global_phase, metadata, 
- copy. Make a complete copy of an existing circuit.
- copy_empty_like. Copy data objects from one circuit into a new one without any instructions.
- from_instructions. Infer data objects needed from a list of instructions.

## Data objects in circuits

