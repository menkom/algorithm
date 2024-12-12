package info.mastera.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

class CasePhoenixTest {

    public static class SimpleClass {
        String fieldA;
        String fieldB;
        String fieldC;

        public SimpleClass(String fieldA, String fieldB, String fieldC) {
            this.fieldA = fieldA;
            this.fieldB = fieldB;
            this.fieldC = fieldC;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", SimpleClass.class.getSimpleName() + "[", "]")
                    .add("fieldA='" + fieldA + "'")
                    .add("fieldB='" + fieldB + "'")
                    .add("fieldC='" + fieldC + "'")
                    .toString();
        }
    }

    public boolean updateAIfChanged(SimpleClass target, SimpleClass source) {
        if (target.fieldA.equals(source.fieldA)) {
            return false;
        }
        target.fieldA = source.fieldA;
        return true;
    }

    public boolean updateBIfChanged(SimpleClass target, SimpleClass source) {
        if (target.fieldB.equals(source.fieldB)) {
            return false;
        }
        target.fieldB = source.fieldB;
        return true;
    }

    public boolean updateCIfChanged(SimpleClass target, SimpleClass source) {
        if (target.fieldC.equals(source.fieldC)) {
            return false;
        }
        target.fieldC = source.fieldC;
        return true;
    }

    @Test
    void practicalTest() {
        var simpleTarget = new SimpleClass("targetA", "targetB", "targetC");
        var simpleSource = new SimpleClass("sourceA", "sourceB", "sourceC");

        boolean changed = updateAIfChanged(simpleTarget, simpleSource)
                || updateBIfChanged(simpleTarget, simpleSource)
                || updateCIfChanged(simpleTarget, simpleSource);

        System.out.println(changed);
        System.out.println(simpleTarget);
        Assertions.assertTrue(changed);
    }
}
