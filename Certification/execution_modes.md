# Introduction to Qiskit Runtime execution modes
- Execution modes determine how jobs are executed.
- There are three execution modes: job, batch and session.

## Job mode
- A single primitive request of the estimator or the sampler made without a context manager.
- Circuits and inputs are packaged as primitive unified blocs (PUBs) and submitted as an execution task on the quantum computer. -
- To run in job mode, specify mode=backend when instantiating a primitive.
- Single job usage is the quantum time the job uses in processing.
```python
from qiskit_ibm_runtime import QiskitRuntimeService,SamplerV2

service = QiskitRuntimeService()
backend = service.least_busy(simulator=False, operational=True)
sampler = SamplerV2(mode=backend)
```

## Batch Mode
- A multi-job manager for efficiently running experiments comprising multi-job workloads.
- These workloads are made up of independently executable jobs that have no conditional relationship with each other.
- With batch mode, users submit their jobs all at once. The system parallelizes or threads the pre-processing step of each primitive job to more tightly package quantum execution across jobs, and then runs the quantum execution of each job in quick succession to deliver the most efficient results.

- Jobs are not guaranteed to be executed in the order they were submitted.
- They will run as closely as possible but they do not get exclusive access to the backend.
- Sending a one job batch makes no difference in queue execution time compared to job mode.
- Batch usage is the sum of quantum time of all jobs in the batch.

```python
from qiskit_ibm_runtime import QiskitRuntimeService,SamplerV2,Batch

service = QiskitRuntimeService()
backend = service.least_busy(simulator=False, operational=True)
batch1 = Batch(backend=backend)
sampler = SamplerV2(mode=batch1)
...
batch1.close()

with Batch(backend=backend) as batch2:
  sampler = SamplerV2() # mode is not required!
  # close is not required
```

## Session mode
- A dedicated window for running a multi-job workload.
- During this window, the user has exclusive access of the system and no other jobs can run - including calibration jobs.
- This allows users to experiment with variational algorithms in a more predictable way and even run multiple experiments simultaneously, taking advantage of parallelism in the stack.
- Using sessions helps avoid delays caused by queuing each job separately, which can be particularly useful for iterative tasks that require frequent communication between classical and quantum resources.
- Session usage is the time from when the first job starts until the session goes inactive, is closed, or when its last job completes, whichever happens last. It includes both classical and quantum time (time spent by the QPU complex to process your job).

```python
from qiskit_ibm_runtime import QiskitRuntimeService,SamplerV2,Session

service = QiskitRuntimeService()
backend = service.least_busy(simulator=False, operational=True)
session1 = Batch(backend=backend)
sampler = SamplerV2(mode=session1)
...
session1.close()

with Session(backend=backend) as session2:
  sampler = SamplerV2() # mode is not required!
  ...
  # close is not required
```

- Sending a one job session makes no difference in queue execution time compared to job mode.

## Basic workflow

- The first job in a batch or session enters the normal queue. For batches, the entire batch of jobs is scheduled together.
- When the first job starts running, the maximum time to live (TTL) timer starts, and does not stop or pause until the end is reached.
- The interactive TTL timer starts after each job is completed. If there are no workload jobs ready within the interactive TTL window, the workload is temporarily deactivated and normal job selection resumes.
- A job can reactivate the deactivated workload if the batch or session has not reached its maximum TTL value.
- If the maximum TTL value is reached, the workload ends and any remaining queued jobs fail. Any job currently running won't run to completion if doing so would exceed the instance's cost limit.

  
