package info.mastera.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DijkstraSearchTest {

    @Test
    public void noSolutionTest() {
        var resultToTest = new DijkstraSearch(new int[][]{{1, 2, 1}}, 2)
                .find(2);

        Assertions.assertEquals(-1, resultToTest);
    }

    @Test
    public void solutionExistsTest() {
        var resultToTest = new DijkstraSearch(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4)
                .find(2);
        Assertions.assertEquals(3, resultToTest);

        resultToTest = new DijkstraSearch(new int[][]{{1, 2, 1}}, 2)
                .find(1);
        Assertions.assertEquals(1, resultToTest);

        // https://habr.com/ru/post/111361/
        resultToTest = new DijkstraSearch(new int[][]{{1, 2, 10}, {1, 3, 30}, {1, 4, 50}, {1, 5, 10},
                {3, 5, 10}, {4, 2, 40}, {4, 3, 20}, {5, 1, 10}, {5, 3, 10}, {5, 4, 30}}, 5)
                .find(1);
        Assertions.assertEquals(60, resultToTest);
    }
}