class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find(self, node):
        if self.parent[node] != node:
            self.parent[node] = self.find(self.parent[node])  # Path compression
        return self.parent[node]

    def union(self, node1, node2):
        root1 = self.find(node1)
        root2 = self.find(node2)

        if root1 != root2:
            if self.rank[root1] > self.rank[root2]:
                self.parent[root2] = root1
            elif self.rank[root1] < self.rank[root2]:
                self.parent[root1] = root2
            else:
                self.parent[root2] = root1
                self.rank[root1] += 1

def kruskal(num_vertices, edges):
    edges.sort(key=lambda x: x[2])  # Sort edges by weight
    uf = UnionFind(num_vertices)
    mst = []

    for u, v, weight in edges:
        if uf.find(u) != uf.find(v):  # If adding this edge won't form a cycle
            uf.union(u, v)
            mst.append((u, v, weight))

    return mst