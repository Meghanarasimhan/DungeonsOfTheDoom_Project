import com.se459.DungeonOfTheDoomApp;
import com.se459.view.DungeonView;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DungeonOfTheDoomAppTest {
    @Test
    public void testApplicationLoadsSuccessfully() throws InterruptedException {
        DungeonOfTheDoomApp dungeonOfTheDoomApp = new DungeonOfTheDoomApp();
        assertNotNull(dungeonOfTheDoomApp);

        System.setProperty("java.awt.headless", "true");
        DungeonOfTheDoomApp.main(new String[]{});
        Thread.sleep(2000);
        DungeonOfTheDoomApp.shutdown();
    }
}
