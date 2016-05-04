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

    public Wares(String name, int price, int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Wares(){

    }



    public int getWare_ID() {
        return ware_ID;
    }

    public void setWare_ID(int ware_ID) {
        this.ware_ID = ware_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
