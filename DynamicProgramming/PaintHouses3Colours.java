package DynamicProgramming;

/*
1. You are given N houses, each house can be painted with 3 different colours: red, 
blue or green
2. Cost of painting each house a certain colour is different and is given as an 
N x 3 matrix to you
3. You need to find the minimum amount spent on painting all the houses such that no 2 adjacent 
houses have the same colour
4. Input and output is handled for you
5. It is a functional problem ,please do not modify main()

Sample Input
4
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8
*/

import java.util.*;

public class PaintHouses3Colours {
	
	public static void disp(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  	");
		}
		System.out.println();
	}
	
	 public static int minCost(int[][] costs) {
	  	  //Write your code here
		 
		 int n = costs.length;
		 
		 if(n==0) {
			 return 0;
		 }
		 
		 int colour1[] = new int [n+1];
		 int colour2[] = new int [n+1];
		 int colour3[] = new int [n+1];
		 
		 colour1[1] = costs[0][0];
		 colour2[1] = costs[0][1];
		 colour3[1] = costs[0][2];
		 
		 for(int i=2; i<n+1; i++) {
			 int costIndex = i-1;
			 
			 colour1[i] = Math.min(colour2[i-1],colour3[i-1])+costs[costIndex][0];
			 colour2[i] = Math.min(colour1[i-1],colour3[i-1])+costs[costIndex][1];
			 colour3[i] = Math.min(colour2[i-1],colour1[i-1])+costs[costIndex][2];
		 }
		 
		 disp(colour1);
		 disp(colour2);
		 disp(colour3);
		 
		 return Math.min(colour1[n],Math.min(colour2[n],colour3[n]));
	  }

	
	public static void main(String[] args) {
	  	  // TODO Auto-generated method stub
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[][] costs= new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                costs[i][j]=scn.nextInt();
            }
        }
         System.out.println(minCost(costs));
         scn.close();
	  }
}
