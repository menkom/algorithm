@file:Suppress("unused")

package info.mastera.leetcode.ransomNote383

class Solution {

    fun canConstructWorse(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) {
            return false
        }
        val ransom = hashMapOf<Char, Int>()
        ransomNote.forEach { c -> ransom[c] = ransom.getOrDefault(c, 0).plus(1) }

        magazine.forEach { c ->
            if (ransom.containsKey(c)) {
                ransom[c] = ransom[c]!! - 1
            }
        }
        return ransom.values.all { it <= 0 }
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) {
            return false
        }
        val magazineChars = hashMapOf<Char, Int>()
        magazine.forEach { c -> magazineChars[c] = magazineChars.getOrDefault(c, 0).plus(1) }

        for (c in ransomNote) {
            val index = magazineChars[c]
            if (index == null || index == 0) {
                return false
            } else {
                magazineChars[c] = magazineChars[c]!! - 1
            }
        }
        return true
    }

    fun canConstructOriginal(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) {
            return false
        }
        val magazineChars = hashMapOf<Char, Int>()
        for (c in magazine) {
            if (magazineChars[c] == null) {
                magazineChars.put(c, 1)
            } else {
                magazineChars.put(c, magazineChars[c]?.plus(1)!!)
            }
        }
        for (c in ransomNote) {
            if (magazineChars[c] == null || magazineChars[c] == 0) {
                return false
            } else {
                magazineChars.put(c, magazineChars[c]?.minus(1)!!)
            }
        }
        return true
    }
}