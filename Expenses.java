import java.io.*;
import java.util.*;
class Expenses{
public static void getExpense() throws IOException{
Scanner sc = Split_Wise.INPUT;
//------------------------------------------------------------------------
BufferedReader br=new BufferedReader(new FileReader("data.csv"));
    String line;
    String[] data = null;

    while((line=br.readLine())!=null){
        data = line.split(",");
    }

    String[] unames = new String[data.length/2];   
    String[] fnames = new String[data.length/2];

    for(int i=0; i <= (data.length/2)-1; i++){
        unames[i] = data[i];
    }
    
    for(int i=data.length/2, j=0; i <= data.length-1; i++, j++){
        fnames[j] = data[i];
    }
//-----------------------------------------------------------------
    
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

//-------------------------------------------------------------
	FileWriter WExp=new FileWriter("tot_Expense.csv",true);
	FileWriter fw =new FileWriter(filename,true);

            System.out.print("Enter expense date: ");
            String date = sc.next();

            System.out.print("Enter expense: ");
            int exp = sc.nextInt();

	    System.out.print("Enter Description : ");
	    System.out.print("---- NOTE*: After typing description press enter and type END ---- ");
	    String desc=getLine.getMultiLineInput();
	
//---------------------------------------------------------------

//Entering data to file
	   fw.write(date + "," + exp + "," + desc);
		fw.write(System.lineSeparator());
	   WExp.write(exp+",");
System.out.println("Data saved Successfully");
fw.close();
//sc.close();
WExp.close();	
}}