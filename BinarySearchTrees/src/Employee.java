//-----------------------------------------------------
// Title: Employee class
// Author: Ozan Alp Sarýdoðan
// ID: 12955096052
// Section: 1
// Assignment: 3
// Description: This class represents the object type that we store in the BST
//-------------------------------------

public class Employee {

	int id;
	String name;
	boolean gender;
	Employee left;
	Employee right;
	
	Employee(int id, String name, boolean gender){
		this.id=id;
		this.name=name;
		this.gender=gender;
		
		
	}
	
	Employee(int id){
		this.id=id;
	}
	
	Employee(){
		
	}
	
}
