package third;

import java.util.Objects;

public class Goods {
    private final String description;
    private final String name;

    public Goods(String name, String description) {
        if (name == null) {
            throw new IllegalArgumentException("Name string of goods is null");
        }
        if (description == null) {
            throw new IllegalArgumentException("Description string of goods is null");
        }
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;
        Goods goods = (Goods) o;
        return Objects.equals(getDescription(), goods.getDescription()) &&
                Objects.equals(getName(), goods.getName());
    }

    @Override
    public String toString() {
        return "Goods: " +
                "description='" + description + '\'' +
                ", name='" + name + '\'';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getName());
    }
}
