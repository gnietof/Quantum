---
layout: default
title: Qiskit 2.x Practice Exam (REST API)
---
<h1>Qiskit 2.x Practice Exam (REST API)</h1>

1.	Which of these parameters should not be included in the header for a REST API request:
<div style="margin-left: 2em;">
  <ol type="A">
    <li>IAM Key</li>
    <li>Bearer token</li>
    <li>Service CRN</li>
    <li>IBM API version</li>
  </ol>
</div>

2.	Which is the endpoint for cancelling a running job?
<div style="margin-left: 2em;">
  <ol type="A">
	  <li>DELETE /v1/jobs/{id}</li>
	  <li>POST /v1/jobs/{id}/stop</li>
	  <li>POST /v1/jobs/{id}/cancel</li>
	  <li>PUT /v1/jobs/{id}/cancel</li>  
  </ol>
</div>

3.	Which is the endpoint for deleting a job?
<div style="margin-left: 2em;">
  <ol type="A">
	  <li>DELETE /v1/jobs/{id}</li>  
	  <li>POST /v1/jobs/{id}/delete</li>  
		<li>GET /v1/delete/{id}</li>
	  <li>PUT /v1/jobs/{id}/delete</li>  
  </ol>
</div>

4.	How are the jobs for a single backend retrieved?
<div style="margin-left: 2em;">
  <ol type="A">
	  <li>GET /v1/jobs/backends/{id}</li>  
	  <li>POST /v1/backends/{id}/jobs</li>  
		<li>GET /jobs?backend={id}</li>
	  <li>PUT /cancel</li>  
  </ol>
</div>

5.	Which is the endpoint for getting the status of a backend
<div style="margin-left: 2em;">
  <ol type="A">
	  <li>POST /v1/backends/status</li>  
	  <li>POST /v1/backends/{id}/status</li>  
	  <li>GET /v1/backends/{id}/status</li>  
	  <li>GET /v1/status/{id}</li>  
  </ol>
</div>

Key:
1. A.
2. C.
3. A.  
4. x
5. C.
