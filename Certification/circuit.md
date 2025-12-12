# Quantum Circuit Model
- The fundamental element of quantum computing is the quantum circuit. This is a computational routine that can be run, one shot at a time, on a quantum processing unit (QPU).
-  A circuit will act on a predefined amount of quantum data (in Qiskit, we only directly support qubits) with unitary operations (gates), measurements and resets.
-  In addition, a quantum circuit can contain operations on classical data, including real-time computations and control-flow constructs, which are executed by the controllers of the QPU.

## Concepts and definitions
- **abstract circuit**. A circuit defined in terms of abstract mathematical operations and virtual qubits. You turn an abstract circuit into a physical circuit by using Qiskit’s transpilation package.
- **ancilla qubit**. An extra qubit that is used to help implement operations on other qubits, but whose final state is not important for the program.
- **circuit**. A computational routine the defines a single execution to be taken on a QPU. This can either be an abstract circuit or a physical circuit.
- **clbit**. A Qiskit-specific abbreviation meaning a single classical bit of data.
- **gate**. A unitary operation on one or more qubits.
- **hardware qubit**. The representation of a single qubit on a particular QPU. A hardware qubit has some physical quantum-mechanical system backing it, such as superconducting circuits; unlike a virtual qubit, it has particular coupling constraints and only certain gates can be applied to certain groups of hardware qubits.
- **instruction set architecture (ISA)**. The abstract model of which operations are available on which sets of hardware qubits on one particular QPU. For example, one QPU may allow $\sqrt{X}$  and $R_Z$​ operations on all single hardware qubits, and $CX$ operations on certain pairs of hardware qubits.
- **logical qubit**. A collection of several physical qubits that are controlled together by a QPU (from the user’s perspective) to apply real-time quantum error correction. A logical qubit is a type of hardware qubit for Qiskit.
- **measurement**. The act of extracting one classical bit of a data from a single qubit state. This is an irreversible operation, and usually destroys entanglement and phase coherence between the target qubit and the rest of the system.
- **physical circuit**. A circuit defined in terms of hardware qubits and only the quantum operations available in a particular QPU’s ISA. Physical circuits are tied to one particular QPU architecture, and will not run on other incompatible architectures. You may also hear this referred to as an ISA circuit.
You typically get a physical circuit by using Qiskit’s transpilation routines on an abstract circuit that you constructed.
- **physical qubit**. A controllable two-level quantum system. This is literally one “physics” qubit, such as a transmon or the electronic state of a trapped ion. A QPU may expose this directly as its hardware qubit, or combine several physical qubits into a logical qubit.
- **quantum processing unit (QPU)**. Analogous to a CPU in classical computing or a GPU in graphics processing, a QPU is the hardware that runs quantum operations on quantum data. You can always expect a QPU that uses the circuit model of computation to be able to perform some set of gates, and measurement operations. Depending on the particular technology, they also may be able to run some real-time classical computations as well, such as classical control flow and bitwise calculations on classical data.
- **qubit**. The basic unit of quantum information.
- **real-time classical computation**. Any classical computation that can happen within the execution of a single shot of a circuit, where the results of the classical computation can affect later execution of the circuit. The amount of real-time classical computation available with particular QPUs will vary significantly dependent on many factors, such as the controlling electronics and the qubit technology in use. 
- **unitary operation**. A reversible operation on a quantum state. All quantum gates are unitary operations..
- **virtual qubit**. An abstract, mathematical qubit used to build an abstract circuit. Virtual qubits are how one typically thinks about quantum algorithms at a high level; we assume that all quantum gates are valid on all virtual qubits, and all virtual qubits are always connected to every other virtual qubit.

  When mapping to hardware, virtual qubits must be assigned to hardware qubits. This mapping need not be one-to-one. Typically, one virtual qubit will need to be swapped from one hardware qubit to another over the course of a circuit execution in order to satisfy coupling constraints of the underlying QPU. It is not strictly necessary for all virtual qubits used in a circuit to be mapped to a physical qubit at any given point in a physical circuit; it could be that a virtual qubit is measured (collapsing its state) and then never used again, so a new virtual qubit could take its place. Evaluating these conditions to map a virtual circuit to a physical circuit is the job of Qiskit’s transpilation package.

## API overview of qiskit.circuit
- The principal class is QuantumCircuit.
- Bit, an atom of data.  
   - Qubit  
   - ClBit  
   - AncillaQubit  

- Register, a collection of bits  
   - QuantumRegister  
   - ClassicalRegister  
   - AncitllaRegister  

- Within a circuit, each complete ```CircuitInstruction``` is made up of an ```Operation``` (which might be an ```Instruction```, a ```Gate```, or some other subclass) and the qubit and clbit operands.

- CircuitInstruction, an operation and its operands  
- InstructionSet, a temporary handle to a slice of circuit data  
- Operation  
   - AnnotatedOperation  
     - InverseModifier  
     - ControlModifier  
     - PowerModifier

- The most common concrete subclass of the minimal, abstract Operation interface is the Instruction.
- While Operation can include abstract mathematical objects, an Instruction is something that could conceivably run directly on hardware.
- This is in turn subclassed by Gate and ControlledGate that further add unitarity and controlled semantics on top:

  - Instruction, representing a hardware-based instruction
  - Gate, representing a hardware instruction that is unitary
  - ControlledGate, representing a gate with control structure.

- Qiskit includes a large library of standard gates and circuits, which is documented in qiskit.circuit.library.
- Many of these are declared as Python-object singletons.
- The machinery for this is described in detail in qiskit.circuit.singleton, of which the main classes are each a singleton form of the standard instruction–gate hierarchy:

  - SingletonInstruction
  - SingletonGate
  - SingletonControlledGate

## Representation of circuits in Qiskit

- The main user-facing class for representing circuits is QuantumCircuit.
- This can be either an abstract circuit or a physical circuit. 

- Internally, a QuantumCircuit contains the qubits, classical bits, compile-time parameters, real-time variables, and other tracking information about the data it acts on and how it is parametrized.
- It then contains a sequence of CircuitInstructions, which contain the particular operation (gate, measurement, etc) and its operands (the qubits and classical bits).

### Bits and regiters
- **Bit**
- **Qubit**
- **Clbit**
- **AncillaQubit**
- **Register**
- **QuantumRegister**
- **ClassicalRegister**
- **AncillaRegister**

### Instruction contexts

### Operations, instructions and gates

### Built-in special instructions
- **Measure**
- **Reset**
- **Delay**
- **Barrier**

### Real-time classical computation

### Compile-time parametrization

### Control flow in circuits

## Creating custom instructions
- If you wish to create simple one-off instructions or gates that will be added to a circuit, and the blocks are just being used for visualization or grouping purposes, the easiest way to create a custom instruction or gate is simply to build its definition as a QuantumCircuit, and then use its to_instruction() or to_gate() method as appropriate.
- The results can be given directly to QuantumCircuit.append() on the larger circuit.
- These methods will create base Instruction or Gate instances whose definition attribute is the circuit as supplied, meaning it will automatically be accessible to the transpiler, and to other Qiskit functions that attempt to decompose circuits.

## Working with circuit-level objects
### Apply Pauli twirling to a circuit
- There are two primary types of noise when executing quantum circuits.
  - The first is **stochastic**, **or incoherent**, noise that is **mainly due to the unwanted interaction between the quantum processor and the external environment** in which it resides.
  - The second is known as **coherent** error, and these errors arise due to **imperfect control of a quantum system**. 
- Pauli twirling is a quantum error suppression technique that uses randomization to **shape coherent error into stochastic errors** by combining the results from many random, but logically equivalent circuits, together.

## Circuit conventions
- Qiskit’s conventions are:  
    - In bitstring representations, bits are labelled with the right-most bit in the string called 0 and the left-most bit in the string of nn bits called n−1.
    - When using integers as bit-specifier indices in circuit-construction functions, the integer is treated as an index into QuantumCircuit.qubits (or clbits).
    - When drawing circuits, we put the lowest-index bits on top.
    - In statevector representations, we realize the abstract tensor product as the Kronecker product, and order the arguments to this such that the amplitude of computational-basis state $\ket{x}$, where x is the bitstring interpreted as an integer, is at location statevector[x].
    - When controlling a gate, the control qubit(s) is placed first in the argument list. 


  
  
  



