import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static ArrayList<Goods> arrGoods = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("TP2=-=-=-=-=-=-=-=-=-=-=-=TP2=-=-=-=-=-=-=-=-=-=-=-=TP2");

        arrGoods.add(new Goods("Brosnan", 1111, "HAHA8", Tipe.BERACUN));
        arrGoods.add(new Goods("Brosnan", 1111, "HAHA7", Tipe.BERACUN));
        arrGoods.add(new Goods("Andhika", 2222, "HAHA6", Tipe.MAKANAN));
        arrGoods.add(new Goods("Silalahi", 3333, "xixi7", Tipe.NETRAL));

        Scanner input = new Scanner(System.in);
        String perintah = "";

        while (true) {
            System.out.print("Masukan perintah: ");
            // TODO: 10/16/2019 NTAR UBAH JADI
            perintah = input.nextLine();
            String[] cmd = perintah.split(" ");

            cmd[0] = cmd[0].toLowerCase();

            switch (cmd[0]) {
                case "t":
                    System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+Menambah BARANG=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
//                    arrGoods.add(new Goods("DUMMY", 4444, recCheckId("HAHA6", arrGoods.size() - 1), Tipe.NETRAL));
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

//            for (int i = 0; i < arrGoods.size(); i++) {
//                System.out.println("Nama: " + arrGoods.get(i).getNama() + ", ID: " + arrGoods.get(i).getId());
//            }
        }
    }

    public static String recFixId(String id, int idx) {

        ArrayList<Integer> tmpAngka = new ArrayList<>();

        for (int i = 0; i < arrGoods.size() ; i++) {
            tmpAngka.add(Integer.parseInt(arrGoods.get(i).getId().substring(4)));
        }

        Collections.sort(tmpAngka);

        int angkaID = Integer.parseInt(id.substring(4));

        for (int i = 0; i < tmpAngka.size(); i++) {
            if (angkaID == tmpAngka.get(i)){
                angkaID+=1;
            }
        }

        String nmdantp = id.substring(0, 4);
        nmdantp+=angkaID;

        System.out.println("DATA BERUBAH!");
        return nmdantp;
    }

    public static String recCheckId(String idlama, int index) {
        System.out.println("MASOK RECHECKID, index: " + index);
        if (index == 0) {
            return idlama;
        } else {
            System.out.println("ID: " + arrGoods.get(index).getId());
            System.out.println("idlama: " + idlama);
            if (idlama.substring(0, 4).equals(arrGoods.get(index).getId().substring(0, 4))) {
                System.out.println("INDEX " + index + " SAMA(sub0-4):  " + idlama.substring(0, 4));
                return recFixId(idlama, index);
            } else {
                return recCheckId(idlama, index - 1);
            }
        }
    }
}
