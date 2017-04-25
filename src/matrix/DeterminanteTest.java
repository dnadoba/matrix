package matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeterminanteTest {

	@Test
	public void detMatrix1x1() {
		int[][] matrix = {
				{5},
		};
		int det = Determinante.determinanteMatrixOrdnung1(matrix);
		assertEquals(5, det);
	}
	
	@Test
	public void detMatrix2x2() {
		int[][] matrix = {
				{2, 2},
				{2, 2},
		};
		int det = Determinante.determinanteMatrixOrdnung2(matrix);
		assertEquals(0, det);
		
		int[][] matrix2 = {
				{3, 2},
				{2, -3},
		};
		int det2 = Determinante.determinanteMatrixOrdnung2(matrix2);
		assertEquals(-13, det2);
	}
	@Test
	public void detMatrix3x3() {
		int[][] matrix = {
				{1, 3, 4},
				{2, 0, 1},
				{3, 1, 2},
		};
		int det = Determinante.determinateMatrixOrdnung3(matrix);
		assertEquals(4, det);
		
		int[][] matrix2 = {
				{1, 2, 3},
				{3, 0, 1},
				{4, 1, 2},
		};
		int det2 = Determinante.determinateMatrixOrdnung3(matrix2);
		assertEquals(4, det2);
		
		int[][] matrix3 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
		};
		int det3 = Determinante.determinateMatrixOrdnung3(matrix3);
		assertEquals(0, det3);
	}

}
