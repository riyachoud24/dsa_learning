package dsa_learning;
//Question 4
class C4_PriorQueue {
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public C4_PriorQueue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        if (isFull()) {
            System.out.println("Priority Queue is full");
            return;
        }
        queArray[nItems++] = item; 
    }

    public long remove() { 
        if (isEmpty()) {
            System.out.println("Priority Queue is empty");
            return -1;
        }

        int maxIndex = 0;
        for (int i = 1; i < nItems; i++) {
            if (queArray[i] > queArray[maxIndex]) {
                maxIndex = i;
            }
        }

        long maxItem = queArray[maxIndex];
        for (int i = maxIndex; i < nItems - 1; i++) {
            queArray[i] = queArray[i + 1];
        }
        nItems--;
        return maxItem;
    }

    public long peekMin() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty");
            return -1;
        }

        int maxIndex = 0;
        for (int i = 1; i < nItems; i++) {
            if (queArray[i] > queArray[maxIndex]) {
                maxIndex = i;
            }
        }
        return queArray[maxIndex];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void displayQueue() {
        for (int i = 0; i < nItems; i++) {
            System.out.print(queArray[i] + " ");
        }
        System.out.println();
    }
}
//////////////////////////////////////////////
class C4_PriorityQApp {
    public static void main(String[] args) {
        C4_PriorQueue thePQ = new C4_PriorQueue(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        System.out.print("Priority Queue contents: ");
        thePQ.displayQueue();

        System.out.print("Removing elements: ");
        while (!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.print(item + " "); 
        }
        System.out.println();
    }
}

