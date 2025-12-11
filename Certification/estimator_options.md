# Estimator Options
These are the options for the Sampler.

- **max_execution_time**.
- **environment**. Options related to the execution environment (tags, log_level, private)
- **simulator**. Simulator options (noise_model, seed_simulator, coupling_map, basis_gates)
- **default_precision**. Default $\frac{1}{\sqrt{4096}} = 0.015625$.
- **default_shots**. The default number of shots to use if none are specified in the PUBs or in the run method. Default 4096.
- **resilience_level**.
- **seed_estimator**.
- **dynamical_decoupling**. Suboptions for dynamical decoupling. See DynamicalDecouplingOptions for all available options.
- **resilience**. Execution time options. See SamplerExecutionOptionsV2 for all available options.
- **execution**. Execution time options. See SamplerExecutionOptionsV2 for all available options.
- **twirling**. Pauli twirling options. See TwirlingOptions for all available options.

