package dsa_learning;

//Question 2
class Node {
    public int data;
    public Node next;
    public Node previous;

    public Node(int data) {
        this.data = data;
    }
}

//////////////////////////////////////////////////////
class C5_NewDeque {

	private Node first;
    private Node last;

    public C5_NewDeque() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
    }

    public Node removeFirst() {
        Node temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public Node removeLast() {
        Node temp = last;
        if (last.previous == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public void displayForward() {
        System.out.print("Deque (First --> Last): ");
        Node current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("Deque (Last --> First): ");
        Node current = last;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }
        System.out.println();
    }
}

////////////////////////////////////////////////////
class C5_DequeApp {
    public static void main(String[] args) {
        C5_NewDeque deque = new C5_NewDeque();
        deque.insertFirst(20);
        deque.insertFirst(10);
        deque.insertLast(30);
        deque.insertLast(40);

        deque.displayForward(); 
        deque.displayBackward(); 

        deque.removeFirst(); 
        deque.removeLast(); 

        deque.displayForward(); 
    }
}
