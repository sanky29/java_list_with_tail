
//create interface which shows functions of node class
public interface node_interface<Type> {
       
	//the function that set value of node element to the input
	//for node NODE, with element value ELEMENT, ELEMENT = new_element 
	void change_element(Type new_element);
	
	//set the value of next_node to new_node
	void change_next(node<Type> new_node);
	
	//show's the value of element in node
	Type show_element();
	
	//show's the value of next node in node
	node<Type> show_next();

}
