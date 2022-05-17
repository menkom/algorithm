package info.mastera.search;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class BasicSearch<T> {

    List<T> source;

    public BasicSearch(List<T> source) {
        this.source = source;
        System.out.println("source.size=" + source.size() + " for " + this.getClass().getSimpleName());
//        System.out.println(sourceToString());
    }

    public final int search(T toFind) {
        return measure(this::find, toFind);
    }

    protected abstract int find(@NonNull T toFind);

    private int measure(Function<T, Integer> method, T toFind) {
        var eventStart = LocalDateTime.now();
        try {
            return method.apply(toFind);
        } finally {
            System.out.println("Search for " + toFind + " took " + ChronoUnit.MILLIS.between(eventStart, LocalDateTime.now()));
        }
    }

    protected boolean isEqual(T currentElement, T elementToFind) {
        return currentElement != null && currentElement.equals(elementToFind);
    }

    private String sourceToString() {
        return getSource().stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }
}
