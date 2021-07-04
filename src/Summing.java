
public class Summing extends Thread
{
	private int[] arr;
	private int low, high;
	
	public Summing(int[] arr, int low, int high)
	{
		this.arr = arr;
		this.low = low;
		this.high = high;
	}
	
	/**
	 * This method iterates over an array and adds together the values at each index
	 * @param arr the array to iterate over
	 * @return the total sum of all indices
	 */
	
	public int simpleSum(int[] arr)
	{
		int total = 0;
		for (int i = 0; i < arr.length; i++)
		{
			total += arr[i];
		}
		
		return total;
	}
	
	/**
	 * This method iterates over part of an array between a low and high index and adds 
	 * together the values at each index.
	 * @param arr the array to iterate over
	 * @param low the starting index
	 * @param high the ending index
	 * @return the sum of indices between the low and high indices
	 */
	
	public int partialSum(int [] arr, int low, int high)
	{
		int subTotal = 0;
		for (int i = low; i < high; i++)
		{
			subTotal += arr[i];
		}
		return subTotal;
	}
	
	/**
	 * This method splits an array in half into 2 Summing objects.
	 * The sum of each half is calculated by calling partialSum on
	 * different threads, and the total sum is calculated by adding
	 * the results of the threads together
	 * @param arr the array to split
	 * @return the total sum
	 */
	
	public int threadedSum(int[] arr)
	{
		Summing firstHalf = new Summing(arr, 0, arr.length / 2);
		Summing secondHalf = new Summing(arr, (arr.length / 2) + 1, arr.length);
		
		Thread firstThread = new Thread(firstHalf);
		Thread secondThread = new Thread(secondHalf);
		
		firstThread.start();
		secondThread.start();
		
		try
		{
			firstThread.join();
			secondThread.join();
		}
		catch (InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		
		int first = firstHalf.partialSum(arr, firstHalf.low, firstHalf.high);
		int second = secondHalf.partialSum(arr, secondHalf.low, secondHalf.high);
		
		return first + second;
	}
}
