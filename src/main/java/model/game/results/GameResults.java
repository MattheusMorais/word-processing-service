package model.game.results;

/**
 * Representa o resultado de uma partida.
 * Contém informações como jogador, acertos, erros, pontuação e data.
 */
public class GameResults {
	private String playerName;
	private Integer hits;
	private Integer misses;
	private Integer score;
	private String timeStampFormatted;

	public GameResults() {
		this.hits = 0;
		this.misses = 0;
	}

	public GameResults(String playerName, Integer hits, Integer misses, Integer score, String timeStampFormatted) {
		this.playerName = playerName;
		this.hits = hits;
		this.misses = misses;
		this.score = score;
		this.timeStampFormatted = timeStampFormatted;
	}

	public String getPlayerName() { return playerName; }

	public Integer getHits() {
		return hits;
	}

	public Integer getMisses() { return misses; }

	public Integer getScore() { return score; }

	public String getTimeStampFormatted() { return timeStampFormatted; }

	public void incrementHits(int hits) {
		this.hits += hits;
	}

	public void incrementMisses(int misses) {
		this.misses += misses;
	}

	/**
	 * Calcula a pontuação com base nos acertos e erros.
	 *
	 * @return pontuação calculada
	 */
	public Integer calculateScore() {
		return (200 * hits) + (-100 * misses);
	}

	@Override
	public String toString() {
		return "Nome do Jogador = '" + playerName + '\'' +
				", Acertos = " + hits +
				", Erros = " + misses +
				", Pontuação = " + score +
				", Horário = " + timeStampFormatted;
	}

	public void setPlayerName(String value) {
		this.playerName = value;
	}

	public void setTimeStampFormatted(String value) {
		this.timeStampFormatted = value;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
