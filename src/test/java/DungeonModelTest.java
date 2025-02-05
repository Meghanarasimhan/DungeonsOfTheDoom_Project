import com.se459.model.DungeonModel;
import com.se459.model.FloorModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DungeonModelTest {
    private DungeonModel dungeonModel;
    private FloorModel floorModel;

    @Before
    public void setUp() {
        dungeonModel = new DungeonModel();
        floorModel = dungeonModel.getFloors().get(0);
    }

    @Test
    public void testDungeonInitialzation(){
        assertEquals("Dungeon should have exactly one floor for now",1, dungeonModel.getNumFloors());
        assertEquals("Dungeons should have only one floor in the list", 1, floorModel.getNumRooms());

        assertNotNull("Floor should not be null", dungeonModel.getFloors().get(0));
        assertNotNull("Floors can be accessed individually", dungeonModel.getFloor(0));
        assertNotNull("Player should not be null", dungeonModel.getPlayer());
    }

    @Test
    public void testFloorInitialization(){

        assertEquals("Floor should have one room for now", 1, floorModel.getNumRooms());
        assertEquals("Floor should have one room in the list",1,floorModel.getRooms().size());
        assertNotNull("Floor should not be null", floorModel.getRooms().get(0));
        assertNotNull("Rooms in a floor can be fetched", floorModel.getRoom(0));
    }

    @Test
    public void testAddingFloor() {
        assertEquals("Dungeon should have one floor for now", 1, dungeonModel.getNumFloors());

        dungeonModel.addFloor();

        assertEquals("Dungeon should have two floors now", 2, dungeonModel.getNumFloors());
    }
}
