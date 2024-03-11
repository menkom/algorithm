package info.mastera.leetcode.validParentheses20


import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun test() {
        assertTrue(Solution().isValid("()"))
        assertFalse(Solution().isValid(")("))
        assertTrue(Solution().isValid("(())"))
        assertTrue(Solution().isValid("()[]{}"))
        assertFalse(Solution().isValid("(]"))
        assertTrue(Solution().isValid("{[]}"))
        assertFalse(Solution().isValid("()))"))
        assertFalse(Solution().isValid("["))
    }
}