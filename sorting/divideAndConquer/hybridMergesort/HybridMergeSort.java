package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	private int getLimit() {
		return this.SIZE_LIMIT;
	}

	public void sort(T[] array, int leftIndex, int rightIndex) {
//		if(array.length > getLimit() || ) {
//
//		} else {
//
//		}
	}

//	@Override
//	public void sort(T[] array, int leftIndex, int rightIndex) {
//		int mid;
//		if((rightIndex - leftIndex >= 1) && (leftIndex >= 0) && (rightIndex < array.length)) {
//			mid = (rightIndex + leftIndex)/2;
//
//			sort(array, leftIndex, mid);
//			sort(array, mid + 1, rightIndex);
//
//			merge(array, leftIndex, mid, rightIndex);
//
//		}
//	}

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
