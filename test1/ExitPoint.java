package test1;

import java.io.*;
import java.util.*;

public class ExitPoint
{
	public static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
       int r = scn.nextInt();
       int c = scn.nextInt();
       int[][] arr = new int[r][c];
       for (int i = 0; i < arr.length; i++) 
       {
    	   for (int j = 0; j < arr[0].length; j++) 
    	   {
				arr[i][j] = scn.nextInt();
    	   }

		}
		exitPoint(arr);
    }


    public static void exitPoint(int[][] arr) {
		// Write your code only here.
        
        int row = arr.length;
        int c = arr[0].length;
        
        
        int i=0,j=0;
        
        char direction = 'r';
        
        while(i!=row && j!=c)
        {
        	if(direction == 'r')
            {
        		if(j==c-1)
        		{
        			if(arr[i][j]==0)
        			{
        				break;
        			}
        			if(arr[i][j]==1)
        			{
        				direction = 'd';
                		i++;
                		continue;
        			}
        		}
        		
        		if(arr[i][j]==0)
        		{
        			if(arr[i][j+1]==0)
                	{
                		j++;
                	}
                	else if(arr[i][j+1]==1)
                	{
                		direction = 'd';
                		j++;
                		i++;
                	}
        		}
        		
        		else if(arr[i][j]==1)
        		{
        			direction = 'd';
        			if(i+1==row)
        			{
        				break;
        			}
            		i++;
        		}
            	
            }
            
        	else if(direction == 'd')
            {
            	if(i==row-1)
        		{
        			if(arr[i][j]==0)
        			{
        				break;
        			}
        			if(arr[i][j]==1)
        			{
        				direction = 'l';
                		j--;
                		continue;
        			}
        		}
            	
            	if(arr[i][j]==0)
            	{
            		if(arr[i+1][j]==0)
                	{
                		i++;
                	}
                	else if(arr[i+1][j]==1)
                	{
                		direction = 'l';
                		i++;
                		j--;
                	}
            	}
            	
            	else if(arr[i][j]==1)
            	{
            		direction = 'l';
            		if(j==0)
            		{
            			break;
            		}
            		j--;
            	}
            	
            }
            
        	else if(direction == 'l')
            {
            	if(j==0)
        		{
        			if(arr[i][j]==0)
        			{
        				break;
        			}
        			if(arr[i][j]==1)
                	{
        				direction = 'u';
                		i--;	
                		continue;
                	}
        			
        		}
            	
            	if(arr[i][j]==0)
            	{
            		if(arr[i][j-1]==0)
                	{
                		j--;
                	}
                	else if(arr[i][j-1]==1)
                	{
                		direction = 'u';
                		j--;
                		i--;
                	}
            	}
            	
            	else if(arr[i][j]==1)
            	{
            		direction = 'u';
            		if(i==0)
            		{
            			break;
            		}
            		i--;	
            	}
            }
            
        	else if(direction == 'u')
            {
            	if(i==0)
        		{
        			if(arr[i][j]==0)
        			{
        				break;
        			}
        			if(arr[i][j]==1)
        			{
        				direction = 'r';
        				j++;
        				continue;
        			}
        		}
            	
            	if(arr[i][j]==0)
            	{
            		if(arr[i-1][j]==0)
                	{
                		i--;
                	}
                	else if(arr[i-1][j]==1)
                	{
                		direction = 'r';
                		i--;
                		j++;
                	}
            	}
            	
            	else if(arr[i][j]==1)
            	{
            		direction = 'r';
            		if(j+1==c)
            		{
            			break;
            		}
    				j++;
            	}
            	
            }

        }
        
        System.out.println(i+","+j);    
   }
}
