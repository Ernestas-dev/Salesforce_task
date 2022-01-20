import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ReadFile {

    /**
     * Takes data from orders.txt file <br>
     * Creates 2 patterns, to separate ID's and Item count <br>
     * Matches data <br>
     * Separates data <br>
     * Adds all data to List orderList <br>
     * @return data
     */

    public ArrayList<ArrayList<Integer>> ReturnList() {

        String file_path = "src/main/java/orders.txt";

        ArrayList<ArrayList<Integer>> orderList = new ArrayList<>();

        // Looks for patterns to separate ID's and Item count values
        orderList.add(new ArrayList<>());
        orderList.add(new ArrayList<>());
        try {
            File myObj = new File(file_path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                Pattern pattern_1 = Pattern.compile("\\D*(\\d+)\\D*");
                Pattern pattern_2 = Pattern.compile("[\\D]*[\\d]+[\\D]+([\\d]+)");

                Matcher matcher_1 = pattern_1.matcher(data);
                Matcher matcher_2 = pattern_2.matcher(data);

                // get ID's from file
                if (matcher_1.find()) {
                    String stringDigit = matcher_1.group(1);
                    int number_1 = Integer.parseInt(stringDigit);
                    orderList.get(0).add(number_1);
                }
                // get item_count from file
                if (matcher_2.find()) {
                    String stringDigit = matcher_2.group(1);
                    int number_2 = Integer.parseInt(stringDigit);
                    orderList.get(1).add(number_2);
                }

            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return orderList;

    }
}
