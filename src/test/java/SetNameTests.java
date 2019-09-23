import org.improving.tag.Game;
import org.improving.tag.commands.SetNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SetNameTests {
    SetNameCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        // Arrange
        io = new TestInputOutput();
        target = new SetNameCommand(io);
    }

    // TESTING EXECUTE***
    @Test
    public void execute_should_display_all_words_but_set_name() {
        //Act
        target.execute("@set name=Fluefedor", new Game(null, io));

        //Assert
        assertEquals("Your name is now Fluefedor", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_set_name_with_spaces() {
        //Act
        target.execute("       @set name=Fluefedor   ", new Game(null, io));

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
    public void isValid_should_be_false_when_input_is_null() {
        // Act
        var result = target.isValid(null, null);

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
