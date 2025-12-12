# Monitor or cancel a job

- The first section includes working with jobs in the Dashboard.

## Monitor a job
- The job instance can be used to check the job status or retrieve the results by calling the appropriate command:
- **result**.	Review job results immediately after the job completes. Job results are available after the job completes. Therefore, job.result() is a blocking call until the job completes.
- **job_id**.	Return the ID that uniquely identifies that job. Retrieving the job results at a later time requires the job ID. Therefore, it is recommended that you save the IDs of jobs you might want to retrieve later.
- **status**.	Check the job status.
- **job**.	Retrieve a job you previously submitted. This call requires the backend instance and the job ID.

## Retrieve job results at a later time
- A job previously submitted can be retrieved with service.job(\<job\_id>).
- With no job ID or if multiple jobs have to be retrieved, including jobs from retired QPUs (quantum processing units), then the service.jobs() with optional filters may be used instead. 
Deprecated provider packages

## Cancel a job

- Jobs may be cancelled using job.cancel().

## View Sampler execution spans

- The results of SamplerV2 jobs executed in Qiskit Runtime contain execution timing information in their metadata.
- This timing information can be used to place upper and lower timestamp bounds on when particular shots were executed on the QPU.
- Shots are grouped into ExecutionSpan objects, each of which indicates a start time, a stop time, and a specification of which shots were collected in the span.

- An execution span specifies which data was executed during its window by providing an ExecutionSpan.mask method.
- This method, given any Primitive Unified Block (PUB) index, returns a boolean mask that is True for all shots executed during its window.
- PUBs are indexed by the order in which they were given to the Sampler run call. 

