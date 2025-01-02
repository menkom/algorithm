package info.mastera.practice.parent_child_relationship;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringToSetConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String setString)) {
            throw new ArgumentConversionException("Can only convert from String");
        }
        try {
            return Arrays.stream(setString.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            throw new ArgumentConversionException("Failed to convert String to Set: " + e.getMessage(), e);
        }
    }
}
