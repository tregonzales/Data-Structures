//Tre Gonzales fgonzales19@cmc.edu
public class Partition {
	
	public static void partition(int p, int [] M)
	{
		int numP=0; int numHigh=0; int numhloop=0; int numploop=0; int numL=0;
		
		for(int i=0;i<M.length;i++) //counts the number of numbers that are greater than, less than, or equal to p
		{
			if(M[i]>p)
				numhloop++;
			if(M[i]==p)
				numploop++;
			if(M[i]<p)
				numL++;
		}
		
		for(int i=0;i<M.length;i++) //organizes the numbers high than p to the right side of the array
		{
		if(M[i]>p)
		{
			numHigh++;
			int temp=M[i];
			M[i]=M[M.length-numHigh];
			M[M.length-numHigh]=temp;
		}
		if(numHigh==numhloop)
			break;
		}
		
		for(int i=0;i<M.length;i++) //places values of p in the array in correct placement
		{
			if(i==numL+numP-1&&numP>0) //skips M[i] if that value has already been placed
			{
				
			}
		else if(M[i]==p)
			{
				numP++;
				int temp=M[i];
				M[i]=M[numL+numP-1];
				M[numL+numP-1]=temp;
			}
			if(numP==numploop)
				break;
		}
		
	
		
	
		
	
	

	
		
	}

	public static void main(String[] args) {
		int[] first=new int[]{5, 6, 3, 5, 8, 7, 6, 5, 9, 2};
		Partition.partition(5, first);
		for(int i=0;i<first.length;i++)
			System.out.print(first[i]);
		System.out.println("");
		
		int [] o=new int[]{7, 6, 8, 9, 2, 3, 1, 5, 5, 5};
	Partition.partition(5, o);
	for(int i=0;i<o.length;i++)
		System.out.print(o[i]);
	System.out.println("");
	
	int [] a=new int[]{2, 3, 1, 7, 9, 8};
	for(int i=0;i<a.length;i++)
		System.out.print(a[i]);

	}

}
