from topological_sort import topological_sort

def test_topological_sort():
    # Example from the book or a custom case
    graph = {5: [2, 0], 4: [0, 1], 2: [3], 3: [1], 1: [], 0: []}
    result = topological_sort(graph)
    # The order may vary, but should satisfy dependencies
    assert result in [[5, 4, 2, 3, 1, 0], [4, 5, 2, 3, 1, 0]]

if __name__ == "__main__":
    test_topological_sort()
    print("Topological Sort Test Passed!")
