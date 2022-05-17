package info.mastera.search.simple;

import info.mastera.generation.ListGeneration;
import info.mastera.search.SimpleSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class SimpleSearchTest {

    @Test
    public void searchWithPositiveResultTest() {
        var source = ListGeneration.generateSorted();
        var elementIndex = getElementToSearch(source);

        var resultToTest = new SimpleSearch<>(source)
                .search(source.get(elementIndex));
        Assertions.assertEquals(elementIndex, resultToTest);
    }

    @Test
    public void elementNotFoundTest() {
        var source = ListGeneration.generateSorted();
        var elementToSearch = source.size() + 2;// source.get(elementIndex);

        var resultToTest = new SimpleSearch<>(source)
                .search(elementToSearch);
        Assertions.assertEquals(-1, resultToTest);
    }

    private Integer getElementToSearch(List<Integer> source) {
        //noinspection PointlessArithmeticExpression
        return 0 + new Random().nextInt(source.size() - 0 + 1);
    }
}