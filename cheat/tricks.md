# Tricks
Just some useful 'tricks' I keep here for my own consumption

# Trigonometry
When preparing for the Qiskit exam, sometimes you face with the need to find the sinus or cosinus for multiples of $\pi$ ($\frac{\pi}
{2}, \frac{\pi}{4}, \frac{\pi}{8}$...).

I have found interesting useful these relationships, although cumbersome if multiple steps are required.

$`sin(\frac{\theta}{2})= \sqrt{\frac{1-cos(\theta)}{2}}`$  
$`cos(\frac{\theta}{2})= \sqrt{\frac{1+cos(\theta)}{2}}`$  

In the interest of brevity, I will be including here a table with some common values. I am also including the square of those numbers because that is the magnitude used for probabilities.

| Angle (Rad) | Angle (Deg) | Cosinus | Sinus | Cosinus^2 | Sinus^2 |
| :---------: | :---------: | :-----: | :---: | :-------: | :-----: |  
|$`\pi`$|180º|-1|0|1|0|
|$`\frac{\pi}{2}`$|90º|0|1|0|1|  
|$`\frac{\pi}{4}`$|45º|$`\frac{\sqrt{2}}{2} \approx 0.707`$|$`\frac{\sqrt{2}}{2} \approx 0.707`$|0.5|0.5|  
|$`\frac{\pi}{8}`$|22.5º|$`\frac{\sqrt{2+\sqrt{2}}}{2} \approx 0.382`$|$`\frac{\sqrt{2-\sqrt{2}}}{2} \approx 0.924`$|$`\approx 0.146`$|$`\approx 0.854`$|
|$`\frac{\pi}{16}`$|11.25º|$`\frac{\sqrt{2+\sqrt{2+\sqrt{2}}}}{2} \approx 0.980`$|$`\frac{\sqrt{2-\sqrt{2+\sqrt{2}}}}{2} \approx 0.195`$|$`\approx 0.962`$|$`\approx 0.038`$
|$`0`$|0|1|0|1|0|  

