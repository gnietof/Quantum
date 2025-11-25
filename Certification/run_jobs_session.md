:warning: I have not been able to test this functionality because open accounts are restricted.

# Run jobs in session
- Sessions give dedicated and exclusive use to a QPU.
## Open a session
- There are two ways to execute a session. Using the context manager ```with Session(...)``` or by initializing the ```Session``` class.

### Session class
- The session instance must be provided to the Sampler/Estimator and it has to be closed.
```python
from qiskit_ibm_runtime import SamplerV2, Session

session = Session(backend= backend)
sampler1 = SamplerV2(mode=session) 
sampler2 = SamplerV2(mode=session) 
job1 = sampler1.run([qct1])
job2 = sampler2.run([qct2])
session.close()
```
### Context mamager
- In this case closing the session is not required and it is not required to pass the session to the Sampler/Estimator.
```python
from qiskit_ibm_runtime import SamplerV2, Session

with Session(backend=backend) as session:
    sampler1 = SamplerV2() 
    sampler2 = SamplerV2() 
    job1 = sampler1.run([qct1])
    job2 = sampler2.run([qct2])

## End session
- A session end if the maximum timeout is reached, resulting in the cancellation of all queued jobs.
- The session is cancelled, resulting in the cancellation of all queued jobs.
- The session is closed. No more jobs are accepted but the queued jobs continue to run with priority.
- The session is automatically closed when using a context manager.

## Check session status
- Session status can be queries by using the ```Session.status()``` method.

## Close the session
- Closing the session is not required if using a context but it has to be closed otherwise.
```python
session.close()
```


