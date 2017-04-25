package matrix;

public class Determinante {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix4 = {
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
		};
		int[][] matrix3 = {
				{1,2,3},
				{1,2,3},
				{1,2,3},
		};
	}
	/**
	 * Gibt die Ordnung einer Quadratischen Matrix zurück
	 * @param matrix
	 * @return Ordnung
	 */
	public static int ordnung(int[][] matrix) {
		if(!quadratischeMatrix(matrix))
			throw new IllegalArgumentException("Matrix ist nicht Quadratisch");
		
		return matrix.length;
	}
	
	public static boolean quadratischeMatrix(int[][] matrix) {
		int erwarteteOrdnung = matrix.length;
		for(int[] spalte: matrix) {
			if (spalte.length != erwarteteOrdnung) {
				return false;
			}
		}
		return true;
	}
	public static int determinanteMatrixOrdnung1(int[][] matrix) {
		if(ordnung(matrix) != 1)
			throw new IllegalArgumentException("Matrix hat nicht die Ordnung 1");
		return matrix[0][0];
	}
	public static int determinanteMatrixOrdnung2(int[][] matrix) {
		if(ordnung(matrix) != 2)
			throw new IllegalArgumentException("Matrix hat nicht die Ordnung 2");
		return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
	}
	public static int determinateMatrixOrdnung3(int[][] matrix){
		if(ordnung(matrix) != 3)
			throw new IllegalArgumentException("Matrix hat nicht die Ordnung 3");
		int det = 0;
		System.out.println("Addition");
		for(int i = 0; i < 3; i++){
			int produkt = wert(matrix, 0, i);
			for(int j = 1; j < 3; j++) {
				int zeile = j;
				int spalte = i + j;
				produkt *= wert(matrix, zeile, spalte);
			}
			det += produkt;
		}
		System.out.println("Subtraktion");
		for(int i = 0; i < 3; i++){
			int produkt = wert(matrix, 2, i);
			for(int j = 1; j < 3; j++) {
				int zeile = 2 - j;
				int spalte = i +  j;
				produkt *= wert(matrix, zeile, spalte);
			}
			det -= produkt;
		}
		return det;
	}
	private static int wert(int[][] matrix, int zeile, int spalte) {
		int ordnung = ordnung(matrix);
		System.out.println(((zeile % ordnung) + 1) + " " + ((spalte % ordnung) + 1));
		return matrix[zeile % ordnung][spalte % ordnung];
	}
}
