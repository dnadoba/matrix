package matrix;

public class Determinante {
	/**
	 * Gibt die Ordnung einer Quadratischen Matrix zurück
	 * @param matrix
	 * @return Ordnung
	 */
	private static int ordnung(int[][] matrix) {
		return matrix.length;
	}

	/**
	 * Berechnung einer Matrix der Ordnung 1 deren Determinante.
	 * @param matrix
	 * @return
	 */
	public static int determinanteMatrixOrdnung1(int[][] matrix) {
		return matrix[0][0];
	}

	/**
	 * Berechnung einer Matrix der Ordnung 2 deren Determinante.
	 * @param matrix
	 * @return
	 */
	public static int determinanteMatrixOrdnung2(int[][] matrix) {
		return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
	}

	/**
	 * Berechnung einer Matrix der Ordnung 3 deren Determinante.
	 * Nach Regel von Sarrus
	 * @param matrix
	 * @return
	 */
	public static int determinateMatrixOrdnung3 (int [][] matrix){
		int det = 0;
		// Einzelen Produkte miteinander Multiplitzieren und mit det addieren
		for(int i = 0; i < 3;i++){

			int produkt = wert(matrix, 0, i);
			for(int j = 1; j<3; j++){

				int spalte = i + j;
				int zeile = j;
				produkt *= wert(matrix, zeile, spalte);
			}
			det += produkt; 
		}
		// Einzelen Produkte miteinander Multiplitzieren und mit det subtrahieren
		for(int i = 0; i < 3;i++){

			int produkt = wert(matrix, 2, i);
			for(int j = 1; j<3; j++){
				int zeile = 2- j;
				int spalte = j + i;
				produkt *= wert(matrix, zeile, spalte);
			}
			det-= produkt;
		}
		return det;
	}

	/**
	 * Berechnung einer Matrix der Ordnung 4 deren Determinante.
	 * Nach Laplace Entwicklungssatz
	 * @param matrix
	 * @return
	 */
	public static int determinateMatrixOrdnung4 (int[][] matrix){
		int det = 0;
		// ite- Zeile wird gewählt 
		for(int i = 0, j=0; i< ordnung(matrix);i++){

			// Formel einer 4*4 Dertiminanten Berechnung
			det += matrix[i][j]*(Math.pow(-1, i+j))*determinateMatrixOrdnung3(zweitMatrix(matrix, i, j));	
		}
		return det;	
	}

	public static int determinateMatrixNxN (int[][] matrix){

		int det = 0;
		// ite- Zeile wird gewählt
		for(int i = 0, j=0; i< ordnung(matrix);i++){
			// 
			if(ordnung(matrix) <= 4){
				det += Math.pow(-1, i+j)*matrix[i][j]*determinateMatrixOrdnung3(zweitMatrix(matrix, i, j));
				continue;
			}
			else{
				det += matrix[i][j]*(Math.pow(-1, i+j))*determinateMatrixNxN(zweitMatrix(matrix,i,j));
			}
		}
		return det;	

	}

	/**
	 * Bei überschreitung der Indizes zum wert der davorigen.
	 * @param matrix
	 * @param zeile
	 * @param spalte
	 * @return
	 */
	private static int wert (int[][] matrix, int zeile, int spalte){	
		zeile += ordnung(matrix)*2;
		spalte += ordnung(matrix)*2;
		zeile %= ordnung(matrix);
		spalte%= ordnung(matrix);

		return matrix[zeile][spalte];
	}

	/**
	 * Der Aufbau einer zweit Matrize vom Prinzip des Laplace Entwicklungssatz.
	 * @param matrix
	 * @param zeile
	 * @param spalte
	 * @return
	 */
	private static int[][] zweitMatrix(int[][] matrix, int zeile, int spalte){
		int[][] zweitMatrix = new int [ordnung(matrix)-1][ordnung(matrix)-1];
		for(int zweitZeile = 0; zweitZeile < ordnung(matrix); zweitZeile++){

			for(int zweitSpalte =0; zweitSpalte < ordnung(matrix); zweitSpalte++){
				//Die Werte in der Spalte und der Zeile werden nicht übernommen
				if(zweitZeile == zeile|| zweitSpalte==spalte) {
					continue;
				}
				//Lücke von nicht übernommenen Wert wird gedeckt
				int tmpZeile = zweitZeile;
				if(zweitZeile > zeile){
					tmpZeile--;
				}
				int tpmSpalte = zweitSpalte;
				if(zweitSpalte > spalte){
					tpmSpalte--;
				}
				//Wertübergabe
				zweitMatrix[tmpZeile][tpmSpalte] =  matrix[zweitZeile][zweitSpalte];
			}
		}
		return zweitMatrix;
	}
}
