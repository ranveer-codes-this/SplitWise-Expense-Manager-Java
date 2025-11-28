import java.util.Scanner;
public class getLine {

    public static String getMultiLineInput() {
        Scanner sc = Split_Wise.INPUT; // use the shared scanner; DO NOT close it
        StringBuilder buffer = new StringBuilder();

        while (true) {
            // read next line (blocking). We assume caller ensured Scanner exists.
            String line;
            try {
                line = sc.nextLine();
            } catch (Exception e) {
                // if input is exhausted unexpectedly, stop gracefully
                break;
            }
            if (line == null) break;
            if ("END".equalsIgnoreCase(line.trim())) break;
            buffer.append(line).append(System.lineSeparator());
        }

        return buffer.toString().trim();
    }
}
