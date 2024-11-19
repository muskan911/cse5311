def topological_sort(graph):
    visited = set()
    stack = []

    def dfs(v):
        if v not in visited:
            visited.add(v)
            # Sort neighbors for deterministic traversal
            for neighbor in sorted(graph.get(v, [])):
                dfs(neighbor)
            stack.append(v)

    # Sort vertices in descending order for consistent processing
    for vertex in sorted(graph, reverse=True):
        if vertex not in visited:
            dfs(vertex)

    return stack[::-1]  # Return in reverse order

# Example Graph
graph = {5: [2, 0], 4: [0, 1], 2: [3], 3: [1], 1: [], 0: []}

# Running the Topological Sort
print("Topological Sort (Adjusted):", topological_sort(graph))