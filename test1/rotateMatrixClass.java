package test1;

import java.util.Scanner;

public class rotateMatrixClass {
	
	static void rotateMatrix(int N, int mat[][]) 
    { 
		int row = mat.length;
		int col = mat[0].length;
		int r=0,c=0;
		
		
		while(r<row && c<col)
		{
			int i=r;
			int j=c;
			
			while(i+1<row && j+1<col)
			{
				int temp = mat[i+1][c];
				mat[i+1][c] = mat[r][j+1];
				mat[r][j+1] = temp;
				i++;
				j++;
			}
			
			r++;
			c++;
		}
		
		
		for(int j=0 ; j<col ; j++)
		{
			int iStart = 0;
			int iEnd = row-1;
			
			while(iStart<iEnd)
			{
				int temp = mat[iStart][j];
				mat[iStart][j] = mat[iEnd][j];
				mat[iEnd][j] = temp;
				iStart++;
				iEnd--;
			}
		}
		
		
		
    } 
  
    
    static void displayMatrix(int N, int mat[][]) 
    { 
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print(mat[i][j]+" "); 
       
            System.out.print("\n"); 
        } 
        System.out.print("\n"); 
    } 
       
   
    public static void main (String[] args)  
    { 
    	Scanner scn=new Scanner(System.in);

        int n=scn.nextInt(); 
        int [][]mat=new int[n][n];
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		mat[i][j]=scn.nextInt();
        	}
         }      
       
       
        rotateMatrix(n,mat); 
        displayMatrix(n,mat); 
    } 

}
