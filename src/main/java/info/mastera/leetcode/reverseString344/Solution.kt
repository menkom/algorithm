@file:Suppress("RedundantUnitReturnType")

package info.mastera.leetcode.reverseString344

class Solution {

    fun reverseString(s: CharArray): Unit {
        val middle = s.size / 2
        for (i in 0 until middle) {
            s[i] = s[s.size - 1 - i].also {
                s[s.size - 1 - i] = s[i]
            }
        }
    }

    @Suppress("unused")
    fun reverseStringOriginal(s: CharArray): Unit {
        val middle = (s.size / 2)
        var temp: Char
        for (i in 0 until middle) {
            temp = s[s.size - i - 1]
            s[s.size - i - 1] = s[i]
            s[i] = temp
        }
    }
}