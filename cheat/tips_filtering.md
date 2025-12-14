# Recovering Jobs
- The QiskitRuntimeService allows querying about previously executed jobs.
```pyhton
from qiskit_ibm_runtime import QiskitRuntimeService

service = QiskitRuntimeService()
```

- We can just retrieve 'all' the jobs.
```pyhton
service.jobs()
```
<img width="433" height="177" alt="image" src="https://github.com/user-attachments/assets/f359ee34-7ffd-4b45-8dae-724c1530c090" />

- Although by default all jobs should be provided (according to the documentation), the truth is that this is being filtered and only the ten most recent ones are being returned because the ```limit```parameter set to 10 by default. I have seen this is also the default set for the REST API ```/jobs``` endpoint.

- A different number of results might be retrieved using ```limit``` and ```skip``` combination.
```pyhton
service.jobs(limit=5,skip=5)
```

## Filtering

## Backend
- The name of the backend where this job was executed.
```pyhton
jobs = service.jobs(backend_name='ibm_torino')
```

### Pending
-The pending value is True when the status is pending when the state is ‘QUEUED’ or ‘RUNNING’ and False when the state is ‘DONE’, ‘CANCELLED’ and ‘ERROR’.
```pyhton
jobs = service.jobs(pending=True)
```

### Mode
- Valid modes for the query are job, session or batch.
```pyhton
jobs = service.jobs(mode='batch')
```

### Creation Date 
```pyhton
jobs = service.jobs(created_after='2025-12-07', created_before='2025-12-12')
for job in jobs:
    print(job.job_id(),job.creation_date)
```
<img width="430" height="174" alt="image" src="https://github.com/user-attachments/assets/96189752-f6f9-4412-87df-061d7c8c0c06" />

### Tags
- Tags may be added to a job before execution.
```pyhton
with Batch(backend=backend) as batch:
    sampler1 = SamplerV2() 
    sampler1.options.environment.job_tags = ['batch-example2','133-qubits','bacth-job1']
    sampler2 = SamplerV2() 
    sampler2.options.environment.job_tags = ['batch-example2','133-qubits','bacth-job2']
    job1 = sampler1.run([(qct1,[],1024)])
    job2 = sampler2.run([(qct2,[],1024)])
```
- They can also be added (or modified) after execution.
```pyhton
job2.update_tags(['batch-example','133-qubits','bacth-job2'])
```
<img width="911" height="436" alt="image" src="https://github.com/user-attachments/assets/1bdc1418-6fcb-40df-95e7-4f8bd60b2595" />

-We may then filter by the tags.
  - Wild cards or partial matches are not allowed.
  - Multiple tags are considered as an AND between them.
```
service.jobs(job_tags='batch-example')
```
