package info.mastera.search;


import lombok.NonNull;

import java.util.List;

public class SimpleSearch<T> extends BasicSearch<T> {

    public SimpleSearch(List<T> source) {
        super(source);
    }

    @Override
    protected int find(@NonNull T toFind) {
        for (int index = 0; index < getSource().size(); index++) {
            var currentElement = getSource().get(index);
            if (isEqual(currentElement, toFind)) {
                System.out.println("Element " + toFind + " found on index " + index);
                return index;
            }
        }
        System.out.println("Element " + toFind + " not found.");
        return -1;
    }
}
