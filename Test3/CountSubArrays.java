package Test3;

import java.util.*;

public class CountSubArrays {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);		
		int n = s.nextInt();
		int arr[] = new int [n];
		HashMap<Integer,ArrayList<Integer>> temp = new HashMap<>();
        
        for(int i=0; i<n; i++)
        {
            arr[i] = s.nextInt();
           
            int val = arr[i];
            
            if(!temp.containsKey(val))
            {
            	ArrayList<Integer> A = new ArrayList<>();
            	A.add(i);
            	temp.put(val,A);
            }
            else
            {
            	ArrayList<Integer> A = temp.get(val);
            	A.add(i);
            	temp.put(val,A);
            }
        }
        
        int count = temp.size();
		
		for(int val : temp.keySet())
		{
			ArrayList<Integer> A = temp.get(val);
			HashSet<Integer> H = new HashSet<>();
		
			for(int i=0; i<A.size(); i++)
			{
				int start = A.get(i);
				H.add(arr[start]);
				
				for(int end=start+1; end<arr.length; end++)
				{
					int value = arr[end];
					if(!H.contains(value))
					{
						count++;
						H.add(value);
					}
				}
			}
			
		}
		
		System.out.println(count);
	}

}
