# Qiskit Runtime REST API
- The Qiskit Runtime REST API allows you to run on quantum processing units (QPUs) using Qiskit Runtime primitives, a simplified interface for circuit execution powered by advanced runtime compilation, error suppression, and error mitigation techniques, as well as getting information about instances and QPUs you have access to.

## Authentication
- An IBM Cloud Identity and Access Management (IAM) bearer token has to be provided with every call as an http header.

```bash
curl -X POST 'https://iam.cloud.ibm.com/identity/token' \
-H 'Content-Type: application/x-www-form-urlencoded' \
-d 'grant_type=urn:ibm:params:oauth:grant-type:apikey&apikey=MY_APIKEY'
```

- Additionally, many requests to the REST API require an instance's Cloud Resource Name (CRN) in the request's header.
```
Authorization: Bearer <YOUR_BEARER_TOKEN>
Service-CRN: <YOUR_INSTANCE_CRN>
IBM-API-Version: <YYYY-MM-DD>
```

## Submit a job
- The create job operation is used to submit primitive jobs.
- Several circuits can be submitted into a single job as an array of OpenQASM strings representing these circuits.
- Specify the primitive you want to use with the program_id parameter. Available primitive values are sampler and estimator.
- When submitting a job to a QPU, the IBM Cloud instance CRN has to be included.

## Use sessions
- The create session operation is required to start a session.
- The response provides an "id" which has to be included as the ```session_id``` parameter in the payload with jobs to run them as part of the session.
