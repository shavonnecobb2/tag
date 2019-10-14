import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.WorldBuilder;
import org.improving.tag.commands.SetCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class SetCommandTests {
    SetCommand target;
    TestInputOutput io;
    Game game;

    @BeforeEach
    public void arrange() {
        // Arrange
        io = new TestInputOutput();
        target = new SetCommand(io);
        game = mock(Game.class);

    }

    // TESTING EXECUTE***
    @Test
    public void execute_should_set_name() {
        Player player = new Player(null);
        player.setName("hi");
        player.setHitPoints(50);
        player = spy(player);
        when(game.getPlayer()).thenReturn(player);

        //Act
        target.execute("@set name=Fluefedor", game);

        //Assert
        verify(player).setName("Fluefedor");
    }


    @Test
    public void execute_should_display_all_words_but_set_name() {
        //Act
        target.execute("@set name=Fluefedor", game);

        //Assert
        assertEquals("Your name is now Fluefedor", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_set_name_with_spaces() {
        //Act
        target.execute("       @set name=Fluefedor   ", new Game(null, io, null, new WorldBuilder(null, null)));

        //Assert
        assertEquals("Your name is now Fluefedor", io.lastText);
    }

    // TESTING INPUT***
    @Test
    public void isValid_should_be_true_when_input_is_set_name() {
        // Act
        var result = target.isValid("@set name=name", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_set_name_with_spaces() {
        // Act
        var result = target.isValid("     @set name=name       ", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_set_name_with_caps() {
        // Act
        var result = target.isValid("@Set NamE=name", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {
        // Act
        var result = target.isValid("foobar", null);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_only_one_word() {
        // Act
        var result = target.isValid("move", null);

        // Assert
        assertFalse(result);
    }
}
