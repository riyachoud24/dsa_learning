package dsa_learning;
//////////////////////////////////////////////////////////////
//////////////////CLASS C2_HighArray//////////////////////////
/////////////////////////////////////////////////////////////
class C2_HighArray {
	private long[] a;
	private int nElems;
	
	public C2_HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public boolean find(long searchKey) {
		int j;
		for(j=0; j<nElems; j++)
			if (a[j]== searchKey)
				break;
		if (j== nElems)
			return false;
		else 
			return true;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public boolean delete(long value) {
		int j;
		for (j=0;j<nElems;j++)
			if (value == a[j])
				break;
		if (j==nElems)
			return false;
		else {
			for (int k=j; k<nElems; k++)
				a[k] = a[k+1];
			nElems--;
			return true;
		}
	}
	
	public void display() {
		for (int j=0; j<nElems; j++)
			System.out.print(a[j]+" ");
		System.out.println(" ");
	}
	/* //Question 1
	public long getMax() { 
		if (nElems == 0) {
            return -1;
        }

        long max = a[0];
        for (int i = 1; i < nElems; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
    */
	
	
	//Question 2, Question 3
	public long removeMax() {
        if (nElems == 0) {
            return -1;
        }

        int maxIndex = 0;
        long max = a[0];

        // Find the maximum value and its index
        for (int i = 1; i < nElems; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }

        // Shift elements to the left, remove the max element
        for (int i = maxIndex; i < nElems - 1; i++) {
            a[i] = a[i + 1];
        }
        nElems--; // Decrease the number of elements

        return max; // Return the maximum value
    }
	
}
//////////////////////////////////////////////////////////////
//////////////////CLASS C2_HighArrayApp//////////////////////
/////////////////////////////////////////////////////////////
class C2_HighArrayApp{
	public static void main(String[] args) {
		int maxSize = 100;
		C2_HighArray arr;
	    arr = new C2_HighArray(maxSize);
		
		
        C2_HighArray sortedArr = new C2_HighArray(maxSize);
        

		
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
		
		int searchKey = 35;
		if (arr.find(searchKey))
			System.out.println("Found " + searchKey);
		
		arr.delete(00);
		arr.delete(55);
		arr.delete(99);
		
		arr.display();
		//Question 1
		//System.out.println("The highest key is: " + arr.getMax()); 
		
		//Question 2
		//System.out.println("Removed highest key: " + arr.removeMax());
		
		//Question 3
		
		//Sorting process
        while (true) {
            long max = arr.removeMax();
            if (max == -1) {
                break; // Break when all elements are removed
            }
            sortedArr.insert(max);
        }
		
		System.out.println("Sorted array (inversely sorted): " );
        sortedArr.display();
	}
}

