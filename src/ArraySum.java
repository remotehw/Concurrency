import java.util.Random;

public class ArraySum {

	public static void main(String[] args)
	{
		Random rand = new Random();
		
		// Create an array of 200M random integers between 1 and 10
		int[] arr = new int[200000000];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(10) + 1;
		}
		
		// Compute the sum with a single thread
		Summing sum = new Summing(arr, 0, arr.length);
		long start = System.currentTimeMillis();
		System.out.println("Sum from single thread: " + sum.simpleSum(arr));
		System.out.println("Single thread time: " + (System.currentTimeMillis() - start) + " milliseconds.");
		
		// Compute the sum with 2 threads
		Summing splitSum = new Summing(arr, 0, arr.length);
		start = System.currentTimeMillis();
		System.out.println("Sum from two threads: " + splitSum.threadedSum(arr));
		System.out.println("Multithread time: " + (System.currentTimeMillis() - start) + " milliseconds.");
	}

}
