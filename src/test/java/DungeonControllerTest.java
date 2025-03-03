import com.se459.controller.DungeonController;
import com.se459.model.DungeonModel;
import com.se459.model.FloorModel;
import com.se459.model.PlayerModel;
import com.se459.model.RoomModel;
import com.se459.view.DungeonView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.event.KeyEvent;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DungeonControllerTest {
    private DungeonController dungeonController;

    @Mock
    DungeonModel dungeonModel;

    @Mock
    DungeonView dungeonView;

    @Mock
    PlayerModel playerModel;

    @Mock
    KeyEvent keyEvent;

    @Mock
    RoomModel roomModel;

    @Mock
    FloorModel floorModel;

    @Before
    public void setUp() {
        dungeonController = new DungeonController(dungeonModel, dungeonView);
        when(dungeonModel.getPlayer()).thenReturn(playerModel);
        when(dungeonModel.getFloor(anyInt())).thenReturn(floorModel);
        when(floorModel.getRoom(anyInt())).thenReturn(roomModel);
    }

    @Test
    public void testPlayerCanMoveLeft() {
        when(playerModel.getPositionX()).thenReturn(2);
        when(playerModel.getPositionY()).thenReturn(2);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(false);

        dungeonController.keyPressed(keyEvent);

        verify(playerModel, times(1)).setPlayerPosition(1, 2);
    }

    @Test
    public void testPlayerCanMoveRight() {
        when(playerModel.getPositionX()).thenReturn(2);
        when(playerModel.getPositionY()).thenReturn(2);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(false);

        dungeonController.keyPressed(keyEvent);

        verify(playerModel, times(1)).setPlayerPosition(3, 2);
    }

    @Test
    public void testPlayerCanMoveUp() {
        when(playerModel.getPositionX()).thenReturn(2);
        when(playerModel.getPositionY()).thenReturn(2);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_UP);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(false);

        dungeonController.keyPressed(keyEvent);

        verify(playerModel, times(1)).setPlayerPosition(2, 1);
    }

    @Test
    public void testPlayerCanMoveDown() {
        when(playerModel.getPositionX()).thenReturn(2);
        when(playerModel.getPositionY()).thenReturn(2);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(false);

        dungeonController.keyPressed(keyEvent);

        verify(playerModel, times(1)).setPlayerPosition(2, 3);
    }

    @Test
    public void testPlayerCanMoveDownRightDiagonally() {
        when(playerModel.getPositionX()).thenReturn(3);
        when(playerModel.getPositionY()).thenReturn(3);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_N);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(false);

        dungeonController.keyPressed(keyEvent);

        verify(playerModel, times(1)).setPlayerPosition(4, 4);
    }

    @Test
    public void testPlayerCanMoveDownLeftDiagonally() {
        when(playerModel.getPositionX()).thenReturn(3);
        when(playerModel.getPositionY()).thenReturn(3);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_B);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(false);

        dungeonController.keyPressed(keyEvent);

        verify(playerModel, times(1)).setPlayerPosition(2, 4);
    }

    @Test
    public void testPlayerCanMoveUpRightDiagonally() {
        when(playerModel.getPositionX()).thenReturn(3);
        when(playerModel.getPositionY()).thenReturn(3);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_U);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(false);

        dungeonController.keyPressed(keyEvent);

        verify(playerModel, times(1)).setPlayerPosition(4, 2);
    }

    @Test
    public void testPlayerCanMoveUpLeftDiagonally() {
        when(playerModel.getPositionX()).thenReturn(3);
        when(playerModel.getPositionY()).thenReturn(3);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_Y);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(false);

        dungeonController.keyPressed(keyEvent);

        verify(playerModel, times(1)).setPlayerPosition(2, 2);
    }

    @Test
    public void testPlayerCannotMovePastWall() {
        when(playerModel.getPositionX()).thenReturn(2);
        when(playerModel.getPositionY()).thenReturn(2);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(true);

        dungeonController.keyPressed(keyEvent);

        verify(playerModel, times(0)).setPlayerPosition(anyInt(), anyInt());
    }

    @Test
    public void testViewIsUpdated() {
        when(playerModel.getPositionX()).thenReturn(2);
        when(playerModel.getPositionY()).thenReturn(2);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        when(roomModel.isWall(anyInt(), anyInt())).thenReturn(false);

        dungeonController.keyPressed(keyEvent);

        verify(dungeonView, times(1)).repaint();
    }
}
