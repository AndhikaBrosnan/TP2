import java.util.Date;

public class ConsumableGoods extends Goods {
    Date date = new Date();
    public int expDate;
    public double diskonConsum = 0;

    public ConsumableGoods() {
        super();
    }

    public ConsumableGoods(String nama, String id, String harga, double discountConsumableGoods) {
        super();
        this.diskonConsum = discountConsumableGoods;
    }

    public void setExpDate(int expDate) {
        this.expDate = expDate;
    }

    public int getExpDate() {
        return expDate;
    }

    public void setDiskonConsum(double diskonConsum) {
        this.diskonConsum = diskonConsum;
    }

    public double getDiskonConsum() {
        return diskonConsum;
    }

    public double calculateDate(int jumlahExpiredDate) {

        try {
            if (jumlahExpiredDate <= 0) {
                System.out.println("Produk belum kadaluarsa!");
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Barang udah kadaluarsa: " + e);
        }

        if (jumlahExpiredDate < 7) {
            diskonConsum = (0.9);
            setDiskonConsum(0.9);
            return diskonConsum;
        } else if (jumlahExpiredDate < 120) {
            diskonConsum = (0.4);
            setDiskonConsum(0.4);
            return diskonConsum;
        } else {
            setDiskonConsum(0.1);
            diskonConsum = (0.1);
            return diskonConsum;
        }
    }

}
