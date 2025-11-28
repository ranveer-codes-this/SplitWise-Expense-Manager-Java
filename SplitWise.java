import java.util.*;
import java.io.*;
class Split_Wise{
public static final java.util.Scanner INPUT = new java.util.Scanner(System.in);
public static void main(String Args[])  throws Exception{
Scanner sc = INPUT;
	
	String ly="Welcome to SPLIT - WISE ";
	
	int len=0;
	len=ly.length();
	for(int j=0;j<=len-1;j++){
			char character=ly.charAt(j);
			System.out.print(character);
			Thread.sleep(105);
       		}
	System.out.println();

	ly="The only TREASURER for your trip";
	len=ly.length();
	for(int j=0;j<=len-1;j++){
			char character=ly.charAt(j);
			System.out.print(character);
			Thread.sleep(95);
       		}
	System.out.println();	

while (true){
	System.out.println();
	System.out.println("Please choose from the below options to perform further operations :");
	System.out.println("1. Enter new users : ");
	System.out.println("2. Enter user expense :");
	System.out.println("3. Get expense details");
	System.out.println("4. RESET the Trip");
	System.out.println("5. EXIT THE PROGRAM");
	System.out.println();

	System.out.print("Enter choice : ");
	int choice;
	while (true) {                         
    	try {
        	choice = sc.nextInt();
        	sc.nextLine();                 
        	break;
    	} catch (InputMismatchException ime) {
        	sc.nextLine();
                System.out.print("Please enter a valid number: ");
    	       }
	}

	if(choice == 1){
		getuser get = new getuser();
        	get.createuser();
	}
	else if(choice == 2){
		Expenses.getExpense();
	}
	else if(choice == 3){
		calculate calc = new calculate();
		while (true){
			System.out.println();
			System.out.println("1. Trip Expense Details : ");
			System.out.println("2. Personal Expense Details :");
			System.out.println("3. Exit to Last Menu :");
			System.out.println();
			System.out.print("Enter choice : ");
			int ch;
			while (true) {                         
    			   try {
        			ch = sc.nextInt();
        			sc.nextLine();                 
        			break;
    			   } catch (InputMismatchException ime) {
        			sc.nextLine();
                		System.out.print("Please enter a valid number: ");
    	       			}
			}

			
			if(ch == 1){
				while (true){
					System.out.println("1. Total Trip Expense : ");
					System.out.println("2. Average Trip Expense : ");
					System.out.println("3. Minimum Expense Bearer : ");
					System.out.println("4. Maximum Expense Bearer : ");
					System.out.println("5. Expense Bearer Names(Ascending Ord.) : ");
					System.out.println("6. Exit to Last Menu :");
					System.out.println();
					System.out.print("Enter choice : ");
					int op;
					while (true) {                         
    					   try {
        					op = sc.nextInt();
        					sc.nextLine();                 
        					break;
    					   } catch (InputMismatchException ime) {
        					sc.nextLine();
                				System.out.print("Please enter a valid number: ");
    	       				   }
					}
				
					if(op == 1){
						calc.total_expense();
					}

					else if(op == 2){
						calc.avg_expense();
					}

					else if(op == 3){
						calc.min_expense_bearer();
					}

					else if(op == 4){
						calc.max_expense_bearer();
					}

					else if(op == 5){
						calc.ascending_expense_bearer_names();
					}

					else if(op == 6){
						System.out.println("Getting you to last menu...");
						break;
					}
			
					else{ System.out.println("ENTER VALID CHOICE !!!");
					}
				}
			}

			else if(ch == 2){
				while (true){
					System.out.println();
					System.out.println("1. Total Personal Expense : ");
					System.out.println("2. Personal Expense Sheet : ");
					System.out.println("3. Exit to Last Menu :");
					System.out.println();
					System.out.print("Enter choice : ");
					int option;
					while (true) {                         
    					   try {
        					option = sc.nextInt();
        					sc.nextLine();                 
        					break;
    					   } catch (InputMismatchException ime) {
        					sc.nextLine();
                				System.out.print("Please enter a valid number: ");
    	       				   }
					}

					if(option == 1){
						calc.pp_total();	
					}

					else if(option == 2){
						calc.pp_desc();	
					}
					else if(option == 3){
						System.out.println("Getting you to last menu...");
						break;
					}
			
					else{ System.out.println("ENTER VALID CHOICE !!!");
					}

				}
			}
			
			else if(ch == 3){
				System.out.println("Getting you to last menu...");
				break;
			}

			else{
				System.out.println("ENTER VALID CHOICE !!!");
			}
		}
	}

	else if(choice == 5){
		
		ly="Thank you for using our system.";
		len=0;
		len=ly.length();
		for(int j=0;j<=len-1;j++){
				char character=ly.charAt(j);
				System.out.print(character);
				Thread.sleep(105);
       			}
		System.out.println();

		ly="EXITING THE PROGRAM......";
		len=ly.length();
		for(int j=0;j<=len-1;j++){
				char character=ly.charAt(j);
				System.out.print(character);
				Thread.sleep(95);
       			}
		System.out.println();	
	
			break;
	}
	else if(choice == 4){
		reset r = new reset(); 
        	r.resetTrip();
	}

	else{
		System.out.println("ENTER VALID CHOICE !!!");
	}



}
}}