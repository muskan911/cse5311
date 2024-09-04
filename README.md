Name : Muskan Arora
Student ID: 1002160963

**Overview of Selection Sort**
Iteratively choosing the lowest (or largest) member from the array's unsorted section, selection sort replaces it with the array's initial unsorted element. Until the entire array is sorted, these steps are repeated.

**Invariant:** The subarray {arr[0...i-1]} is sorted before to each iteration of the outer loop (indexed by {i}), and each element in this subarray is less than or equal to each element in the remaining subarray {arr[i...n-1]}.

1. **Base Case (Initialization):** - **Initial State:** Because no entries have been processed prior to the first iteration ({i = 0}), the subarray {arr[0...i-1]} is empty.
   - **Check for Conditions:** The invariant is valid since an empty subarray is trivially sorted. In addition, the smallest element will be chosen in the first iteration, and every element in the unsorted segment {arr[0...n-1]} stays unchanged.

2. **Inductive Step (Maintenance):** - **Assumption:** Assume that the subarray {arr[0...i-1]} is sorted and that all of its elements are less than or equal to every element in {arr[i...n-1]}. This means that the loop invariant is true prior to the {i}th iteration.
   - **Action in Loop:** The algorithm locates the smallest element in the subarray {arr[i...n-1]} and replaces it with {arr[i]} in the {i}th iteration. This guarantees that the subarray {arr[0...i]} is sorted at the end of this iteration.
   **Check Condition**: After sorting the subarray {arr[0...i]}, we chose the smallest element from the unsorted part, so all the elements in `arr[0...i]} are still less than or equal to all the elements in `arr[i+1...n-1]}. After the {i}th iteration, the invariant is thus preserved.

3. **Termination (Final State):** - **Condition:** When {i = n-1}, the loop breaks after {n-1} iterations. At this stage, the array has been accurately sorted in non-decreasing order, and the subarray {arr[0...n-1]} is entirely sorted.
   - **Static Requirements:** The selection sort algorithm is accurate, and the array is sorted through to the end, since the invariant holds at each iteration and following the last iteration.

- **Initialization:** When the sorted subarray is empty, the loop invariant is true prior to the first iteration.
**Maintenance:** The smallest element from the unsorted segment is chosen at each iteration and placed in the appropriate location within the sorted subarray to maintain the invariant.
**Termination:** After processing the entire array, the loop ends, leaving a fully sorted array that validates the algorithm's accuracy.

### **Result:**
The sorted component of the array grows correctly and stays sorted because the selection sort method continuously maintains a loop invariant. We may assert with confidence that selection sort always results in an array that is correctly sorted by proving that the invariant holds from initialization through maintenance to termination.
