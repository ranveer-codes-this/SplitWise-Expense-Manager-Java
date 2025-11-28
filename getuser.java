import java.util.*;
import java.io.*;

public class getuser {
    public void createuser() throws IOException {
	Scanner sc = Split_Wise.INPUT;

        System.out.print("Enter number of members for trip: ");
        int users = sc.nextInt();
        //sc.nextLine();

        String[] fnames = new String[users];
        String[] unames = new String[users];

        for (int i = 0; i < users; i++) {
            System.out.print("Enter name of user " + (i + 1) + ": ");
            String uname = sc.next();
            unames[i] = uname;

            String fnm = uname + ".csv";
            fnames[i] = fnm;

            FileWriter writer = new FileWriter(fnm);
            writer.close();
        }

        FileWriter writedata = new FileWriter("data.csv");

        // write all usernames
        for (int i = 0; i < unames.length; i++) {
            writedata.write(unames[i] + ",");
        }

        // write all filenames on the same line (no newline)
        for (int i = 0; i < fnames.length; i++) {
            writedata.write(fnames[i] + ",");
        }

        writedata.close();
        //sc.close();
    }
}
