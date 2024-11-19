from dfs import depth_first_search

def test_dfs():
    graph = {0: [1, 2], 1: [2], 2: [0, 3], 3: [3]}
    start_vertex = 2
    result = depth_first_search(graph, start_vertex)
    assert result == [2, 0, 1, 3] or result == [2, 3, 0, 1]

if __name__ == "__main__":
    test_dfs()
    print("DFS Test Passed!")