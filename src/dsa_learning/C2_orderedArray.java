package dsa_learning;

public class C2_orderedArray {
	private long[] a;
	private int nElems;

	public C2_orderedArray(int max) {
		a = new long[max];
		nElems=0;
	}
	
	public int size() {
		return nElems;
	}
	
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems-1;
		int curIn;
		
		while(true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn]==searchKey)
				return curIn;
			else if (lowerBound>upperBound)
				return nElems;
			else {
				if(a[curIn] < searchKey)
					lowerBound = curIn + 1;
				else
					upperBound = curIn - 1;
			}
		}
	}
	
	public void insert(long value) {
		int j;
		for(j=0; j<nElems; j++)
			if (a[j] > value)
				break;
		for(int k=nElems; k>j; k--)
			a[k] = a[k-1];
		a[j] = value;
		nElems++;
	}
	
	public boolean delete(long value) {
		int j = find(value);
		if(j==nElems) 
			return false;
		else {
			for(int k=j; k<nElems; k++) 
				a[k] = a[k+1];
				nElems--; 
				return true;
		}
	} 
	
	public void display() {
		for (int j =0; j<nElems; j++)
			System.out.println(a[j]+ " ");
		System.out.println(" ");
	}
	
	/*
	
	//Question 4
	public static C2_orderedArray merge(C2_orderedArray arr1, C2_orderedArray arr2) {
        int maxSize = arr1.size() + arr2.size();
        C2_orderedArray result = new C2_orderedArray(maxSize);

        int i = 0, j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.a[i] < arr2.a[j]) {
                result.insert(arr1.a[i++]);
            } else {
                result.insert(arr2.a[j++]);
            }
        }

        while (i < arr1.size()) {
            result.insert(arr1.a[i++]);
        }
       
        while (j < arr2.size()) {
            result.insert(arr2.a[j++]);
        }

        return result;   
    }
    
    */
}

///////////////////////////////////////////////////

class OrderedApp{
	public static void main(String[] args) {
		int maxSize = 100;
		C2_orderedArray arr;
		arr = new C2_orderedArray(maxSize);
		
		//Question 4
		//C2_orderedArray arr1 = new C2_orderedArray(maxSize);
       // C2_orderedArray arr2 = new C2_orderedArray(maxSize);
		
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
		
		int searchKey = 55; 
		
		if( arr.find(searchKey) != arr.size() )
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can’t find " + searchKey);
		
		
		arr.display();
		
		arr.delete(00); 
		arr.delete(55);
		arr.delete(99);
		arr.display(); 		
		
		/*
		//Question 4
        C2_orderedArray mergedArr = C2_orderedArray.merge(arr1, arr2);
        System.out.println("Merged Array:");
        mergedArr.display();
        */
	}
}
