package info.mastera.leetcode.pathSum112;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void pathSum112Test() {
        TreeNode source = null;
        Assertions.assertFalse(new Solution().hasPathSum(source, 0));

        source = new TreeNode(1);
        Assertions.assertFalse(new Solution().hasPathSum(source, 5));
        Assertions.assertTrue(new Solution().hasPathSum(source, 1));

        source = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assertions.assertFalse(new Solution().hasPathSum(source, 5));
        Assertions.assertTrue(new Solution().hasPathSum(source, 3));
        Assertions.assertTrue(new Solution().hasPathSum(source, 4));

        source = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
        );
        Assertions.assertTrue(new Solution().hasPathSum(source, 22));
    }

}