import java.util.ArrayList;

public class Store {
    private String nm_store;
    private ArrayList<Goods> list_produk = new ArrayList<>();
    private ArrayList<Store> list_store = new ArrayList<>();
    private ArrayList<Storage> list_storage = new ArrayList<>(3);

    //CONSTRUCTOR
    public Store() {
    }

    public Store(String nm_store) {
        this.nm_store = nm_store;
    }

    //STORE
    public void setList_store(Store store) {
        this.list_store.add(store);
    }

    public void setNm_store(String nm_store) {
        this.nm_store = nm_store;
    }

    public ArrayList<Store> getList_store() {
        return list_store;
    }

    public String getNm_store() {
        return nm_store;
    }

    //PRODUK
    public void setList_produk(Goods list_produk) {
        this.list_produk.add(list_produk);
    }

    public ArrayList<Goods> getList_produk() {
        return list_produk;
    }

    //STORAGE
    public void setList_storage(Storage list_storage) {
        this.list_storage.add(list_storage);
    }

    public ArrayList<Storage> getList_storage() {
        return list_storage;
    }
}
