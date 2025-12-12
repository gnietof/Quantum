# Monitor or cancel a job
- This first section covers how to use the Workloads table on the Dashboard.

## Monitor a job
- Use the job instance to check the job status or retrieve the results by calling the appropriate command:
  - **result**. Review job results immediately after the job completes. Job results are available after the job completes. Therefore, job.result() is a blocking call until the job completes.
  - **job_id**.	Return the ID that uniquely identifies that job. Retrieving the job results at a later time requires the job ID. Therefore, it is recommended that you save the IDs of jobs you might want to retrieve later.
  - **status**.	Check the job status.
  - **job**. Retrieve a job (from the backend instance passing the job_id) previously submitted. 

## Retrieve job results at a later time
- Call ```service.job(<job_id>)``` to retrieve a job you previously submitted.
- Without the job ID, or in order to retrieve multiple jobs at once; including jobs from retired QPUs (quantum processing units), the ```service.jobs()``` should be used instead with optional filters.

## Cancel
- You can cancel a job using the job.cancel() to cancel a job.

## View Sampler execution spans
- The results of SamplerV2 jobs executed in Qiskit Runtime contain execution timing information in their metadata.
- This timing information can be used to place upper and lower timestamp bounds on when particular shots were executed on the QPU.
- Shots are grouped into ExecutionSpan objects, each of which indicates a start time, a stop time, and a specification of which shots were collected in the span.

- An execution span specifies which data was executed during its window by providing an ExecutionSpan.mask method.
- This method, given any Primitive Unified Block (PUB) index, returns a boolean mask that is True for all shots executed during its window.
- PUBs are indexed by the order in which they were given to the Sampler run call. If, for example, a PUB has shape (2, 3) and was run with four shots, then the mask's shape is (2, 3, 4). 
