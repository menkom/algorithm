package info.mastera.practice.parent_child_relationship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class FilteredParentsTest {

    @Nested
    class GetWithoutParentsTest {

        @Test
        void noRelationsNoParentsTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{});

            int[] resultToTest = filteredParents.getWithoutParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(0, resultToTest.length);
        }

        @Test
        void oneRelationOneParentTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{{10, 3}});

            int[] resultToTest = filteredParents.getWithoutParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{10}, resultToTest);
        }

        @Test
        void twoIndependentRelationsTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{{10, 3}, {2, 4}});

            int[] resultToTest = filteredParents.getWithoutParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{2, 10}, resultToTest);
        }

        @Test
        void complicatedRelationsTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{{10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}});

            int[] resultToTest = filteredParents.getWithoutParents();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{2, 4, 10}, resultToTest);
        }
    }

    @Nested
    class GetWithOneParentTest {

        @Test
        void noRelationsNoParentsTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{});

            int[] resultToTest = filteredParents.getWithOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(0, resultToTest.length);
        }

        @Test
        void oneRelationOneWithParentTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{{10, 3}});

            int[] resultToTest = filteredParents.getWithOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{3}, resultToTest);
        }

        @Test
        void twoIndependentRelationsTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{{10, 3}, {2, 4}});

            int[] resultToTest = filteredParents.getWithOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{3, 4}, resultToTest);
        }

        @Test
        void complicatedRelationsTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{{10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}});

            int[] resultToTest = filteredParents.getWithOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[]{5, 7, 8, 9}, resultToTest);
        }
    }

    @Nested
    class NoParentsOneParentTest {

        @Test
        void noRelationsNoParentsTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{});

            int[][] resultToTest = filteredParents.noParentsOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[][]{{}, {}}, resultToTest);
        }

        @Test
        void oneRelationTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{{10, 3}});

            int[][] resultToTest = filteredParents.noParentsOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(new int[][]{{10}, {3}}, resultToTest);
        }

        @Test
        void twoIndependentRelationsTest() {
            FilteredParents filteredParents = new FilteredParents(new int[][]{{10, 3}, {2, 4}});

            int[][] resultToTest = filteredParents.noParentsOneParent();

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
            FilteredParents filteredParents = new FilteredParents(source);

            int[][] resultToTest = filteredParents.noParentsOneParent();

            Assertions.assertNotNull(resultToTest);
            Assertions.assertArrayEquals(expected, resultToTest);
        }
    }
}