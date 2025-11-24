# Transpiler Stages

## Stages
There are five stages in the transpilation process:
- **init**  
Used to translate any gates that operate on more than two qubits, into gates that only operate on one or two qubits.
Also useful for custom initializations.

- **layout**  
Maps 'virtual' qubits in a circuit to the 'physical' qubits in a real device and stores the information in a Layout object.
Two passes for this layout step:
    - TrivialLayout: maps one to one.
    - VF2Layout: uses VF2++ algorithm and if multiple solutions are found, a scoring heuristic is run. The heuristic state also includes two passes:
        - DenseLayout: Finds the sub-graph of the device with the greatest connectivity and that has the same number of qubits
as the circuit.
        - SabreLayout: This pass selects a layout by starting from an initial random layout and repeatedly running the
SabreSwap algorithm.

- **routing**  
The layout process selects which 'physical' qubits wull be used while the routinh process adds the required SWAP gates to implement the two-qubit bit gates between qubits that are not directly connected.
The SabreSwap algorithm is used for this purpose.

- **translation**  
This process translates (or unrolls) the gates specified in a circuit to the native basis gates of a specified backend.  
Some operations are especially important: 
    - SWAP: If not included natively requires three CNOT/CX gates.
    - Toffoli: Requires at least fifteen gates (nine one-qubit gates and six two-qubit gates; see [Decompose](tips_basic.md#Decompose)).
 
- **optimization**  
This stage centers around decomposing quantum circuits into the basis gate set of the target device, and must fight against the
increased depth from the layout and routing stages. These methods are so effective that the resulting circuit might even have a lower depth than the inputs!  
After all the optimizations, a final check is done so that the circuit is only composed of gates includid in the basis gates in the target backend.

- **scheduling**  
This last stage is only run if it is explicitly called for and does not run by default. It is typically used once the circuit has been translated to the target basis, mapped to the device, and optimized. 
At a high level, the scheduling pass can be thought of as explicitly inserting delay instructions to account for the
idle time between gate executions and to inspect how long the circuit will be running on the backend.
