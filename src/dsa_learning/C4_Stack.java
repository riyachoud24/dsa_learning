package dsa_learning;
//Question 3
class C4_Stack {
    private C4_Dequeue deque;

    public C4_Stack(int s) {
        deque = new C4_Dequeue(s);
    }

    public void push(long j) {
        deque.insertRight(j);
    }

    public long pop() {
        return deque.removeRight();
    }

    public long peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        long item = pop();
        push(item);
        return item;
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }
}
////////////////////////////////////////////////
class C4_StackApp {
    public static void main(String[] args) {
        C4_Stack theStack = new C4_Stack(10); // make new stack

        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

