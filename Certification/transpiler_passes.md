# Transpiler Passes

This includes a list of classes implementing each of the passes in a transpiler. I wonder if going through this list makes any sense for the certification. 

## Layout Selection

SetLayout — Set the layout property to the given layout.

TrivialLayout — Choose a layout by assigning qubits to device qubits 0..n-1.

DenseLayout — Choose a layout by finding the most connected subset of qubits.

SabreLayout — Choose a layout via iterative bidirectional routing.

CSPLayout — Constraint-satisfaction layout search.

VF2Layout — Layout via subgraph isomorphism (VF2++).

ApplyLayout — Apply/update the mapping from virtual to physical qubits.

Layout2qDistance — Evaluate layout quality.

EnlargeWithAncilla — Add unused layout qubits as ancilla.

FullAncillaAllocation — Allocate idle nodes as ancilla qubits.

SabrePreLayout — Choose a starting layout for Sabre trials.

## Routing

BasicSwap — Insert swaps minimally to satisfy coupling map.

Commuting2qGateRouter — Router for commuting two-qubit gates.

LayoutTransformation — Add swaps to transform between layouts.

LookaheadSwap — Lookahead-based swap routing.

SabreSwap — SABRE strategy for swap selection.

StarPreRouting — Pre-route by mapping stars to linear topology.

## Basis Change

BasisTranslator — Translate gates into a target basis.

Decompose — Decompose gates using their decomposition rules.

TranslateParameterizedGates — Translate parameterized gates to a supported basis.

Unroll3qOrMore — Unroll 3+ qubit gates into 1- and 2-qubit gates.

UnrollCustomDefinitions — Unroll instructions with custom gate definitions.

## Optimizations

Collect1qRuns — Collect runs of 1-qubit subcircuits.

Collect2qBlocks — Collect 2-qubit subcircuits.

CollectAndCollapse — Collect and collapse multi-gate blocks.

CollectCliffords — Collect Cliffords into blocks.

CollectLinearFunctions — Collect linear functions and simplify CX chains.

CollectMultiQBlocks — Collect uninterrupted multi-qubit gate blocks.

CommutationAnalysis — Determine commutation relations.

CommutativeCancellation — Cancel redundant self-adjoint gates.

CommutativeInverseCancellation — Cancel inverse pairs using commutation.

ConsolidateBlocks — Replace blocks of gates with a single unitary.

ContractIdleWiresInControlFlow — Remove idle wires inside control flow.

ElidePermutations — Remove pre-layout permutations.

HoareOptimizer — Hoare-logic-based circuit optimization.

InverseCancellation — Cancel sequential inverse gates.

LitinskiTransformation — Apply Litinski transformations.

Optimize1qGates — Optimize sequences of single-qubit gates.

Optimize1qGatesDecomposition — Combine 1-qubit gates via decomposition.

Optimize1qGatesSimpleCommutation — Simplify 1-qubit runs via commutation.

OptimizeAnnotated — Optimization for annotated circuits.

OptimizeCliffordT — Optimize Clifford+T circuits.

OptimizeCliffords — Combine adjacent Clifford operations.

OptimizeSwapBeforeMeasure — Remove swaps before measurement.

RemoveDiagonalGatesBeforeMeasure — Remove diagonal gates before measurement.

RemoveFinalReset — Remove trailing reset operations.

RemoveIdentityEquivalent — Remove identity-equivalent operations.

RemoveResetInZeroState — Remove unnecessary resets.

ResetAfterMeasureSimplification — Replace reset-after-measure patterns.

Split2QUnitaries — Attempt to split 2-qubit unitaries.

TemplateOptimization — Apply pattern-based optimization templates.

## Scheduling

ALAPScheduleAnalysis — Latest-time scheduling analysis.

ASAPScheduleAnalysis — Earliest-time scheduling analysis.

ConstrainedReschedule — Reschedule respecting alignment constraints.

ContextAwareDynamicalDecoupling — Insert context-aware DD sequences.

InstructionDurationCheck — Validate gate durations.

PadDelay — Pad idle time with delays.

PadDynamicalDecoupling — Insert padding dynamical decoupling.

SetIOLatency — Set input/output latency metadata.

TimeUnitConversion — Normalize circuit time units.

Circuit Analysis

CountOps — Count operations.

CountOpsLongestPath — Count operations on the longest path.

DAGLongestPath — Find the DAG longest path.

Depth — Compute circuit depth.

NumTensorFactors — Number of tensor factors.

ResourceEstimation — Resource estimation.

Size — Compute circuit size.

Width — Compute circuit width.

## Synthesis

HLSConfig — Configuration container for high-level synthesis.

HighLevelSynthesis — Perform high-level synthesis or unrolling.

LinearFunctionsToPermutations — Convert linear functions to permutations.

SolovayKitaev — Solovay-Kitaev 1-qubit approximation synthesis.

UnitarySynthesis — Synthesize unitaries for a target basis.

## Post Layout

VF2PostLayout — Improve layout post-routing via VF2++ search.

## Additional Passes

BarrierBeforeFinalMeasurements — Add a barrier before final measurements.

CheckGateDirection — Check if 2-qubit gates follow coupling direction.

CheckMap — Check if circuit respects coupling map.

ContainsInstruction — Detect presence of specified instructions.

DAGFixedPoint — Check if DAG is at a fixed point.

Error — Error/exception pass.

FilterOpNodes — Remove ops matching a filter.

FixedPoint — Check if a circuit property has stabilized.

GatesInBasis — Check if all gates are in a basis set.

MergeAdjacentBarriers — Merge back-to-back barriers.

MinimumPoint — Check for semi-stable points.

RemoveBarriers — Remove barrier instructions.

RemoveFinalMeasurements — Remove trailing measurements.

UnrollForLoops — Unroll for loops.

WrapAngles — Wrap angles to valid device ranges.
