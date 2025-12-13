# Advocate Certification Guide  

<table>
  <thead>
    <tr>
      <th>Topic</th>
      <th>Subtopics</th>
      <th>Resources</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Perform quantum operations</td>
      <td>
        <ul>
          <li>Define Pauli Operators</li>
          <li>Apply quantum operations</li>
        </ul>
      </td>
      <td>
        <ul>
          <li><a href='./operators.md'>Operators overview</a>✅</li>
          <li>Documentation: Operator class</li>
        </ul>
      </td>
    </tr>
    <tr>
      <td>Visualize quantum circuits, measurements, and states</td>
      <td>
        <ul>
          <li>Visualize quantum circuits</li>
          <li>Visualize quantum measurements</li>
          <li>Visualize quantum states</li>
        </ul>
      </td>
      <td>
        <ul>
          <li><a href='./visualize_circuits.md'>Visualize circuits</a>✅</li>
          <li>Documentation: Visualize results :soon:</li>
          <li><a href='.visualization.md'>Plot quantum states</a>✅</li>
        </ul>
      </td>
    </tr>
    <tr>
      <td>Create quantum circuits</td>
      <td>
        <ul>
          <li>Construct basic quantum circuits</li>
          <li>Construct dynamic circuits</li>
          <li>Construct parameterized circuits</li>
          <li>Transpile and optimize circuits</li>
        </ul>
      </td>
      <td>
        <ul>
          <li>Documentation: Construct circuits</li>
          <li>Documentation: Circuit library</li>
          <li><a href='./classical_feedforward_and_control_flow.md'>Classical feedforward and control flow</a>✅</li>
          <li>Documentation: Parameterized circuits</li>
          <li><a href='https://www.youtube.com/watch?v=TmXlUUFMUgI'>Introduction to transpilation</a>🎬</li>
          <li>Documentation: Introduction to Transpilation</li>
          <li>:new:<a href='./optimize_hardware'>Optimize for hardware</a>📝</li>
          <li>:new:<a href='./optimization_level'>Set transpiler optimization level</a>✅</li>
        </ul>
      </td>
    </tr>
    <tr>
      <td>Run quantum circuits</td>
      <td>
        <ul>
          <li>Differentiate execution modes to optimize job queuing</li>
          <li>Run quantum circuits with real hardware in the IBM Runtime provider</li>
        </ul>
      </td>
      <td>
        <ul>
          <li><a href='./execution_modes.md>Execution modes</a>✅</li>
          <li><a href='./execute_on_hardware.md'>Execute on hardware</a>✅</li>
          <li><a href='./get_started_with_primitives.md'>Get started with primitives</a>✅</li>
        </ul>
      </td>
    </tr>
    <tr>
      <td>Use the sampler primitive</td>
      <td>
        <ul>
          <li>Set sampler primitive options such as resilience levels</li>
          <li>Bypass runtime error mitigations and implement your own</li>
          <li>Understand the theoretical background behind the sampler primitive</li>
        </ul>
      </td>
      <td>
        <ul>
          <li><a href='https://www.youtube.com/watch?v=OuYz02clnx4'>An Introduction to Qiskit Runtime Primitives V2</a>🎬</li>
          <li><a href='./sampler_options.md'>Sampler options</a>✅</li>
        </ul>
      </td>
    </tr>
    <tr>
      <td>Use the estimator primitive</td>
      <td>
        <ul>
          <li>Set estimator primitive options such as resilience levels</li>
          <li>Understand the theoretical background behind the estimator primitive</li>
        </ul>
      </td>
      <td>
        <ul>
          <li><a href='https://www.youtube.com/watch?v=OuYz02clnx4'>Video: An Introduction to Qiskit Runtime Primitives V2</a>🎬</li>
          <li><a href='./estimator_options.md'>Estimator options</a>✅</li>
        </ul>
      </td>
    </tr>
    <tr>
      <td>Retrieve and analyze the results of quantum circuits</td>
      <td>
        <ul>
          <li>Retrieve previous experiment results (session/runtime)</li>
          <li>Monitor jobs</li>
        </ul>
      </td>
      <td>
        <ul>
          <li><a href='./save_jobs.md'>Save and retrieve jobs</a>✅</li>
          <li>:new:<a href='.monitor_cancel_job'>Monitor or cancel a job</a>✅</li>
        </ul>
      </td>
    </tr>
    <tr>
      <td>Operate with OpenQASM</td>
      <td>
        <ul>
          <li>Structure types in OpenQASM3 programs</li>
          <li>Interpret OpenQASM semantics for versions 2 and 3</li>
          <li>Interoperate different versions of OpenQASM with Qiskit</li>
          <li>Interact with the Qiskit IBM Runtime REST API</li>
        </ul>
      </td>
      <td>
        <ul>
          <li>Documentation: Introduction to QASM</li>
          <li><a href='qasm3_structures.md'>OpenQASM types and casting</a>✅</li>
          <li>OpenQASM syntax</li>
          <li>Documentation: OpenQASM3 and the Qiskit SDK</li>
          <li>Documentation: OpenQASM2 and the Qiskit SDK</li>
          <li><a href='./qasm3_runtime.md>Qiskit Runtime REST API</a>✅</li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

