//-----------------------------------------------------
// Title: Main test class
// Author: Ozan Alp Sarýdoðan
// ID: 12955096052
// Section: 1
// Assignment: 3
// Description: This class is used to test and printed the expected output.
//-------------------------------------
import java.util.Scanner;

public class Main extends BST {

    public static void main(String[] args) {

        BST tree = new BST();
        Scanner input = new Scanner(System.in);

        int Insert = 1;
        int Delete = 2;
        int search = 3;
        int List = 4;
        int ListWithRange = 5;
        int quit = 6;
        int i =0;
        
        while(i!=6) {
            System.out.println("Enter operation code: ");
            int no = input.nextInt();
            input.nextLine(); // Consume the newline character

            if (no == 1) {
                System.out.println("Enter information: ");
                String input1 = input.nextLine();
                String[] parts = input1.split(" ");

                String part1 = parts[0];  //id
                String part2 = parts[1];  //name
                String part3 = parts[2];  //gender

                int id = Integer.parseInt(part1);
                boolean gender = true;

                if (part3.equals("Male")) {
                    gender = false;
                } else if (part3.equals("Female")) {
                    gender = true;
                }

                tree.insertEmployee(id, part2, gender);
            }
            
            if (no == 2) {
                System.out.println("Enter ID to be deleted: ");
                int deletedId = input.nextInt();
                input.nextLine(); // Consume the newline character

                tree.deleteEmployee(deletedId);
            }
            
            if (no == 3) {
                System.out.println("Enter ID to be searched: ");
                int idForSearch = input.nextInt();
                input.nextLine(); // Consume the newline character

                Employee exist = tree.searchEmployee2(idForSearch);

                if (exist.id == idForSearch) {
                    if (exist.gender == false) {
                        System.out.println(exist.id + " " + exist.name + " " + "Male");
                    } else if (exist.gender == true) {
                        System.out.println(exist.id + " " + exist.name + " " + "Female");
                    }
                } else {
                    System.out.println("No record found.");
                }
            }
            
            if (no == 4) {
                tree.inorder();
            }
            
            if (no == 5) {
                System.out.println("Enter bounds of range: ");
                String bounds = input.nextLine();

                String rangeHolder[] = bounds.split(" ");
                int range1 = Integer.parseInt(rangeHolder[0]);
                int range2 = Integer.parseInt(rangeHolder[1]);
                tree.ListAllEmployeWithRange(range1, range2);
                
                
               
                
                
            }
            
            if (no == 6) {
            	
            	
                System.out.println("Stopped!");
                break;
            }
        }
    }
}
