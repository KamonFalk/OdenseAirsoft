/**
 * Created by Falk on 04/05/2016.
 */
public class Wares {

    int ware_ID;
    String name;
    int price;
    int amount;

    public Wares(int ware_ID, String name, int price, int amount){
        this.ware_ID = ware_ID;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    Wares(String name, int price, int amount){
        this.name = name;
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
        return name;
    }

    void setName(String name) {
        this.name = name;
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
