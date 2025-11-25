# Run jobs in batch
- Batchs are used to submit multiple primitive jobs simultaneously.
## Open a batch
- There are two ways to execute a batch. Using the context manager ```with Batch(...)``` or by initializing the ```Batch``` class.

### Batch class
- The batch instance must be provided to the Sampler/Estimator and it has to be closed.
```python
from qiskit_ibm_runtime import SamplerV2, Batch

batch = Batch(backend= backend)
sampler1 = SamplerV2(mode=batch) 
sampler2 = SamplerV2(mode=batch) 
job1 = sampler1.run([qct1])
job2 = sampler2.run([qct2])
batch.close()
```
### Context mamager
- In this case closing the batch is not required and it is not required to pass the batch to the Sampler/Estimator.
```python
from qiskit_ibm_runtime import SamplerV2, Batch

with Batch(backend=backend) as batch:
    sampler1 = SamplerV2() 
    sampler2 = SamplerV2() 
    job1 = sampler1.run([qct1])
    job2 = sampler2.run([qct2])
```
## Close the batch
- Closing the batch is not required if using a context but it has to be close otherwise.

## Determine batch details
- Batch details can be determined by using the ``Batch.details()``` method.

## Reconfigure jobs for parallel processing
- The documentation is not clear here and the example is buggy.
