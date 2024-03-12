package info.mastera.leetcode.ransomNote383

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest{

    @Test
    fun test() {
        assertFalse(Solution().canConstruct("a", "b"))
        assertFalse(Solution().canConstruct("a", "bb"))
        assertFalse(Solution().canConstruct("aa", "ab"))
        assertTrue(Solution().canConstruct("aa", "aab"))
        assertFalse(Solution().canConstruct("aaa", "aab"))
        assertFalse(Solution().canConstruct("aaa", "aa"))
    }
}