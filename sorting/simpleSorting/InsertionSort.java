package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	private int posicao;
	private boolean alocado;

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i <= rightIndex; i++) { // 2 4
			posicao = i;
			alocado = false;
			while (!alocado && posicao > leftIndex) {
				if (array[posicao].compareTo(array[posicao - 1]) < 0) {
					Util.swap(array, posicao, posicao - 1);
					posicao--;
				} else {
					alocado = true;
				}
			}
		}
	}
}
