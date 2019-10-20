import java.util.ArrayList;

public class Store {
    private String nm_store;
    private ArrayList<Goods> list_produk = new ArrayList<>();
    private ArrayList<Store> list_store = new ArrayList<>();

    public Store(){}

    public Store(String nm_store){
        this.nm_store = nm_store;
    }

    public Store(String nm_store, ArrayList<Goods> list_produk) {
        this.nm_store = nm_store;
        this.list_produk = list_produk;
    }

    public void setList_store(Store store) {
        this.list_store.add(store) ;
    }

    public void setNm_store(String nm_store) {
        this.nm_store = nm_store;
    }

    public void setList_produk(Goods list_produk) {
        this.list_produk.add(list_produk);
    }

    public void updateListProduk(String name, int harga, int jml,int index){
        for (int i=0;i<list_store.get(index).list_produk.size();i++){
            if(name.equals(list_produk.get(i).getNama())){
                list_produk.get(i).setHarga(harga);
            }
        }
    }

    public ArrayList<Goods> getList_produk() {
        return list_produk;
    }

    public ArrayList<Store> getList_store() {
        return list_store;
    }

    public String getNm_store() {
        return nm_store;
    }

}
