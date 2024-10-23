class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def append(self, key, value):
        new_node = Node(key, value)
        if not self.head:
            self.head = self.tail = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node

    def find(self, key):
        current = self.head
        while current:
            if current.key == key:
                return current
            current = current.next
        return None

    def remove(self, key):
        current = self.find(key)
        if current is None:
            return False
        if current.prev:
            current.prev.next = current.next
        if current.next:
            current.next.prev = current.prev
        if current == self.head:
            self.head = current.next
        if current == self.tail:
            self.tail = current.prev
        return True


class HashTable:
    def __init__(self, initial_capacity=8, load_factor=0.75):
        self.capacity = initial_capacity
        self.size = 0
        self.load_factor = load_factor
        self.table = [DoublyLinkedList() for _ in range(self.capacity)]

    def hash_function(self, key):
        A = 0.6180339887  
        hash_value = int(self.capacity * ((key * A) % 1))
        return hash_value

    def put(self, key, value):
        index = self.hash_function(key)
        linked_list = self.table[index]

        existing_node = linked_list.find(key)
        if existing_node:
            existing_node.value = value  
        else:
            linked_list.append(key, value)
            self.size += 1

        if self.size / self.capacity > self.load_factor:
            self.resize(self.capacity * 2)

    def get(self, key):
        index = self.hash_function(key)
        linked_list = self.table[index]
        node = linked_list.find(key)
        return node.value if node else None

    def remove(self, key):
        index = self.hash_function(key)
        linked_list = self.table[index]
        removed = linked_list.remove(key)
        if removed:
            self.size -= 1
            if self.size / self.capacity < 0.25:
                self.resize(self.capacity // 2)

    def resize(self, new_capacity):
        old_table = self.table
        self.table = [DoublyLinkedList() for _ in range(new_capacity)]
        self.capacity = new_capacity
        self.size = 0  

        for linked_list in old_table:
            current = linked_list.head
            while current:
                self.put(current.key, current.value)
                current = current.next


# Example usage:
hash_table = HashTable()

hash_table.put(1, 10)
hash_table.put(2, 20)
hash_table.put(3, 30)

print(hash_table.get(1))  
print(hash_table.get(2))  
print(hash_table.get(3))  

hash_table.remove(2)
print(hash_table.get(2)) 