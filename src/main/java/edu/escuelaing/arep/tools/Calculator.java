package edu.escuelaing.arep.tools;

/**
 * Class in charge of performing calculator operations.
 *
 */
public class Calculator {

	/**
	 * Method in charge of calculating the mean of the values of a specified list.
	 * 
	 * @param ale_lista Object of type with the values to be
	 *                  calculated.
	 * @return the mean of the values in the specified list.
	 */
	public static double mean(double[] ale_lista) {
		int li_cont;
		double ld_suma;

		li_cont = 0;
		ld_suma = 0;
		for (int i = 0; i < ale_lista.length; i++) {
			ld_suma += ale_lista[i];
			li_cont++;
		}
		return (double) ld_suma / li_cont;
	}

	/**
	 * Method in charge of calculating the standard deviation of the values of a
	 * specified list.
	 * 
	 * @param ale_lista Object of type with the values to be calculated.
	 * @return The standard deviation of the values in the specified list.
	 */
	public static double standardDeviation(double[] ale_lista) {
		int li_cont;
		double ld_suma;
		double ld_media;

		li_cont = 0;
		ld_suma = 0;
		ld_media = Calculator.mean(ale_lista);

		for (int i = 0; i < ale_lista.length; i++) {
			ld_suma += Math.pow(ale_lista[i] - ld_media, 2);
			li_cont++;
		}

		return Math.sqrt((double) ld_suma / (li_cont - 1));
	}

	public static double[] bubbleSort(double[] ada_param) {
		double ld_tmp;
		for (int i = 0; i < ada_param.length - 1; i++) {
			for (int j = 0; j < ada_param.length - i - 1; j++) {
				if (ada_param[j + 1] < ada_param[j]) {
					ld_tmp = ada_param[j + 1];
					ada_param[j + 1] = ada_param[j];
					ada_param[j] = ld_tmp;
				}
			}
		}
		return ada_param;
	}
	
	public static double sum(double[] ada_param) {
		double ld_sum;
		
		ld_sum = 0;
		for (int i = 0; i < ada_param.length; i++)
			ld_sum += ada_param[i];
		
		return ld_sum;
	}

}