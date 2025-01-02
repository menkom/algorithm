package info.mastera.practice.parent_child_relationship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class FamilyRelationsTest {

    @Test
    void emptyRelationsTest() {
        var resultToTest = new FamilyRelations(new int[][]{});

        Assertions.assertNotNull(resultToTest);
        Assertions.assertNotNull(resultToTest.getChildWithParents());
        Assertions.assertTrue(resultToTest.getChildWithParents().isEmpty());
    }

    @Test
    void oneParentRelationsTest() {
        var resultToTest = new FamilyRelations(new int[][]{{10, 3}});

        Assertions.assertNotNull(resultToTest);
        Assertions.assertNotNull(resultToTest.getChildWithParents());
        Assertions.assertEquals(Map.of(3, List.of(10), 10, List.of()), resultToTest.getChildWithParents());
    }

    @Test
    void twoIndependentAncestorsTest() {
        var resultToTest = new FamilyRelations(new int[][]{{10, 3}, {2, 4}});

        Assertions.assertNotNull(resultToTest);
        Assertions.assertNotNull(resultToTest.getChildWithParents());
        Assertions.assertEquals(
                Map.of(
                        3, List.of(10),
                        10, List.of(),
                        4, List.of(2),
                        2, List.of()),
                resultToTest.getChildWithParents());
    }

    @Test
    void twoParentsForChildTest() {
        var resultToTest = new FamilyRelations(new int[][]{{10, 3}, {5, 3}});

        Assertions.assertNotNull(resultToTest);
        Assertions.assertNotNull(resultToTest.getChildWithParents());
        Assertions.assertEquals(
                Map.of(
                        3, List.of(10, 5),
                        10, List.of(),
                        5, List.of()),
                resultToTest.getChildWithParents());
    }

    @Test
    void twoChildrenForOneParentTest() {
        var resultToTest = new FamilyRelations(new int[][]{{10, 3}, {10, 4}});

        Assertions.assertNotNull(resultToTest);
        Assertions.assertNotNull(resultToTest.getChildWithParents());
        Assertions.assertEquals(
                Map.of(
                        3, List.of(10),
                        4, List.of(10),
                        10, List.of()),
                resultToTest.getChildWithParents());
    }

    @Test
    void complicatedRelationsTest() {
        var resultToTest = new FamilyRelations(new int[][]{{10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}});

        Assertions.assertNotNull(resultToTest);
        Assertions.assertNotNull(resultToTest.getChildWithParents());
        Assertions.assertEquals(9, resultToTest.getChildWithParents().size());
    }
}