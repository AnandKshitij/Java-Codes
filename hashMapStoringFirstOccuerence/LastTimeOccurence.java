package hashMapStoringFirstOccuerence;

/*
1. Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and 
only if it is not printed in the last 10 seconds.
2. Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, 
otherwise returns false.
3. It is possible that several messages arrive roughly at the same time.

Sample Input
5
1 2 3 8 10
foo bar foo bar foo
Sample Output
true true false false false
*/

import java.util.*;

public class LastTimeOccurence {
	
	public static void shouldPrint(int times[], String messages[]){
		int n = times.length;
		//key-> message
		//value-> last time the message was printed
		HashMap<String,Integer> H = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			int time = times[i];
			String message = messages[i];
			
			if(!H.containsKey(message)){
				System.out.print("true ");
				H.put(message, time);
			}
			else{
				int lastTime = H.get(message);
				
				if(time-lastTime>=10)
				{
					System.out.print("true ");
					H.put(message, time);
				}
				else
				{
					System.out.print("false ");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int times[] = new int[n];
		String messages[] = new String[n];
		
		for(int i=0; i<n; i++){
			times[i] = s.nextInt();
		}
		
		for (int i = 0; i < messages.length; i++) {
			messages[i] = s.next();
		}
		
		shouldPrint(times,messages);
		
	}

}
