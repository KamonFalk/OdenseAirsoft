import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Falk on 04/05/2016.
 */
public class Wares {

    private int ware_ID;
    private SimpleStringProperty name;
    int price;
    int amount;

    public Wares(int ware_ID, String sSPName, int price, int amount){
        this.ware_ID = ware_ID;
        this.name = new SimpleStringProperty(sSPName);
        this.price = price;
        this.amount = amount;
    }

    Wares(String sSPName, int price, int amount){
        this.name = new SimpleStringProperty(sSPName);
        this.price = price;
        this.amount = amount;
    }

    Wares(){

    }

    public int getWare_ID() {
        return ware_ID;
    }

    public void setWare_ID(int ware_ID) {
        this.ware_ID = ware_ID;
    }

    String getName() {
        return name.get();
    }

    void setName(String sSPName) {
        name.set(sSPName);
    }

    int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

    int getAmount() {
        return amount;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }
}
