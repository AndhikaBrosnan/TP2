import java.util.ArrayList;

public class Storage {
    ArrayList<Goods> goods = new ArrayList<>();
    ArrayList<Storage> storages = new ArrayList<>();


    public Storage() {
    }

    public Storage(ArrayList<Goods> goods) {
        this.goods = goods;
    }


    public ArrayList<Storage> getStorages() {
        return storages;
    }

    public void setStorages(Storage storages) {
        this.storages.add(storages);
    }

    public ArrayList<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods.add(goods);
    }
}
