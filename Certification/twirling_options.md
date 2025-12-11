# TwirlingOptions
- Twirling options

## Attributes
**enable_gates**. Whether to apply 2-qubit Clifford gate twirling.  
**enable_measure**. Whether to enable twirling to measurement instructions, as long as the measurement is not involved within a conditional block.  
**num_randomizations**. The number of random samples to use when twirling or peforming sampled mitigation.  
**shots_per_randomization**. The number of shots to run for each random sample.  
**strategy**. Specify the strategy of twirling qubits in identified layers of 2-qubit twirled gates.  
  - **active**. Only the instruction qubits in each individual twirled layer will be twirled.  
  - **active-circuit**. The union of all instruction qubits in the circuit will be twirled in each twirled layer.  
  - **active-accum**. The union of instructions qubits in the circuit up to the current twirled layer will be twirled in each individual twirled layer.  
  - **all**. All qubits in the input circuit will be twirled in each twirled layer.  

![twirling_strategy_options-1](https://github.com/user-attachments/assets/4140c505-1cd0-4cb6-8ba6-09dfa73e85ab)


