public interface GoodsFactory {
    public ConsumableGoods createConsumablesGoods();
    public Foods createFoods();
    public Goods createNeutralGoods(String nama, int harga, String id, Tipe tipe);
    public PoisonousGoods createPoisonousGoods();
}
