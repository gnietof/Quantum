# Set transpiler optimization level
- Real quantum devices are subject to noise and gate errors, so optimizing the circuits to reduce their depth and gate count can significantly improve the results obtained from executing those circuits. 
- The generate_preset_pass_manager function has one required positional argument, optimization_level, that controls how much effort the transpiler spends on optimizing circuits.
- This argument can be an integer taking one of the values 0, 1, 2, or 3. 
- Higher optimization levels generate more optimized circuits at the expense of longer compile times. 

| Optimization Level | Description |
|:------------------:|-------------|
| 0 | No optimization. Typically used for hardware characterization.<br>- Basic translation<br>- Layout/Routing: TrivialLayout, where it selects the same physical qubit numbers as virtual and inserts SWAPs to make it work (using SabreSwap) |
| 1	| Light optimization.<br>- Layout/Routing: Layout is first attempted with TrivialLayout. If additional SWAPs are required, a layout with a minimum number of SWAPs is found by using SabreSwap, then it uses VF2LayoutPostLayout to try to select the best qubits in the graph.<br>- InverseCancellation<br>- 1Q gate optimization |
| 2	| Medium optimization.<br>- Layout/Routing: Optimization level 1 (without trivial) + heuristic optimized with greater search depth and trials of optimization function.<br>- Because TrivialLayout is not used, there is no attempt to use the same physical and virtual qubit numbers.<br>- CommutativeCancellation. |
| 3	| High Optimization.<br>- Optimization level 2 + heuristic optimized on layout/routing further with greater effort/trials.<br>- Resynthesis of two-qubit blocks using Cartan's KAK Decomposition.<br>- Unitarity-breaking passes:<br>- OptimizeSwapBeforeMeasure: Moves the measurements around to avoid SWAPs.<br>- RemoveDiagonalGatesBeforeMeasure: Removes gates before measurements that would not effect the measurements. |



