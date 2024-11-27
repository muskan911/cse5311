import heapq

# Dijkstra's Algorithm
def DIJKSTRA(V, E, w, s):
    """
    Implements Dijkstra's Algorithm for finding the shortest paths from a single source vertex.
    V: Set of vertices
    E: Adjacency list representing edges
    w: Weight function (included in E as (v, weight))
    s: Source vertex
    """
    d = {v: float('inf') for v in V}  # Initialize distances
    d[s] = 0
    Q = [(0, s)]  # Priority queue initialized with source
    while Q:
        _, u = heapq.heappop(Q)  # Extract-min
        for v, weight in E[u]:  # For each neighbor v of u
            if d[u] + weight < d[v]:  # Relax edge (u, v)
                d[v] = d[u] + weight
                heapq.heappush(Q, (d[v], v))  # Update priority queue
    return d

# Bellman-Ford Algorithm
def BELLMAN_FORD(V, E, w, s):
    """
    Implements Bellman-Ford Algorithm for finding shortest paths and detecting negative-weight cycles.
    V: Set of vertices
    E: List of edges as (u, v, weight)
    w: Weight function (included in E)
    s: Source vertex
    """
    d = {v: float('inf') for v in V}  # Initialize distances
    d[s] = 0
    for _ in range(len(V) - 1):  # Perform |V| - 1 relaxations
        for u, v, weight in E:  # For each edge (u, v)
            if d[u] + weight < d[v]:  # Relax edge
                d[v] = d[u] + weight
    for u, v, weight in E:  # Check for negative-weight cycles
        if d[u] + weight < d[v]:
            return None  # Negative-weight cycle detected
    return d

# Floyd-Warshall Algorithm
def FLOYD_WARSHALL(V, W):
    """
    Implements Floyd-Warshall Algorithm for finding shortest paths between all pairs of vertices.
    V: List of vertices
    W: Adjacency matrix of weights
    """
    n = len(V)
    d = [row[:] for row in W]  # Copy of adjacency matrix
    for k in range(n):  # For each intermediate vertex k
        for i in range(n):  # For each pair (i, j)
            for j in range(n):
                if d[i][k] + d[k][j] < d[i][j]:  # Update shortest path
                    d[i][j] = d[i][k] + d[k][j]
    return d

# Main Function to Test Algorithms
if __name__ == "__main__":
    # Dijkstra Example (Figure 24.2)
    V_dijkstra = {0, 1, 2, 3, 4}
    E_dijkstra = {
        0: [(1, 10), (2, 5)],
        1: [(2, 2), (3, 1)],
        2: [(1, 3), (3, 9), (4, 2)],
        3: [],
        4: [(0, 7), (3, 6)]
    }
    s_dijkstra = 0
    dijkstra_result = DIJKSTRA(V_dijkstra, E_dijkstra, None, s_dijkstra)
    print("Dijkstra's Algorithm Result:", dijkstra_result)

    # Bellman-Ford Example (Figure 24.4)
    V_bellman = {0, 1, 2, 3, 4}
    E_bellman = [(0, 1, 6), (0, 2, 7), (1, 2, 8), (1, 3, 5), (1, 4, -4),
                 (2, 3, -3), (2, 4, 9), (3, 1, -2), (4, 0, 2), (4, 3, 7)]
    s_bellman = 0
    bellman_result = BELLMAN_FORD(V_bellman, E_bellman, None, s_bellman)
    print("Bellman-Ford Algorithm Result:", bellman_result)

    # Floyd-Warshall Example (Figure 25.1)
    V_fw = [0, 1, 2, 3, 4]
    W_fw = [[0, 3, 8, float('inf'), -4],
            [float('inf'), 0, float('inf'), 1, 7],
            [float('inf'), 4, 0, float('inf'), float('inf')],
            [2, float('inf'), -5, 0, float('inf')],
            [float('inf'), float('inf'), float('inf'), 6, 0]]
    floyd_warshall_result = FLOYD_WARSHALL(V_fw, W_fw)
    print("Floyd-Warshall Algorithm Result:")
    for row in floyd_warshall_result:
        print(row)
