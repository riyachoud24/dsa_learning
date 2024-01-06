package dsa_learning;

public class C4_Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public C4_Queue(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long j) {
		if(rear == maxSize-1) 
			rear = -1;
			queArray[++rear] = j; 
			nItems++; 
	}
	
	public long remove() {
		long temp = queArray[front++]; 
		if(front == maxSize) 
		front = 0;
		nItems--; 
		return temp;
	}
	
	public long peekFront() {
		return queArray[front];
	}
	
	public boolean isEmpty() {
		return (nItems==0);
	}
	
	public boolean isFull() {
		return (nItems==maxSize);
	}
	
	public int size() {
		return nItems;
	}
	
	//Question 1
	public void displayQueue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue contents: ");
        int index = front;
        for (int i = 0; i < nItems; i++) {
            System.out.print(queArray[index] + " ");
            index++;
            if (index == maxSize) {
                index = 0;
            }
        }
        System.out.println();
    }
}
//////////////////////////////////////////////////////////////////////////
class C4_QueueApp {
	public static void main(String[] args) {
		C4_Queue theQueue = new C4_Queue(5);
		
		theQueue.insert(10);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		
		theQueue.remove();
		theQueue.remove();
		theQueue.remove();
		
		theQueue.insert(50);
		theQueue.insert(60);
		theQueue.insert(70);
		theQueue.insert(80);
		
		// Question 1
		theQueue.displayQueue();
		
		while (!theQueue.isEmpty()) {
			long n = theQueue.remove();
			System.out.print(n);
			System.out.print(" ");
		}
		
		System.out.print(" ");
	}
}