package info.mastera.leetcode.reverseString344

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun test() {
        var workingArray = "hello".toCharArray()
        Solution().reverseString(workingArray)
        assertArrayEquals("olleh".toCharArray(), workingArray)

        workingArray = "Hannah".toCharArray()
        Solution().reverseString(workingArray)
        assertArrayEquals("hannaH".toCharArray(), workingArray)
    }
}