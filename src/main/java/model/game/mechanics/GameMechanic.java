package model.game.mechanics;

import model.game.settings.MenuSettings;
import model.game.results.GameResults;

public interface GameMechanic {
	GameResults play(MenuSettings settings);
}
