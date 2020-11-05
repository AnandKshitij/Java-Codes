package Test2;


import java.util.*;

public class RajneeshBirthday {
	
	public static int celebrityProblem(int arr[][], int n)
	{
		Stack<Integer> S = new Stack<>();
		
		for(int i=0 ; i<n ; i++)
		{
			S.add(i);
		}
		
		while(S.size()>1)
		{
			int val1 = S.pop();
			int val2 = S.pop();
			
			//val1 knows val2
			//val1 is not a celebrity
			if(arr[val1][val2]==1)
			{
				S.push(val2);
			}
			//val2 is not a celebrity
			else
			{
				S.push(val1);
			}
		}
		
		int index = 0;
		
		if(!S.empty())
		index = S.pop();
		
		//first checking the row
		//every element should be 0
		for(int j=0 ; j<n ; j++)
		{
			if(j==index)
			{
				continue;
			}
			//the element knows someone other than himself
			if(arr[index][j]==1)
			{
				return -1;
			}
		}
		
		//now checking the row
		//every element should be 1
		for(int i=0 ; i<n ; i++)
		{
			if(i==index)
			{
				continue;
			}
			if(arr[i][index]==0)
			{
				return -1;
			}
		}
		
		return index;
	}
	
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		
		int input[][] = new int [n][n];
		
		for(int i=0 ; i<m ; i++)
		{
			int val1 = s.nextInt();
			int val2 = s.nextInt();
			
			input[val1][val2] = 1;
		}
		
		System.out.println(celebrityProblem(input,n));
	}

}
