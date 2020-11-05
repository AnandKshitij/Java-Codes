package Array;

import java.util.*;

public class LoopInCircularArray {
	
	public static boolean isLoop(int input[]) {
		
		HashSet<Integer> visited = new HashSet<>();
		
		for (int i = 0; i < input.length; i++) {
			int val = input[i];
			if(visited.contains(i)) {
				continue;
			}
			
			visited.add(i);
			HashSet<Integer> curr = new HashSet<>();
			curr.add(i);
			
			boolean isPositive = true;
			if(val<0) {
				isPositive = false;
			}
			
			int next = val+i;
			int prev = i;
			
			while(true) {
				if(next>=input.length) {
					next = next%input.length;
				}
				if(next<0) {
					next = next%input.length+input.length;
				}
				
				if(next==prev) {
					break ;
				}
				
				
				if(isPositive && input[next]<0) {
					break;
				}
				else if(!isPositive && input[next]>0) {
					break;
				}
				
				if(visited.contains(next)) {
					if(curr.contains(next)) {
						return true;
					}
					break ;
				}
				else {
					if(curr.contains(next)) {
						return true;
					}
					prev = next;
					curr.add(next);
					visited.add(next);
					next = next+input[next];
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int input[] = new int [n];
		for (int i = 0; i <n; i++) {
			input[i] = s.nextInt();
		}
		
		System.out.println(isLoop(input));
	}
}
