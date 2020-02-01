package chapter8;

public class CountingSort {
	
	//A is the array waiting to be sorted
	//B is the resulted sorted array
	//k is the largest number in A
	public static void countingSort(int[] A, int[] B, int k)
	{
		int[] C = new int[k + 1];
		
		for(int i = 0; i < A.length; i++)
			C[A[i]]++;

		for(int i = 1; i <= k; i++)
			C[i] += C[i - 1];

		for(int i = A.length - 1; i >= 0; i--)
		{
			B[C[A[i]] - 1] = A[i];
			C[A[i]]--;
		}
	}
	
	public static int findMax(int[] a)
	{
		int l = a.length;
		int temp = Integer.MIN_VALUE;
		for(int i = 0; i < l; i++)
		{
			if(temp < a[i])
				temp = a[i];
		}
		return temp;
	}
	
	
	public static void main(String[] args)
	{
		int[] a = new int[] {0,9,3,2,5,7,9,8,4,5,7};
		int[] result = new int[a.length];
		int max = findMax(a);
		System.out.println("max value = " + max);
		countingSort(a, result, max);
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i] + ",");
	}
}
