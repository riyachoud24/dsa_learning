package dsa_learning;


////////////////////////class c3_bubbleSort//////////////////////////////
class C3_BubbleSort {
	private long[] a;
	private int nElems;
	
	public C3_BubbleSort(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems]=value;
		nElems++;
	}
	
	public void display() {
		for(int j=0; j<nElems; j++) 
			System.out.println(a[j] + " "); 
		System.out.println("");
	}
	
	public void bubbleSort() {
		
		/*
		//Question 1
		int leftOut = 0; 
	    int rightOut = nElems - 1;
	    boolean swapped;

	    while (leftOut < rightOut) {
	        swapped = false;

	        for (int in = leftOut; in < rightOut; in++) {
	            if (a[in] > a[in + 1]) {
	                swap(in, in + 1);
	                swapped = true;
	            }
	        }
	        rightOut--;

	        if (!swapped) {
	            break;
	        }

	        swapped = false;
	       
	        for (int in = rightOut; in > leftOut; in--) {
	            if (a[in] < a[in - 1]) {
	                swap(in, in - 1);
	                swapped = true;
	            }
	        }
	        
	        leftOut++;
	    }
	}
		
	*/	
		
		int out, in;
		
		for(out=nElems-1; out>1; out--) 
			for(in=0; in<out; in++) 
				if( a[in] > a[in+1] ) 
					swap(in, in+1);
	}
	
	
	
	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	
}

////////////////////////class c3_bubbleSortApp////////////////////////////

class C3_BubbleSortApp{
	public static void main(String[] args) {
		int maxSize = 100;
		C3_BubbleSort arr;
		arr = new C3_BubbleSort(maxSize);
		
		arr.insert(77); 
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();
		
		arr.bubbleSort();
		arr.display();
		
	}
}
