import com.se459.model.RoomModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomModelTest {
    private RoomModel roomModel;

    @Before
    public void setUp() {
        roomModel = new RoomModel();
    }

    @Test
    public void testRoomDimensionsWithinRange() {
        assertTrue("Room length should be between 1 and 100", roomModel.getLength() >= 1 && roomModel.getLength() <= 100);
        assertTrue("Room width should be between 1 and 100", roomModel.getWidth() >= 1 && roomModel.getWidth() <= 100);
    }

    @Test
    public void testNumSpacesCalculation() {
        int expectedNumSpaces = roomModel.getLength() * roomModel.getWidth();
        assertEquals("Number of spaces should equal length * width", expectedNumSpaces, roomModel.getNumSpaces());
    }

    @Test
    public void testGetCellValue() {
        assertTrue("A room cell is either a # or a .", roomModel.getCell(1,1) == '#' ||
                roomModel.getCell(1,1) == '.');
    }

    @Test
    public void testIsWallValue() {
        assertTrue("Room edges are walls", roomModel.isWall(0,0));
        assertFalse("There are no walls in the middle of the room", roomModel.isWall(1,1));
    }
    @Test
    public void testRoomCenterIsNotWall() {
        int midX = roomModel.getWidth() / 2;
        int midY = roomModel.getLength() / 2;
        assertFalse(roomModel.isWall(midX, midY));
    }

    @Test
    public void testMonsterGeneration() {
        assertNotNull(roomModel.getMonsterModel());
    }

}
