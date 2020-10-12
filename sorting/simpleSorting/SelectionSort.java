package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int pont = leftIndex, min;

		if(rightIndex > 1) {
			do {
				min = pont;
				for (int i = pont + 1; i <= rightIndex; i++) {

					if (array[min].compareTo(array[i]) > 0) {
						min = i;
					}
				}
				Util.swap(array, min, pont);
				pont++;
			} while (pont <= rightIndex);
		}
	}
}
