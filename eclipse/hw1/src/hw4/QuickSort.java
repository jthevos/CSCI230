package hw4;
import java.lang.Math;
public class QuickSort {
	
	public static void populate(int[] numbers) {
		for (int i = 0; i < 10000; i++) {
			numbers[i] = (int) (Math.random() * (10001));
		}
	}
	
	public static int[] duplicate(int[] numbers) {
		int[] newArray = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			newArray[i] = numbers[i];
		}
		
		return newArray;
	}
	
	public static int partition(int[] numbers, int i, int k) {
		   int l = 0;
		   int h = 0;
		   int midpoint = 0;
		   int pivot = 0;
		   int temp = 0;
		   boolean done = false;
		   
		   System.out.println("\nEntering partition with");
		   for(int start = i; start <= k; ++start) {
			      System.out.print(numbers[start] + " ");
		   }
		   System.out.println();
		   System.out.println("left index: " + i);
		   System.out.println("right index: " + k);		   
		   // Pick middle element as pivot
		   midpoint = i + (k - i) / 2;
		   pivot = numbers[midpoint];
		   System.out.println("pivot: " + pivot);	
		   
		   l = i;
		   h = k;
		   
		   while (!done) {
		      
		      // Increment l while numbers[l] < pivot
		      while (numbers[l] < pivot) {
		         ++l;
		      }
		      
		      // Decrement h while pivot < numbers[h]
		      while (pivot < numbers[h]) {
		         --h;
		      }
		      
		      // If there are zero or one elements remaining,
		      // all numbers are partitioned. Return h
		      if (l >= h) {
		         done = true;
		      }
		      else {
		         // Swap numbers[l] and numbers[h],
		         // update l and h
		         temp = numbers[l];
		         numbers[l] = numbers[h];
		         numbers[h] = temp;		         
		         ++l;
		         --h;
		      }
		   }	
		   System.out.println("\nLeaving partition with");
		   for(int start = i; start <= k; ++start) {
			      System.out.print(numbers[start] + " ");
		   }
		   System.out.println();
		   System.out.println("Return index " + h + " as last of lower portion.");
		   return h;
		}

		public static void Quicksort(int[] numbers, int i, int k) {
		   int j = 0;
		   
		   // Base case: If there are 1 or zero elements to sort,
		   // partition is already sorted
		   if (i >= k) {
		      return;
		   }
		   
		   // Partition the data within the array. Value j returned
		   // from partitioning is location of last element in low partition.
		   j = partition(numbers, i, k);
		   
		   // Recursively sort low partition (i to j) and
		   // high partition (j + 1 to k)
		   Quicksort(numbers, i, j);
		   Quicksort(numbers, j + 1, k);
		}

		public static void main(String[] args) {
		   //int [] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };
		   //final int NUMBERS_SIZE = 8;
		   //int i = 0;
			
			int[] numbers = new int[10000];
			populate(numbers);
			System.out.print(numbers.length);
		   
		   System.out.print("UNSORTED: ");
//		   for(i = 0; i < NUMBERS_SIZE; ++i) {
//		      System.out.print(numbers[i] + " ");
//		   }
		   System.out.println();
		   
		   // Initial call to quicksort
		  // Quicksort(numbers, 0, NUMBERS_SIZE - 1);
		   
		   System.out.print("SORTED: ");
//		   for(i = 0; i < NUMBERS_SIZE; ++i) {
//		      System.out.print(numbers[i] + " ");
//		   }
		   System.out.println();
		}
		 
//		UNSORTED: 10 2 78 4 45 32 7 11 
//		SORTED: 2 4 7 10 11 32 45 78
}
