public class IndoSangatsuGoodsFactory implements GoodsFactory {

    @Override
    public ConsumableGoods createConsumablesGoods() {
        return new ConsumableGoods();
    }

    @Override
    public Foods createFoods() {
        return new Foods();
    }

    @Override
    public Goods createNeutralGoods(String nama, int harga, String id, Tipe tipe) {
        return new Goods(nama,harga,id,tipe);
    }

    @Override
    public PoisonousGoods createPoisonousGoods() {
        return new PoisonousGoods();
    }
}
