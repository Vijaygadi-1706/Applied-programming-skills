class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    public void push(int x) {
        stackIn.push(x);
    }
    public int pop() {
        shiftStacks();
        return stackOut.pop();
    }
    public int peek() {
        shiftStacks();
        return stackOut.peek();
    }
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}
