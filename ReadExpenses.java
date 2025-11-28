import java.io.*;
import java.util.*;

public class ReadExpenses{

    public static int[] getExpenses(String fileName) throws IOException {

        List<Integer> expenseList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = br.readLine()) != null) {
		if (line == null || line.trim().isEmpty()) {
    		continue;   // skip empty lines
		}

		String[] parts = line.split(",");

	if (parts.length < 2) {
    		continue;
	}
            int expense = Integer.parseInt(parts[1].trim());
            expenseList.add(expense);
        }

        br.close();

        return expenseList.stream().mapToInt(i -> i).toArray();
    }
}
