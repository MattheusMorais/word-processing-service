package model.game.validators;

import model.exceptions.ValidationException;

public final class MenuValidator {
    private MenuValidator(){}

    public static void isOptionValid(int option) {
        if (option != 1 && option != 2 && option != 3 && option != 4  && option != 5) {
            throw new ValidationException("Opção Inválida! Digite 1, 2, 3, 4 ou 5.");
        }
    }

    public static void isPlayerNameValid(String playerName) {
        if (playerName.length() < 3) {
            throw new ValidationException("Nome inválido! O nome deve ter pelo menos 3 caracteres.");
        } else if (playerName.matches("^\\d.*")) {
            throw new ValidationException("Nome inválido! O nome deve começar com letras.");
        }
    }

    public static void isDifficultyValid(int difficulty) {
        if (difficulty != 1 && difficulty != 2) {
            throw new ValidationException("Dificuldade Inválida! Digite 1 ou 2.");
        }
    }
}
