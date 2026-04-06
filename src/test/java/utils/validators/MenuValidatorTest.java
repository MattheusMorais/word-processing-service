package utils.validators;

import exceptions.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MenuValidatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldAcceptValidOptions() {
        int[] validOptions = {1,2,3,4,5};

        for(int option : validOptions) {
            assertDoesNotThrow(() -> {MenuValidator.isOptionValid(option);});
        }
    }

    @Test
    void shouldThrowExceptionWhenOptionIsInvalid() {
        assertThrows(ValidationException.class, () -> {MenuValidator.isOptionValid(14);});
    }

    @Test
    void shouldAccept3LettersName() {
        assertDoesNotThrow(() -> {MenuValidator.isPlayerNameValid("abc");});
    }

    @Test
    void shouldThrowExceptionWhenPlayerNameIsTooShort() {
        assertThrows(ValidationException.class, () -> {MenuValidator.isPlayerNameValid("ss");});
    }

    @Test
    void shouldThrowExceptionWhenPlayerNameStartWithNumbers() {
        assertThrows(ValidationException.class, () -> {MenuValidator.isPlayerNameValid("1sss");});
    }

    @Test
    void shouldThrowExceptionWhenDifficultyOptionIsInvalid() {
        assertThrows(ValidationException.class, () -> {MenuValidator.isDifficultyValid(3);});
    }
}