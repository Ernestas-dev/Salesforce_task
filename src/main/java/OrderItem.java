import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class OrderItem {

    int order_id;
    int product_id;
    String provisioning_date;

    // OrderItem constructor
    public OrderItem(int order_id, int product_id) {
        this.order_id = order_id;
        this.provisioning_date = this.get_provisioning_date();
        this.product_id = product_id;
    }

    /**
     * When executed <br>
     * @return provisioning date
     */

    public String get_provisioning_date() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }
}