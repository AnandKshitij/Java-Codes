package Test3;


import java.util.*;

public class DensityStack {
	
	static class Triplet
	{
		int freq;
		int element;
		int index;
	}
	
	static class freqComparator implements Comparator<Triplet>
	{
		public int compare(Triplet P1, Triplet P2)
		{
			if(P1.freq != P2.freq)
			{
				return (P2.freq-P1.freq);
			}
			else
			{
				return (P2.index-P1.index);
			}
		}
	}
	static class densityStack
	{
		static PriorityQueue<Triplet> P;
		static HashMap<Integer,Integer> H;
		
		public densityStack()
		{
			P = new PriorityQueue<>(new freqComparator());
			H = new HashMap<>();
		}
		
		public void insert(int x, int index)
		{
			int freq = 0;
			if(!H.containsKey(x))
			{
				H.put(x,1);
				freq = 1;
			}
			else
			{
				H.put(x,H.get(x)+1);
				freq = H.get(x);
			}
			
			Triplet T = new Triplet();
			T.element = x;
			T.freq = freq;
			T.index = index;
			P.add(T);
			System.out.println("null");
		}
		
		public int pop()
		{
			if(P.isEmpty())
			{
				return -1;
			}
			
			Triplet T = P.remove();
			
			int freq = T.freq;
			int popped = T.element;
			
			H.put(popped,freq-1);
			
			if(H.containsKey(popped) && H.get(popped)==0)
			{
				H.remove(popped);
			}
			
			return popped;
		}
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n= s.nextInt();

		densityStack D = new densityStack();
		
		for(int i=0; i<n; i++)
		{
			String str = s.next();
			
			if(str.equals("DensityStack"))
			{
				System.out.println("null");
				continue;
			}
			
			if(str.equals("push"))
			{
				int x = s.nextInt();
				D.insert(x,i);
			}
			else if(str.equals("pop"))
			{
				int popped = D.pop();
				if(popped==-1)
				{
					System.out.println("null");
				}
				else
				{
					System.out.println(popped);
				}
			}
		}
		
	}

}
