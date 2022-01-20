import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AssetManagementTask implements OrchestrationTask {

    /**
     * Takes in data from orders.txt file <br>
     * Separates ID's and Item count <br>
     * Executes order ID's through setOrderIds() <br>
     * Executes order Items through setOrderItems() <br>
     * Creates txt file in path = "src/main/outputs/output.txt" with output<br>
     * @param data ID's and item_count
     * @throws IOException looks for exceptions
     */

    public void executeBatch(List data) throws IOException {

        StringBuilder output = new StringBuilder();

        // Create variables and add data for id_list and items_count
        List<Integer> id_list = (List) data.get(0);
        List<Integer> items_count = (List) data.get(1);

        // Execute methods and get output
        output.append(setOrderIds(id_list, items_count));
        output.append(setOrderItems(id_list, items_count));

        // Create output file in path = "src/main/outputs/output.txt"
        writeStringToFile(String.valueOf(output));

    }

    /**
     * Takes data from executeBranch() <br>
     * Appends to output order information <br>
     * @param id_list ID list
     * @param items_count items_count list
     * @return output String
     */

    public String setOrderIds(List<Integer> id_list, List<Integer> items_count) {
        Order [] Orders = new Order[id_list.size()];

        int i = 0;

        StringBuilder output = new StringBuilder("All orders: \n");

        for (Object id : id_list) {
            Orders[i] = new Order(items_count.get(i), (int)id);
            output.append("Order id: ").append(Orders[i].order_id).append(" | Item count: ").append(Orders[i].item_count).append("\n");
            i++;
        }

        return output.toString();
    }

    /**
     * Takes data from executeBranch() <br>
     * Appends to output order items information <br>
     * @param id_list ID list
     * @param items_count items_count list
     * @return output String
     */

    public String setOrderItems(List<Integer> id_list, List<Integer> items_count) {

        int count = 0;
        int j = 0;
        int product_id = 1;

        StringBuilder output = new StringBuilder("\nAll Items with IDs and dates: \n");

        for (Object items : items_count) {

            OrderItem [] Items = new OrderItem[(int) items];

            while (j < (int) items) {
                Items[j] = new OrderItem(id_list.get(count), product_id);
                output.append("ID: ").append(Items[j].product_id).append(" | Order_id: ").append(Items[j].order_id).append(" | Date: ").append(Items[j].provisioning_date).append("\n");

                j++;
                product_id++;
            }

            j = 0;
            count++;

            output.append("-------------------------------------- \n");
        }

        return output.toString();
    }

    /**
     * Creates output10.txt file <br>
     * Path = "src/main/outputs/output.txt"
     * @param data executeBranch() output
     * @throws IOException looks for exceptions
     */

    static void writeStringToFile(String data) throws IOException {

        String path = "src/main/outputs/output.txt";
        Files.write( Paths.get(path), data.getBytes());

    }
}

