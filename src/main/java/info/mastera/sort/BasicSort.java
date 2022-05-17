package info.mastera.sort;

import info.mastera.util.CollectionToString;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class BasicSort<T> {

    List<T> source;

    public BasicSort(List<T> source) {
        if (source == null) {
            throw new IllegalStateException("Source collection can't be null");
        }
        this.source = source;
        System.out.println("source.size=" + source.size() + " for " + this.getClass().getSimpleName());
        System.out.println(CollectionToString.sourceToString(getSource()));
    }

    public final List<T> sort() {
        return measure(this::getSorted);
    }

    protected abstract List<T> getSorted();

    private List<T> measure(Supplier<List<T>> method) {
        var eventStart = LocalDateTime.now();
        try {
            return method.get();
        } finally {
            System.out.println("Sort process took " + ChronoUnit.MILLIS.between(eventStart, LocalDateTime.now()));
        }
    }
}
