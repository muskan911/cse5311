class SinglyLinkedList:
    def __init__(self, size):
        self.data = [0] * size  
        self.next = [-1] * size  
        self.head = -1  
        self.free_index = 0  
        self.size = size

    def insert_at_beginning(self, value):
        if self.free_index == self.size:
            print("List is full")
            return
        self.data[self.free_index] = value
        self.next[self.free_index] = self.head
        self.head = self.free_index
        self.free_index += 1

    def insert_at_end(self, value):
        if self.free_index == self.size:
            print("List is full")
            return
        new_node = self.free_index
        self.free_index += 1
        self.data[new_node] = value
        self.next[new_node] = -1

        if self.head == -1:
            self.head = new_node
        else:
            current = self.head
            while self.next[current] != -1:
                current = self.next[current]
            self.next[current] = new_node

    def delete_node(self, value):
        if self.head == -1:
            print("List is empty")
            return

        current = self.head
        prev = -1

        while current != -1 and self.data[current] != value:
            prev = current
            current = self.next[current]

        if current == -1:
            print("Value not found")
            return

        if prev == -1:
            self.head = self.next[current]
        else:
            self.next[prev] = self.next[current]

    def display(self):
        if self.head == -1:
            print("List is empty")
            return
        current = self.head
        while current != -1:
            print(f"{self.data[current]} -> ", end="")
            current = self.next[current]
        print("NULL")


# Example 
linked_list = SinglyLinkedList(5)
linked_list.insert_at_beginning(10)
linked_list.insert_at_end(20)
linked_list.insert_at_end(30)
linked_list.display()
linked_list.delete_node(20)
linked_list.display()
