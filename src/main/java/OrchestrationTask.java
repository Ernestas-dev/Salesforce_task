import java.io.IOException;
import java.util.List;

public interface OrchestrationTask {

    void executeBatch(List data )  throws IOException;

}