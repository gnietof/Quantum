# Retrieve and save jobs
Quantum jobs take a while to complete. To avoid loss of data, past jobs results from IBM Quantum can be saved to a file so that a session can continue where it was left off.

## Retrieve job results from IBM Quantum
- IBM Quantum automatically stores results from every job for you to retrieve at a later date. 
- Jobs executed in IBM Quantum can be retrieved at a later date providing their job Id.
- All executed jobs can be found at [Workloads page](https://quantum.cloud.ibm.com/workloads).
- A job can be found using the ```QiskitRuntimeService.jobs``` method. This returns the most recently submitted jobs but it is also possible to filter by backend, creation date ...
```python
import datetime
from qiskit_ibm_runtime import QiskitRuntimeService
 
five_days_ago = datetime.datetime.now() - datetime.timedelta(days=5)
 
service = QiskitRuntimeService()
jobs = service.jobs(created_after=five_days_ago)
```
- Oncethe job has been retrieved, all the information is available including the circuit, observables, parameters, results, start, end and elapsed time ...
  - The inputs are in ```job.inputs```.
```python
job.inputs['pubs'][0][0].draw('mpl')
```
<img width="725" height="209" alt="image" src="https://github.com/user-attachments/assets/ac39d2e7-c328-4e06-8db0-ccac513387e6" />

  - The results are in ```job.results```.
```python
result=job.result[0]
result[0].data.meas
```
## Save results to disk
- Results can be saved to JSON using the json library.
```python
import json
from qiskit_ibm_runtime import RuntimeEncoder
 
with open("result.json", "w") as file:
    json.dump(retrieved_job.result(), file, cls=RuntimeEncoder)
```

- And also retrieved.
```python
from qiskit_ibm_runtime import RuntimeDecoder
 
with open("result.json", "r") as file:
    result = json.load(file, cls=RuntimeDecoder)
```



