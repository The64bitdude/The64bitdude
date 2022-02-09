package length;

public class testingwithclasses {
	public static int e = 0;
	
	
	
	public static void main(String[] args) {
		int[][] matrix = new int[4][8];
		for(int row=0;row<matrix.length;row++)
		{
		  for(int column=0;column<matrix[row].length;column++)
		  {
		     matrix[row][column]=row*column+column/2+row*(column+1);
		  }
		}
		System.out.println(matrix[1][2]); //line 1
		System.out.println(matrix[1][3]); //line 2
		System.out.println(matrix[2][6]); //line 3
		System.out.println(matrix[1][5]); //line 4
		System.out.println(matrix[1][6]); //line 5
		int val = matrix[2][0] + matrix[0][0];
		System.out.println( val ); //line 6
		System.out.println(matrix[2][2]); //line 7
		val = matrix[2][5] - matrix[1][1];
		System.out.println( val ); //line 8
		System.out.println(matrix[2][7]); //line 9
		System.out.println(matrix[2][5]); //line 10
		val = matrix[3][6] / matrix[2][1];
		System.out.println( val ); //line 11
		val  = (matrix[1][1]+matrix[1][2])/3;
		System.out.println(matrix[ val ][ val ]); //line 12
	}
}
