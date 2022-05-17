package info.mastera.sort;

import info.mastera.generation.ListGeneration;
import info.mastera.search.SimpleSearch;
import info.mastera.util.CollectionToString;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    public void sortTest() {
        var source = ListGeneration.generateRandom(7);

        var sortedCollection = new QuickSort<>(source).sort();

        System.out.println(CollectionToString.sourceToString(sortedCollection));
    }

    @Test
    public void sortCompareTest() {
        var source = ListGeneration.generateRandom(1_000);

        var sortedCollection = new SelectSort<>(source).sort();
        System.out.println(CollectionToString.sourceToString(sortedCollection));

        sortedCollection = new QuickSort<>(source).sort();
        System.out.println(CollectionToString.sourceToString(sortedCollection));
    }
}