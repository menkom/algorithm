package info.mastera.util;

import java.util.Collection;
import java.util.stream.Collectors;

public class CollectionToString {

    public static <T> String sourceToString(Collection<T> source) {
        return source.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

}
