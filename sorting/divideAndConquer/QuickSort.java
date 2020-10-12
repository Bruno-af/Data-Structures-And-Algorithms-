package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

import java.util.Random;


/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if(leftIndex < rightIndex) {

			for(int i = leftIndex; i <= rightIndex; i++)System.out.print(array[i] + " ");
			System.out.print("\n");

			int pivotIndex = partition(array, leftIndex, rightIndex);

			System.out.print(array[pivotIndex] + "\n");

			sort(array, leftIndex, pivotIndex - 1 );
			sort(array, pivotIndex + 1, rightIndex);

		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int flag = leftIndex;
		int pivotIndex = (int)(Math.random() * ((rightIndex - leftIndex) + 1)) + leftIndex;
		Util.swap(array, leftIndex, pivotIndex);

		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			if(!(array[leftIndex].compareTo(array[i]) < 0)) {
				flag++;
				Util.swap(array, flag, i);
			}
		}

		Util.swap(array, leftIndex, flag);

		return flag;
	}
}
