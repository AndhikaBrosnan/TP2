import org.jetbrains.annotations.NotNull;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IndoStorSystem {

    public static Store str = new Store();
    public static ArrayList<Store> lstStr = str.getList_store();

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
                case "hapus":
                    int temp_4 = 0;
                    String nama = cmd[1];

                    boolean cekAda = false;
                    int jmlHrgBarang = 0;

                    for (int i = 0; i < lstStr.size(); i++) {
                        if (lstStr.get(i).getNm_store().equals(nama)) {
                            for (int j = 0; j < lstStr.get(i).getList_storage().size(); j++) {
                                for (int k = 0; k < lstStr.get(i).getList_storage().get(j).getGoods().size(); k++) {
                                    Goods gds = lstStr.get(i).getList_storage().get(j).getGoods().get(k);
                                    jmlHrgBarang += gds.getHarga();
                                }
                            }

                            System.out.println("Berhasil menghapus dengan nama " + lstStr.get(i).getNm_store()
                                    + " dengan total harga barang " + jmlHrgBarang);
                            cekAda = true;
                            lstStr.remove(i);
                        }
                    }

                    if (cekAda == false) {
                        System.out.println("Tidak ada store dengan nama tersebut");
                    }

                    break;

                case "cari":
                    int temp_0 = 0;
                    int temp_1 = 0;
                    boolean kosong = true;

                    for (int i = 0; i < lstStr.size(); i++) {
                        for (int j = 0; j < lstStr.get(i).getList_storage().size(); j++) {
                            Storage strge = lstStr.get(i).getList_storage().get(j);
                            for (int k = 0; k < strge.getGoods().size(); k++) {
                                if (strge.getGoods().get(k).getNama().equals(cmd[2])) {
                                    System.out.println("Store dengan " + cmd[2] + "berada di store: " + lstStr.get(i).getNm_store());
                                    //get the i and j
                                    temp_0 = i;
                                    kosong = false;
                                }
                            }
                        }
                        //Handling data kosong!

                    }

                    if (kosong == true) {
                        System.out.println("Data tidak ditemukan");
                        continue;
                    } else {

                        for (int i = 0; i < lstStr.get(temp_0).getList_storage().size(); i++) {
                            Storage strge = lstStr.get(temp_0).getList_storage().get(i);
                            for (int j = 0; j < strge.getGoods().size(); j++) {
                                System.out.println(". Nama: " + strge.getGoods().get(j).getNama()
                                        + " Harga: " + strge.getGoods().get(j).getHarga()
                                        + " Id: " + strge.getGoods().get(j).getId());

                            }
                        }

                    }

                    kosong = false;
                    temp_0 = 0;
                    temp_1 = 1;
                    break;

                case "tambah":
                    // TODO: 11/6/2019 TAMBAH 
                    switch (cmd[1]) {
                        case "store":
                            System.out.print("Masukan nama Store: ");
                            nm_store = input.nextLine();


                            if (nm_store.equals("") || nm_store.equals(" ")) {
                                System.out.println("Input salah!");
                                break;
                            }

                            // TODO: 11/6/2019 Cek STORE apabila namanya DUPLIKAT
                            for (int i = 0; i < lstStr.size(); i++) {
                                if (lstStr.get(i).getNm_store().equals(nm_store)) {
                                    System.out.println("Store dengan nama tersebut sudah ada, harap ganti nama");
                                    duplikat = true;
                                    break;
                                }
                            }

                            //jika duplikat
                            if (!duplikat) {
                                str.setList_store(new Store(nm_store));
                                for (int i = 0; i < lstStr.size(); i++) {
                                    if (lstStr.get(i).getNm_store().equals(nm_store)) {
                                        // tambah 3 storage kosong
                                        lstStr.get(i).setList_storage(new Storage());
                                        lstStr.get(i).setList_storage(new Storage());
                                        lstStr.get(i).setList_storage(new Storage());
                                    }
                                }
                                System.out.println("Store bertambah!");
                            }
                            duplikat = false;
                            break;

                        case "barang":
                            // TODO: 11/6/2019 tambah BARANG
                            System.out.print("Masukan nama barang: ");
                            nm_produk = input.nextLine();
                            System.out.print("Masukan tipe barang: ");
                            tipe_produkString = input.nextLine();
                            System.out.print("Masukan harga barang: ");
                            hrg_produk = input.nextInt();
                            System.out.print("Masukan kuantitas barang: ");
                            jml_produk = input.nextInt();

                            //di passing ke fungsi aja, soalnya panjang
                            tambahBarang(nm_produk,tipe_produkString,hrg_produk, jml_produk, cmd[2]);

                            break;
                    }
                    break;

                case "exit":
                    System.out.println("Terimakasih!");
                    break loop;

                case "lihat":
                    for (int i = 0; i < lstStr.size(); i++) {
                        System.out.println("Nama Store " + (i + 1) + " : " + lstStr.get(i).getNm_store());
                    }
                    break;

                case "tampilkan":
                    int jmlHargaTampil = 0;
                    int fck = 0;
                    if (lstStr.size() == 0) {
                        System.out.println("[]");
                    }

                    for (int i = 0; i < lstStr.size(); i++) {

                        for (int j = 0; j < lstStr.get(i).getList_storage().size(); j++) {
                            for (int k = 0; k < lstStr.get(i).getList_storage().get(j).getGoods().size(); k++) {
                                if (lstStr.get(i).getList_storage().get(j).getGoods().get(k).getHarga() != 0) {

                                    jmlHargaTampil += lstStr.get(i).getList_storage().get(j).getGoods().get(k).getHarga();
                                }
                            }
                        }
                        System.out.println((++fck) + ". " + lstStr.get(i).getNm_store() + " jumlah harga: " + jmlHargaTampil);
                        jmlHargaTampil = 0;
                    }
                    break;

                case "detail":
                    int temp = 0;
                    int temp1 = 0;
                    int urutan = 0;
                    ArrayList<Goods> tampung;

                    //dapetin indexnya aja
                    for (int i = 0; i < lstStr.size(); i++) {
                        if (cmd[2].equals(lstStr.get(i).getNm_store())) {
                            temp1 = i;
                        }
                    }

                    //===========================>>>>DANGEROUS<<<<===============================
                    System.out.println("          ====" + lstStr.get(temp1).getNm_store() + "====");
                    System.out.println("Barang yang dimiliki: ");
                    for (int i = 0; i < lstStr.size(); i++) {
                        if (lstStr.get(i).getNm_store().equals(cmd[2])) {
                            for (int j = 0; j < lstStr.get(i).getList_storage().size(); j++) {
                                System.out.println("STORAGE NOMOR:" + j);
                                Storage strge = lstStr.get(i).getList_storage().get(j);
                                for (int k = 0; k < strge.getGoods().size(); k++) {
                                    System.out.println(". Nama: " + strge.getGoods().get(k).getNama()
                                            + " Harga: " + strge.getGoods().get(k).getHarga()
                                            + " Id: " + strge.getGoods().get(k).getId()
                                            + " TIPE: " + strge.getGoods().get(k).getTipe());
                                }
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

    @NotNull
    public static String recFixId(String id, int idx_store) {

        // 10/20/2019 di sort dulu baru tambahin nomor ID
        ArrayList<Integer> tmpAngka = new ArrayList<>();

        // TODO: 11/6/2019 'RECURSIVE BIKIN ID'Ambil semua index goods.terus diurutin
        for (int i = 0; i < lstStr.get(idx_store).getList_storage().size(); i++) {
            Storage strge = lstStr.get(idx_store).getList_storage().get(i);
            for (int j = 0; j < strge.getGoods().size(); j++) {
                tmpAngka.add(Integer.parseInt(strge.getGoods().get(j).getId().substring(4)));
            }

        }

        //todo 'RECFIXID' dari angka angka yang ada dalam goods, di sort dulu
        Collections.sort(tmpAngka);

        int angkaID = Integer.parseInt(id.substring(4));

        //  10/20/2019 cek duplikat
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


    public static String recCheckId(String idlama, int index, int idx_Store, int idx_Storage) {
        // TODO: 11/6/2019 Yang dipanggil id kalo di method main diatas. 
        if (index == -1) {
            return idlama;
        } else {
            //  10/20/2019 AMBIL VARIABLE DARI Goods yang ada di store
            Storage strge = lstStr.get(idx_Store).getList_storage().get(idx_Storage);
            System.out.println("ID: " + strge.getGoods().get(index).getId());
            System.out.println("idlama: " + idlama);
            if (idlama.substring(0, 4).equals(strge.getGoods().get(index).getId().substring(0, 4))) {
                // TODO: 11/6/2019 KALO UDAH DAPET YANG SAMA, TAMBAHIN DENGAN METHOD recFixId() 
                return recFixId(idlama, idx_Store);
            } else {
                // TODO: 11/6/2019 Kalo ga sama dengan yang diatas, iterasi lagi
                return recCheckId(idlama, index - 1, idx_Store, idx_Storage);
            }
        }
    }

    public static void cekBarang(String nmBarang){

    }

    public static void tambahBarang(String nmBarang, String tipeBarang, int hrgBarang, int qtyBarang, String command){

        Tipe tipe_produk = null;
        String tipe_id_prod = "";
        String id_produk = "";
        String nm_produk = nmBarang;
        String tipe_produkString = tipeBarang;
        int hrg_produk = hrgBarang;
        int jml_barang = qtyBarang;
        String id_lama = "";
        String tipePd;

        // TODO: 11/6/2019 'BUAT ID' ambil harga
        String tmp = "";
        tmp = Integer.toString(hrg_produk);
        String[] tmp1;
        tmp1 = tmp.split("");
        int tmp2 = 0;

        // TODO: 11/6/2019 buat tambahin setiap karakter dari harga
        for (int i = 0; i < tmp1.length; i++) {
            tmp2 += Integer.parseInt(tmp1[i]);
        }

        String nm_1111 = "";
        int jmlharga = 0;
        // ganti id_produk dengan id_produk yang sudah di modifikasi

        // TODO: 11/6/2019 'Buat ID'Ambil karakter pertama dan terakhir ditambah dengan Tipe
        for (int i = 0; i < lstStr.size(); i++) {
            if (lstStr.get(i).getNm_store().equals(command)) {

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

                //  10/28/2019 MASUKIN GOODS KE STORAGE YANG UDAH DI BIKIN!
                //  10/28/2019 CEK kalo dia kosong, baru isi, kalo penuh baru jangan isi
                String tmp_id = nm_1111 + tipe_id_prod + jmlharga;

                int tmp_a = 0;

                lupstge:
                for (int j = 0; j < lstStr.get(i).getList_storage().size(); j++) {

                    //TODO kalo udah di index terakhir tambahin storagenya 3
                    if (j == lstStr.get(i).getList_storage().size() - 1) {
                        lstStr.get(i).setList_storage(new Storage());
                        lstStr.get(i).setList_storage(new Storage());
                        lstStr.get(i).setList_storage(new Storage());
                    }


                    //TODO pindah storage kalo udah penuh
                    System.out.println("====MENAMBAHKAN DI STORAGE KE: ====: " + j);
                    if (lstStr.get(i).getList_storage().get(j).getGoods() != null
                            && lstStr.get(i).getList_storage().get(j).getGoods().size() < 3) {

                        Storage strge = lstStr.get(i).getList_storage().get(j); //ini penting dipake pas masukin barang ke strge

                        if (tipe_produk == Tipe.BERACUN) {
                            // TODO: 11/6/2019 kalau storageya disamping kiri makanan padahal tipenya beracun
                            //pake try karena kalo index ke 0 ga punya samping kiri
                            try {
                                int sizey = lstStr.get(i).getList_storage().get(j).getGoods().size();
                                if (lstStr.get(i).getList_storage().get(j).getGoods().get(sizey - 1).getTipe() == Tipe.MAKANAN) {
                                    //if size 2 tambah storage,
                                    if (sizey > 1) {
                                        System.out.println("Tidak bisa ditambahkan di storage ini, pindah storage ...");
                                        ++j;
                                    } else {
                                        //TODO tambah goods "kosong"
                                        String cekIDKosong;
                                        cekIDKosong = recCheckId("KGNE1", strge.getGoods().size() - 1, i, j);
                                        strge.setGoods(new Goods("Kosong", 1, cekIDKosong, Tipe.NETRAL));
                                    }
                                }
                            } catch (Exception e) {
//                                                    System.out.println("error barang beracun: " + e);
                            }
                        } else if (tipe_produk == Tipe.MAKANAN) {
                            // TODO: 11/6/2019 cek goods di samping kirinya
                            try {
                                int sizey = lstStr.get(i).getList_storage().get(j).getGoods().size();
                                if (lstStr.get(i).getList_storage().get(j).getGoods().get(sizey - 1).getTipe() == Tipe.BERACUN) {
                                    if (sizey > 1) { //kalau
                                        System.out.println("Tidak bisa ditambahkan di storage ini, pindah storage ...");
                                        ++j;
                                    } else {
                                        //tambah goods "kosong"
                                        String cekIDKosong;
                                        cekIDKosong = recCheckId("KGNE1", strge.getGoods().size() - 1, i, j);
                                        strge.setGoods(new Goods("Kosong", 1, cekIDKosong, Tipe.NETRAL));
                                    }

                                }
                            } catch (Exception e) {

                            }
                        }

                        tmp_a = j; //ngedapetin index si storage

                        try {
                            id_produk = recCheckId(tmp_id, strge.getGoods().size() - 1, i, j);
                            strge.setGoods(new Goods(nm_produk, hrg_produk, id_produk, tipe_produk));
                        } catch (Exception e) {
                            System.out.println("DON'T WORRY we're using try catch");
                            Storage strgeKhusus = lstStr.get(i).getList_storage().get(j);
                            strgeKhusus.setGoods(new Goods(nm_produk, hrg_produk, id_produk, tipe_produk));
                        }

                        break lupstge;
                    }
                }

                System.out.println("Barang " + nm_produk + " berhasil ditambahkan pada " +
                        lstStr.get(i).getNm_store());
                break;
            }
        }
    }

}