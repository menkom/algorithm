# JUnit converters for LeetCode notation

Put each class in `src/test/java/info/mastera/leetcode/converter/`. Create only the ones a test needs; reuse existing ones.

Usage:

```java
@ParameterizedTest(name = "nums = {0} → {1}")
@CsvSource(delimiter = '|', textBlock = """
        [1,2,3,4]    | [1,3,6,10]
        [3,1,2,10,1] | [3,4,6,16,17]
        [5]          | [5]
        """)
void runningSum(@ConvertWith(IntArrayConverter.class) int[] nums,
                @ConvertWith(IntArrayConverter.class) int[] expected) {
    assertArrayEquals(expected, new Solution().runningSum(nums));
}
```

## IntArrayConverter: `[1,2,3]`, `[]`

```java
package info.mastera.leetcode.converter;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.Arrays;

public class IntArrayConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) {
        return parse((String) source);
    }

    static int[] parse(String text) {
        String body = LeetCodeNotation.unwrap(text);
        return body.isEmpty()
                ? new int[0]
                : Arrays.stream(body.split(",")).map(String::strip).mapToInt(Integer::parseInt).toArray();
    }
}
```

## LeetCodeNotation: shared bracket check

```java
package info.mastera.leetcode.converter;

import org.junit.jupiter.params.converter.ArgumentConversionException;

final class LeetCodeNotation {

    private LeetCodeNotation() {
    }

    /** Returns the text between the outer brackets: "[1, 2]" -> "1, 2". */
    static String unwrap(String text) {
        String trimmed = text == null ? "" : text.strip();
        if (!trimmed.startsWith("[") || !trimmed.endsWith("]")) {
            throw new ArgumentConversionException("Expected LeetCode notation like [1,2,3] but got: " + text);
        }
        return trimmed.substring(1, trimmed.length() - 1).strip();
    }
}
```

## ListNodeConverter: `[1,2,3]`; `[]` becomes `null`, as on LeetCode

```java
package info.mastera.leetcode.converter;

import info.mastera.leetcode.ListNode;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ListNodeConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) {
        int[] values = IntArrayConverter.parse((String) source);
        return values.length == 0 ? null : new ListNode(values);
    }
}
```

## TreeNodeConverter: level order `[3,9,20,null,null,15,7]`; `[]` becomes `null`

```java
package info.mastera.leetcode.converter;

import info.mastera.leetcode.TreeNode;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNodeConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) {
        String body = LeetCodeNotation.unwrap((String) source);
        if (body.isEmpty()) {
            return null;
        }
        String[] tokens = body.split(",");
        TreeNode root = node(tokens[0]);
        Queue<TreeNode> parents = new ArrayDeque<>();
        parents.add(root);
        int next = 1;
        while (next < tokens.length && !parents.isEmpty()) {
            TreeNode parent = parents.poll();
            parent.left = node(tokens[next++]);
            if (parent.left != null) {
                parents.add(parent.left);
            }
            if (next < tokens.length) {
                parent.right = node(tokens[next++]);
                if (parent.right != null) {
                    parents.add(parent.right);
                }
            }
        }
        return root;
    }

    private static TreeNode node(String token) {
        String value = token.strip();
        return "null".equals(value) ? null : new TreeNode(Integer.parseInt(value));
    }
}
```
