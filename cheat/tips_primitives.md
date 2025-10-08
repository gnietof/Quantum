# ⚠️ Work in Progress!

# Primitives

Primitives are the smallest processing instruction, the simplest building block from which one can create something useful
for a given abstraction level.
The two most common tasks are sampling quantum states and calculating expectation values. These tasks motivated the design of the Qiskit Estimator and Sampler primitives.

- Base classes
```BaseEstimatorV2``` and ```BaseSamplerV2``` are the abstract classes which define a common interface for implementing primitives.
- Implementations
    - ```EstimatorV2``` and ```SamplerV2``` provide a more sophisticated implementation as a Cloud service (to be run on IBM Quantum hardware).
    - ```StatevectorEstimator``` and ```StatevectorSampler``` are the reference implementations to use on the simulator built into Qiskit. The results are based on ideal statevector simulations
    - ```BackendEstimatorV2``` and ```BackendSamplerV2``` can be used to wrap any quantum computing resource into a primitive.

## Estimator
An Estimator computes expectation values of observables with respect to states prepared by quantum circuits.
The expectation value of an observable $O$ in state $\\ket{\\psi}$ is:  

$$\\braket{O}=\\braket{\\psi|O|\\psi}$$

Where $\\ket{\\psi}$ is the result of applying our circuit to the initial state vector $\\ket{0}$:\n",
    
$$\\ket{\\psi} = U\\ket{0}$$

The input in the Estimator is an array of PUBs (Primitive Unified Bloc) each of them having the format:
```
(<circuit>,<observables>,[<parameters>],[<precision>])
```
The output is a PubResult which includes the computed expectation values per pair and their standar errors.

### Example
In this ![Estimator example](./example_estimator.md) we can see all the calculations using algebra, qiskit operations and an estimator.

## Sampler
A Sampler samples the output register from the execution of one or more quantum circuits.

The input in the Sampler is an array of PUBs (Primitive Unified Bloc) each of them having the format:
```
(<circuit>,[<parameters>],[<shots>])
```

## PUBs
When a ```run``` is invoked a group of parameters must be provided. The most important one is the list of tuples; one for each circuit being executed. Each of this tuples is a PUB.

### Broadcasting rules
I have found this concept confusing in the documentation. I am writing down this section to try to understand each of the possible options.

### Broadcast single observable
This is the easiest one (probably) to understand: a circuit which accepts **n** parameters and just one observable. So the parameters part in the PUB must be an array of **m** tuples each having **n** values (one for each parameter in the circuit). 

Each of the **m** sets of **n** values will have the circuit applied and then estimated with the observable. Thus, having **m** tuples we get **m** estimations. This is just like looping through all the tuples and apply them to the circuit and then estimate the observation.

observables = [ob1]
parameters = [[a1,b1],[a2,b2],[a3,b3]
job = estimator.run([(qc,observables,parameters)])

We have n = 2, m = 3 thus three estimates will be returned.

### Zip
We still have a circuit that accepts **n** parameters. But in this case we have **p** observables. The parameters part in the PUB is also an array of **m** tuples each having **n** values (one for each parameter in the circuit).

Each of the **m** tuples in parameters is applied to **one** of the **p** observables. So **m** and **p** must be equal or an error will be raised. The number of estimations will also be **m** but because they have been mapped 1:1.

observables = [ob1,ob2,ob3]
parameters = [[a1,b1],[a2,b2],[a3,b3]
job = estimator.run([(qc,observables,parameters)])

We have n = 2, m = 3 and p = 3 thus three estimates will be returned.

### Outer / Product
We still have a circuit that accepts **n** parameters. In this case we also have **p** observables. The parameters part in the PUB is now a **vector** of **m** tuples each having **n** values (one for each parameter in the circuit).

Each of the **m** tuples in parameters is applied to **each** of the **p** observables. Now **m** and **p** do not need to be equal. The number of estimations will in this case be **m** times **p**.

observables = [ob1,ob2,ob3] # p=3
parameters = [[[a1,b1]],[[a2,b2]],[[a3,b3],[[a4,b4]]]
job = estimator.run([(qc,observables,parameters)])

We have n = 2, m = 4 and p = 3 thus 12 estimates will be returned.

estimates = [[O(p1m1),O(p2m1)],
             [O(p1m2),O(p2m2)],
             [O(p1m3),O(p2m3)],
             [O(p1m4),O(p2m4)]]

### Standard Generalization
We still have a circuit that accepts **n** parameters. In this case we also have an array of **q** elements with **p** observables each. The parameters part in the PUB is now a **array** of **r** elemts with **m** tuples and each tuple having **n** values (one for each parameter in the circuit).

observables = [[ob11,ob12,ob13],[ob21,ob22,ob23]] # q=2 and p=3
parameters = [[[a11,b11]],[[a12,b12]],[[a13,b13],[[a14,b14],[[a15,b15]],
              [[a21,b21]],[[a22,b22]],[[a23,b23],[[a24,b24],[[a25,b25]]] # r=2 and m=5
job = estimator.run([(qc,observables,parameters)])

We have n = 2, r = 2, m = 5, q = and p = 3 thus 12 estimates will be returned.







