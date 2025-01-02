package info.mastera.practice.parent_child_relationship;

import java.util.HashSet;
import java.util.Set;

public class Ancestors {

    private final FamilyRelations familyRelations;

    public Ancestors(int[][] relations) {
        this.familyRelations = new FamilyRelations(relations);
    }

    /**
     * Write a function that, for two given individuals in our dataset, returns true if and only if they share at least one known ancestor.
     * [3,8]=>false
     * [5,8]=>true
     * [6,8]=>true
     */
    public boolean hasCommonAncestor(int child1, int child2) {
        var intersection = new HashSet<>(getAncestors(child1));
        intersection.retainAll(getAncestors(child2));
        return !intersection.isEmpty();
    }

    public Set<Integer> getAncestors(int child) {
        var parents = familyRelations.getChildWithParents().get(child);
        if (parents == null || parents.isEmpty()) {
            return Set.of(child);
        } else {
            Set<Integer> alreadyAncestors = new HashSet<>(parents);
            alreadyAncestors.add(child);
            for (Integer parent : parents) {
                alreadyAncestors.addAll(getAncestors(parent));
            }
            return alreadyAncestors;
        }
    }
}
