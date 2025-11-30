# Pauli
This is a representation of an operator from a n-qubit Pauli group.

$$P = (-i)^q P_{n-1} \otimes ...\otimes P_0$$

Where $q \in \mathbb{Z^4}$ and $P \in {I, X, Y, Z}$ are the single qubit Pauli matrices:  

$$
I = 
\left[\begin{array}{cc}1 & 0 \\ 
0 & 1\end{array}\right]
\quad
X = 
\left[\begin{array}{cc}0 & 1 \\ 
1 & 0\end{array}\right]
\quad
Y = 
\left[\begin{array}{cc}0 & -i \\ 
i & 0\end{array}\right]
\quad
Z = 
\left[\begin{array}{cc}1 & 0 \\ 
0 & -1\end{array}\right]
$$

Keeping $q \in \mathbb{Z^4}$ means that q $\in$ {0,1,2,3} and so the phase term will only have four possible values: 1, -i, -1, i.

## Initialization

- **Pauli(obj)**. Where obj is a Pauli string, Pauli or ```ScalarOp```operator, or a Pauli gate or ```QuantumCircuit ````containing only Pauli gates.
    - Using a Pauli string which represents $P = (-i)^1 X \otimes Y \otimes Z$.
      ```python
      P = Pauli('-iXYZ') 
      ```
    - Using a QuantumCircuit composed only of Pauli gates. The example below represents $P = X \otimes Y \otimes Z$ and is equivalent to ```Pauli('XYZ')```.
      ```python
      P = Pauli('XYZ') 
      P.to_matrix()   
      ```
      <img width="589" height="139" alt="image" src="https://github.com/user-attachments/assets/82e5df46-2c1b-4926-b218-f5ed3e936076" />
      
      ```python
      from qiskit import QuantumCircuit

      qc = QuantumCircuit(3)
      qc.x(2)
      qc.y(1)
      qc.z(0)
      qc.draw('mpl')
      ```
      <img width="126" height="195" alt="image" src="https://github.com/user-attachments/assets/767eca20-f8c6-42cb-9530-14fe0115fd60" />
      
      ```python
      Q = Pauli(qc)
      Q.to_matrix()        
      ```  
      <img width="589" height="139" alt="image" src="https://github.com/user-attachments/assets/82e5df46-2c1b-4926-b218-f5ed3e936076" />

      Now, the expression returns **True** (in fact, ```np.True```)
      ```python
      P.to_matrix() == Q.to_matrix()
      ```
      <img width="527" height="146" alt="image" src="https://github.com/user-attachments/assets/ac86dbd8-fc04-4822-b1ce-d5069b94d4d8" />

    - Using a ScalarOp **having dimensions compatible with N-qubits**. So dimension can only be 1 (returns a constant and not a Pauli gate),2,4 ...
      - Pauli(ScalarOp(2,1)) $\equiv I$
      - Pauli(ScalarOp(4,1j)) $\equiv iII$

- **Pauli(z,x,[phase])**. Where z and x are boolean ```numpy.ndarrays``` and the optional phase is an integer in {0,1,2,3}.
  In this case the Pauli object is expressed as a combination of X and Z gates. That is possible because $ZZ = XX = I$ and $ZX = iY$ or $XZ = -iY$.

$$P = P_{n-1} \otimes ...\otimes P_0$$
$$P_k = (-i)^{q+x_k*z_k} Z^{z_k} X^{x_k}$$

|$z_k$|$x_k$|Pauli|$P_k$|
|:---:|:---:|:---:|-|
|0|0|$I$|$(-i)^q|
|0|1|$X$|$(-i)^q X$|
|1|0|$Z$|$(-i)^q Z$|
|1|1|$Y$|$(-i)^{q+1} iY = -i(-i)^q iY = (-i)^q Y$|

  Each bit is provided in a bit array. So, the previous Pauli('XYZ') would be:
      ```python
      Pauli(([1,1,0],[0,1,1],0))
      ```  

  That is (qubits are in reversed order):
  
  $$P_2 = (-i)^{0+0} X = X$$  
  $$P_1 = (-i)^{0+1} ZX = -i(ZX) = -i(iY) = Y$$  
  $$P_0 = (-i)^{0+0} Z = Z$$  

  And the resulting Pauli would be $(X)(Y)(Z) = XYZ$

  ### Bonus thinking
  If we add a global phase then:  
      ```python
      Pauli(([1,1,0],[0,1,1],1))
      ```
     
  That is (qubits are in reversed order):  
  
  $$P_2 = (-i)^{1+0} X = -iX$$  
  $$P_1 = (-i)^{1+1} ZX = ZX = iY$$  
  $$P_0 = (-i)^{1+0} Z = -iZ$$  

  And the resulting Pauli would be $(-iX)(iY)(-iZ) = -iXYZ$
  
  In a four bit Pauli ```Pauli(([1,1,0,0],[0,1,1,0],0))```:

  $$P_3 = (-i)^{0+0} = I$$  
  $$P_2 = (-i)^{0+0} X = X$$  
  $$P_1 = (-i)^{0+1} ZX = -i(ZX) = -i(iY) = Y$$  
  $$P_0 = (-i)^{0+0} Z = Z$$  

  And the resulting Pauli would be $(I)(X)(Y)(Z) = IXYZ$
  
  If we add a phase in that four bit Pauli ```Pauli(([1,1,0,0],[0,1,1,0],1))```:

  $$P_3 = (-i)^{1+0} = -iI$$  
  $$P_2 = (-i)^{1+0} X = -iX$$  
  $$P_1 = (-i)^{1+1} ZX = ZX = iY$$  
  $$P_0 = (-i)^{1+0} Z = -iZ$$  

  And the resulting Pauli would be $(-iI)(-iX)(iY)(-iZ) = -iXYZ$

  I was thinking that the number of qubits would affect the global phase. But that is not the case because we might write:

  $$P = P_{n-1} \otimes ...\otimes P_0 = ((-i)^{(q+x_{n-1}*z_{n-1})} Z^{z_{n-1}} X^{x_{n-1}}) ... ((-i)^{(q+ x_0 * z_0)} Z^{z_0} X^{x_0}) = $$
  $$= (-i)^q ((-i)^{x_{n-1} * z_{n-1}} Z^{z_{n-1}} X^{x_{n-1}})...((-i)^{x_0 * z_0} Z^{z_0} X^{x_0})$$

## String representation

  - An n-qubit Pauli may be represented by a string consisting of nn characters from ['I', 'X', 'Y', 'Z'], and optionally phase coefficient in ['', '-i', '-', 'i']. For example: 'XYZ' or '-iZIZ'.
  - In the string representation qubit-0 corresponds to the right-most Pauli character, and qubit-(n−1) to the left-most Pauli character.
    
## Array respresentation

  - The internal data structure of an n-qubit Pauli is two length-n boolean vectors $z \in Z_2^N, x \in Z_2^N$ and an integer $q \in Z_4$​ defining the Pauli operator.
  
## Matrix operator representation

Pauli’s can be converted to $(2^n,2^n)$ Operator using the ```to_operator()``` method, or to a dense or sparse complex matrix using the ```to_matrix()``` method.

## Data access

The individual qubit Paulis can be accessed and updated using the [] operator which accepts integer, lists, or slices for selecting subsets of Paulis. Note that selecting subsets of Pauli’s will discard the phase of the current 
