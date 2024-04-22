//-----------------------------------------------------
// Title: Binary search tree class
// Author: Ozan Alp Sarýdoðan
// ID: 12955096052
// Section: 1
// Assignment: 3
// Description: This class creates the binary search tree
//-------------------------------------
public class BST {
	
	Employee root=null;
	
	public void insertEmployee(int id, String name, Boolean gender) {
	    //--------------------------------------------------------
        // Summary: inserts an object to the tree using insertRecursively() method
        // 
        // Precondition: id is an integer, name is a String and gender is a boolean data
        // 
        // Postcondition: id, name and gender is set to the parameters of the object
        //-------------------------------------------------------
	    root = insertRecursively(root, id, name, gender);
	}

	public Employee insertRecursively(Employee node, int id, String name, Boolean gender) {
	    //--------------------------------------------------------
        // Summary: This method is used to add object to tree by traversing in the tree.
        // 
        // Precondition: node is an object from Employee class. id is an integer, name is a String and gender is a boolean data
        // 
        // Postcondition: node is added to the tree and id, name and gender is set to the parameters of the object
        //-------------------------------------------------------
	    if (node == null) {
	        return new Employee(id, name, gender);
	    }

	    // traverse the tree
	    if (id < node.id) // insert in the left subtree
	        node.left = insertRecursively(node.left, id, name, gender);
	    else if (id > node.id) // insert in the right subtree
	        node.right = insertRecursively(node.right, id, name, gender);

	    return node;
	}

	
	public void deleteEmployee(int id) {
	    //--------------------------------------------------------
        // Summary: deleteEmployee() method uses deleteRecursively method to delete the object with specified id
        // 
        // Precondition: id is integer variable
        // 
        // Postcondition: object which has id is deleted from the BST.
        //-------------------------------------------------------
	    
		root= deleteRecursively(root, id);
		
	}
	
	int minValue(Employee root)  { 
	    //--------------------------------------------------------
        // Summary: This method takes the current root of the subtree and iteratively traverses the left children
        // until it reaches the leftmost leaf node, which has the minimum value.
        // 
        // Precondition: root is an object from Employee class
        // 

        // Postcondition: Returns the minimum value in the binary search tree
        //-------------------------------------------------------
	    
        //initially minval = root
        int minval = root.id; 
        //find minval
        while (root.left != null)  { 
            minval = root.left.id; 
            root = root.left; 
        } 
        return minval; 
    } 
	 
	 public Employee deleteRecursively(Employee root, int id)  { 
	    //--------------------------------------------------------
        // Summary:  DeleteRecursively is a method that deletes an item from the BST by using tree traversing.
        // The deleteRecursively method is a recursive function that performs the deletion operation. 
        // It takes two parameters: the current root of the subtree and the ID of the employee to be deleted.
        // 
        // Precondition: root is an object from Employee class and id is an integer variable
        // 

        // Postcondition: object deleted from the BST.
        //-------------------------------------------------------
        
        
        
	        //tree is empty
	        if (root == null)  return root; 
	   
	        //traverse the tree
	        if (id < root.id)     //traverse left subtree 
	            root.left = deleteRecursively(root.left, id); 
	        else if (id > root.id)  //traverse right subtree
	            root.right = deleteRecursively(root.right, id); 
	        else  { 
	            // node contains only one child
	            if (root.left == null) 
	                return root.right; 
	            else if (root.right == null) 
	                return root.left; 
	   
	            
	            root.id = minValue(root.right); 
	   
	            
	            root.right = deleteRecursively(root.right, root.id); 
	        } 
	        return root; 
	    } 
	 
	
	
	 
	public Employee searchEmployee2(int id)  { 
	    //--------------------------------------------------------
        // Summary: searchEmployee2 method takes an id as parameter and returns and Employee class object which contains the same in the parameter.
        // It uses searchRecursively method to traverse in the tree
        //
        // Precondition: id is an integer variable
        // 
        // Postcondition: returns the object with specified id. otherwise it returns and empty Employee object
        //-------------------------------------------------------
			Employee emptyObject = new Employee();
	        root = searchRecursively(root, id); 
	        if (root!= null) {
	        	
	        	return root;
	        }
	        	
	        	  
	        else
	            return emptyObject;
	    } 
	
	 
	 
	   
	    
	    public Employee searchRecursively(Employee root, int id)  { 
	    //--------------------------------------------------------
        // Summary: searcRecursively method takes an object from the BST and integer id as parameter.
        // Then the method traverse in the tree to find the item which contains the id
        //
        // Precondition:root is an item in BST and id is an integer variable
        // 
        // Postcondition: returns an Employee object which has the id in the parameter.
        //-------------------------------------------------------
	         
	        if (root==null || root.id==id) 
	            return root; 
	        
	        if (root.id > id) 
	            return searchRecursively(root.left, id); 
	        
	        return searchRecursively(root.right, id); 
	    } 
	    
	    
	   
	   
	    void inorder() {
	        //--------------------------------------------------------
            // Summary: inorder method uses inOrderRecursively method to print the items in ascending order based on their id.
            //
            //
            // Precondition: Takes no parameter
            // 
            // Postcondition: prints the BST in ascending order
            //-------------------------------------------------------
	        
	    	inorderRecursively(root);
	    }
	    
	    void inorderRecursively(Employee root) {
	        //--------------------------------------------------------
            // Summary: inOrderRecursively method is used to print the items in ascending order
            // 
            //
            // Precondition:root is an item in BST and id is an integer variable
            // 
            // Postcondition: returns an Employee object which has the id in the parameter.
            //-------------------------------------------------------
	    	if(root!= null) {
	    		inorderRecursively(root.left);
	    		System.out.println(root.id+" "+ root.name+" "+ (root.gender ? "Female" : "Male"));
	    		inorderRecursively(root.right);
	    	}
	    }
	    
	    
	   
	    
	    void ListAllEmployeWithRange(int range1, int range2) {
	        //--------------------------------------------------------
            // Summary: listAllEmployeeWithRange method is used to print the items in specified range.
            // 
            //
            // Precondition:range 1 and range 2 are integer variables that determines the range
            // 
            // Postcondition:
            //-------------------------------------------------------
            
	        boolean foundRecords = inorderByRange(root, range1, range2);
	        if (!foundRecords) {
	            System.out.println("No record found");
	        }
	    }

	    boolean inorderByRange(Employee root, int minRangeId, int maxRangeId) {
	        //--------------------------------------------------------
            // Summary: inOrderByRange method is used to print the items in specified range by using inorder travering.
            // 
            //
            // Precondition:root is an item in BST, minRangeId and maxRangeId are integer variables
            // 
            // Postcondition: returns an true if the item is in specified range, otherwise, it returns false
            //-------------------------------------------------------
	        if (root == null) {
	            return false;
	        }

	        boolean foundRecords = false;

	        if (root.id > minRangeId) {
	            foundRecords = inorderByRange(root.left, minRangeId, maxRangeId);
	        }

	        if (root.id >= minRangeId && root.id <= maxRangeId) {
	            System.out.println(root.id + " " + root.name + " " + (root.gender ? "Female" : "Male"));
	            foundRecords = true;
	        }

	        if (root.id < maxRangeId) {
	            foundRecords = inorderByRange(root.right, minRangeId, maxRangeId) || foundRecords;
	        }

	        return foundRecords;
	    }

	    
	   
	    		
	    	
	    }
		
	

	


