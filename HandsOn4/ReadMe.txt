Muskan Arora
1002160963

Problem 0: Fibonacci
Function Call Stack for fib(5):

fib(5) -> fib(4) -> fib(3) -> fib(2) -> fib(1) -> fib(0)
fib(2) -> fib(1) -> fib(0)
fib(3) -> fib(2) -> fib(1) -> fib(0)
fib(4) -> fib(3) -> fib(2) -> fib(1) -> fib(0)

Problem 1: Merging K Sorted Arrays
Time Complexity Analysis:
We use a priority queue (min-heap) to efficiently retrieve the smallest element from the K sorted arrays.
The priority queue always contains K elements at most (one from each array).
For every element in the arrays, we insert it into or extract it from the priority queue, which costs 
𝑂(log𝐾) per operation.
Since there are a total of 𝑁 × 𝐾 elements across all arrays, where N is the size of each array and K is the number of arrays, the overall time complexity is:
𝑂(𝑁 × 𝐾 × log⁡𝐾)

Possible Improvements:

Divide and Conquer Approach:
Instead of using a priority queue, you could merge arrays two at a time in a divide and conquer fashion. This would reduce the number of times you merge from 
K to logK.
The time complexity would still be 
O(N×KlogK), but in practice, it may perform slightly better due to fewer comparisons in the heap.

Parallel Processing:
If you are dealing with extremely large arrays, parallelizing the merging process across multiple processors or threads can significantly improve performance. You can divide the arrays among multiple threads and merge their results in parallel.

External Merge Sort:
If the arrays are so large that they cannot fit into memory, an external merge sort can be employed. You would sort chunks of data in memory and then merge them using a disk-based merge process. This is useful for handling large datasets.

Problem 2: Removing Duplicates from a Sorted Array
Time Complexity Analysis:
We iterate through the array exactly once, comparing each element with its predecessor. This gives a time complexity of:
O(N) where, N is the size of the input array.

Possible Improvements:
Memory Usage:
Currently, the solution modifies the input array in place. If memory usage is not a concern, you could allocate a new array for the result. This might improve code clarity but would increase space complexity from O(1) to O(N).
Handling Large Arrays:
If you have very large sorted arrays and memory is a limitation, consider stream processing the array. You can handle chunks of the array sequentially rather than loading the entire array into memory at once.