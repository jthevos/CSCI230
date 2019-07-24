package hw4;
import java.lang.Math;
import java.util.Random;
public class QuickSort {
	
	public static int[] populate(int[] numbers) {
		for (int i = 0; i < 10000; i++) {
			numbers[i] = (int) (Math.random() * (10001));
		}
		return numbers;
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
				
		public static void testPerformance(int[] n, String type) {
			// pivot: midpoint
			long timePre;
			long timePost;
			
			switch(type) {
				case "RANDOM":
					timePre = System.currentTimeMillis();
					Quicksort(n, getRandomIndex(0, 10000), n.length - 1);
					timePost = System.currentTimeMillis();
					System.out.println("TEST TYPE = RANDOM ");
					System.out.println("Runtime = " + Long.toString(timePost- timePre));
					break;
				case "FIRST":
					timePre = System.currentTimeMillis();
					Quicksort(n, n[0], n[n.length-1] );
					timePost = System.currentTimeMillis();
					System.out.println("TEST TYPE = FIRST ");
					System.out.println("Runtime = " + Long.toString(timePost- timePre));
					break;
				case "MID":
					timePre = System.currentTimeMillis();
					Quicksort(n, n[n.length/2], n[n.length -1] );
					timePost = System.currentTimeMillis();
					System.out.println("TEST TYPE = MID ");
					System.out.println("Runtime = " + Long.toString(timePost- timePre));
					break;
				case "LAST":
					timePre = System.currentTimeMillis();
					Quicksort(n, n[n.length-1], n[0] );
					timePost = System.currentTimeMillis();
					System.out.println("TEST TYPE = LAST ");
					System.out.println("Runtime = " + Long.toString(timePost- timePre));
					break;
			}
		
		}
		
		public static int getRandomIndex(int low, int high) {
			Random r = new Random();
			return r.nextInt(high-low) + low;
		}

		public static void main(String[] args) {
			
			int[] n1 = populate(new int[10000]);
			int[] n2 = duplicate(n1);
			int[] n3 = duplicate(n1);
			int[] n4 = duplicate(n1);
			
			//testPerformance(n1, "RANDOM");
			//testPerformance(n2, "FIRST");
			// FIX testPerformance(n3, "MID");
			testPerformance(n4, "LAST");
		   
		}
		 
//		UNSORTED: 10 2 78 4 45 32 7 11 
//		SORTED: 2 4 7 10 11 32 45 78
}
