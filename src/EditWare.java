import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Falk on 09/05/2016.
 */
public class EditWare {

    private Stage editWareObject;

    int c;
    String name;
    int price;
    int amount;
    public void editWare(Wares c){


        editWareObject = new Stage();
        Wares ware2 = new Wares("Hej", 2, 2);
        // Labels
        final Label title1 = new Label("                                    " +
                "OpretVare\n\n\n");
        title1.setFont(Font.font("Verdana", 14));
        final Label l_name = new Label("Navn:");
        final Label l_price = new Label("Pris:");
        final Label l_amount = new Label("Antal");

        // Textfields
        final TextField tf_name = new TextField();
        tf_name.setPrefSize(300, 15);
        tf_name.setText((ware2.getName()));
        final TextField tf_price = new TextField();
        tf_price.setPrefSize(30, 15);
        tf_price.setText((String.valueOf(ware2.getPrice())));
        final TextField tf_amount = new TextField();
        tf_amount.setPrefSize(30, 15);
        tf_amount.setText((String.valueOf(ware2.getAmount())));


        // Create button
        Button b_Done = new Button("Rediger medlem");
        b_Done.getStyleClass().add("buttonGreen");
        b_Done.getStyleClass().add("button:hover");
        b_Done.setCursor(Cursor.HAND);
        b_Done.setOnAction(e -> {
            ware2.setName(tf_name.getText());
            ware2.setPrice (Integer.parseInt(tf_price.getText()));
            ware2.setAmount (Integer.parseInt(tf_amount.getText()));
        });

        // Clear button
        Button b_clear = new Button("Ryd alle felter");
        b_clear.getStyleClass().add("buttonRed");
        b_clear.setCursor(Cursor.HAND);
        b_clear.setOnAction(e -> {
            tf_name.clear();
            tf_price.clear();
            tf_amount.clear();
        });

        // HBoxes for buttons
        HBox hb_buttons = new HBox();
        hb_buttons.setSpacing(20);
        hb_buttons.setAlignment(Pos.BOTTOM_CENTER);
        hb_buttons.setPadding(new Insets(20, 0, 0, 70));
        hb_buttons.getChildren().addAll(b_Done, b_clear);

        // HBoxes to set label and textfield next to each other

        HBox hBName = new HBox();
        hBName.setSpacing(5);
        hBName.getChildren().addAll(l_name, tf_name);

        HBox hBPrice = new HBox();
        hBPrice.setSpacing(5);
        hBPrice.getChildren().addAll(l_price, tf_price);

        HBox hBAmount = new HBox();
        hBAmount.setSpacing(5);
        hBAmount.getChildren().addAll(l_amount, tf_amount);

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(title1, hBName, hBPrice, hBAmount, hb_buttons);
        vBox.setSpacing(5);
        vBox.getChildren().addAll();

        StackPane sp = new StackPane();
        sp.getChildren().addAll(vBox);
        sp.setId("backgroundDefault");
        Scene editWareScene = new Scene(sp, 500, 500);
        editWareScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        editWareObject.setTitle("Odense Airsoft alpha 1.0 - Rediger Vare");
        editWareObject.setScene(editWareScene);
        editWareObject.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        editWareObject.initModality(Modality.APPLICATION_MODAL);
        editWareObject.show();
    }
    private void closeProgram(){

        Boolean answer = ConfirmBox.display("Luk", "Er du sikker på, at du vil lukke?");

        if (answer.equals(true)) {
            editWareObject.close();
        }
    }
}
