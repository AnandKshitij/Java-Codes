package Queue;

//we will reverse the queue using stack
// we will first add all the values of the Queue to Stack
// then we will transfer all these values back to Queue

import java.util.*;

public class ReverseQueue {

    public static Queue<Integer> rev(Queue<Integer> q) 
    {
    	Stack<Integer> S = new Stack<>();
    	
    	while(!q.isEmpty()){
    		S.push(q.remove());
    	}
    	while(!S.empty()){
    		q.add(S.pop());
    	}
    	return q;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }
        Queue<Integer> res = rev(q);
        while (res.size() != 0) {
            System.out.println(res.remove()+" ");
        }
    }
}