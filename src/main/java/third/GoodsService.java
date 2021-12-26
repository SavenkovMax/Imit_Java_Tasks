package third;

public final class GoodsService {
    private GoodsService() {}

    public static int countByFilter(BatchGoods goods, IFilter filter) {
        int count = 0;
        for (IPackagedGoods item : goods.getGoods()) {
            if (filter.apply(item.getGoodsName())) count++;
        }
        return count;
    }

    public static boolean checkAllWeight(BatchGoods goods) {
        int count = 0;
        for (IPackagedGoods item : goods.getGoods()) {
            if (item instanceof PackagedWeightGoods) count ++;
        }
        return count == goods.getGoods().length;
    }
}
