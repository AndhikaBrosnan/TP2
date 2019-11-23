//import java.io.FileWriter;
//import java.io.IOException;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import org.json.JSONObject;

import java.io.FileWriter;

public abstract class DatabaseModelObject {

    public static Goods defineAttributeToWrite(String nmGoods, int hrgGoods, String idGoods, Tipe tipeGoods, String nmStore, int numStrge) {
        return null;
    }

    public final void save(String databaseName){

        databaseName = "/E:/UI/Kuliah/Sem 3/DDP2/TP2/src/data.json";

        writeToDatabase();
    }


    public void writeToDatabase(){
        //@TODO Implementasi tulis ke file
        try (FileWriter file = new FileWriter("/E:/UI/Kuliah/Sem 3/DDP2/TP2/src/data.json")) {
            JSONObject goodsDetail = new JSONObject();
            goodsDetail.put("nama", "Brosnan");
            goodsDetail.put("detail", "BNFD57");
            goodsDetail.put("harga", 111111);

            JSONObject storage = new JSONObject();
            storage.put("storage1", goodsDetail);

            file.write(storage.toString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
