//import java.util.*;
public class Selection {

 static int minIndex;
 
 //Precondition: start is a valid index into a.
 private static void sSortRex(int [] a, int start)
 {
  if(start<a.length) {
  
  //Find the index of smallest element in a[start...a.length-1]
  int minIndex=IndexOfSmallest(int[ ] a, start);
  
  //Move smallest element to start position
  swap(int[] a, minIndex, start);
  
  //Recurse on everything to the left of start
  sSortRec(int [] a, start);
  
  }
 }
 
 //Returns the index of the smallest element in a between the index start
 // and the end of the array inclusive.
 //Precondition: start is a valid index in a.
 private static int indexOfSmallest(int [] a, int start) {
  for(int i=start;i<a.length-1;i++)
   if(a[i]<a[minIndex])
    minIndex=i;
  start++;
  return minIndex;
 }
 
 //Precondition: i and j are valid indices in a.
 private stativ void swap(int[] a, int i, int j) {
  int temp=a[i];
  a[i]=a[j];
  a[j]=temp;
  
 }

 public static void main(String [] args) {
        int[] a = {1, 4, 5, 2, 3, 7, 10, 9, 21, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int[] a) {
        sSortRec(a, 0);   
    }

 
}
