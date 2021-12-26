package third;

import java.util.Objects;

public class PackageGoods {
    private final double mass;
    private final String name;

    public PackageGoods(String name, double mass) {
        if (name == null) {
            throw new IllegalArgumentException("The name string is null");
        }
        if (mass <= 0) {
            throw new IllegalArgumentException("The mass is less or equal to 0");
        }
        this.name = new String(name);
        this.mass = mass;
    }

    public PackageGoods(PackageGoods packageGoods) {
        this.name = packageGoods.name;
        this.mass = packageGoods.mass;
    }

    public double getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackageGoods)) return false;
        PackageGoods that = (PackageGoods) o;
        return Double.compare(that.getMass(), getMass()) == 0 &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMass(), getName());
    }

    @Override
    public String toString() {
        return "PackageGoods{" +
                "mass=" + mass +
                ", name='" + name + '\'' +
                '}';
    }
}
