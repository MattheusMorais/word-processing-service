package model.game.results;

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

	public GameResults(int hits, int misses) {
		this.hits = hits;
		this.misses = misses;
	}

	public GameResults(String playerName, Integer hits, Integer misses, Integer score, String timeStampFormatted) {
		this.playerName = playerName;
		this.hits = hits;
		this.misses = misses;
		this.score = score;
		this.timeStampFormatted = timeStampFormatted;
	}

	public Integer getHits() {
		return hits;
	}

	public void incrementHits(int hits) {
		this.hits += hits;
	}

	public Integer getMisses() { return misses; }

	public void incrementMisses(int misses) {
		this.misses += misses;
	}

	public Integer getScore() {
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
}
