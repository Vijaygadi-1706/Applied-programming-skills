class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        data = new int[k];
        head = -1;
        tail = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) head = 0;
        tail = (tail + 1) % capacity;
        data[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % capacity;
        }
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
