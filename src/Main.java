import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Goods> arrGoods = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("TP2=-=-=-=-=-=-=-=-=-=-=-=TP2=-=-=-=-=-=-=-=-=-=-=-=TP2");

        arrGoods.add(new Goods("Brosnan", 1111, "HAHA05", Tipe.BERACUN));
        arrGoods.add(new Goods("Andhika", 2222, "HAHA06", Tipe.MAKANAN));
        arrGoods.add(new Goods("Silalahi", 3333, "HIHI07", Tipe.NETRAL));

        Scanner input = new Scanner(System.in);
        String perintah = "";

        while (true) {
            System.out.print("Masukan perintah: ");
            // TODO: 10/16/2019 NTAR UBAH JADI
            perintah = input.nextLine();
            String[] cmd = perintah.split(" ");
            switch (cmd[0]) {
                case "t":
                    System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+Menambah BARANG=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
                    arrGoods.add(new Goods("DUMMY", 4444, recCheckId("HAHA06", arrGoods.size() - 1), Tipe.NETRAL));
                    break;
                case "detail":
                    System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+Menampilkan DETAIL=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
                    break;
                case "hapus":
                    break;
                case "cari":
                    break;
                default:
                    System.out.println("Masukan INVALID!");
                    break;
            }

            for (int i = 0; i < arrGoods.size(); i++) {
                System.out.println("Nama: " + arrGoods.get(i).getNama() + ", ID: " + arrGoods.get(i).getId());
            }
        }
    }

    public static String recFixId(String id) {

        String hrg = arrGoods.get(arrGoods.size() - 1).getId().substring(4);
        String nmdantp = id.substring(0, 4);
        System.out.println("test substring: "+nmdantp);
        System.out.println("pisah harga 1: " + hrg);
        System.out.println("pisah harga 2: " + nmdantp);
        int harga = Integer.parseInt(hrg);
        harga += 1;
        nmdantp = nmdantp + harga;

        System.out.println("DATA BERUBAH!");
        return nmdantp;

    }

    public static String recCheckId(String idlama, int index) {
        System.out.println("MASOK RECHECKID, index: "+ index);
        if (index == 0) {
            return idlama;
        } else {
            System.out.println("ID: " + arrGoods.get(index).getId());
            System.out.println("idlama: " + idlama);
            if (idlama.equals(arrGoods.get(index).getId())) {
                System.out.println("INDEX "+index+" SAMA");
                return recCheckId(recFixId(idlama), index - 1);
            } else {
                System.out.println("INDEX "+index+" tidak SAMA");
                return recCheckId(idlama, index - 1);
            }

        }
    }
}
