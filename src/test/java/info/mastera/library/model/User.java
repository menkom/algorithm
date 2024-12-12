package info.mastera.library.model;

import java.util.Objects;

public class User {

    public String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return name.equals(((User) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
