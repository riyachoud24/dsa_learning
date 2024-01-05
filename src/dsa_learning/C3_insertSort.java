package dsa_learning;
/////////////////////////class C3_InsertSort///////////////////////////////////////////
class C3_insertSort {
	
	private long[] a;
	private int nElems;
	
	public C3_insertSort(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for (int j=0; j<nElems; j++)
			System.out.print(a[j]+ " ");
		System.out.print(" ");
	}
	
	public void insertionSort() {
		
		
		int in, out;
		
		for(out = 1; out<nElems; out++) {
			long temp = a[out];
			in = out;
			while (in>0 && a[in-1]>=temp) {
				a[in] = a[in - 1];
				--in;
			}
			a[in] = temp;
			
			/*
			//Question 6
			while (in > 0 && a[in - 1] >= temp) {
	            if (a[in - 1] == temp) {
	                temp = -1;
	                break;
	            }
	            a[in] = a[in - 1];
	            --in;
	        }
	        a[in] = temp;
	    }
		
		int shiftIndex = 0;
	    for (int j = 0; j < nElems; j++) {
	        if (a[j] != -1) {
	            a[shiftIndex++] = a[j];
	        }
	    }
	    nElems = shiftIndex;
	    
	    */
	}
		
		
		
		/*
		//Question 5
		
		int in, out;
	    int copies = 0; 
	    int comparisons = 0; 

	    for(out = 1; out < nElems; out++) {
	        long temp = a[out];
	        in = out;
	        copies++; 

	        while (in > 0) {
	            comparisons++; 
	            if (a[in - 1] >= temp) {
	                a[in] = a[in - 1];
	                copies++;
	                --in;
	            } else {
	                break;
	            }
	        }
	        a[in] = temp;
	        copies++; 
	    }

	    System.out.println("Number of copies: " + copies);
	    System.out.println("Number of comparisons: " + comparisons);
	}
	
	*/
	
	/*
	
	//Question2 
	public double median() {
		int middle = nElems/2;
		if(nElems%2==0) {
			return (a[middle-1]+ a[middle]) / 2.0;
		} else {
			return a[middle];
		}
	}
	*/
	
	/*
	//Question 3
	public void noDups() {
	    if (nElems == 0) return; 

	    int uniqueIndex = 0; 

	    for (int checkIndex = 1; checkIndex < nElems; checkIndex++) {
	        if (a[checkIndex] != a[uniqueIndex]) {
	            uniqueIndex++;
	            a[uniqueIndex] = a[checkIndex];
	        }
	    }

	    nElems = uniqueIndex + 1;
	}
	 */

	}
}

/////////////////////////class C3_InsertSortApp//////////////////////////////////////
class InsertSortApp {
	public static void main(String[] args) {
		int maxSize = 100; 
		C3_insertSort arr; 
		arr = new C3_insertSort(maxSize); 
		
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
		
		arr.insertionSort(); 
		
		//Question 3
		//arr.noDups();
		
		arr.display();
		
		//Question2
		//System.out.println("Median: " + arr.median());
	}
}