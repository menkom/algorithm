package info.mastera.forte;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordBucketsChallenge {

    private static final String MAX_SIZE_TOO_SMALL = "maxSize too small";

    /**
     * Divides a phrase into word buckets, each containing N or fewer characters.
     * - Each bucket must include full words.
     * - Spaces count as one character.
     * - Each bucket is trimmed (no leading/trailing spaces).
     * - If a bucket size is too small to hold a single word, throw a RuntimeException with message "maxSize too small".
     * <p>
     * Greedy single pass: a word joins the current bucket while the bucket stays within maxSize,
     * otherwise it starts a new one. Buckets are substrings of the input, so consecutive spaces
     * between words are kept and each of them counts as a character.
     * Time: O(n), space: O(1) extra (output excluded).
     *
     * @param input   the phrase to split
     * @param maxSize the maximum number of characters per bucket
     * @return list of word buckets
     * @throws NullPointerException     if input is null
     * @throws IllegalArgumentException if maxSize is less than 1 or than the length of any word
     */
    public List<String> bucketize(String input, int maxSize) {
        Objects.requireNonNull(input, "input must not be null");
        if (maxSize < 1) {
            throw new IllegalArgumentException(MAX_SIZE_TOO_SMALL);
        }

        List<String> buckets = new ArrayList<>();
        int wordStart = skipSpaces(input, 0);
        int bucketStart = wordStart;
        int bucketEnd = wordStart;
        while (wordStart < input.length()) {
            int wordEnd = findWordEnd(input, wordStart);
            int wordLength = wordEnd - wordStart;
            int bucketLengthWithWord = wordEnd - bucketStart;
            if (wordLength > maxSize) {
                throw new IllegalArgumentException(MAX_SIZE_TOO_SMALL);
            }
            if (bucketLengthWithWord > maxSize) {
                buckets.add(input.substring(bucketStart, bucketEnd));
                bucketStart = wordStart;
            }
            bucketEnd = wordEnd;
            wordStart = skipSpaces(input, wordEnd);
        }
        if (bucketEnd > bucketStart) {
            buckets.add(input.substring(bucketStart, bucketEnd));
        }
        return buckets;
    }

    private static int skipSpaces(String input, int from) {
        int index = from;
        while (index < input.length() && input.charAt(index) == ' ') {
            index++;
        }
        return index;
    }

    private static int findWordEnd(String input, int wordStart) {
        int spaceIndex = input.indexOf(' ', wordStart);
        return spaceIndex == -1 ? input.length() : spaceIndex;
    }
}
