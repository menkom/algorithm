package info.mastera.leetcode.intersectionOfTwoLinkedLists160;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        var expectedResult = new Solution.ListNode(8, 4, 5);
        Assertions.assertEquals(expectedResult,
                new Solution().getIntersectionNode(
                        new Solution.ListNode(4, 1).setNext(expectedResult),
                        new Solution.ListNode(5, 6, 1).setNext(expectedResult)
                ));
        expectedResult = new Solution.ListNode(2, 4);
        Assertions.assertEquals(expectedResult,
                new Solution().getIntersectionNode(
                        new Solution.ListNode(1, 9, 1).setNext(expectedResult),
                        new Solution.ListNode(3).setNext(expectedResult)
                ));
        Assertions.assertEquals(null, new Solution().getIntersectionNode(new Solution.ListNode(2, 6, 4), new Solution.ListNode(1, 5)));
        expectedResult = new Solution.ListNode(4, 5, 4);
        Assertions.assertEquals(expectedResult,
                new Solution().getIntersectionNode(
                        new Solution.ListNode(2, 2).setNext(expectedResult),
                        new Solution.ListNode(2, 2).setNext(expectedResult)
                ));
    }
}