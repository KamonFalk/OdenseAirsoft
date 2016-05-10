import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Falk on 04/05/2016.
 */
public class Wares{

    private SimpleIntegerProperty wareID;
    private SimpleStringProperty name;
    private SimpleIntegerProperty price;
    private SimpleIntegerProperty amount;

    public Wares(Integer wareID, String name, Integer price, Integer amount){
        this.wareID = new SimpleIntegerProperty (wareID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.amount = new SimpleIntegerProperty (amount);
    }

    Wares(String name, int price, int amount){
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.amount = new SimpleIntegerProperty (amount);
    }

    Wares(){}

    public Integer getWareID() {return wareID.get();}

    public SimpleIntegerProperty wareIDProperty() {return wareID;}

    public void setWare_ID(Integer wareID) {this.wareID.set(wareID);}



    public String getName() {return name.get();}

    public SimpleStringProperty nameProperty() {return name;}

    public void setName(String name) {this.name.set(name);}





    public Integer getPrice() {return price.get();}

    public SimpleIntegerProperty priceProperty() {return price;}

    public void setPrice(Integer price) {this.price.set(price);}




    public Integer getAmount() {return amount.get();}

    public SimpleIntegerProperty amountProperty() {return amount;}

    public void setAmount(Integer amount) {this.amount.set(amount);}
}
