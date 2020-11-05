package BitManipulation;

import java.util.*;

public class ValidSudoku {
	
    public static boolean isValidSudoku(char[][] board) {
        
    	int row[] = new int [9];
    	int col[] = new int [9];
    	int subMatrix[][] = new int [3][3];
    	
    	for(int i=0; i<board.length; i++)
    	{
    		for(int j=0; j<board[i].length; j++)
    		{
    			char ch = board[i][j];
    			
    			if(ch=='.')
    			{
    				continue;
    			}
    			
    			int val = ch-'0';
    			
    			int subRow = i/3;
    			int subCol = j/3;
    			
    			if((row[i] & (1<<val))==0)
    			{
    				row[i] = (row[i]|(1<<val));
    			}
    			else
    			{
    				return false;
    			}
    			
    			if((col[j] & (1<<val))==0)
    			{
    				col[j] = (col[j]|(1<<val));
    			}
    			else
    			{
    				return false;
    			}
    			
    			if((subMatrix[subRow][subCol] & (1<<val))==0)
    			{
    				subMatrix[subRow][subCol] = (subMatrix[subRow][subCol]|(1<<val));
    			}
    			else
    			{
    				return false;
    			}
    		}
    	}

    	return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        if (isValidSudoku(board)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

    }

}
