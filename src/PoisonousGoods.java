public class PoisonousGoods extends Goods {
    public int idxRacun;

    public PoisonousGoods() {
    }

    public double calculatePoisinousGood(int idxRacun) {
        double tempPersen = 0;
        tempPersen = 100 - idxRacun;
        tempPersen = 0.01 * tempPersen;

        try {
            if (idxRacun > 0 && idxRacun < 100) {
                System.out.println("Nilai Racun diambang normal");
            } else {
                System.out.println("");
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("NILAI RACUN DIAMBANG TIDAK NORMAL" + e);
        }

        return tempPersen;
    }
}
