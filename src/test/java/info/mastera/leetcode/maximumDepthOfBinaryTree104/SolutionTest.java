package info.mastera.leetcode.maximumDepthOfBinaryTree104;

import info.mastera.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        TreeNode rootNode = new TreeNode(3);
        Assertions.assertEquals(1, new Solution().maxDepth(rootNode));

        rootNode = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        Assertions.assertEquals(3, new Solution().maxDepth(rootNode));

        rootNode = new TreeNode(1,
                null,
                new TreeNode(2)
        );
        Assertions.assertEquals(2, new Solution().maxDepth(rootNode));
    }
}