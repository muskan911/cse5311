def depth_first_search(graph, start):
    visited = set()
    result = []

    def dfs(v):
        if v not in visited:
            visited.add(v)
            result.append(v)
            for neighbor in graph.get(v, []):
                dfs(neighbor)

    dfs(start)
    return result

# Example Graph
graph = {0: [1, 2], 1: [2], 2: [0, 3], 3: [3]}
start_vertex = 2
print("DFS Traversal:", depth_first_search(graph, start_vertex))