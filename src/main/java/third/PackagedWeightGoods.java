package third;

import java.util.Objects;

public class PackagedWeightGoods extends WeightGoods implements IPackagedGoods {
    private final PackageGoods packageGoods;
    private final double mass;

    public PackagedWeightGoods(String name, String description, double mass, PackageGoods packageGoods) {
        super(name, description);
        if (packageGoods == null) {
            throw new IllegalArgumentException("Package goods is null pointer");
        }
        if (mass <= 0) {
            throw new IllegalArgumentException("Goods mass is less or equal to 0");
        }
        this.packageGoods = new PackageGoods(packageGoods);
        this.mass = mass;
    }

    public double getNetMass() {
        return mass;
    }

    public double getGrossMass() {
        return getNetMass() + packageGoods.getMass();
    }

    public String getGoodsName() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackagedWeightGoods)) return false;
        if (!super.equals(o)) return false;
        PackagedWeightGoods that = (PackagedWeightGoods) o;
        return Double.compare(that.mass, mass) == 0 && Objects.equals(packageGoods, that.packageGoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packageGoods, mass);
    }

    @Override
    public String toString() {
        return "PackagedWeightGoods{" +
                "packageGoods=" + packageGoods +
                ", mass=" + mass +
                '}';
    }
}
