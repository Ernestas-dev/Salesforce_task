import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // Execute orders.txt file
        ReadFile newFile = new ReadFile();
        List data = newFile.ReturnList();

        // Execute app
        AssetManagementTask newAsset = new AssetManagementTask();
//        newAsset.executeBatch(data);

    }

}
