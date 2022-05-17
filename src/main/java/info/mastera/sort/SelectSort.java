package info.mastera.sort;

import info.mastera.util.CollectionToString;

import java.util.ArrayList;
import java.util.List;

public class SelectSort<T extends Comparable<T>> extends BasicSort<T> {

    public SelectSort(List<T> source) {
        super(source);
    }

    @Override
    protected List<T> getSorted() {
        var workingSource = new ArrayList<>(List.copyOf(getSource()));
        var result = new ArrayList<T>();
        while (workingSource.size() > 0) {
            var smallest = findSmallestIndex(workingSource);
            result.add(workingSource.remove(smallest));
        }
//        System.out.println("Result=" + CollectionToString.sourceToString(getSource()));
//        System.out.println("size= " + getSource().size() + ";");
        return result;
    }

    protected int findSmallestIndex(List<T> sourceToSearch) {
        var smallestElementIndex = 0;
        for (int index = 1; index < sourceToSearch.size(); index++) {
            if (sourceToSearch.get(index).compareTo(sourceToSearch.get(smallestElementIndex)) < 0) {
                smallestElementIndex = index;
            }
        }
        return smallestElementIndex;
    }
}
