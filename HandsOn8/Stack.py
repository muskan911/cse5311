class Stack:
    def __init__(self, size):
        self.stack = [0] * size  
        self.top = -1  
        self.size = size

    def push(self, value):
        if self.top == self.size - 1:
            print("Stack Overflow")
            return
        self.top += 1
        self.stack[self.top] = value

    def pop(self):
        if self.top == -1:
            print("Stack Underflow")
            return None
        value = self.stack[self.top]
        self.top -= 1
        return value

    def peek(self):
        if self.top == -1:
            print("Stack is empty")
            return None
        return self.stack[self.top]

    def display(self):
        if self.top == -1:
            print("Stack is empty")
            return
        for i in range(self.top + 1):
            print(self.stack[i], end=" ")
        print()


# Example 
stack = Stack(5)
stack.push(10)
stack.push(20)
stack.push(30)
stack.display()
print("Popped:", stack.pop())
stack.display()
