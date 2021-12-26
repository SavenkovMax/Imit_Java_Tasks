package third;

import java.util.Objects;

public class PackagedPieceGoods extends PieceGoods implements IPackagedGoods {
    private final PackageGoods packageGoods;
    private final int countGoods;


    public PackagedPieceGoods(String name, String description, double mass, int countGoods, PackageGoods packageGoods) {
        super(name, description, mass);
        if (packageGoods == null) {
            throw new IllegalArgumentException("Package goods is null pointer");
        }
        this.packageGoods = new PackageGoods(packageGoods);
        this.countGoods = countGoods;
    }

    public int getCountGoods() {
        return countGoods;
    }

    public double getNetMass() {
        return countGoods * getMass();
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
        if (!(o instanceof PackagedPieceGoods)) return false;
        if (!super.equals(o)) return false;
        PackagedPieceGoods that = (PackagedPieceGoods) o;
        return getCountGoods() == that.getCountGoods() && Objects.equals(packageGoods, that.packageGoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packageGoods, getCountGoods());
    }

    @Override
    public String toString() {
        return "PackagedPieceGoods{" +
                "packageGoods=" + packageGoods +
                ", countGoods=" + countGoods +
                '}';
    }
}
