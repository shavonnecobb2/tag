import org.improving.tag.commands.TeleportCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TeleportCommandTests {
    TeleportCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        // Arrange
        io = new TestInputOutput();
        target = new TeleportCommand(io);
    }

    // TESTING EXECUTE
    @Test
    public void execute_should_return_phrase() {
        // Act
        target.execute(null, null);

        // Assert
        assertEquals("You phase out of existence - have a nice trip!", io.lastText);
    }

    // TESTING INPUT
    @Test
    public void isValid_should_be_true_when_input_is_teleport() {
        // Act
        var result = target.isValid("teleport", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_teleport_with_spaces() {
        // Act
        var result = target.isValid("     teleport         ", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_teleport_with_caps() {
        // Act
        var result = target.isValid("teLEPorT", null);

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
    public void isValid_should_be_false_when_input_is_null() {
        // Act
        var result = target.isValid(null, null);

        // Assert
        assertFalse(result);
    }
}
