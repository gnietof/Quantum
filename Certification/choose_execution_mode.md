# Choose the right execution mode
- Utility-scale workloads can take many hours to complete, so it is important that both the classical and quantum resources are scheduled efficiently to streamline the execution.
- Execution modes provide flexibility in balancing the cost and time tradeoff to use resources optimally for your workloads.

## Batch
- The entire batch of jobs is scheduled together and there is no additional queuing time for each.
- The jobs' classical computation, such as compilation, is run in parallel. Thus, running multiple jobs in a batch is significantly faster than running them serially.
- There is usually minimal delay between jobs, which can help avoid drift.
- If you partition your workload into multiple jobs and run them in batch mode, you can get results from individual jobs, which makes them more flexible to work with. For example, if a job's results don't meet your expectations, you can cancel the remaining jobs. Also, if one job fails, you can re-submit it instead of re-running the entire workload.
- Is generally less expensive than sessions.

## Session
- All the functionality from batch mode (but requiring increased usage; see [Workload usage](#workloads) for more details on how usage is calcuated).
- Dedicated and exclusive access to the QPU during the session active window.
- Useful for workloads that don’t have all inputs ready at the outset, for iterative workloads that require classical post-processing before the next one can run, and for experiments that need to run as tightly together as possible.

## Job
- Easiest to use when running a small experiment.
- Might run sooner than batch mode.

# Recommendations and best practices

- Use **batch** mode to submit multiple primitive jobs simultaneously to shorten processing time.
- Use **session** mode for iterative workloads, or if you need dedicated access to the QPU.
- Always use **job** mode to submit a single primitive request.
- Because sessions are generally more expensive, it is recommended that you use **batch** whenever you don't need the additional benefits from using sessions.

- There is a fixed overhead associated with running a job. In general, if each of your jobs uses less than one minute of QPU time, consider combining several into one larger job (this applies to all execution modes).
- If each of the jobs consumes more than one minute of QPU time, or if combining jobs is not practical, you can still run multiple jobs in parallel. 

# Workloads
(This section is not refered in the certification materials but in this document. So I am including some notes here although it might not be required.)

- Usage is a measurement of the amount of time the QPU is locked for your workload, and it is calculated differently, depending on which execution mode you're using.
  - Session usage is the time from when the first job starts until the session goes inactive, is closed, or when its last job completes, whichever happens last. It includes both classical and quantum time (time spent by the QPU complex to process your job).
  - Batch usage is the sum of quantum time of all jobs in the batch.
  - Single job usage is the quantum time the job uses in processing.

The reported usage is the time a QPU is locked for your workload. Failed or canceled jobs count toward your usage in certain circumstances - see the Failed and canceled jobs section for details.

For paid plan users, usage determines how much the workload costs. 
## Usage for failed and canceled jobs
- When a job is failed or canceled, the reported usage is as follows:
  - Job or batch mode: The reported usage is the time the QPU was locked for executing your workload until the time it failed or was canceled. Therefore, if the failure or cancellation occurred before the lock, the reported usage is zero.
  
  Otherwise, the workload's reported usage is the amount of usage before the workload failed or was canceled. Thus, some failed jobs do not appear in your reported usage and others do.

  - Session mode: The reported usage is the wall-clock time from when the first job started executing in the session until the session terminates, regardless of the number of jobs that fail or are canceled.
 
## Determine a workload's actual usage

  - ```Run Batch.usage()``` or ```Session.usage()``` in qiskit-ibm-runtime 0.30 or later.
  - Use ```GET /sessions/{id}``` to see usage for a specific batch or session.
  - Use ```GET /jobs/{id}``` to see usage for a single job.





