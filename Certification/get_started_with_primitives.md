# Get Started With Primitives

## Get started with Estimator
I have created another document where the maths behind an Estimator are explained [here](../cheat/example_estimator.ipynb). In the end, an Estimator is just applying a circuit to a initial vector and then finding $\braket{O}=\braket{\psi|O|\psi}$, where $O$ is the observable and $\ket{\psi}$ is the output of the circuit.

1. Create a circuit.
```qasm
from qiskit import QuantumCircuit

qc = QuantumCircuit(2)
qc.h(0)  
qc.cx(0,1)  
qc.draw('mpl')
```
<img width="197" height="121" alt="image" src="https://github.com/user-attachments/assets/03838a9b-6f84-46ad-8dfe-f6bac8a32404" />

2. Create and observable.
```qasm
from qiskit.quantum_info import SparsePauliOp
import numpy as np

observable = SparsePauliOp.from_sparse_list([("XX", [0,1], 1)], num_qubits=2)
print(observable)
```

3. Transpile the circuit and observable to only use the instructions supported by the QPU.
Here we have a simple way of transpiling our circuit.
```qasm
from qiskit import transpile

qct = transpile(qc,backend)
qct.draw('mpl')
```
<img width="564" height="171" alt="image" src="https://github.com/user-attachments/assets/eb9efd51-43e7-44e3-b433-2a588cace69f" />

We might use the pass manager instead. 
```qasm
from qiskit.transpiler import generate_preset_pass_manager
 
pm = generate_preset_pass_manager(optimization_level=1, backend=backend)
qct = pm.run(qc)
qct.draw('mpl')
```
<img width="583" height="133" alt="image" src="https://github.com/user-attachments/assets/4729e72c-2647-4914-b153-f3cc5c9751d8" />

**Note**. The circuit for this example is slightly different when using the pass manager and setting the optimization_level to 0-1 (no or low optimization) but the same when using 2-3 (medium or high optimization).

4. **Important** Align the observable with the layout of the transpiled circuit.
Applying the layout resizes our observable to the number of qubits in the QPU and also align the physical qubits with the ones used by our transpiled circuit.
```qasm
layout = qct.layout
observable = observable.apply_layout(layout)
```

5. Initialize the estimator runtime.
```qasm
from qiskit_ibm_runtime import EstimatorV2

estimator = EstimatorV2(backend)
```

6. Invoke the estimator and get results.
```qasm
job = estimator.run([(qct, observable)])
result = job.result()
print(f"Result: {result}")
print(f"Expectation value: {result[0].data.evs}")
print(f"Metadata: {result[0].metadata}")
```
In this case we are using just one observable and no parameters. But we might provide a set of observables and parameters and have then combined and evaluated in one shot. The rules for this evaluation is covered in the broadcasting rules.

## Get started with Sampler
A Sampler just executes the circuit a number of times and returns the measurements from each run. No observables are required. However, the circuit must include measurements; otherwise the sampler would return no output.

1. Create the circuit.
```qasm
from qiskit import QuantumCircuit

qc = QuantumCircuit(2)
qc.h(0)  
qc.cx(0,1)
qc.measure_all()
qc.draw('mpl')
```
<img width="445" height="184" alt="image" src="https://github.com/user-attachments/assets/a41f328f-2c3f-4927-98ae-edd1cd78cd88" />

2. Transpile the circuit.
```qasm
from qiskit.transpiler import generate_preset_pass_manager
 
pm = generate_preset_pass_manager(optimization_level=1, backend=backend)
qct = pm.run(qc)
qct.draw('mpl')
```
<img width="725" height="220" alt="image" src="https://github.com/user-attachments/assets/814d3515-8037-4c93-9de4-21eeace0b869" />

3. Initialize the sampler runtime.
```qasm
from qiskit_ibm_runtime import SamplerV2

sampler = SamplerV2(backend)
```

4. Invoke the sampler and get results.
```qasm
job = sampler.run([(qct)])
result = job.result()
```

4.1. Bitstring
We might recover each of the output bitstrings (bit pairs in this case). But this provides little value.
```qasm
result[0].data.meas.get_bitstrings()[:10]
```
4.1. Plot
We can easily plot the results which provides more information. In this case we get the expected Bell state distribution with some noise.
```qasm
from qiskit.visualization import plot_histogram

plot_histogram(result[0].data.meas.get_counts())
```
<img width="626" height="468" alt="image" src="https://github.com/user-attachments/assets/ca8b54e7-6173-45b9-b9df-cc3217577694" />

## Bonus
Because 'QPU executions' are 'expensive', I usually save the output of the execution in a file so that I can retrieve the results without having to execute the Sampler/Estimator each time.

- Saving
```qasm
import pickle

with open('sampler_fez.pkl','wb') as f:
    pickle.dump(result,f)
```

- Loading
```qasm
import pickle

with open('sampler_fez.pkl','rb') as f:
    result2 = pickle.load(f)
```

