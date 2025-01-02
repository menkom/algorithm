package info.mastera.practice.parent_child_relationship.storage;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to store child-parent relations
 */
//@Service//We can use @Repository but no connection to database to wrap exceptions
@Getter
public class FamilyRelationsStorage {

    private final Map<Integer, List<Integer>> childWithParents;

    public FamilyRelationsStorage() {
        childWithParents = new HashMap<>();
    }

    public void setChildWithParents(int[][] relations) {
        childWithParents.clear();
        for (int[] relation : relations) {
            int parent = relation[0];
            int child = relation[1];
            childWithParents.putIfAbsent(parent, new ArrayList<>());
            childWithParents.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
        }
    }
}
