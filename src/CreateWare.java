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
public class CreateWare {

    Stage createWareObject;
    public void createWare(){

        createWareObject = new Stage();

        Wares ware1 = new Wares();
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
        final TextField tf_price = new TextField();
        tf_price.setPrefSize(30, 15);
        final TextField tf_amount = new TextField();
        tf_amount.setPrefSize(30, 15);


        // Create button
        Button b_create = new Button("Opret medlem");
        b_create.getStyleClass().add("buttonGreen");
        b_create.getStyleClass().add("button:hover");
        b_create.setCursor(Cursor.HAND);
        b_create.setOnAction(e -> {
            /*ware1.nameString = tf_name.getText();
            ware1.priceInt = Integer.parseInt(tf_price.getText());
            ware1.amountInt = Integer.parseInt(tf_amount.getText());*/
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
        hb_buttons.getChildren().addAll(b_create, b_clear);

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
        Scene createWareScene = new Scene(sp, 500, 500);
        createWareScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        createWareObject.setTitle("Odense Airsoft alpha 1.0 - Opret Vare");
        createWareObject.setScene(createWareScene);
        createWareObject.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        createWareObject.initModality(Modality.APPLICATION_MODAL);
        createWareObject.show();
    }
    public void closeProgram(){

        Boolean answer = ConfirmBox.display("Luk", "Er du sikker på, at du vil lukke?");

        if (answer.equals(true)) {
            createWareObject.close();
        }
    }
}
