package info.mastera.leetcode.validParentheses20

import java.util.*

class Solution {

    fun isValid(s: String): Boolean {
        val stack = LinkedList<Char>()
        for (next in s) {
            if (stack.size == 0) {
                if (")]}".contains(next)) {
                    return false
                } else {
                    stack.push(next)
                }
            } else {
                val last = stack.peek()
                when (last) {
                    '(' -> when (next) {
                        ')' -> stack.pop()
                        '[', '{', '(' -> stack.push(next)
                        else -> return false
                    }

                    '[' -> when (next) {
                        ']' -> stack.pop()
                        '[', '{', '(' -> stack.push(next)
                        else -> return false
                    }

                    '{' -> when (next) {
                        '}' -> stack.pop()
                        '[', '{', '(' -> stack.push(next)
                        else -> return false
                    }

                    else -> return false
                }
            }
        }
        return stack.size == 0
    }

    @Suppress("unused")
    fun isValidFaster(s: String): Boolean {
        val stack = LinkedList<Char>()
        var lastPushed: Char? = null
        for (next in s) {
            if (stack.isEmpty() && lastPushed == null) {
                if (')' == next || ']' == next || '}' == next) {
                    return false
                } else {
                    lastPushed = next
                }
            } else {
                when (lastPushed) {
                    '(' -> when (next) {
                        ')' -> lastPushed = if (stack.isEmpty()) null else stack.pop()
                        '[', '{', '(' -> {
                            stack.push(lastPushed)
                            lastPushed = next
                        }

                        else -> return false
                    }

                    '[' -> when (next) {
                        ']' -> lastPushed = if (stack.isEmpty()) null else stack.pop()
                        '[', '{', '(' -> {
                            stack.push(lastPushed)
                            lastPushed = next
                        }

                        else -> return false
                    }

                    '{' -> when (next) {
                        '}' -> lastPushed = if (stack.isEmpty()) null else stack.pop()
                        '[', '{', '(' -> {
                            stack.push(lastPushed)
                            lastPushed = next
                        }

                        else -> return false
                    }

                    else -> return false
                }
            }
        }
        return stack.isEmpty() && lastPushed == null
    }
}