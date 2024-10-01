import matplotlib.pyplot as plt

# Data from benchmarking output
n_values = [100, 500, 1000, 5000, 10000]

best_case_times = [115792, 443542, 1362292, 6402916, 22297084]
worst_case_times = [81459, 306708, 1691834, 4778125, 19474041]
average_case_times = [25917, 25709, 45125, 207792, 441417]

plt.figure(figsize=(10, 6))

plt.plot(n_values, best_case_times, marker='o', label='Best Case', color='green')
plt.plot(n_values, worst_case_times, marker='o', label='Worst Case', color='red')
plt.plot(n_values, average_case_times, marker='o', label='Average Case', color='blue')

plt.xlabel('Input Size (n)')
plt.ylabel('Time (nanoseconds)')
plt.title('Benchmarking Quicksort (Non-Random Pivot)')

plt.legend()
plt.grid(True)
plt.yscale('log')  

plt.show()