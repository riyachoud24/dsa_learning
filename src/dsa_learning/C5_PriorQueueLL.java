package dsa_learning;
//QUESTION 1 
class Node {
    public int key;
    public Node next;

    public Node(int key) {
        this.key = key;
        this.next = null;
    }
}
/////////////////////////////////////////////////////////////////////////////
class C5_PriorQueueLL {
    private Node first;

    public C5_PriorQueueLL() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        Node previous = null;
        Node current = first;

        while (current != null && key > current.key) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = newNode;
        } else {
            previous.next = newNode;
        }
        newNode.next = current;
    }

    public Node remove() {
        if (isEmpty()) {
            return null;
        }
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayQueue() {
        Node current = first;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }
}
////////////////////////////////////////////////////////////
class C5_PriorityQueueApp {
    public static void main(String[] args) {
    	C5_PriorQueueLL pq = new C5_PriorQueueLL();
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(40);
        pq.insert(20);

        System.out.print("Priority Queue contents (from smallest to largest): ");
        pq.displayQueue();

        while (!pq.isEmpty()) {
            Node removedNode = pq.remove();
            System.out.print("Removed " + removedNode.key + ", new queue: ");
            pq.displayQueue();
        }
    }
}


