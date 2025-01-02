package info.mastera.practice.parent_child_relationship.service;

import info.mastera.practice.parent_child_relationship.storage.FamilyRelationsStorage;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
//@Service
public class RelationsService {

    private final FamilyRelationsStorage familyRelations;

    public void setRelations(int[][] relations) {
        familyRelations.setChildWithParents(relations);
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

    public boolean hasCommonAncestor(int child1, int child2) {
        var intersection = new HashSet<>(getAncestors(child1));
        intersection.retainAll(getAncestors(child2));
        return !intersection.isEmpty();
    }

    public Set<Integer> getAncestors(int child) {
        var parents = familyRelations.getChildWithParents().get(child);
        if (Objects.isNull(parents) || parents.isEmpty()) {
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
