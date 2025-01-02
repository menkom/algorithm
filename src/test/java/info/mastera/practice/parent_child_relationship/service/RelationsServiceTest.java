package info.mastera.practice.parent_child_relationship.service;

import info.mastera.practice.parent_child_relationship.storage.FamilyRelationsStorage;
import info.mastera.practice.parent_child_relationship.utils.StringToInt2DArrayConverter;
import info.mastera.practice.parent_child_relationship.utils.StringToSetConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;
import java.util.Set;

class RelationsServiceTest {

    @Nested
    class SetRelationsTest {

        private FamilyRelationsStorage familyRelations;
        private RelationsService relationsService;

        @BeforeEach
        void init() {
            familyRelations = new FamilyRelationsStorage();
            relationsService = new RelationsService(familyRelations);
        }

        @Test
        void initObjectWithEmptyStorageTest() {

            var resultToTest = familyRelations.getChildWithParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(0, resultToTest.size());
        }

        @Test
        void setEmptyRelationsWithServiceTest() {
            relationsService.setRelations(new int[][]{});

            var resultToTest = familyRelations.getChildWithParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(0, resultToTest.size());
        }

        @Test
        void setRelationsWithServiceTest() {
            relationsService.setRelations(new int[][]{{10, 3}});

            var resultToTest = familyRelations.getChildWithParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(2, resultToTest.size());
            Assertions.assertEquals(Map.of(10, List.of(), 3, List.of(10)), resultToTest);
        }
    }

    @Nested
    class GetWithoutParentsTest {

        private final RelationsService relationsService = new RelationsService(new FamilyRelationsStorage());

        @Test
        void noRelationsNoParentsTest() {
            relationsService.setRelations(new int[][]{});

            int[] resultToTest = relationsService.getWithoutParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(0, resultToTest.length);
        }

        @Test
        void oneRelationOneParentTest() {
            relationsService.setRelations(new int[][]{{10, 3}});

            int[] resultToTest = relationsService.getWithoutParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{10}, resultToTest);
        }

        @Test
        void twoIndependentRelationsTest() {
            relationsService.setRelations(new int[][]{{10, 3}, {2, 4}});

            int[] resultToTest = relationsService.getWithoutParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{2, 10}, resultToTest);
        }

        @Test
        void complicatedRelationsTest() {
            relationsService.setRelations(new int[][]{{10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}});

            int[] resultToTest = relationsService.getWithoutParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{2, 4, 10}, resultToTest);
        }
    }

    @Nested
    class GetWithOneParentTest {

        private final RelationsService relationsService = new RelationsService(new FamilyRelationsStorage());

        @Test
        void noRelationsNoParentsTest() {
            relationsService.setRelations(new int[][]{});

            int[] resultToTest = relationsService.getWithOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(0, resultToTest.length);
        }

        @Test
        void oneRelationOneWithParentTest() {
            relationsService.setRelations(new int[][]{{10, 3}});

            int[] resultToTest = relationsService.getWithOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{3}, resultToTest);
        }

        @Test
        void twoIndependentRelationsTest() {
            relationsService.setRelations(new int[][]{{10, 3}, {2, 4}});

            int[] resultToTest = relationsService.getWithOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{3, 4}, resultToTest);
        }

        @Test
        void complicatedRelationsTest() {
            relationsService.setRelations(new int[][]{{10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}});

            int[] resultToTest = relationsService.getWithOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{5, 7, 8, 9}, resultToTest);
        }
    }

    @Nested
    class NoParentsOneParentTest {

        private final RelationsService relationsService = new RelationsService(new FamilyRelationsStorage());

        @Test
        void noRelationsNoParentsTest() {
            relationsService.setRelations(new int[][]{});

            int[][] resultToTest = relationsService.noParentsOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[][]{{}, {}}, resultToTest);
        }

        @Test
        void oneRelationTest() {
            relationsService.setRelations(new int[][]{{10, 3}});

            int[][] resultToTest = relationsService.noParentsOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[][]{{10}, {3}}, resultToTest);
        }

        @Test
        void twoIndependentRelationsTest() {
            relationsService.setRelations(new int[][]{{10, 3}, {2, 4}});

            int[][] resultToTest = relationsService.noParentsOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[][]{{2, 10}, {3, 4}}, resultToTest);
        }

        @ParameterizedTest
        @CsvSource({
                "'10,3','10;3'",
                "'10,3;2,3;3,6;5, 6; 5, 7; 4, 5; 4, 8; 8, 9','2, 4, 10;5, 7, 8, 9'",
                //         14  13
                //         |   |
                //1   2    4   12
                // \ /   / | \ /
                //  3   5  8  9
                //   \ / \     \
                //    6   7     11
                "'1, 3; 2, 3; 3, 6; 5, 6; 5, 7; 4, 5; 4, 8; 4, 9; 9, 11; 14, 4; 13, 12; 12, 9','1, 2, 13, 14;4, 5, 7, 8, 11, 12'",
                //        11
                //       /  \
                //      10   12
                //     /  \
                //1   2    5
                // \ /    / \
                //  3    6   7
                //   \        \
                //    4        8
                "'11, 10;11, 12;2, 3;10, 2;10, 5;1, 3;3, 4;5, 6;5, 7;7, 8','1, 11;2, 4, 5, 6, 7, 8, 10, 12'",
        })
        void complicatedRelationsTest(@ConvertWith(StringToInt2DArrayConverter.class) int[][] source,
                                      @ConvertWith(StringToInt2DArrayConverter.class) int[][] expected) {
            relationsService.setRelations(source);

            int[][] resultToTest = relationsService.noParentsOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(expected, resultToTest);
        }
    }

    @Nested
    class GetAncestorsTest {

        private final RelationsService relationsService = new RelationsService(new FamilyRelationsStorage());

        @Test
        void noRelationsNoAncestorsTest() {
            relationsService.setRelations(new int[][]{});

            var parents = relationsService.getAncestors(1);

            Assertions.assertNotNull(parents);
        }

        @ParameterizedTest
        @CsvSource({
                "'10,3', 3, '3,10'",
                "'10,3;2,3;3,6;5, 6; 5, 7; 4, 5; 4, 8; 8, 9', 3,'2,3, 10'",
                "'10,3;2,3;3,6;5, 6; 5, 7; 4, 5; 4, 8; 8, 9', 6,'2,3,4,5,6, 10'",
        })
        void complicatedRelationsTest(@ConvertWith(StringToInt2DArrayConverter.class) int[][] source,
                                      int child,
                                      @ConvertWith(StringToSetConverter.class) Set<Integer> expected) {
            relationsService.setRelations(source);

            var resultToTest = relationsService.getAncestors(child);

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(expected, resultToTest);
        }
    }

    @Nested
    class HasCommonAncestorTest {

        private final RelationsService relationsService = new RelationsService(new FamilyRelationsStorage());

        @ParameterizedTest
        @CsvSource({
                "'10,3', 3, 10, true",
                //   10  2  4
                //    \ /  / \
                //     3  5   8
                //      \/ \   \
                //      6  7   9
                "'10,3;2,3;3,6;5, 6; 5, 7; 4, 5; 4, 8; 8, 9', 3,8, false",
                "'10,3;2,3;3,6;5, 6; 5, 7; 4, 5; 4, 8; 8, 9', 5,8, true",
                "'10,3;2,3;3,6;5, 6; 5, 7; 4, 5; 4, 8; 8, 9', 6,8, true",
        })
        void complicatedRelationsTest(@ConvertWith(StringToInt2DArrayConverter.class) int[][] source,
                                      int child1, int child2, boolean expected) {
            relationsService.setRelations(source);

            var resultToTest = relationsService.hasCommonAncestor(child1, child2);

            Assertions.assertEquals(expected, resultToTest);
        }
    }
}