//Tre Gonzales fgonzales19@cmc.edu
public class HeapSort2 {
	private static int n;
	
	public static void heapSort2(int [] a) {
		buildHeap(a);
		for(int i=n;i>0;i--) {
			int temp = a[i];
			a[i]=a[0];
			a[0]=temp;
			n=n-1;
			maxValue(a, 0);
			
		}
	}
	
	public static void buildHeap(int[] a) {
		n=a.length-1;
		for(int i=n/2;i>=0;i--) {
			maxValue(a, i);
		}
	}
	
	public static void maxValue(int [] a, int i) {
		int left=2*i+1;
		int right=2*i+2;
		int max=i;
		if(left <= n && a[left] > a[max]) {
			max=left;
		}
		if(right <= n && a[right] > a[max]) {
			max=right;
		}
		if(max!=i) {
			int temp=a[i];
			a[i]=a[max];
			a[max]=temp;
			maxValue(a, max);
		}
	}
	
	 public static void main(String [] args) {
		 int [] a = new int[]{4,3,19,5,12,32,7,11,3,3,3,45,54,92,11};
		 heapSort2(a);
		 for(int i=0;i<a.length;i++) {
			 System.out.println(a[i]);
		 }
		 System.out.println("");
		 int [] b = new int[]{5,4,2,8,11,1};
		 heapSort2(b);
		 for(int i=0;i<b.length;i++) {
			 System.out.println(b[i]);
		 }
	 }
	
}
