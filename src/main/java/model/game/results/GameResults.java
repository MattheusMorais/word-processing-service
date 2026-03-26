package model.game.results;

public class GameResults {
	private Integer hits;
	private Integer misses;
	private Integer score;


	public GameResults() {
		this.hits = 0;
		this.misses = 0;
	}

	public GameResults(int hits, int misses) {
		this.hits = hits;
		this.misses = misses;
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
		return "GameResults{" +
				"hits=" + hits +
				", misses=" + misses +
				", score=" + getScore() +
				'}';
	}
}
