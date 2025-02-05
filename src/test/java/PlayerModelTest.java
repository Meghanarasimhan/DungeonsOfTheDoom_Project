import com.se459.model.PlayerModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerModelTest {
    private PlayerModel playerModel;

    @Before
    public void setUp() {
        playerModel = new PlayerModel(1, 2);
    }

    @Test
    public void testPlayerInitialization() {
        assertEquals("X coordinate is populated", 1, playerModel.getPositionX());
        assertEquals("Y coordinate is populated", 2, playerModel.getPositionY());
    }

    @Test
    public void testUpdatePlayerPosition() {
        playerModel.movePlayer(2, 3);
        assertEquals("X coordinate is updated", 2, playerModel.getPositionX());
        assertEquals("Y coordinate is updated", 3, playerModel.getPositionY());
    }
}
