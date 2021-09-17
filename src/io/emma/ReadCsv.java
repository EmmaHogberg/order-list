package io.emma;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCsv {

    private static ArrayList<ArrayList<String>> wholeSheet = new ArrayList<>();
    private static final String COMMA_DELIMITER = ",";

    // Load CSV if wholeSheet is not empty
    public static ArrayList<ArrayList<String>> getWholeSheet() {
        if (wholeSheet.isEmpty()) {
            loadCSV();
        }
        return wholeSheet;
    }

    // Scan, read from file and add rows to wholeSheet
    public static void loadCSV() {

        try (Scanner scanner = new Scanner(new File("src/Orderlist.csv"));) {
            int i = 0;
            while (scanner.hasNextLine()) {
                wholeSheet.add(getRows(scanner.nextLine(), i));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read text in file and return row values
    private static ArrayList<String> getRows(String row, int i) {
        ArrayList<String> rowValues = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(row)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            rowValues.add(String.valueOf(i));

            while (rowScanner.hasNext()) {
                String currentCell = rowScanner.next();
                rowValues.add(currentCell);
            }
        }
        return rowValues;
    }
}
