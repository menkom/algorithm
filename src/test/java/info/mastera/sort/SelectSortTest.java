package info.mastera.sort;

import info.mastera.generation.ListGeneration;
import info.mastera.util.CollectionToString;
import org.junit.jupiter.api.Test;

public class SelectSortTest {

    @Test
    public void searchForSmallestTest() {
        var source = ListGeneration.generateRandom(7);

        var smallestIndex = new SelectSort<>(source).findSmallestIndex(source);
        System.out.println("index=" + smallestIndex + "; smallest=" + source.get(smallestIndex));
    }

    @Test
    public void sortTest() {
        var source = ListGeneration.generateRandom(7);

        var sortedCollection = new SelectSort<>(source).sort();

        System.out.println(CollectionToString.sourceToString(sortedCollection));
    }
}