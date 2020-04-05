package sort;

public class MergeSort
{
	private static final int CUT_OFF = 10;
	
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		sort(a, aux, 0, N-1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if (hi <= lo + CUT_OFF - 1)
		{
			InsertionSort.sort(a, lo, hi);
			return;
		}
		int mid = (lo + hi)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		if (!less(a[mid+1], a[mid])) return;
		merge(a, aux, lo, mid, hi);
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
