# Transpile with pass managers

- Transpilation refers to the process of transforming an input circuit into a form that is suitable for execution on a quantum device.
- Transpilation typically occurs in a sequence of steps called transpiler passes.
- The circuit is processed by each transpiler pass in sequence, with the output of one pass becoming the input to the next.
- The transpiler passes included with Qiskit are located in the qiskit.transpiler.passes module.

- A pass manager is an object that stores a list of transpiler passes and can execute them on a circuit.
- Create a pass manager by initializing a ```PassManager``` with a list of transpiler passes.
- To run the transpilation on a circuit, call the run method with a circuit as input.

- A **staged pass manager** is a special kind of pass manager that represents a level of abstraction above that of a normal pass manager.
- While a normal pass manager is composed of several transpiler passes, a staged pass manager is composed of several pass managers.
- Staged pass managers are represented by the ```StagedPassManager``` class.

## Generate a preset staged pass manager
- We might create a preset staged pass manager with reasonable defaults, using the ```generate_preset_pass_manager``` function.
- There are many optional parameters except for ```optimization_level``` (how much optimization to perform on the circuits). The optimization value is in the range (0 - 3). Higher levels generate more optimized circuits, at the expense of longer transpilation time.

| Level | Description | Comments |
|-------|-------------|----------|
| 0 | No optimization. | Only Basic translattion and Layout/Routing using ```TrivialLayout```. |
| 1 | Light optimization. | Layout/Routing: Layout is first attempted with TrivialLayout. SabreSwap used to find the minimum number of SWAP. Then VF2LayoutPostLayout to try to select the best qubits in the graph. InverseCancellation.1Q gate optimization. |
| 2 | Medium optimization | Layout/Routing: Optimization level 1 (without trivial) + heuristic optimized with greater search depth and trials of optimization function. TrivialLayout is not used. CommutativeCancellation |
| 3 | High optimization | Optimization level 2 + heuristic optimized on layout/routing further with greater effort/trials. Resynthesis of two-qubit blocks using Cartan's KAK Decomposition. Unitarity-breaking passes: OptimizeSwapBeforeMeasure: Moves the measurements around to avoid SWAPs. RemoveDiagonalGatesBeforeMeasure: Removes gates before measurements that would not effect the measurements. |




```python
from qiskit.transpiler import generate_preset_pass_manager
from qiskit_ibm_runtime import QiskitRuntimeService
 
service = QiskitRuntimeService()
backend = service.backend("ibm_fez")
pass_manager = generate_preset_pass_manager(
    backend=backend,optimization_level=3
)
```

- Now we create a simple circuit.
```python
from qiskit import QuantumCircuit
 
qc = QuantumCircuit(2)
qc.h(0)
qc.cx(0, 1)
qc.draw("mpl")
```
<img width="241" height="174" alt="image" src="https://github.com/user-attachments/assets/8f7688e8-9309-4a9a-9187-2d2fca8716d6" />

- Once we have our circuit and a pass_manager we may transpile the circuit.
```python
qct = pass_manager.run(qc)
qct.draw("mpl")
```
<img width="567" height="187" alt="image" src="https://github.com/user-attachments/assets/8e18fdc6-7abd-4c0e-8e0a-35d9025ffb07" />




