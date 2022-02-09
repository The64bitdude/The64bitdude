package length;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class TicTacToe
{
	private char[][] mat = new char[3][3];

	public TicTacToe()
	{
	}

	public TicTacToe(String game)
	{
		for(int i = 0;i<3;i++) {
			for(int k = 0;k<3;k++) {
		mat[i][k] = game.charAt((i*3)+k);
		System.out.print(mat[i][k]);
			}
			System.out.println("");
		}
	}

	public String getWinner()
	{
		for(int i = 0;i<3;i++) {
			if((mat[i][0] == mat[i][1])&&(mat[i][1]  == mat[i][2])) {
				return mat[i][0]+" wins horizontally!";
			}
            if((mat[0][i] == mat[1][i])&&(mat[1][i]  == mat[2][i])) {
            	return mat[0][i] +" wins vertically!";
			}
            if((mat[0][0] == mat[1][1])&&(mat[1][1]  == mat[2][2])) {
            	return mat[0][0]+" wins diagonally!";	
            }
            if((mat[0][2] == mat[1][1])&&(mat[1][1]  == mat[2][0])) {
            	return mat[0][2]+" wins diagonally!";	
            }
		}
		return "cat's game - no winner!";
	}

	public String toString()
	{
		String output="";
		return output+"\n\n";
	}
}