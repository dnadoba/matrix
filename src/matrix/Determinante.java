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
	private static int ordnung(int[][] matrix) {
		return matrix.length;
	}
	
	private static boolean quadratischeMatrix(int[][] matrix) {
		int erwarteteOrdnung = matrix.length;
		for(int[] spalte: matrix) {
			if (spalte.length != erwarteteOrdnung) {
				return false;
			}
		}
		return true;
	}
	private static int determinanteMatrixOrdnung1(int[][] matrix) {
		return matrix[0][0];
	}
	private static int determinanteMatrixOrdnung2(int[][] matrix) {
		return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
	}
}
