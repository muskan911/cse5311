class Queue:
    def __init__(self, size):
        self.queue = [0] * size  
        self.front = -1
        self.rear = -1
        self.size = size

    def enqueue(self, value):
        if self.rear == self.size - 1:
            print("Queue Overflow")
            return
        if self.front == -1:
            self.front = 0  
        self.rear += 1
        self.queue[self.rear] = value

    def dequeue(self):
        if self.front == -1 or self.front > self.rear:
            print("Queue Underflow")
            return None
        value = self.queue[self.front]
        self.front += 1
        return value

    def display(self):
        if self.front == -1 or self.front > self.rear:
            print("Queue is empty")
            return
        for i in range(self.front, self.rear + 1):
            print(self.queue[i], end=" ")
        print()


# Example 
queue = Queue(5)
queue.enqueue(10)
queue.enqueue(20)
queue.enqueue(30)
queue.display()
print("Dequeued:", queue.dequeue())
queue.display()
