package Stacks;

/*
1. There are N cars are going to the same destination along a one lane road. The destination 
is target km away.
2. Each car i has a constant speed speed[i] (in km per hour), and initial position position[i] km 
towards the target along the road.
3. A car can never pass another car ahead of it, but it can catch up to it(i.e they will have 
same position now-onwards), and drive with it at the same speed.
4. A car fleet is some non-empty set of cars driving at the same position and same speed. 
Note that a single car is also a car fleet.
 */

import java.util.*;

class Pair
{
	int pos;
	int spd;
}
public class CarFleet {
	
	public static void compare(Pair[] arr)
	{
		Arrays.sort(arr,new Comparator<Pair>() {
			@Override public int compare(Pair P1,Pair P2)
			{
				return (P1.pos-P2.pos);
			}	
		});
	}
	public static int carFleet(int target, int[] position, int[] speed) 
	{
		Pair[] arr = new Pair[position.length];
		
		for(int i=0 ; i<position.length ; i++)
		{
			arr[i] = new Pair();
			arr[i].pos = position[i];
			arr[i].spd = speed[i];
		}
		
		compare(arr);
		
		int size = -1;
		
		for(int i=0 ; i<arr.length ; i++)
		{
			if(arr[i].pos<=target)
			{
				size = i;
			}
			else
			{
				break;
			}
		}
		
		size++;
		int Ans = 0;
		
		boolean flag = true;
		if(size<=1)
		{
			Ans += size;
			flag = false;
		}
		
		double time[] = new double [size];
		
		for(int i=0 ; i<size ; i++)
		{
			double d = (double)target-(double)arr[i].pos;
			time[i] = d/(double)arr[i].spd;
		}
		
		Stack<Double> S = new Stack<>();
		
		
		int index = size-1;
		
		while(index>=0 && flag)
		{
			double val = time[index];
			if(S.empty())
			{
				S.push(val);
				index--;
				continue;
			}
			
			double topValue = S.peek();
			
			if(val<=topValue)
			{
				index--;
				continue;
			}
			
			S.pop();
			Ans++;		
			S.push(val);
			index--;
		}
		
		while(!S.empty())
		{
			S.pop();
			Ans++;
		}
				
		//now after this we start for cars whose position is ahead of target
		//so these cars will be moving in opposite direction
		//as all cars are moving towards target
		double time1[] = new double [arr.length-size];
		
		for(int i=size ; i<time1.length ; i++)
		{
			double d = (double)arr[i].pos-(double)target;
			time1[i] = d/(double)arr[i].spd;
		}
		
		Stack<Double> S1 = new Stack<>();
		
		int index1 = time1.length;
		
		flag = true;
		
		if(time1.length<=1)
		{
			Ans += time1.length;
			flag = false;
		}
		
		//here the car with smaller position will be closer to target
		//whereas in cars on LHS of target the cars with higher position will closer to target
		//so there we moved the index right to left
		//here we will move indexes left to right
		int newIndex = 0;
		while(newIndex<index1 && flag)
		{
			double val = time1[newIndex];
			if(S1.empty())
			{
				S1.push(val);
				newIndex++;
				continue;
			}
			
			double topValue = S1.peek();
			
			if(val<=topValue)
			{
				newIndex++;
				continue;
			}
			
			System.out.println(newIndex);
			S1.pop();
			Ans++;		
			S1.push(val);
			newIndex++;
		}
		
		while(!S1.empty())
		{
			S1.pop();
			Ans++;
		}
		
		return Ans;
    }  
    
    
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int target=sc.nextInt();
        int n=sc.nextInt();
        int[] pos=new int[n];
        int[] speed=new int[n];
        for(int i=0;i<n;i++)pos[i]=sc.nextInt();
        for(int i=0;i<n;i++)speed[i]=sc.nextInt();
        System.out.println(carFleet(target, pos, speed));
    }
}
