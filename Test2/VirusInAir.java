package Test2;


import java.util.*;

public class VirusInAir{
    
    public static int getDays(int virus[])
    {
        int days = 0;
        
        Stack<Integer> S = new Stack<>();
        
        for(int i=0 ; i<virus.length ; i++)
        {
            if(S.empty())
            {
                S.push(i);
                continue;
            }
            
            int val = virus[i];
            
            if(virus[S.peek()]<val)
            {
                S.push(i);
                continue;
            }
            
            if(virus[S.peek()]>=val)
            {
                int Ans = i-S.peek();
                if(Ans>days)
                {
                    days = Ans;
                }
            }
            
        }
        
        return days;
    }
    
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        int virus[] = new int [n];
        
        for(int i=0 ; i<n ; i++)
        {
            virus[i] = s.nextInt();
        }
        
        int days = getDays(virus);
        
        System.out.println(days);
    }

}
