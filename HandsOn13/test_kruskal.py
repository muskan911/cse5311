from kruskal import kruskal

def test_kruskal():
    # Example edges and graph
    edges = [
        (0, 1, 10),
        (0, 2, 6),
        (0, 3, 5),
        (1, 3, 15),
        (2, 3, 4)
    ]
    num_vertices = 4
    mst = kruskal(num_vertices, edges)

    print("Kruskal's MST:", mst)

if __name__ == "__main__":
    test_kruskal()
