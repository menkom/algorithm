package info.mastera.leetcode.minimumDepthOfBinaryTree111;

import info.mastera.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {


    @Test
    void test() {
        TreeNode rootNode = new TreeNode(3);
        Assertions.assertEquals(1, new Solution().minDepth(rootNode));

        rootNode = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        Assertions.assertEquals(2, new Solution().minDepth(rootNode));

        rootNode = new TreeNode(2,
                null,
                new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6))))
        );
        Assertions.assertEquals(5, new Solution().minDepth(rootNode));
    }
}