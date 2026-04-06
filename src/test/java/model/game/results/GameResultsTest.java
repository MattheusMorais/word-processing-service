package model.game.results;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameResultsTest {
    private GameResults gr;

    @BeforeEach
    void setUp() {
        gr = new GameResults();
    }

    @Test
    void shouldIncrementHits() {
        int expected = gr.getHits() + 1;

        gr.incrementHits(1);
        int actual = gr.getHits();

        assertEquals(expected, actual);
    }

    @Test
    void shouldIncrementMisses() {
        int expected = gr.getMisses() + 1;

        gr.incrementMisses(1);

        int actual = gr.getMisses();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateScore() {
        gr.incrementHits(1);
        gr.incrementMisses(1);

        int expected = (200 * 1) + (-100 * 1);
        int actual = gr.calculateScore();

        assertEquals(expected, actual);
    }
}