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

# Create your own pass manager
- The qiskit.transpiler.passes module includes many transpiler passes that can be used to create pass managers.
- A PassManager is created by initializing a PassManager with a list of passes.

```python
from qiskit.transpiler import PassManager
from qiskit.transpiler.passes import (
  ConsolidateBlocks,Collect2qBlocks,
  UnitarySynthesis,Collect1qRuns,
  Optimize1qGatesDecomposition
)

basis_gates = ['rx','ry','rxx','rz']
pass_manager2 = PassManager(
    [ 
        Collect2qBlocks(), 
        ConsolidateBlocks(basis_gates=basis_gates),
        UnitarySynthesis(basis_gates),
        Collect1qRuns(),
        Optimize1qGatesDecomposition()
    ]
)

qct2 = pass_manager2.run(qc)
qct2.draw('mpl')
```
<img width="434" height="187" alt="image" src="https://github.com/user-attachments/assets/990b5f17-79b4-4ecd-8f90-9ead88cde856" />

# Create a staged pass manager
- A StagedPassManager is a pass manager that is composed of individual stages, where each stage is defined by a PassManager instance.
- Stages in a StagedPassManager can be defined as desired with custom names (the documentation refers to 'init' and 'translation' but that is not required).
- There is no limit on the number of stages in a staged pass manager.

Below a couple of pass_managers are being created. The stages are the same as the PassManager created in the previous section in a single PassMananger.
```python
from qiskit.transpiler import PassManager
from qiskit.transpiler.passes import (
  ConsolidateBlocks,Collect2qBlocks,
  UnitarySynthesis,Collect1qRuns,
  Optimize1qGatesDecomposition
)
from qiskit.transpiler import StagedPassManager

pass_manager21 = PassManager(
    [ 
        Collect2qBlocks(), 
        ConsolidateBlocks(basis_gates=basis_gates),
        UnitarySynthesis(basis_gates),
    ]
)

pass_manager22 = PassManager(
    [ 
        Collect1qRuns(),
        Optimize1qGatesDecomposition(),
    ]
)
```
If only of those PassManager's is applied we get an 'intermediate step'.
```python
staged_pass = StagedPassManager(
    stages = ['a'], a= pass_manager21
)
    
qct3 = staged_pass.run(qc)
qct3.draw('mpl')
```
<img width="949" height="187" alt="image" src="https://github.com/user-attachments/assets/023eaa37-c70d-4341-8a34-0f032d025f21" />

And if both of them are applied then we get the same circuit as the one in the previous section.
```python
staged_pass = StagedPassManager(
    stages = ['a','b'], a= pass_manager21,b=pass_manager22
)
qct3 = staged_pass.run(qc)
qct3.draw('mpl')
```

<img width="434" height="187" alt="image" src="https://github.com/user-attachments/assets/990b5f17-79b4-4ecd-8f90-9ead88cde856" />



