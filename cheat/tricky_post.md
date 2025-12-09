# Tricky Post

## Questions

- How long can be a session be open?  
  The maximum session time to live (TTL) determines how long a session can run. If not specified, the maximum tieme is 8h.  
  There is also an interactive time to live (interactive TTL) value that cannot be configured. If no session jobs are queued within that window, the session is temporarily deactivated.  

- How are execution times being measured for Job, Session, Batch and **API**!!
  - The session starts when its first job begins execution. 

- Is there a maximum time? Is there a default time?  
  If you open a session but do not submit any jobs to it for 30 minutes, the session automatically closes.  
  There is also an interactive time to live (interactive TTL) value that cannot be configured. If no session jobs are queued within that window, the session is temporarily deactivated.  

- How long are Jobs stored for retrieval from the Quantum logs?  
  There is no maximum time. They are automatically saved 'forever'.

- Which jobs are retrieved by default when querying the system?  
  By default ALL of them are returned (open to filtering). But the Pyhton SDK, by default, only returns the latest 10 submitted jobs. 

- Which parameter can be provided when creating a session?  
  Good question. The Session must be provided. And the max_time can be provided. So, which is the right answer? 

- What is the session_id used for?
  

- How recover from the job the duration of the execution in the QPU?

- 


## Review

- Configuration of different error techniques by setting parameters.
- Different pass managers. Including the **unroll3qOrMore**.
- Check ParameterVectors
- Visualizations
- Finish the page with all bell states and their representations using different visualizations.
- Repasar process fidelity

- Quizá echarle un vistazo más detallado a las clases Pauli y PauliList y **SparsepauliOp**
- revisar las EstimatorOptions y las SamplerOptions
- Revisar el concepto the process fidelity
- Circuit, Operator ...classes

#Check

Add this somewhere and have a look

<img width="723" height="527" alt="image" src="https://github.com/user-attachments/assets/0f0e91cd-ad39-48b3-b43f-9786ff7b8573" />

