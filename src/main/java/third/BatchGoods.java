package third;

import java.util.Arrays;
import java.util.Objects;

public class BatchGoods {
    private final String description;
    private final IPackagedGoods[] goods;

    public BatchGoods(String description, IPackagedGoods... packagedGoods) {
        if (description == null) {
            throw new IllegalArgumentException("The description string is null");
        }
        if (packagedGoods == null) {
            throw new IllegalArgumentException("The packaged goods array is null");
        }
        this.description = description;
        this.goods = packagedGoods;
    }

    public double getBatchMass() {
        double res = 0;
        for (IPackagedGoods item : goods) {
            res += item.getGrossMass();
        }
        return res;
    }

    public String getDescription() {
        return description;
    }

    public IPackagedGoods[] getGoods() {
        return goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BatchGoods)) return false;
        BatchGoods that = (BatchGoods) o;
        return Objects.equals(getDescription(), that.getDescription())
                && Arrays.equals(getGoods(), that.getGoods());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getDescription());
        result = 31 * result + Arrays.hashCode(getGoods());
        return result;
    }

    @Override
    public String toString() {
        return "BatchGoods{" +
                "description='" + description + '\'' +
                ", goods=" + Arrays.toString(goods) +
                '}';
    }
}
