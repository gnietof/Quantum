# Doubts

## Aer vs AerSimulator 
### Qiskit Aer (package/module).
- Aer is the simulation backend provider included with the qiskit-aer package.
- It contains multiple backends—some legacy, some modern—including:
  - Aer.get_backend("aer_simulator")
  - Aer.get_backend("qasm_simulator") (legacy)
  - Aer.get_backend("statevector_simulator") (legacy)
- Think of Aer as the container of all simulation capabilities.

### AerSimulator
- AerSimulator is the main, modern simulator backend in Qiskit Aer. The new unified simulator backend.
- It replaces old simulators like qasm_simulator, statevector_simulator, and unitary_simulator.
- It supports many simulation modes, controlled by the method argument.

 1. "automatic" (default)  
   Aer automatically picks the best method based on Circuit size, Noise model, Memory availability.  
   Best for beginners.

 1. "statevector"  
   Computes the full quantum statevector. Allows access to amplitudes. Fastest for pure, noise-free simulation.  
   You need exact amplitudes or final state.  
   You don't use measurements until the end.  

 1. "density_matrix"
   Tracks a density matrix instead of a statevector.  
   Supports mixed states and noise, but is very memory-heavy (size grows as $4^n$ instead of $2^n$ for n qubits).  
   Use when you simulate decoherence or noise using full density-matrix evolution.  

 1. "matrix_product_state" (MPS)
   Efficient for circuits with limited entanglement.  
   Supports some kinds of noise.  
   Allows simulation of 50–100+ qubits (depending on entanglement).  
   User with large circuits that are not highly entangled (e.g., variational algorithms).  

  1. "stabilizer"
   Uses the Gottesman–Knill algorithm.  
   Supports only Clifford circuits (H, S, CNOT, measurement).  
   Extremely fast and scalable.  
   Use when you run Clifford-only circuits. You need very large-qubit simulations (1000+ qubits possible).  

  1. "extended_stabilizer"  
   Hybrid between stabilizer and non-stabilizer simulation.  
   Allows limited non-Clifford gates (T-gates) using approximation methods.  
   Faster than full statevector but less accurate.  
   Use for circuits that are mostly stabilizer with a few non-Clifford gates and algorithms like QAOA or VQE.  

  1. "unitary"
    Computes the full unitary matrix of the circuit. Dimension grows as $2^n x 2^n$ → extremely memory-heavy.  
    Use when you need the explicit unitary of a small circuit (≤10 qubits typical limit).  

  1. "superop"
    Computes the superoperator representation of the entire circuit.  
    Used for noisy process simulations. Even more expensive than unitary (size $4^n x 4^n$).  
    Use when doing quantum process tomography.




