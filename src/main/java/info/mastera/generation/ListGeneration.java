package info.mastera.generation;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListGeneration {

    public static List<Integer> generateSorted() {
        var maxSize = 1_000_000;
        return IntStream.range(0, maxSize)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generateRandom(int maxListSize) {
        return new Random().ints(maxListSize, 1, maxListSize)
                .boxed()
                .distinct()
                .collect(Collectors.toList());
    }
}
