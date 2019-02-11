
//dpsinghimport the exception library for error handeling
import java.lang.IndexOutOfBoundsException;


//define list class to play operations on nodes
public class list_with_tail<Type> implements list_with_tail_interface<Type> {
	
	  //the list is just location of head node and we can then achieve whole list
	  //so just define variable node
      private node<Type> head = new node<>();
      
      //one must have variable to store the length of list
      private int len = 0;
      
      //just define the tail node
      private node<Type> tail = new node<>();
      
      //define function for showing value at head
      public Type show_head() {
	      return(head.show_element());

      }
      
      //define function for showing value at tail
      public Type show_tail() {
    	  
    	  //just return element in tail
	      return(len != 1 ? tail.show_element(): null);
      }
      
      //define function to add node
      //we can add node at i_th position
      public void add_node(int pos, Type new_element) {
    	  
    	  //if pos_ is greater than len_ then show exception
    	  if (pos > len) {
    		  
    		  //then throw the exception
    		  throw new IndexOutOfBoundsException("your index has reached bounds");
    	  }
    	  
    	  //now we need to go at i_th position and change the node their
    	  //give i_th node to next element of new node and for i - 1 node give next as new node
    	  else {
    		  
    		  //just create new_node with new_element as initiator
			  //make new node
			  node<Type> new_node = new node<>(new_element);
    		  
    		  //if i = 1 will have to change head
    		  if(pos == 0) {
    			  
    			  //if len is zero need to do something
    			  if (len ==0) {
    				  
    				//just update the tail
    				  tail.change_element(new_element);
    				  
    				  
    				  //just keep tail to head
    				  head = new_node;
    				  
    				  //and keep tail as next of head
    				  head.change_next(tail);
    						  
    			  }
    			  //if len is one we have some different case 
    			  if (len == 1) {
    				  
    				  //just change next_of new node to tail
    				  new_node.change_next(tail);
    				  
    				  //and make head as new_node
    				  head = new_node;
    				  
    			  }
    			  //else
    			  else {
    			  
    			 //just need to change next node to head
    			 new_node.change_next(head);
    			 
    			 //now change head to new_node
    			 head = new_node;

    			 }}
    		  
    		//need to go at i_th position
    		else {
    			
    			//define curent_node as head
    			node<Type> current_node = head;
    			
    			//now also define pre_node to store node before current node
    			node<Type> pre_node = new node<>();
    			
    			//now run for loop from i = 0 to i = i_th pos_
    			for (int i = 1 ; i <= pos; i++) {
    				
    				//change pre_node to current node
    				pre_node = current_node;
    				
    				//now just change value of current node to its next element
    				current_node = current_node.show_next();
    			}
    			//for next of new_node add current node
    			new_node.change_next(current_node);
    			
    			//now set the next of pre_node to be new node
    			pre_node.change_next(new_node);
    			
    			//let if last element is to add we also need to update the tai
    			if (pos == len  ) {
    				
    				//now just change tail
    				tail = new_node;
    			}
    		  }
    		//change the len_ by one
  			len++;
    	  }
      }
      //make function to get i_th value of list
      public Type show_ith_element(int pos) {
    	  
    	  //if pos_ > len_ then just throw error
    	  if (pos > len - 1) {
    		  
    		  //throw error
    		  throw new IndexOutOfBoundsException("your index has reached bounds"); 
    	  }
    	  //else run for loop for current node and return its value
    	  else {
    		  
    		  //if pos_ = 0 then call show head
    		  if (pos == 0 ) {
    			  
    			  //just call show_head
    			  return(head.show_element());
    		  }
    		  
    		  /*//also we can show last element easily
    		  else if(pos == len -1) {
    			  
    			  //just print tail element
    			  return(tail.show_element());*/
    		  //}
    		  //go for for loop and do things
    		  else {
    			  
    			  //define the current node
    			  node<Type> current_node = head;
    			  
    			  //run the for loop
    			  for (int i = 1; i <= pos ; i++) {
    				  
    				  //just change current node to current_node.next
    				  current_node= current_node.show_next();
    			  }
    			  //now return value in code
    			  return(current_node.show_element());
    		  }
    	  }
      }
      
      //define function to delete the ith element in the list
      public void delete_ith_element (int pos) {
    	  
    	  //check if the pos is less than maximum possible value
    	  if (pos > len - 1) {
    		  
    		  //throw exception for index of bounds
    		  throw new IndexOutOfBoundsException("your index has reached bounds");
    	  }
    	  
    	  //now must run loop
    	  else {
    		  
    	  //if pos is 0 then just change head
    	  if (pos == 0) {
    		  
    		  //just change pointer of head next element
    		  head.change_next(head.show_next());
    		  
    		  //also change the element in node
    		  head.change_element(head.show_next().show_element());
    	  }
    	  //else run for loop to reach node
    	  else {
    		  
    		  //define the current node as head
    		  node<Type> current_node = new node<>();
    		  
    		  //place current node to head
    		  current_node = head;
    		  
    		  //now run the for loop
    		  for(int i = 1 ; i < pos; i++ ) {
    			  
    			  //just update current node
    			  current_node = current_node.show_next();
    		  }
    		  //now just delete the node
              //now just set current_node's next element to next next element of current
    		  current_node.change_next(current_node.show_next().show_next());
    		  
    		  //if the deleted node was last then update the tail
    		  if (pos == len -1) {
    			  
    			  //just change the last node 
    			  tail = current_node;
    		  }
    		  
    	  	}
    	  //decrese length by one
		  len--;
    	  }
      }
      
      //define function to print the list
      public void print_list() {
    	  
    	  //now just run for loop and print each element
    	  for (int i = 0; i < len ; i++ ) {
    		  
    		  //print ith element
    		  System.out.println(show_ith_element(i) + " ");
    	  }
      }
      
      
      public static void main(String args[]) {
    	list_with_tail<Integer> list = new list_with_tail<>();
    	Integer c = new Integer(4);
    	Integer a = new Integer(3);
    	Integer b = new Integer(2);
    	list.add_node(0,c);
    	 System.out.println("now the last element " + list.show_tail());
    	list.add_node(0,a);
    	 System.out.println("now the last element " + list.show_tail());
    	list.add_node(0, b);
    	 
    	list.print_list();
    	   System.out.println("now the last element " + list.show_tail());
    	list.delete_ith_element(2);
    	
    	System.out.println("new list");
    	list.print_list();
    	System.out.println("now the last element " + list.show_tail());
      }
}
