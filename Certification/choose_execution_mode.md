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
- All the functionality from batch mode (but requiring increased usage; see [Workload usage](#workload) for more details on how usage is calcuated).
- Dedicated and exclusive access to the QPU during the session active window.
- Useful for workloads that don’t have all inputs ready at the outset, for iterative workloads that require classical post-processing before the next one can run, and for experiments that need to run as tightly together as possible.

## Job
- Easiest to use when running a small experiment.
- Might run sooner than batch mode.

## Recommendations and best practices

- Use **batch** mode to submit multiple primitive jobs simultaneously to shorten processing time.
- Use **session** mode for iterative workloads, or if you need dedicated access to the QPU.
- Always use **job** mode to submit a single primitive request.
- Because sessions are generally more expensive, it is recommended that you use **batch** whenever you don't need the additional benefits from using sessions.

- There is a fixed overhead associated with running a job. In general, if each of your jobs uses less than one minute of QPU time, consider combining several into one larger job (this applies to all execution modes).
- If each of the jobs consumes more than one minute of QPU time, or if combining jobs is not practical, you can still run multiple jobs in parallel. 

## Workloads
(This section is not refered in the certification materials but in this document. So I am including some notes here.)

