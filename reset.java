import java.io.*;
import java.nio.file.*;
import java.util.*;

public class reset {

    String[] fnames;

    public reset() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            String[] data = null;

            while ((line = br.readLine()) != null) {
                data = line.split(",");
            }

            if (data == null) throw new IllegalStateException("data.csv is empty or unreadable.");

            fnames = new String[data.length / 2];
            for (int i = data.length / 2, j = 0; i < data.length; i++, j++) {
                fnames[j] = data[i].trim();
            }
        }
    }

    public void resetTrip() {
        Scanner sc = Split_Wise.INPUT;

        System.out.println("Resetting the trip may lead to deletion of all stored data...");
        System.out.print("Are you sure you want to reset the trip (Yes/No): ");

        String ch = sc.next();
        if (!"YES".equalsIgnoreCase(ch.trim())) return;

        boolean anyFailure = false;

        // ----------------------------------------------------------------
        // 1. DELETE ALL DYNAMIC USER CSV FILES FIRST
        // ----------------------------------------------------------------
        for (String fnm : fnames) {
            if (fnm == null || fnm.isEmpty()) continue;

            Path p = Paths.get(fnm).toAbsolutePath();

            try {
                boolean deleted = Files.deleteIfExists(p);
                if (!deleted) anyFailure = true;
            } catch (Exception e) {
                anyFailure = true;
            }
        }

        // ----------------------------------------------------------------
        // 2. DELETE MAIN CSV FILES *AFTER* DYNAMIC FILES
        // ----------------------------------------------------------------
        try {
            boolean del2 = Files.deleteIfExists(Paths.get("tot_Expense.csv"));
            if (!del2) anyFailure = true;
        } catch (Exception e) {
            anyFailure = true;
        }

        // ----------------------------------------------------------------
        // 3. FINAL SINGLE OUTPUT MESSAGE
        // ----------------------------------------------------------------
        if (!anyFailure) {
            System.out.println("Trip data reset successfully.");
        } else {
            System.out.println("Some files could not be deleted. Please ensure files exist and are accessible.");
        }
    }
}
