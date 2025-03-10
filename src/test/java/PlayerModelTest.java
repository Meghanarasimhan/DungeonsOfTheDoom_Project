import com.se459.model.PlayerModel;
import com.se459.model.RoomModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerModelTest {
    private PlayerModel playerModel;
    private RoomModel roomModel;

    @Before
    public void setUp() {
        roomModel = new RoomModel();
        playerModel = new PlayerModel(roomModel);
    }

    @Test
    public void testPlayerInitialization() {
        int x = playerModel.getPositionX();
        int y = playerModel.getPositionY();
        assertTrue("Player X coordinate is within room bounds", x > 0 && x < roomModel.getWidth() - 1);
        assertTrue("Player Y coordinate is within room bounds", y > 0 && y < roomModel.getLength() - 1);
        assertTrue("Player is not on a wall", !roomModel.isWall(x, y));
    }

    @Test
    public void testUpdatePlayerPosition() {
        playerModel.setPlayerPosition(2, 3);
        assertEquals("X coordinate is updated", 2, playerModel.getPositionX());
        assertEquals("Y coordinate is updated", 3, playerModel.getPositionY());
    }
}
