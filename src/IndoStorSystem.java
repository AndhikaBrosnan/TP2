import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IndoStorSystem {

//    public static ArrayList<Goods> arrGoods = new ArrayList<>();

    public static Store str = new Store();

    public static void main(String[] args) {
        System.out.println();

        String perintah = "tampilkan";
        Goods prd = new Goods();

        ArrayList<Store> listStore = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        boolean duplikat = false;

        //produk
        String nm_produk;
        int hrg_produk;
        int jml_produk;
        String id_lama = "";
        String id_produk = "";
        String tipe_produkString;
        Tipe tipe_produk;
        String tipe_id_prod;

        //store
        String nm_store;

        System.out.println("=====SIMULASI PENYIMPANAN BARANG=====");
        System.out.print("tekan enter . . .");


        loop:
        do {
            input.nextLine();
            System.out.print("Silahkan masukan perintah: ");
            perintah = input.nextLine();
            String[] cmd = perintah.split(" ");
            perintah = cmd[0];
            cmd[0] = cmd[0].toLowerCase();

            switch (cmd[0]) {
                case "update":


                    int temp_4 = 0;

                    for (int i = 0; i < str.getList_store().size(); i++) {
                        for (int j = 0; j < str.getList_store().get(i).getList_produk().size(); j++) {
                            if (str.getList_store().get(i).getList_produk().get(j).getNama().equals(cmd[2])) {
                                temp_4 = i;
                                System.out.println("Form Update Data Barang di " + str.getList_store().get(i).getNm_store());
                            }
                        }
                    }

                    System.out.print("Masukan nama barang: ");
                    nm_produk = input.nextLine();
                    System.out.print("Masukan tipe barang: ");
                    tipe_produkString = input.nextLine();
                    System.out.print("Masukan harga barang: ");
                    hrg_produk = input.nextInt();
                    System.out.print("Masukan kuantitas barang: ");
                    jml_produk = input.nextInt();


                    for (int j = 0; j < str.getList_store().get(temp_4).getList_produk().size(); j++) {
                        if (str.getList_store().get(temp_4).getList_produk().get(j).getNama().equals(nm_produk)) {
                            str.getList_store().get(temp_4).getList_produk().get(j).setHarga(hrg_produk);

                            System.out.println("Data berhasil diubah!");
                        }
                    }
                    break;

                case "cari":
                    int temp_0 = 0;
                    int temp_1 = 0;
                    boolean kosong = true;

                    for (int i = 0; i < str.getList_store().size(); i++) {
                        for (int j = 0; j < str.getList_store().get(i).getList_produk().size(); j++) {
                            if (str.getList_store().get(i).getList_produk().get(j).getNama().equals(cmd[2])) {
                                System.out.println("Store dengan " + cmd[2] + "berada di store: " + str.getList_store().get(i).getNm_store());
                                //get the i and j
                                temp_0 = i;
                                kosong = false;
                            }
                        }
                        // TODO: 10/5/2019 Handling data kosong!

                    }

                    if (kosong == true) {
                        System.out.println("Data tidak ditemukan");
                        continue;
                    } else {
                        for (int j = 0; j < str.getList_store().get(temp_0).getList_produk().size(); j++) {
                            System.out.println(". Nama: " + str.getList_store().get(temp_0).getList_produk().get(j).getNama()
                                    + " Harga: " + str.getList_store().get(temp_0).getList_produk().get(j).getHarga()
                                    + " Id: " + str.getList_store().get(temp_0).getList_produk().get(j).getId());

                        }
                    }

                    kosong = false;
                    temp_0 = 0;
                    temp_1 = 1;
                    break;

                case "tambah":
                    switch (cmd[1]) {
                        case "store":
                            System.out.print("Masukan nama Store: ");
                            nm_store = input.nextLine();

                            for (int i = 0; i < str.getList_store().size(); i++) {
                                if (str.getList_store().get(i).getNm_store().equals(nm_store)) {
                                    System.out.println("Store dengan nama tersebut sudah ada, harap ganti nama");
                                    duplikat = true;
                                    break;
                                }
                            }

                            if (!duplikat) {
                                str.setList_store(new Store(nm_store));
                                System.out.println("Store bertambah!");
                            }
                            duplikat = false;
                            break;

                        case "barang":

                            System.out.print("Masukan nama barang: ");
                            nm_produk = input.nextLine();
                            System.out.print("Masukan tipe barang: ");
                            tipe_produkString = input.nextLine();
                            System.out.print("Masukan harga barang: ");
                            hrg_produk = input.nextInt();
                            System.out.print("Masukan kuantitas barang: ");
                            jml_produk = input.nextInt();

                            String tmp = "";
                            tmp = Integer.toString(hrg_produk);
                            String[] tmp1;
                            tmp1 = tmp.split("");
                            int tmp2 = 0;

                            for (int i = 0; i < tmp1.length; i++) {
                                tmp2 += Integer.parseInt(tmp1[i]);
                            }

                            String nm_1111 = "";
                            int jmlharga = 0;
                            //TODO ganti id_produk dengan id_produk yang sudah di modifikasi

                            for (int i = 0; i < str.getList_store().size(); i++) {
                                if (str.getList_store().get(i).getNm_store().equals(cmd[2])) {


                                    String nm_akhir = nm_produk.substring(nm_produk.length() - 1);
                                    String nm_awal = nm_produk.substring(0, 1);
                                    nm_1111 = nm_awal.toUpperCase() + nm_akhir.toUpperCase();

                                    id_lama = String.valueOf(hrg_produk);
                                    String[] tmp_id_lama = id_lama.split("");

                                    for (int k = 0; k < tmp_id_lama.length; k++) {
                                        jmlharga += Integer.parseInt(tmp_id_lama[k]);
                                    }

                                    if (tipe_produkString.equals("m")) {
                                        tipe_produk = Tipe.MAKANAN;
                                        tipe_id_prod = "FD";
                                    } else if (tipe_produkString.equals("b")) {
                                        tipe_produk = Tipe.BERACUN;
                                        tipe_id_prod = "PD";
                                    } else {
                                        tipe_produk = Tipe.NETRAL;
                                        tipe_id_prod = "NE";
                                    }

                                    String tmp_id = nm_1111 + tipe_id_prod + String.valueOf(jmlharga);

                                    System.out.println("ID SEMENTARAH:: " + tmp_id);
                                    id_produk = recCheckId(tmp_id, str.getList_store().get(i).getList_produk().size() - 1, i);

                                    str.getList_store().get(i).setList_produk(new Goods(nm_produk, hrg_produk, id_produk, tipe_produk));
                                    System.out.println("Barang " + nm_produk + " berhasil ditambahkan pada " +
                                            str.getList_store().get(i).getNm_store());
                                    break;
                                }


                            }
                            break;
                    }
                    break;

                case "exit":
                    System.out.println("Terimakasih!");
                    break loop;

                case "lihat":
                    for (int i = 0; i < str.getList_store().size(); i++) {
                        System.out.println("Nama Store " + (i + 1) + " : " + str.getList_store().get(i).getNm_store());
                    }
                    break;

                case "tampilkan":
                    System.out.println("Nama Goods: " + prd.getNama());
                    System.out.println("Harga Goods: " + prd.getHarga());
                    break;

                case "detail":
                    int temp = 0;
                    int temp1 = 0;
                    int urutan = 0;
                    ArrayList<Goods> tampung;

                    //dapetin indexnya aja
                    for (int i = 0; i < str.getList_store().size(); i++) {
                        if (cmd[2].equals(str.getList_store().get(i).getNm_store())) {
                            temp1 = i;
                        }
                    }

                    // TODO: 10/5/2019 DON'T TOUCH BELOW THIS!!
                    System.out.println("          ====" + str.getList_store().get(temp1).getNm_store() + "====");
                    System.out.println("Barang yang dimiliki: ");
                    for (int i = 0; i < str.getList_store().size(); i++) {
                        if (str.getList_store().get(i).getNm_store().equals(cmd[2])) {
                            for (int j = 0; j < str.getList_store().get(i).getList_produk().size(); j++) {
                                System.out.println(". Nama: " + str.getList_store().get(i).getList_produk().get(j).getNama() +
                                        " Harga: " + str.getList_store().get(i).getList_produk().get(j).getHarga()
                                        + " Id: " + str.getList_store().get(i).getList_produk().get(j).getId());
                            }
                        }

                    }
                    temp = 0;
                    temp1 = 0;
                    urutan = 0;
                    tampung = null;
                    break;
                default:
                    System.out.println("Perintah yang anda masukan tidak benar");
                    break;
            }

        } while (true);
    }

    public static String recFixId(String id, int idx_store) {

        // TODO: 10/20/2019 di sort dulu
        ArrayList<Integer> tmpAngka = new ArrayList<>();

        for (int i = 0; i < str.getList_store().get(idx_store).getList_produk().size(); i++) {
            tmpAngka.add(Integer.parseInt(str.getList_store().get(idx_store).getList_produk().get(i).getId().substring(4)));
        }

        Collections.sort(tmpAngka);

        int angkaID = Integer.parseInt(id.substring(4));

        // TODO: 10/20/2019 cek duplikat
        for (int i = 0; i < tmpAngka.size(); i++) {
            if (angkaID == tmpAngka.get(i)) {
                angkaID += 1;
            }
        }

        String nmdantp = id.substring(0, 4);
        nmdantp += angkaID;

        System.out.println("DATA BERUBAH!");
        return nmdantp;
    }

    public static String recCheckId(String idlama, int index, int idx_Store) {

        if (index == -1) {
            return idlama;
        } else {
            // TODO: 10/20/2019 AMBIL VARIABLE DARI Goods yang ada di store
            System.out.println("ID: " + str.getList_store().get(idx_Store).getList_produk().get(index).getId());
            System.out.println("idlama: " + idlama);
            if (idlama.substring(0, 4).equals(str.getList_store().get(idx_Store).getList_produk().get(index).getId().substring(0, 4))) {
                return recFixId(idlama, idx_Store);
            } else {
                return recCheckId(idlama, index - 1, idx_Store);
            }
        }
    }
}