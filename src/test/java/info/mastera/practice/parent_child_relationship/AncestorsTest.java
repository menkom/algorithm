package info.mastera.practice.parent_child_relationship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

class AncestorsTest {

    @Nested
    class GetAncestorsTest {

        @Test
        void noRelationsNoAncestorsTest() {
            var ancestors = new Ancestors(new int[][]{});

            var parents = ancestors.getAncestors(1);

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
            Ancestors ancestors = new Ancestors(source);

            var resultToTest = ancestors.getAncestors(child);

            Assertions.assertNotNull(resultToTest);
            Assertions.assertEquals(expected, resultToTest);
        }
    }

    @Nested
    class HasCommonAncestorTest {

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
            Ancestors ancestors = new Ancestors(source);

            var resultToTest = ancestors.hasCommonAncestor(child1, child2);

            Assertions.assertEquals(expected, resultToTest);
        }
    }
}