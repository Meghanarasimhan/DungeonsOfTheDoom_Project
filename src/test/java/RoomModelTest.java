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

}
