#include <iostream>

class DynamicArray
{
private:
    int *data;
    int capacity;
    int size;

    // Method to resize the array when capacity is reached
    void resize()
    {
        capacity *= 2;
        int *newData = new int[capacity];
        for (int i = 0; i < size; ++i)
        {
            newData[i] = data[i];
        }
        delete[] data; // Free old memory
        data = newData;
    }

public:
    // Constructor to initialize the dynamic array
    DynamicArray()
    {
        capacity = 2; // Initial capacity
        size = 0;     // Initial size
        data = new int[capacity];
    }

    // Destructor to free the allocated memory
    ~DynamicArray()
    {
        delete[] data;
    }

    // Method to add an element to the array
    void add(int value)
    {
        if (size == capacity)
        {
            resize();
        }
        data[size++] = value;
    }

    // Method to get an element at a specific index
    int get(int index) const
    {
        if (index < 0 || index >= size)
        {
            std::cerr << "Index out of bounds\n";
            return -1;
        }
        return data[index];
    }

    // Method to get the current size of the array
    int getSize() const
    {
        return size;
    }

    // Method to print all elements in the array
    void print() const
    {
        for (int i = 0; i < size; ++i)
        {
            std::cout << data[i] << " ";
        }
        std::cout << std::endl;
    }
};

int main()
{
    DynamicArray arr;
    arr.add(10);
    arr.add(20);
    arr.add(30);
    arr.add(40);

    std::cout << "Array elements: ";
    arr.print();

    std::cout << "Element at index 2: " << arr.get(2) << std::endl;

    return 0;
}
