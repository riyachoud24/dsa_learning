package dsa_learning;

class C5_CircStack {
	 private C5_CircularList circularList;

	    public C5_CircStack() {
	        circularList = new C5_CircularList();
	    }

	    public void push(int data) {
	        circularList.insert(data);
	        circularList.step();
	    }

	    public int pop() {
	        if (circularList.isEmpty()) {
	            throw new IllegalStateException("Stack is empty");
	        }
	        int data = circularList.getCurrentData(); 
	        circularList.delete(); 
	        return data;
	    }

	    public boolean isEmpty() {
	        return circularList.isEmpty();
	    }

	    public void displayStack() {
	        System.out.print("Stack (top --> bottom): ");
	        circularList.displayList();
	    }
	}

/////////////////////////////////////////////////////
class C5_StackApp {
    public static void main(String[] args) {
        C5_CircStack stack = new C5_CircStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.displayStack(); 

        System.out.println("Popped: " + stack.pop()); 
        stack.displayStack(); 

        stack.push(40);
        stack.displayStack(); 
    }
}

