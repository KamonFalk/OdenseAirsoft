import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Created by Falk on 09/05/2016.
 */
public class ChooseWareToEdit {

    final ObservableList<Wares> wareList =
            FXCollections.observableArrayList(
                    new Wares("Hej", 2, 2),
                    new Wares("Hej", 2, 2),
                    new Wares("Hej", 2, 2),
                    new Wares("Hej", 2, 2),
                    new Wares("Hej", 2, 2),
                    new Wares("Hej", 2, 2),
                    new Wares("Hej", 2, 2),
                    new Wares("Hej", 2, 2),
                    new Wares("Hej", 2, 2),
                    new Wares("Hej", 2, 2));
    private Stage chooseWareToEditObject;

    //Retrieves a list of wares from the database the user then selects a ware from to edit
    void chooseWareToEdit(){

        chooseWareToEditObject = new Stage();

        TableView<Wares> table = new TableView<Wares>();

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
        table.setEditable(true);

        TableColumn<Wares, String> nameCol = new TableColumn<Wares, String>("Navn");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Wares, String>("navn"));

        TableColumn<Wares, String> priceCol = new TableColumn<Wares, String>("Pris");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Wares, String>("pris"));

        TableColumn<Wares, String> amountCol = new TableColumn<Wares, String>("Antal");
        amountCol.setMinWidth(100);
        amountCol.setCellValueFactory(
                new PropertyValueFactory<Wares, String>("antal"));

        table.setItems(wareList);
        table.getColumns().addAll(nameCol, priceCol, amountCol);

        final TextField addName = new TextField();
        addName.setPromptText("Navn");
        addName.setMaxWidth(nameCol.getPrefWidth());
        final TextField addPrice = new TextField();
        addPrice.setMaxWidth(priceCol.getPrefWidth());
        addPrice.setPromptText("Pris");
        final TextField addAmount = new TextField();
        addAmount.setMaxWidth(amountCol.getPrefWidth());
        addAmount.setPromptText("Antal");


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 0));
        vbox.getChildren().addAll(label, table);

        //StackPane sp = new StackPane();
        //sp.setId("backgroundDefault");
        //Scene chooseWareToEditScene = new Scene(sp, 500, 500);

        Scene chooseWareToEditScene = new Scene(new Group());
        ((Group)chooseWareToEditScene.getRoot()).getChildren().addAll(vbox);
        chooseWareToEditScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        chooseWareToEditObject.setTitle("Odense Airsoft alpha 1.0 - Valg af vare til redigering");
        chooseWareToEditObject.setScene(chooseWareToEditScene);
        chooseWareToEditObject.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });
        chooseWareToEditObject.initModality(Modality.APPLICATION_MODAL);
        chooseWareToEditObject.show();

    }
    private void closeProgram(){

        Boolean answer = ConfirmBox.display("Luk", "Er du sikker på, at du vil lukke?");

        if (answer.equals(true)) {
            chooseWareToEditObject.close();
        }
    }
}
