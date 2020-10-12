package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array.length > 0) {

			int max = array[0], min = array[0];
			int[] countList;
			Integer[] copyArray = array.clone();


			// localizamos o menor e o maior
			for (int i = 0; i < array.length; i++) {
				if (array[i].compareTo(max) > 0) {
					max = array[i];
				} else if (array[i].compareTo(min) < 0) {
					min = array[i];
				}
			}

			// cria-se a lista de contadores
			countList = new int[max - min + 1];

			// conta a frequencia
			for (int i = 0; i < array.length; i++) {
				countList[array[i] - min] ++;
			}

			// soma acumulativa dos contadores
			for (int i = 1; i < countList.length; i++) {
				countList[i] += countList[i - 1];
			}

			// ordena o array original inteirando a copia
			for (int i = array.length -1; i >= 0; i--) {
				array[countList[copyArray[i] - min] - 1] = copyArray[i];
				countList[copyArray[i] - min ]--;
			}
		}
	}

}
