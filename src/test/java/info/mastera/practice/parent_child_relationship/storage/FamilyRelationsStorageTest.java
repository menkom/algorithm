package info.mastera.practice.parent_child_relationship.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class FamilyRelationsStorageTest {

    @Nested
    class ConstructorTest {

        @Test
        void initStorageEmptyTest() {
            FamilyRelationsStorage resultToTest = new FamilyRelationsStorage();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertNotNull(resultToTest.getChildWithParents());
            Assertions.assertTrue(resultToTest.getChildWithParents().isEmpty());
        }
    }

    @Nested
    class SetChildWithParentsTest {

        private FamilyRelationsStorage familyRelations;

        @BeforeEach
        void init() {
            familyRelations = new FamilyRelationsStorage();
        }

        @Test
        void emptyRelationsTest() {
            familyRelations.setChildWithParents(new int[][]{});

            var resultToTest = familyRelations.getChildWithParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertTrue(resultToTest.isEmpty());
        }

        @Test
        void oneParentRelationsTest() {
            familyRelations.setChildWithParents(new int[][]{{10, 3}});

            var resultToTest = familyRelations.getChildWithParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(Map.of(3, List.of(10), 10, List.of()), resultToTest);
        }

        @Test
        void twoIndependentAncestorsTest() {
            familyRelations.setChildWithParents(new int[][]{{10, 3}, {2, 4}});

            var resultToTest = familyRelations.getChildWithParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(
                    Map.of(
                            3, List.of(10),
                            10, List.of(),
                            4, List.of(2),
                            2, List.of()),
                    resultToTest);
        }

        @Test
        void twoParentsForChildTest() {
            familyRelations.setChildWithParents(new int[][]{{10, 3}, {5, 3}});

            var resultToTest = familyRelations.getChildWithParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(
                    Map.of(
                            3, List.of(10, 5),
                            10, List.of(),
                            5, List.of()),
                    resultToTest);
        }

        @Test
        void twoChildrenForOneParentTest() {
            familyRelations.setChildWithParents(new int[][]{{10, 3}, {10, 4}});

            var resultToTest = familyRelations.getChildWithParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(
                    Map.of(
                            3, List.of(10),
                            4, List.of(10),
                            10, List.of()),
                    resultToTest);
        }

        @Test
        void complicatedRelationsTest() {
            familyRelations.setChildWithParents(new int[][]{{10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}});

            var resultToTest = familyRelations.getChildWithParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(9, resultToTest.size());
        }
    }
}