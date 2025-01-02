package info.mastera.practice.parent_child_relationship;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;

public class StringToInt2DArrayConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext parameterContext) throws ArgumentConversionException {
        if (!(source instanceof String matrix)) {
            throw new ArgumentConversionException("Can only convert from String");
        }
        try {
            return Arrays.stream(matrix.split(";"))
                    .map(row -> Arrays.stream(row.split(","))
                            .map(String::trim)
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);
        } catch (Exception e) {
            throw new ArgumentConversionException("Failed to convert String to int[][]: " + e.getMessage(), e);
        }
    }
}
