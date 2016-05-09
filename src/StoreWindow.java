import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Falk on 04/05/2016.
 */
public class StoreWindow {

    Stage storeWindowObject;
    CreateWare createWareObject;
    ChooseWareToEdit chooseWareToEditObject;
    EditWare editWareObject;

    public void storeWindow(){

        createWareObject = new CreateWare();
        chooseWareToEditObject = new ChooseWareToEdit();
        editWareObject = new EditWare();

        storeWindowObject = new Stage();
        Button buttonCreateWare = new Button("Opret Vare");
        buttonCreateWare.setCursor(Cursor.HAND);
        buttonCreateWare.setMinSize(100, 100);
        buttonCreateWare.getStyleClass().add("button");
        buttonCreateWare.setOnAction(e ->
                createWareObject.createWare()
        );

        Button buttonEditWare = new Button("Rediger Vare");
        buttonEditWare.setCursor(Cursor.HAND);
        buttonEditWare.setMinSize(100, 100);
        buttonEditWare.getStyleClass().add("button");
        buttonEditWare.setOnAction(e ->
                //chooseWareToEdit() and not editWare When chooseWareToEdit is finished
                editWareObject.editWare()
        );
        Button buttonSellWare = new Button("Saelg Vare");
        buttonSellWare.setCursor(Cursor.HAND);
        buttonSellWare.setMinSize(100, 100);
        buttonSellWare.getStyleClass().add("button");

        // HBoxes til at sætte knapperne vandret med hinanden
        HBox createAndEdit = new HBox();
        createAndEdit.setSpacing(30);
        createAndEdit.setAlignment(Pos.TOP_CENTER);
        createAndEdit.setPadding(new Insets(15, 0, 0, 0));
        createAndEdit.getChildren().addAll(buttonCreateWare, buttonEditWare, buttonSellWare);

        HBox hBox = new HBox();
        hBox.setSpacing(5);
        hBox.getChildren().addAll(buttonCreateWare, buttonEditWare, buttonSellWare);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(hBox);
        sp.setId("backgroundDefault");
        Scene storeScene = new Scene(sp, 500, 500);
        storeScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        storeWindowObject.setTitle("Odense Airsoft alpha 1.0 - Varer");
        storeWindowObject.setScene(storeScene);
        storeWindowObject.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        storeWindowObject.show();
    }
    public void closeProgram(){

        Boolean answer = ConfirmBox.display("Luk", "Er du sikker på, at du vil lukke?");

        if (answer.equals(true)) {
            storeWindowObject.close();
        }
    }


}
