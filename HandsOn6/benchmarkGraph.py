import matplotlib.pyplot as plt

# Data (replace these with your actual benchmark data)
array_sizes = [100, 500, 1000, 5000, 10000, 50000]
best_case_times = [5000, 25000, 60000, 400000, 900000, 4500000]
worst_case_times = [9000, 45000, 105000, 850000, 1950000, 9450000]
average_case_times = [7000, 35000, 80000, 600000, 1300000, 6600000]

# Plotting the graph
plt.figure(figsize=(10, 6))

plt.plot(array_sizes, best_case_times, label="Best Case", marker='o', color='g')
plt.plot(array_sizes, worst_case_times, label="Worst Case", marker='o', color='r')
plt.plot(array_sizes, average_case_times, label="Average Case", marker='o', color='b')

# Adding title and labels
plt.title('Quicksort Non-Random Pivot Benchmark')
plt.xlabel('Array Size (n)')
plt.ylabel('Time (ns)')
plt.legend()

# Display the graph
plt.grid(True)
plt.show()
