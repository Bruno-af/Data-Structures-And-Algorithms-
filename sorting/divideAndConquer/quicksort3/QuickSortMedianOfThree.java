package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {

			intermediary(array, leftIndex, rightIndex);
			int pivotIndex = partition(array, leftIndex, rightIndex - 1);

			sort(array, leftIndex, pivotIndex - 1 );
			sort(array, pivotIndex + 1, rightIndex);
	}
	}

	private void intermediary(T[] array, int leftIndex, int rightIndex) {
		int flag = leftIndex;
		int center = (rightIndex + leftIndex)/2;
		int pivotIndex;

		if(array[leftIndex].compareTo(array[center]) < 0) {
			if(array[center].compareTo(array[rightIndex]) < 0) {
				// os 3 estao ordenados
			} else {
				//troca centro e ultimo
				Util.swap(array, center,rightIndex);
			}
		} else if(array[center].compareTo(array[rightIndex]) < 0) {
			// troca primeiro com meio
			Util.swap(array, leftIndex, center);
		} else {
			// ordem oposta
			Util.swap(array, leftIndex, rightIndex);
		}

		Util.swap(array, center, rightIndex-1);
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];
		int flag = leftIndex;
		int count = leftIndex + 1;

		while( count <= rightIndex ){
			if(array[count].compareTo(pivot) < 0) {
				flag++;
				Util.swap(array, flag, count);
			}
			count++;
		}

		Util.swap(array, leftIndex, flag);

		return flag;
	}
}
