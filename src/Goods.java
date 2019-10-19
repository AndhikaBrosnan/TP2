enum Tipe{
    BERACUN, MAKANAN, NETRAL
}

public class Goods {
    String id;
    String nama;
    int harga;
    Tipe tipe;

    public Goods() {
    }

    public Goods(String nama, int harga,String id, Tipe tipe) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.tipe = tipe;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public Tipe getTipe() {
        return tipe;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setTipe(Tipe tipe) {
        this.tipe = tipe;
    }
}
