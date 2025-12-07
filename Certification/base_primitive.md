This document just covers the BasePrimitiveJob class. Probably for the Certification the only interesting part are the methods:

# BasePrimitiveJob
- Base abstract class for the primitive job.
  
## Methods
- **cancel**. Tries to cancel a job.
- **cancelled**. Returns whether the job has been cancelled.
- **done**. Returns whether the job has successfully run.
- **in_final_state**. Returns whether the job is in final state (DONE or ERROR).
- **job_id**. Returns a unique id for the job.
- **result**. Returns the result of the job.
- **running**. Returns whether the job is actively running.
- **status**. Returns the status of the job.
