I do not think this section is important for the Certification other than knowing their existence. Although I would like to investigate the implementation of the different pieces (other than the Backend).

# Providers Interface
- ```qiskit.providers``` contains the classes used to build external providers for Qiskit.
- A provider is anything that provides an external service to Qiskit. The typical example of this is a Backend provider which provides Backend objects which can be used for executing QuantumCircuit objects.

## Abstract Classes

### Backend
- **Backend**. Base common type for all versioned Backend abstract classes.
- **BackendV2**.  Abstract class for Backends.
- **QuibitProperties**. A representation of a QubitProperties object.

### Options
- **Options**. Base options object.

### Job
- **Jbb**. Base common type for all versioned Job abstract classes.
- **JobV1**. Class to handle jobs.

### Job Status
- **Job Status**. Class for job status enumerated type.

## Writing a New Backend

### Provider

### Backend

A definition of a custom backend can be found in [Custom Backend](../fake.ipynb) and (Custom Backend & Noise)(../labs/custom_backends.md).

### Backend’s Transpiler Interface

#### Custom Basis Gates

#### Custom Transpiler Passes

#### Real-time variables

#### Angle bounds on Gates

### Backend.run Method

### Backend Options

### Job

### Primitives




