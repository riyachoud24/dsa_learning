package dsa_learning;
//Question2
public class C4_Dequeue {
    private int maxSize;
    private long[] dequeArray;
    private int front;
    private int rear;
    private int nItems;

    public C4_Dequeue(int s) {
        maxSize = s;
        dequeArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insertLeft(long j) {
        if(isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (front == 0) { 
            front = maxSize;
        }
        dequeArray[--front] = j;
        nItems++;
    }

    public void insertRight(long j) {
        if(isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (rear == maxSize - 1) { 
            rear = -1;
        }
        dequeArray[++rear] = j;
        nItems++;
    }

    public long removeLeft() {
        if(isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        long temp = dequeArray[front++];
        if (front == maxSize) { 
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long removeRight() {
        if(isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        long temp = dequeArray[rear--];
        if (rear == -1) { 
            rear = maxSize - 1;
        }
        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }
    
    public static void main(String[] args) {
        C4_Dequeue deque = new C4_Dequeue(5); 

        deque.insertRight(10);
        deque.insertRight(20);
        deque.insertLeft(30);
        deque.insertLeft(40);

        deque.insertRight(50); 
        deque.insertRight(60); 

        System.out.println("Removed from right: " + deque.removeRight()); 
        System.out.println("Removed from left: " + deque.removeLeft());

        deque.insertLeft(70);
        deque.insertRight(80);

        while (!deque.isEmpty()) {
            long num = deque.removeLeft();
            System.out.print(num + " ");
        }
        
        System.out.println();
        System.out.println("Removed from empty deque: " + deque.removeRight()); // Should show deque is empty
    }
}
