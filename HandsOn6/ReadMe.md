Muskan Arora 
1002160963

Problem 1: 
Implementations are available in quickSortNonRandom.java and quickSortRandom.java

Problem 2:
![alt text](image.png)

Problem 3:

For the average case, we assume that the array is random, and the pivot splits the array into two parts where the size of each part varies randomly.

Recursive Formula: The recurrence relation for the average case of quicksort can be written as:
T(n)= i=1 ∑n (T(i−1)+T(n−i))+O(n)
This is because, on average, the pivot splits the array into two parts, and we need to recursively sort both sides.

The first term represents the average number of comparisons in the recursive calls, and the 
O(n) term represents the time needed to perform the partition operation at the current level.

Solving the Recurrence: Using the Master Theorem for divide-and-conquer recurrences, the recurrence simplifies to:
T(n)=O(nlogn)
This implies that, on average, Quicksort runs in linearithmic time.

Intuition for the O(nlogn) Average Case:
Partitioning involves scanning all n elements once (hence O(n) work).
The number of recursive calls is proportional to the depth of the recursion tree, which is O(logn) on average, because the array is typically divided into reasonably balanced parts.
Hence, the total work done is n elements at each level of recursion, across O(logn) levels, giving an overall time complexity of O(nlogn).
Conclusion:
The average time complexity of non-random pivot Quicksort is O(nlogn).
This is because, despite the non-random pivot choice, random input arrays lead to approximately balanced partitions on average.