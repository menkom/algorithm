package info.mastera.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort<T extends Comparable<T>> extends BasicSort<T> {

    public QuickSort(List<T> source) {
        super(source);
    }

    @Override
    protected List<T> getSorted() {
        return sort(getSource());
    }

    protected List<T> sort(List<T> toSort) {
        if (toSort.size() < 2) {
            return toSort;
        } else {
            if (toSort.size() == 2) {
                return toSort.get(0).compareTo(toSort.get(1)) < 1
                        ? toSort
                        : List.of(toSort.get(1), toSort.get(0));
            } else {
                var baseElement = toSort.get(0);
                var result = new ArrayList<T>(toSort.size());
                result.addAll(
                        sort(
                                toSort.subList(1, toSort.size())
                                        .stream()
                                        .filter(element -> element.compareTo(baseElement) < 1)
                                        .collect(Collectors.toList())
                        )
                );
                result.add(baseElement);
                result.addAll(
                        sort(
                                toSort.subList(1, toSort.size())
                                        .stream()
                                        .filter(element -> element.compareTo(baseElement) > 0)
                                        .collect(Collectors.toList())
                        )
                );
                return result;
            }
        }
    }
}
