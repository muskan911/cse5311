def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1
    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i+1], arr[high] = arr[high], arr[i+1]
    return i+1

def quickselect(arr, low, high, i):
    if low == high:  
        return arr[low]
    pivot_index = partition(arr, low, high)
    if pivot_index == i:
        return arr[pivot_index]
    elif pivot_index > i:
        return quickselect(arr, low, pivot_index - 1, i)
    else:
        return quickselect(arr, pivot_index + 1, high, i)

# Example:
arr = [10, 4, 5, 8, 6, 11, 26]
n = len(arr)
i = 3  
print(f"The {i+1}th smallest element is {quickselect(arr, 0, n-1, i)}")
