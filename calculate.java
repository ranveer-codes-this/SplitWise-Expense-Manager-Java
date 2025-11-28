import java.util.*;
import java.io.*;
public class calculate{

	Scanner sc = Split_Wise.INPUT;	
	int tot_exp=0;

//----------------------------------------------------------------
String[] unames;
String[] fnames;
String[] asc_unames;

public calculate() throws Exception {

BufferedReader br=new BufferedReader(new FileReader("data.csv"));
    String line;
    String[] data = null;

    while((line=br.readLine())!=null){
        data = line.split(",");
    }

    unames = new String[data.length/2];   
    fnames = new String[data.length/2];

    for(int i=0; i <= (data.length/2)-1; i++){
        unames[i] = data[i];
    }
    
    for(int i=data.length/2, j=0; i <= data.length-1; i++, j++){
        fnames[j] = data[i];
    }
}
//-----------------------------------------------------------------

	void total_expense() throws IOException	{
		tot_exp=0;
             BufferedReader br=new BufferedReader(new FileReader("tot_Expense.csv"));
             String line;
             String[] data = null;
             	while((line=br.readLine())!=null){
             	data = line.split(",");
             	}
	for(int i=0;i<=data.length-1;i++){
		tot_exp += Integer.parseInt(data[i]);
	}
		br.close();
		System.out.println("Total Expense : "+ tot_exp);
	}
	
	//-----------------------------------------------------------------
	void avg_expense() throws IOException{
		total_expense();
		int avg= tot_exp/unames.length;
		System.out.println("Average trip Expense : "+ avg);	
	}

	//-----------------------------------------------------------------
	void pp_total() throws IOException{
		int pp_tot =0;
		System.out.print("Enter your name:");	
		String name = sc.next();

		String filename = null;

		for (int i = 0; i < unames.length; i++) {
    			if (unames[i].equalsIgnoreCase(name)) {
        		    filename = fnames[i];
        		    break;
    			}
		}

		if (filename == null) {
    			System.out.println("User not found!");
    			return;
		}

		System.out.println("File selected: " + filename);
		int[] expenses = ReadExpenses.getExpenses(filename);
		
		 for (int x : expenses) {
            		pp_tot += x;
      		 }
		System.out.println(name+"'s total expense : "+pp_tot);
	}

	//-----------------------------------------------------------------
	void pp_desc() throws IOException{

		System.out.print("Enter your name:");	
		String name = sc.next();

		String filename = null;

		for (int i = 0; i < unames.length; i++) {
    			if (unames[i].equalsIgnoreCase(name)) {
        		    filename = fnames[i];
        		    break;
    			}
		}

		if (filename == null) {
    			System.out.println("User not found!");
    			return;
		}

		System.out.println("File selected: " + filename);

		BufferedReader br = new BufferedReader(new FileReader(filename));
       		 String line;

               	System.out.printf("%-15s %-10s %-20s\n", "Date", "Amount", "Description");

        	while ((line = br.readLine()) != null) {
			
            		String[] parts = line.split(",");
			
			if (parts.length < 3) {
			        continue;
    			}

            		String date = parts[0];
            		String amount = parts[1];
            		String desc = parts[2];

		String amountWithSymbol = amount + "/-";
		System.out.printf("%-15s %-10s %-20s\n", date, amountWithSymbol, desc);
        	}

             br.close();

	}

	//-----------------------------------------------------------------
	void min_expense_bearer() throws IOException{
		
		asc_exp obj = new asc_exp();
		asc_unames = obj.asc_array(fnames, unames);		
		
		System.out.println("Minimum Expense Bearer : "+ asc_unames[0]);
	}

	//-----------------------------------------------------------------
	void max_expense_bearer() throws IOException{

		asc_exp obj = new asc_exp();
		asc_unames = obj.asc_array(fnames, unames);		

		System.out.println("Maximum Expense Bearer : " + asc_unames[asc_unames.length - 1]);
	}

	//-----------------------------------------------------------------
	void ascending_expense_bearer_names() throws IOException{

		asc_exp obj = new asc_exp();
		asc_unames = obj.asc_array(fnames, unames);		

		System.out.println("Min");
		System.out.println();
		for (int i = 0; i < asc_unames.length; i++) {
			System.out.println(asc_unames[i]);
		}
		System.out.println();
		System.out.println("Max");
	}

}