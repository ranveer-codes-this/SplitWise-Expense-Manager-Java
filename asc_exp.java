import java.io.*;
class asc_exp {

    public String[] asc_array(String[] fnames, String[] unames) throws IOException {

        // minimal change: create an expenses slot per file/user
        int[] expenses = new int[fnames.length];

        for (int i = 0; i < fnames.length; i++) {
            String filename = fnames[i];
            // assume getExpenses returns int[] of entries for that file
            int[] fileExpenses = ReadExpenses.getExpenses(filename);
            int total = 0;
            if (fileExpenses != null) {
                for (int v : fileExpenses) total += v; // sum entries -> one total per file
            }
            expenses[i] = total;
        }

        String[] asc_unames = new String[unames.length];

        for (int i = 0; i < unames.length; i++) {
            asc_unames[i] = unames[i];
        }

        for (int i = 0; i < expenses.length - 1; i++) {
            for (int j = 0; j < expenses.length - i - 1; j++) {

                if (expenses[j] > expenses[j + 1]) {

                    int tempExp = expenses[j];
                    expenses[j] = expenses[j + 1];
                    expenses[j + 1] = tempExp;

                    String tempName = asc_unames[j];
                    asc_unames[j] = asc_unames[j + 1];
                    asc_unames[j + 1] = tempName;
                }
            }
        }

        return asc_unames;
    }
}
