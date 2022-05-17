package info.mastera.util;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
@Accessors(chain = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Node {

    String name;
    @NonFinal
    boolean condition = false;

    @Override
    public String toString() {
        return "{" + getName() + ":" + isCondition() + "}";
    }
}
