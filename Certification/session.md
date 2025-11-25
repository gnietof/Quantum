# Session
This document does not provide much interesting information. Most interesting part for certification is the information provided by the session object.

## Attributes

## Methods

- **details**. Returns a dictionary with session details.
  - **id**: id of the session.
  - **backend_name**: backend used for the session.
  - **interactive_timeout**: The maximum idle time (in seconds) between jobs that is allowed to occur before the session is deactivated.
  - **max_time**: Maximum allowed time (in seconds) for the session, subject to plan limits.
  - **active_timeout**: The maximum time (in seconds) a session can stay active.
  - **state**: State of the session - open, active, inactive, or closed.
  - **accepting_jobs**: Whether or not the session is accepting jobs.
  - **last_job_started**: Timestamp of when the last job in the session started.
  - **last_job_completed**: Timestamp of when the last job in the session completed.
  - **started_at**: Timestamp of when the session was started.
  - **closed_at**: Timestamp of when the session was closed.
  - **activated_at**: Timestamp of when the session state was changed to active.
  - **mode**: Execution mode of the session.
  - **usage_time**: The usage time, in seconds, of this Session or Batch. Usage is defined as the time a quantum system is committed to complete a job.
