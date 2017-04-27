package matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeterminanteTest {

	@Test
	public void testDeterminanteMatrix1x1() {
		int[][] matrix = {{5}};
		int det = Determinante.determinanteMatrixOrdnung1(matrix);
		assertEquals(5, det);
		
		
	}
	@Test
	public void testDetMatrix2x2(){
		int[][] matrix1 ={
				{2,2},
				{2,2},
			};
		int det1 = Determinante.determinanteMatrixOrdnung2(matrix1);
		assertEquals(0, det1);
		int[][] matrix2 ={
				{3,2},
				{2, -3},
		};
		int det2 = Determinante.determinanteMatrixOrdnung2(matrix2);
		assertEquals(-13, det2);
	}
	@Test
	public void testDetMatrix3x3(){
		int[][] matrix1 ={
				{2,5,2},
				{3,-3,1},
				{1, 4, -4},
		};
		int det1 = Determinante.determinateMatrixOrdnung3(matrix1);
		assertEquals(111, det1);
		
		int[][] matrix2 ={
				{1,2,3},
				{4,5,6},
				{7,8,9},
		};
		int det2 = Determinante.determinateMatrixOrdnung3(matrix2);
		assertEquals(0, det2);
		
		int[][] matrix3 ={
				{1,3,4},
				{2,0,1},
				{3,1,2},
		};
		int det3 = Determinante.determinateMatrixOrdnung3(matrix3);
		assertEquals(4, det3);
	}
	
	@Test
	public void testDetMatrix4x4(){
		int[][] matrix1 ={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
		};
		int det1 = Determinante.determinateMatrixOrdnung4(matrix1);
		assertEquals(0, det1);
		
		int[][] matrix2 ={
				{5,0,3,-1},
				{3,0,0,4},
				{-1,2,4,-2},
				{1,0,0,5},
		};
		int det2 = Determinante.determinateMatrixOrdnung4(matrix2);
		assertEquals(66, det2);
		
		int[][] matrix3 ={
				{3,4,2,1},
				{2,1,3,5},
				{0,1,1,2},
				{1,2,4,0},
		};
		int det3 = Determinante.determinateMatrixOrdnung4(matrix3);
		assertEquals(78, det3);
	}
	
	@Test
	public void testDetMatrixNxN(){
			
		int[][] matrix1 ={
				{ 1, 2, 3, 4, 5},
				{ 6, 7, 8, 9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25},
		};
		int det1 = Determinante.determinateMatrixNxN(matrix1);
		assertEquals(0, det1);
		
		int[][] matrix3 = {
				{6, 8, 2, 2, 2},
				{1, 0, 6, 7, 8},
				{4, 6, 3, 2, 9},
				{7, 4, 2, 0, 9},
				{8, 3, 2, 9, 5},
		};
		int det3 = Determinante.determinateMatrixNxN(matrix3);
		assertEquals(10252, det3);
		
		int[][] matrix4 = {
				{5, 1, 9, 2, 1},
				{22, 19, 0, 7, 4},
				{88, 2,-8, -3, 11},
				{6, -22, 9, 7, 2},
				{1, 8, -100, 88, 44},
		};
		int det4 = Determinante.determinateMatrixNxN(matrix4);
		assertEquals(-6381573, det4);
		
	}

}
