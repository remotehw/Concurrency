import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SummingTest
{


	@Test
	void testSimpleSum()
	{
		int[] arr = {1, 2, 3, 4, 5};
		Summing sumTest = new Summing(arr, 0, arr.length);
		
		assertEquals(15, sumTest.simpleSum(arr));
	}

	@Test
	void testPartialSum()
	{
		int[] arr = {1, 2, 3, 4, 5, 7};
		Summing partialSumTest = new Summing (arr, 0, arr.length);
		
		assertEquals(6, partialSumTest.partialSum(arr, 0, arr.length / 2));
	}

}
