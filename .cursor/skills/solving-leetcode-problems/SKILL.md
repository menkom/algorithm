---
name: solving-leetcode-problems
description: Use when solving a LeetCode-style algorithmic problem in this repository - the user points to a Solution.java or Solution.kt under info.mastera.leetcode whose comment holds a problem statement, asks to solve or implement it, add an alternative implementation, write or extend its tests, compare approaches or complexity, or cross-review a solution ("реши задачу", "реализуй метод", "альтернативная реализация", "тесты к решению").
---

# Solving LeetCode problems

## Overview

Every solution must be **optimal in time and memory and still human-readable**, and it is proven by one parameterized test table built from the statement's examples plus edge cases. Tests come first.

## Repository conventions

- Package `info.mastera.leetcode.<camelCaseTitle><number>`, e.g. `isSubsequence392`. Code in `src/main/java/.../Solution.java`, tests in `SolutionTest.java` in the same package under `src/test/java`.
- The problem statement stays in the comment above `class Solution`. Never delete or rewrite it.
- Keep the exact LeetCode method signature. That method holds the main solution.
- Reuse `info.mastera.leetcode.ListNode` (`new ListNode(1, 2, 3)` builds a list) and `info.mastera.leetcode.TreeNode`. Never declare local copies.
- Java 17 language level. JUnit 5 `Assertions` only: no AssertJ, no Hamcrest. No Lombok in solutions.
- For a `Solution.kt` problem, follow the same workflow in Kotlin with the same JUnit annotations.
- Model new tests on `isSubsequence392/SolutionTest`. Older code predates these conventions (`strStr0` and `@MethodSource` in problem 28, solutions without Javadoc, plain `@Test` classes): don't imitate it, and don't convert it unless the user asks.

## Workflow

1. **Read the statement**: signature, examples, constraints, follow-up. Constraints set the target complexity (n ≤ 10^5 means O(n) or O(n log n)). Decide the implementations now (see Choosing implementations).
2. **Write the tests first** (see Test pattern). Stub every planned method with `throw new UnsupportedOperationException();` so the tests compile, then run them: every row must fail, and none of the failures may come from compilation.
3. **Implement.** Every implementation method gets a Javadoc: the idea in one sentence, then `Time: O(..), space: O(..)`; write `space: O(1) extra (output excluded)` when the output array doesn't count. Use descriptive names (`matched`, `indicesByChar`); one-letter names only for loop indices. Match the language of existing comments in the file (English by default).
4. **Run** `./gradlew test --tests 'info.mastera.leetcode.<package>.*'`. Quiet Gradle output has no counts; read them with `grep -o 'tests="[0-9]*" skipped="[0-9]*" failures="[0-9]*" errors="[0-9]*"' build/test-results/test/TEST-info.mastera.leetcode.<package>.SolutionTest.xml` and show them. Never report success without this run. If the sandbox blocks Gradle (it writes to `~/.gradle` and may download the JDK 17 toolchain), rerun it with full permissions.
5. **Cross-review** only when the user asks: if pstack is installed, run `/interrogate` on the solution; otherwise launch two read-only subagents on different model families with the same rubric (correctness on edge cases, complexity, readability). Apply the fixes both agree on and report the rest.
6. **Finish** in the user's language: the approach, the complexity of each implementation, whether the follow-up is covered, the test counts, and any new shared helpers (e.g. converters). Suggest the commit message in the repository's two-line format and do not commit unless asked:

   ```
   Leetcode: 392. Is Subsequence
   https://leetcode.com/problems/is-subsequence
   ```

## Choosing implementations

The LeetCode-signature method holds the most readable solution that meets the target complexity set by the constraints. Add another method to `Solution` for each case that applies:

- The follow-up asks for something the main solution does not do: implement the follow-up.
- A classic algorithm gives a better worst case than the main solution (KMP vs `String.indexOf`): add it.
- The user shares a faster submission or asks for a variant: add it.

If the main solution already satisfies the follow-up, add nothing for it and say so in the report. Name alternatives by their idea (`isSubsequenceWithIndexMap`, not `strStr0`), state the trade-off in the Javadoc, and assert them in the same test table. A faster but cryptic variant goes next to the readable main method, never instead of it.

## Test pattern

One `@ParameterizedTest` table per behavior, named after the LeetCode method; other tests are named by behavior (`handlesMaximumLengthInLinearTime`). Rows: the statement's examples first, then edge cases the constraints allow: minimum and maximum length, extreme values, zeros, negatives, duplicates, all equal. Never add rows that violate the constraints, including guarantees such as "the product fits in 32 bits".

```java
@ParameterizedTest(name = "\"{0}\" subsequence of \"{1}\" → {2}")
@CsvSource({
        "abc, ahbgdc, true",
        "axc, ahbgdc, false",
        "'', ahbgdc, true",
})
void isSubsequence(String s, String t, boolean expected) {
    Solution solution = new Solution();
    assertEquals(expected, solution.isSubsequence(s, t));
    assertEquals(expected, solution.isSubsequenceWithIndexMap(s, t));
}
```

- `''` is an empty string in `@CsvSource`.
- Arrays, linked lists and trees: write cells in LeetCode notation (`[1,2,3]`, `[3,9,20,null,null,15,7]`), use `delimiter = '|'` (a `textBlock` reads best) and `@ConvertWith`. Converters live in `src/test/java/info/mastera/leetcode/converter/`; if one is missing, create it from [converters.md](converters.md).
- Use `@MethodSource` only when a cell cannot express the input (stateful objects, generated data).
- When the input size can reach 10^5 or more, add one `@Test` with `@Timeout(1)` at the maximum size (e.g. `new int[100_000]`): without the timeout a quadratic solution still passes, just slowly. For smaller limits a timeout cannot tell O(n²) from O(n), so test the worst-case input for correctness only.
- Compare arrays with `assertArrayEquals`; for "any order" results sort both sides first; compare doubles with a delta.
- For in-place (`void`) methods, call the method, then assert the mutated argument.

## Common mistakes

| Mistake | Fix |
|---------|-----|
| A separate `@Test` per example | One `@ParameterizedTest` table |
| `@MethodSource` for values that fit in CSV | `@CsvSource`, with converters for arrays, lists and trees |
| An alternative implementation that no test calls | Assert every implementation in the same table |
| Rows outside the constraints (an empty array when n ≥ 2) | Boundary rows inside the constraints |
| A max-size test (n ≥ 10^5) without `@Timeout` | `@Timeout(1)`, otherwise O(n²) passes |
| Changed LeetCode signature or removed statement comment | Restore both |
| Micro-optimizations and cryptic names | Readable code with the same complexity |
| A new `ListNode`/`TreeNode` class | The shared ones in `info.mastera.leetcode` |
