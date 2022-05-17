package info.mastera.search;

import lombok.NonNull;

import java.util.List;

/**
 * Binary search works only on sorted collections and with comparable objects
 */
public class BinarySearch<T extends Comparable<T>> extends BasicSearch<T> {

    public BinarySearch(List<T> source) {
        super(source);
    }

    @Override
    protected int find(@NonNull T toFind) {
        var low = 0;
        var high = getSource().size() - 1;
        while (low <= high) {
            var middle = (high + low) / 2;
            var currentElement = getSource().get(middle);
            if (isEqual(currentElement, toFind)) {
                System.out.println("Element " + toFind + " found on index " + middle);
                return middle;
            } else {
                if (currentElement.compareTo(toFind) < 0) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        System.out.println("Element " + toFind + " not found.");
        return -1;
    }
}
