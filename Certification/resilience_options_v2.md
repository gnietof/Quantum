# Resilience Options

## Attributes
**measure_mitigation**. Whether to enable measurement error mitigation method. If you enable measurement mitigation, you can fine-tune its noise learning by using measure_noise_learning.  
**measure_noise_learning**. Additional measurement noise learning options.  
**zne_mitigation**. Whether to turn on Zero-Noise Extrapolation error mitigation method. If you enable ZNE, you can fine-tune its options by using zne (zero noise extrapolation mitigation options; only used by the V2 Estimator).
**zne**. Additional zero-noise extrapolation mitigation options.  
  - **amplifier**. Unset or one of these values: 'gate_folding', 'gate_folding_front', 'gate_folding_back','pea'.  
  - **noise_factors**. Unset of a sequence of floats.  
  - **extrapolator**. Unset or one of these values: 'linear', 'exponential', 'double_exponential', 'polynomial_degree_1', 'polynomial_degree_2', 'polynomial_degree_3', 'polynomial_degree_4', 'polynomial_degree_5', 'polynomial_degree_6', 'polynomial_degree_7', 'fallback'.
  - **extrapolated_noise_factors**. Unset of a sequence of floats.
**pec_mitigation**. Whether to turn on Probabilistic Error Cancellation error mitigation method. If you enable PEC, you can fine-tune its options by using pec.  
**pec**. Additional probabalistic error cancellation mitigation options.  
**layer_noise_learning**. Layer noise learning options.  
**layer_noise_model**. A NoiseLearnerResult or a sequence of LayerError objects. If None, all the mitigation strategies that require noise data (e.g., PEC and PEA) perform a noise-learning stage. Otherwise, this noise-learning stage is skipped, and instead gather the required information from layer_noise_model. Layers whose information is missing in layer_noise_model are treated as noiseless and their noise is not mitigated.  

