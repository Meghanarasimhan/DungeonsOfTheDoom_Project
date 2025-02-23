import com.se459.model.AquatorModel;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AquatorModelTest {

    private AquatorModel aquatorModel;

    @Before
    public void setUp() {
        aquatorModel = new AquatorModel();
    }

    @Test
    public void testInitialization() {
        assertEquals("Name is Aquator", "Aquator", aquatorModel.getName());
        assertEquals("Char is A", "A", aquatorModel.getScreenChar());
        assertEquals("X position is 0", 0, aquatorModel.getPositionX());
        assertEquals("Y position is 0", 0, aquatorModel.getPositionY());
        assertEquals("Carry is 0", 0, aquatorModel.getCarry());
        assertEquals("Flags are M", List.of("M"), aquatorModel.getFlags());
        assertEquals("Exp is 20", 20, aquatorModel.getExp());
        assertEquals("Level is 5", 5, aquatorModel.getLvl());
        assertEquals("Amr is 9", 9, aquatorModel.getAmr());
        assertEquals("Dmg is 0", 0, aquatorModel.getDmg());
        assertTrue("Hpt is greater than 0", aquatorModel.getHpt() > 0);
        assertEquals("Levels found is empty", 0, aquatorModel.getLevelsFound().size());
    }
}
