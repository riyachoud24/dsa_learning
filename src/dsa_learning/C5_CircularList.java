package dsa_learning;

//Question 3
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

////////////////////////////////////////////////////////
class C5_CircularList {

	private Node current;
    private int size;

    public C5_CircularList() {
        current = null;
        size = 0;
    }

    public boolean isEmpty() {
        return current == null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            current = newNode;
            newNode.next = current;
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void step() {
        if (!isEmpty()) {
            current = current.next;
        }
    }

    public boolean search(int data) {
        if (isEmpty()) {
            return false;
        }
        Node startNode = current;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != startNode);
        return false;
    }

    public boolean delete() {
        if (isEmpty() || size == 1) {
            current = null;
            size = 0;
            return true;
        }
        Node nodeToDelete = current.next;
        current.next = nodeToDelete.next;
        size--;
        return true;
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node startNode = current;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != startNode);
        System.out.println();
    }
    
    //ONLY FOR QUESTION 4
    public int getCurrentData() {
        if (current == null) {
            throw new IllegalStateException("List is empty");
        }
        return current.data;
    }
    
    //ONLY FOR QUESTION 5
    public int eliminateCurrent() {
        if (current == null) {
            throw new IllegalStateException("List is empty");
        }
        int data = current.data;
        delete(); 
        return data;
    }

    public int getSize() {
        return size;
    }
}

///////////////////////////////////////////////////

class C5_CircularListApp {
    public static void main(String[] args) {
        C5_CircularList list = new C5_CircularList();
        
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.step(); 

        list.displayList(); 

        if (list.search(30)) {
            System.out.println("Found 30");
            list.delete(); 
        }

        list.displayList(); 

        list.step();
        list.insert(40);
        list.displayList(); 
    }
}

