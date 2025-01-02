package info.mastera.practice.parent_child_relationship;

import java.util.Map;

/**
 * Suppose we have some input data describing relationships between nodes over multiple generations.
 * The input data is formatted as a list of (parent, child) pairs,
 * where each individual is assigned a unique integer identifier.
 * <p>
 * For example, in this diagram, 3 is a child of 10 and 2, and 5 is a child of 4:
 * <p>
 * •10  2  4
 * ••\ /  / \
 * •••3  5   8
 * ••••\/ \   \
 * ••••6  7   9
 * <p>
 * int[][] parentChildPairs = new int[][] {{10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}}
 * <p>
 * Write a function that takes this data as input and returns two collections:
 * • one containing all individuals with zero known parents, and
 * • one containing all individuals with exactly one known parent.
 * Sample output for the sample graph
 * Zero parents: 10, 2, 4
 * One parent: 5, 7, 8, 9
 * <p>
 * Clarifications
 * • Please do not implement your solution in the main function.
 * • Output order is irrelevant.
 * • The IDs are not guaranteed to be contiguous.
 * • The input is not necessarily a connected graph. There may be >3 generations.
 * • No node in the input set will have more than two parents, nor will there be duplicate entries.
 * • No node in the input is their own parent.
 * • There are no cycles in the input.
 * • No node may appear twice via different ancestry paths from the same descendant.
 * That is, individual A may not be descended from individual B through both of the separate individuals C and D.
 */
public class FilteredParents {

    // If that was only task to get items with one or no parent then we can store a number of parents as only one value.
    // But according to Task 2 we need to find ancestors so it is useful to store parents numbers

    private final FamilyRelations familyRelations;

    public FilteredParents(int[][] relations) {
        this.familyRelations = new FamilyRelations(relations);
    }

    private int[] getByParentsCount(int parentsCount) {
        return familyRelations.getChildWithParents().entrySet().stream()
                .filter(entry -> entry.getValue().size() == parentsCount)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public int[] getWithoutParents() {
        return getByParentsCount(0);
    }

    public int[] getWithOneParent() {
        return getByParentsCount(1);
    }

    public int[][] noParentsOneParent() {
        return new int[][]{
                getWithoutParents(),
                getWithOneParent()
        };
    }
}
