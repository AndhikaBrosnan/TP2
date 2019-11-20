public class Foods extends ConsumableGoods {
    public int salty;
    public double discountSalty;
    public double diskonConsumGoods;
    //discountConsumableGoods + discountSalty

    public Foods() {
        super();
    }

    public Foods(int salty, double discountSalty, double diskonConsumGoods) {
        super();
        this.salty = salty;
        this.discountSalty = discountSalty;
        super.diskonConsum = diskonConsumGoods;
    }

    public double diskonSaltiness(int salty){
        if (salty > 100){
            discountSalty = 0.05;
            return discountSalty;
        }else if(super.expDate<120){
            discountSalty = 0.04;
            return discountSalty;
        }else {
            discountSalty = 0.01;
            return discountSalty;
        }
    }

    public double akumulasiDiscount(double diskonSaltiness){
        double akumulasi;
        akumulasi = diskonSaltiness + super.diskonConsum;
        System.out.println("Diskom consumable goods: "+ super.diskonConsum);
        System.out.println("DISKON CONSUMABLE di FOODS: "+ super.getDiskonConsum());
        akumulasi = discountSalty + super.getDiskonConsum();

        return akumulasi;
    }
}
