package Test2;

import java.util.*;

public class MolecularMass {
	
	static HashMap<Character,String> H = new HashMap<>();
	
	public static int getMolarMass(String input)
	{
		int result = 0;
		Stack<String> S = new Stack<>();
		
		for(int i=0 ; i<input.length() ; i++)
		{
			char ch = input.charAt(i);
			
			if(ch=='(')
			{
				S.push(ch+"");
				continue;
			}
			if(ch=='H' || ch=='O' || ch=='C')
			{
				String str = H.get(ch);
				S.push(str);
				continue;
			}
			if(ch>='0' && ch<='9')
			{
				String str1 = S.pop();
				int val1 = Integer.parseInt(str1);
				int val2 = ch-'0';
				int val = val1*val2;
				S.push(Integer.toString(val));
				continue;
			}
			if(ch==')')
			{
				int val = 0;
				while(!S.peek().equals("("))
				{
					val += Integer.parseInt(S.pop());
				}
				S.pop();
				S.push(Integer.toString(val));
			}	
			
		}
		
		while(!S.empty())
		{
			result += Integer.parseInt(S.pop());
		}
		
		return result;
		
		
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		String input = s.next();
		
		H.put('C',"12");
		H.put('O',"16");
		H.put('H', "1");
		
		System.out.println(getMolarMass(input));
	}

}
