package linkedListTopic;

/*
You are given two linked lists with N and M nodes respectively.
Each linked list represent a polynomial number.
You have to write a function that adds the coefficients who have same powers of the variable.

We have assumed that the linked list are sorted in decreasing order of power
 */

import java.util.*;

public class AdditionOfPolynomials {

    static class Node {
        int coeff;
        int pow;
        Node next;

        Node(int a, int b) {
            coeff = a;
            pow = b;
            next = null;
        }
    }

    public static void addPolynomial(Node poly1, Node poly2) 
    {
        // write your code here
        // Print the polynomial formed by adding both LL in the function itself.
    	
    	Node temp1 = poly1;
    	Node temp2 = poly2;
    	
    	boolean print = false;
    	
    	while(temp1!=null && temp2!=null)
    	{
    		int pow1 = temp1.pow;
    		int coeff1 = temp1.coeff;
    		
    		int pow2 = temp2.pow;
    		int coeff2 = temp2.coeff;
    		
    		int power = 0;
    		int coefficient = 0;
    		
    		if(pow1==pow2)
    		{
    			power = pow1;
    			coefficient = coeff1+coeff2;
    			temp1 = temp1.next;
    			temp2 = temp2.next;
    		}
    		else if(pow1>pow2)
    		{
    			power = pow1;
    			coefficient = coeff1;
    			temp1 = temp1.next;
    		}
    		else
    		{
    			power = pow2;
    			coefficient = coeff2;
    			temp2 = temp2.next;
    		}
    		
    		if(!print)
    		{
    			print = true;
    			System.out.print(coefficient+"x^"+power);
    		}
    		else
    		{
    			System.out.print(" + "+coefficient+"x^"+power);
    		}
    	}
    	
    	while(temp1!=null)
    	{
    		if(!print)
    		{
    			print = true;
    			System.out.print(temp1.coeff+"x^"+temp1.pow);
    		}
    		else
    		{
    			System.out.print(" + "+temp1.coeff+"x^"+temp1.pow);
    		}
    	}
    	
    	while(temp2!=null)
    	{
    		if(!print)
    		{
    			print = true;
    			System.out.print(temp2.coeff+"x^"+temp2.pow);
    		}
    		else
    		{
    			System.out.print(" + "+temp2.coeff+"x^"+temp2.pow);
    		}
    	}
    	

        
    }

    static Node head;

    static Node head2;

    static Node head3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        head = insert(head, a1, b1);

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            head = insert(head, a, b);
        }

        int n2 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        head2 = insert(head2, a2, b2);

        for (int i = 1; i < n2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            head2 = insert(head2, a, b);
        }

        addPolynomial(head, head2);
    }

    public static Node insert(Node head, int a, int b) 
    {
    	if (head == null) 
    	{
            return new Node(a, b);
        }

        head.next = insert(head.next, a, b);

        return head;
    }
    
    public static void display(Node head)
    {
        for (Node node = head; node != null; node = node.next) 
        {
            System.out.print(node.coeff + "x^" + node.pow + " ");
        }
    }

}
