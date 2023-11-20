import matplotlib.pyplot as plt

# Function to read data from the text file
def read_data(file_path):
    sizes = []
    times = []
    with open(file_path, 'r') as file:
        # Skip the header line
        next(file)
        for line in file:
            size, time = map(float, line.strip().split())
            sizes.append(size)
            times.append(time)
    return sizes, times

# Read data from the text file
file_path = 'HeapSortResults.txt'
sizes, times = read_data(file_path)

# Create a scatter plot
plt.plot(sizes, times, marker = 'o')
plt.title('Heap-Sort Performance')
plt.xlabel('Array Size')
plt.ylabel('Time (ms)')
#plt.xscale('log', base = 2)
plt.yscale('log', base = 2)
plt.grid(True)
plt.show()
