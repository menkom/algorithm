package info.mastera.leetcode.balancedBinaryTree110;

import info.mastera.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        Assertions.assertTrue(new Solution().isBalanced(null));

        TreeNode rootNode = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Assertions.assertTrue(new Solution().isBalanced(rootNode));

        rootNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)),
                new TreeNode(2)
        );
        Assertions.assertFalse(new Solution().isBalanced(rootNode));

        rootNode = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );
        Assertions.assertTrue(new Solution().isBalanced(rootNode));

         rootNode = new TreeNode(1,
                new TreeNode(2),
                null
        );
        Assertions.assertTrue(new Solution().isBalanced(rootNode));

         rootNode = new TreeNode(1,
                null,
                 new TreeNode(2)
        );
        Assertions.assertTrue(new Solution().isBalanced(rootNode));

        rootNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), null),
                null
        );
        Assertions.assertFalse(new Solution().isBalanced(rootNode));

        rootNode = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                null
        );
        Assertions.assertFalse(new Solution().isBalanced(rootNode));

//        [1,2,2,3,null,null,3,4,null,null,4]
        rootNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
                new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)))
        );
        Assertions.assertFalse(new Solution().isBalanced(rootNode));
    }
}