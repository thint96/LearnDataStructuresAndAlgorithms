package sort;

public class MergeSortBottomUp 
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		for (int size = 1; size < N; size = 2*size)
		{
			for (int lo = 0; lo < N - size; lo += 2*size)
				merge(a, aux, lo, lo + size - 1, Math.min(lo + 2*size - 1, N-1));
		}
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		// copy
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		// merge
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
}
