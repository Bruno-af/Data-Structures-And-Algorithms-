package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int mid;
		if((rightIndex - leftIndex >= 1) && (leftIndex >= 0) && (rightIndex < array.length)) {
			mid = (rightIndex + leftIndex)/2;

			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);

			merge(array, leftIndex, mid, rightIndex);

		}
	}

	private void merge(T[] array, int leftIndex, int mid, int rightIndex) {
	    int flagL = leftIndex;
	    int flagR = mid + 1;
	    int count = leftIndex;

	    T[] aux =(T[]) new Comparable[array.length];

	    for(int i = leftIndex; i <= rightIndex; i++) aux[i] = array[i];

		while( (flagL <= mid) && (flagR <= rightIndex) ) {

		    if( aux[flagL].compareTo(aux[flagR]) < 0 ) {
		        array[count] = aux[flagL];
		        flagL ++;
            } else {
                array[count] = aux[flagR];
                flagR ++;
            }
            count ++;
        }


		while (flagL <= mid) {
		    array[count] = aux[flagL];
		    flagL++;
		    count++;
        }

		while (flagR <= rightIndex) {
            array[count] = aux[flagR];
            flagR++;
            count++;
        }
	}
}
