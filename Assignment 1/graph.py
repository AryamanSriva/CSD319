import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(0, 1e6, 7)  

y_values = [1700, 2000, 3100, 3700, 4300, 5800, 6600]

labels = [
    'Value 1',
    'Value 2',
    'Value 3',
    'Value 4',
    'Value 5',
    'Value 6',
    'Value 7'
]

plt.figure(figsize=(10, 6))
plt.plot(x, y_values, marker='o', linestyle='-', color='b')

for i, (xi, yi) in enumerate(zip(x, y_values)):
    plt.text(xi, yi, f'{yi}', fontsize=9, ha='right')

plt.xlabel('x-axis (0 to 10^6)')
plt.ylabel('Time (ns)')
plt.title('Graph of Time vs. X-axis')
plt.grid(True)
plt.show()
