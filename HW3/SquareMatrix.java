//Tre Gonzales fgonzales19cmc.edu
/* 
 The algorithm, findRow, is of order O(n) because there is no path in which the method will traverse
 through every element in the array.  The method uses a counter(max1) that finds the maximum number of 1's
 in the first array.  Then as the first for loop continues to the next row, the second for loop uses max1 
 to count 1's in the next row that are past the maximum number of 1's.  If that row does not contain more 1's, 
 then the second for loop is broken.  If the row does have more 1's, the number of 1's in that row are added to
 the maximum number of 1's and the row index is updated to the new row with the most 1's. This way, we are
 not checking values of the array that are redundant.  For example, if a row had 3 1's as the max
 while a following row had a single 1, the method would check if there is a 1 at the 3rd index of that following
 row and simply escape from the second for loop when the value of the row at the 3rd index is 0.
 */

public class SquareMatrix {
	
	
	// Pre: A is a square matrix, i.e., two dimensional square array.
	// Post: the row index for the row having the most number of 1’s has
	// been returned.
	

	public static int findRow (int[][] A)
	{
		int finalRow=-1;
		int max1=0;
		int row1;
		for(int i=0;i<A.length;i++)
		{
			row1=max1; 
			for(int j=max1;j<A.length;j++)
			{
				if(A[i][j]==1)
					row1++;
				else if(A[i][j]==0)
				{
				break;
				}
				if(row1==A.length)
					return i;
			}
			if(row1>max1)
			{
				max1=row1;
				finalRow=i;
			}
			
				
		}
		return finalRow;
		
	}


	
	public static void main(String[] args)
	{
		int[][] A = {{1,0,0,0,0},
		{1,1,1,0,0},
		{1,1,0,0,0},
		{1,1,1,1,0},
		{0,0,0,0,0}};
		System.out.println("The row found is " + findRow(A));
		
		int[][] B = {{1,1,0,0,0},
				{1,1,0,0,0},
				{1,1,0,0,0},
				{1,0,0,0,0},
				{1,1,1,1,1}};
		System.out.println("The row found is " + findRow(B));
		
		int[][] C = {{1,1,0,0,0},
				{0,0,0,0,0},
				{1,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}};
		System.out.println("The row found is " + findRow(C));
		
	}
}