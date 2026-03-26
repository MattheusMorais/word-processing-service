package model.game.settings;

import model.exceptions.ValidationException;

public class MenuSettings {
    private final int OPTION;
    private final String PLAYERNAME;
    private final int DIFFICULTY;

    public MenuSettings(int OPTION, String PLAYERNAME, int DIFFICULTY) {

        this.OPTION = OPTION;
        this.PLAYERNAME = PLAYERNAME;
        this.DIFFICULTY = DIFFICULTY;
    }

    public static void isOptionValid(int OPTION) {
        if (OPTION != 1 && OPTION != 2 ) {
            throw new ValidationException("Opção Inválida! Digite 1 ou 2.");
        }
    }

    public static void isPlayerNameValid(String PLAYERNAME) {
        if (PLAYERNAME.length() < 3) {
            throw new ValidationException("Nome inválido! O nome deve ter pelo menos 3 caracteres.");
        } else if (PLAYERNAME.matches("^\\d.*")) {
            throw new ValidationException("Nome inválido! O nome deve começar com letras.");
        }
    }

    public static void isDifficultyValid(int DIFFICULTY) {
        if (DIFFICULTY != 1 && DIFFICULTY != 2) {
            throw new ValidationException("Dificuldade Inválida! Digite 1 ou 2.");
        }
    }

    public int getOPTION() {
        return OPTION;
    }

    public String getPLAYERNAME() {
        return PLAYERNAME;
    }

    public int getDIFFICULTY() {
        return DIFFICULTY;
    }

}
