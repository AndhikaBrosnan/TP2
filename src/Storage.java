import java.util.ArrayList;

public class Storage {
    ArrayList<Goods> goods = new ArrayList<>();

    public Storage(ArrayList<Goods> goods) {
        this.goods = goods;
    }

    public ArrayList<Goods> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Goods> goods) {
        this.goods = goods;
    }
}
