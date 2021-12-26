package third;

import java.util.Objects;

public class PieceGoods extends Goods {
    private final double mass;

    public PieceGoods(String name, String description, double mass) {
        super(name, description);
        if (mass <= 0) {
            throw new IllegalArgumentException("Goods mass is less or equal to 0");
        }
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PieceGoods)) return false;
        if (!super.equals(o)) return false;
        PieceGoods that = (PieceGoods) o;
        return Double.compare(that.getMass(), getMass()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMass());
    }

    @Override
    public String toString() {
        return "Piece goods: " + getName()
                + ", " + getDescription()
                + ", mass: " + mass;
    }
}
