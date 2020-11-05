package linkedListTopic;

import java.util.*;

public class CloneLL {

    static class Node {
        int data;
        Node next, arbitrary;

        Node(int d) {
            data = d;
            next = arbitrary = null;
        }
    }
    public static Node copyList(Node n) {
   	
	    if(n==null){
	   		return null;
	   	}
	   	
	   	Node temp = n;
	   	
	   	while(temp!=null){
	   		Node newNode = new Node(temp.data);
	   		Node next = temp.next;
	   		temp.next = newNode;
	   		newNode.next = next;
	   		temp = next;
	   	}
	   	
	   	Node newTemp = n;
	   	
	   	int pos = 0;
	   	
	   	while(newTemp!=null){
	   		Node next = newTemp.next;
	   		if(pos%2==0)
	   		if(newTemp.arbitrary!=null){
	   			newTemp.next.arbitrary = newTemp.arbitrary.next;
	   		}
	   		newTemp = next;
	   		pos++;
	   	}
	   	
	   	boolean even = false;
	   	
	   	Node eH = null;
	   	Node eT = null;
	   	Node oH = null;
	   	Node oT = null;
	   	
	   	Node curr = n;
	   	
	   	while(curr!=null)
	   	{
	   		Node next = curr.next;
	   		if(!even){
	   			if(eH==null){
	   				eH = curr;
	   				eT = curr;
	   			}
	   			else{
	   				eT.next = curr;
	   				eT = curr;
	   			}
	   			eT.next = null;
	   		}
	   		else{
	   			if(oH==null)
	   			{
	   				oH = curr;
	   				oT = curr;
	   			}
	   			else
	   			{
	   				oT.next = curr;
	   				oT = curr;
	   			}
	   			oT.next = null;
	   		}
	   		
	   		even = !even;
	   		curr = next;
	   	}
	   	
	   	n = oH;
	   	
	   	return eH;
   }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a1 = sc.nextInt();

        Node tail;
        head = tail = insert(null, a1);

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            tail = insert(tail, a);
        }

        // adding arbitrary pointers
        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            Node tempA = head;
            int count = -1;

            while (tempA != null) {
                count++;
                if (count == a - 1) {
                    break;
                }
                tempA = tempA.next;
            }

            Node tempB = head;
            count = -1;

            while (tempB != null) {
                count++;
                if (count == b - 1) {
                    break;
                }

                tempB = tempB.next;
            }

            // when both a greater than N
            if (a <= n) {
                tempA.arbitrary = tempB;
            }
        }

        Node generated_add = head;

        Node res = copyList(head);

        Node cloned_add = res;
        
        display(res);
        
    }

    static Node head;

    public static void display(Node head) {

        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    public static Node insert(Node tail, int data) {

        if (tail == null) {
            return new Node(data);
        }

        Node nn = new Node(data);
        tail.next = nn;
        return nn;
    }

    

}