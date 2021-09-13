package com.java.preparation.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;

@Service("linkedListRotation")
public class LinkedList {

	private Logger logger = Logger.getLogger(LinkedList.class);
	
	Node head;
	
	class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
	
	void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
	void printList(Node node)
	{
	    while (node != null)
	    {
	        System.out.print(node.data + " ");
	        node = node.next;
	    }
	}
	
     public void rotation()  throws CustomException{
    	 LinkedList llist = new LinkedList();
    	 
         // create a list 10->20->30->40->50->60
         for (int i = 0; i <= 25; i += 3) {
        	 llist.push(i);
         }
            
  
         System.out.println("Given Linked list::" +llist);
         printList(head);
  
         llist.rotate(4);
  
         System.out.println("Rotated Linked List::" +llist );
         printList(head);
         System.out.println("Completed");
     }
     
     public void rotate(int k)
     {
    	 System.out.println("Testing");
    	 if (k == 0)
             return;
    	 
    	 Node current = head;
    	 
    	 int count = 1;
         while (count < k && current != null) {
             current = current.next;
             count++;
         }
         
         if (current == null)
             return;
  
         
         Node kthNode = current;
         
         
         while (current.next != null)
             current = current.next;
         
         
         
         current.next = head;
         
         System.out.println(head.data +"and"+head.next.data);
         head = kthNode.next;
         System.out.println(head.data +"and"+head.next.data);
        
         kthNode.next = null;
     }
    
     
     
}
