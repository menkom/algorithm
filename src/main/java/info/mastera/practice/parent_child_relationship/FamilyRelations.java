package info.mastera.practice.parent_child_relationship;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class FamilyRelations {

    private final Map<Integer, List<Integer>> childWithParents;

    public FamilyRelations(int[][] relations) {
        childWithParents = buildChildWithParents(relations);
    }

    private Map<Integer, List<Integer>> buildChildWithParents(int[][] relations) {
        final HashMap<Integer, List<Integer>> result = new HashMap<>();
        for (int[] relation : relations) {
            int parent = relation[0];
            int child = relation[1];
            result.putIfAbsent(parent, new ArrayList<>());
            var parents = result.getOrDefault(child, new ArrayList<>());
            parents.add(parent);
            result.put(child, parents);
        }
        return result;
    }
}
