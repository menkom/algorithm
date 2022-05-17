package info.mastera.search;

import info.mastera.generation.GraphGeneration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BreadthFirstSearchTest {

    @Test
    public void noResultTest() {
        var source = GraphGeneration.generateNoResult();

        var resultToTest = new BreadthFirstSearch(source)
                .search();
        System.out.println("Found:" + resultToTest);
        Assertions.assertNull(resultToTest);
    }

    @Test
    public void withResultTest() {
        var source = GraphGeneration.generateWithResult();

        var resultToTest = new BreadthFirstSearch(source)
                .search();
        System.out.println("Found:" + resultToTest);
        Assertions.assertNotNull(resultToTest);
        Assertions.assertEquals("thom", resultToTest.getName());
    }

    @Test
    public void loopTest() {
        var source = GraphGeneration.generateLoop();

        var resultToTest = new BreadthFirstSearch(source)
                .search();
        System.out.println("Found:" + resultToTest);
        Assertions.assertNull(resultToTest);
    }
}