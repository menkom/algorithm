package info.mastera.search;

import info.mastera.generation.ListGeneration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class BinarySearchTest {

    @Test
    public void searchWithPositiveResultTest() {
        var source = ListGeneration.generateSorted();
        var elementIndex = getElementToSearch(source);
        var elementToSearch = source.get(elementIndex);

        var resultToTest = new BinarySearch<>(source)
                .search(elementToSearch);
        Assertions.assertEquals(elementIndex, resultToTest);
    }

    @Test
    public void elementNotFoundTest() {
        var source = ListGeneration.generateSorted();
        var elementToSearch = source.size() + 2;

        var resultToTest = new BinarySearch<>(source)
                .search(elementToSearch);
        Assertions.assertEquals(-1, resultToTest);
    }

    @Test
    public void comparingSearchWithPositiveResultTest() {
        var source = ListGeneration.generateSorted();
        var elementIndex = getElementToSearch(source);
        var elementToSearch = source.get(elementIndex);

        var resultToTest = new SimpleSearch<>(source)
                .search(elementToSearch);
        Assertions.assertEquals(elementIndex, resultToTest);

        resultToTest = new BinarySearch<>(source)
                .search(elementToSearch);
        Assertions.assertEquals(elementIndex, resultToTest);
    }

    @Test
    public void comparingNotFoundTest() {
        var source = ListGeneration.generateSorted();
        var elementToSearch = source.size() + 2;

        var resultToTest = new SimpleSearch<>(source)
                .search(elementToSearch);
        Assertions.assertEquals(-1, resultToTest);

        resultToTest = new BinarySearch<>(source)
                .search(resultToTest);
        Assertions.assertEquals(-1, resultToTest);
    }

    private Integer getElementToSearch(List<Integer> source) {
        //noinspection PointlessArithmeticExpression
        return 0 + new Random().nextInt(source.size() - 0 + 1);
    }
}