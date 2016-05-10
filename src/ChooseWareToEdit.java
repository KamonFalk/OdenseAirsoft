import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Created by Falk on 09/05/2016.
 */
public class ChooseWareToEdit{
    EditWare editWareObject = new EditWare();
    Wares chosen;
    private TableView<Wares> table = new TableView<>();
    ObservableList<Wares> wareList =
            FXCollections.observableArrayList(
                    new Wares(2, "Hej", 2, 2),
                    new Wares(2, "Hej", 2, 2),
                    new Wares(3, "Hej", 2, 2),
                    new Wares(4, "Hej", 2, 2),
                    new Wares(5, "Hej", 2, 2),
                    new Wares(6, "Hej", 2, 2),
                    new Wares(7, "Hej", 2, 2),
                    new Wares(8, "Hej", 2, 2),
                    new Wares(9, "Hej", 2, 2),
                    new Wares(10, "Hej", 2, 2));
    private Stage chooseWareToEditObject;

    //Retrieves a list of wares from the database the user then selects a ware from to edit
    void chooseWareToEdit(){

        chooseWareToEditObject = new Stage();
        chooseWareToEditObject.setWidth(400);
        chooseWareToEditObject.setHeight(500);

        final Label label = new Label("Varer");
        label.setFont(new Font("Arial", 20));
        table.setEditable(true);
        ObservableValue<Integer> a = new ObservableValue<Integer>() {
            @Override
            public void addListener(ChangeListener<? super Integer> listener) {

            }

            @Override
            public void removeListener(ChangeListener<? super Integer> listener) {

            }

            @Override
            public Integer getValue() {
                return null;
            }

            @Override
            public void addListener(InvalidationListener listener) {

            }

            @Override
            public void removeListener(InvalidationListener listener) {

            }
        };

        TableColumn<Wares, String> nameColumn = new TableColumn<>("Navn");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(e -> e.getValue().nameProperty());
        nameColumn.setOnEditCommit( (TableColumn.CellEditEvent<Wares, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setName(t.getNewValue());
        });
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Wares, Integer> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(e -> a);
        priceCol.setOnEditCommit( (TableColumn.CellEditEvent<Wares, Integer> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setPrice(t.getNewValue());
        });

       //priceCol.setCellFactory(TextFieldTableCell.forTableColumn());

/*        TableColumn<Wares, String> priceCol = new TableColumn<>("Pris");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<>("price"));*/

        TableColumn<Wares, String> amountCol = new TableColumn<>("Antal");
        amountCol.setMinWidth(100);
        amountCol.setCellValueFactory(
                new PropertyValueFactory<>("amount"));

        table.setItems(wareList);
        table.getColumns().setAll(nameColumn, priceCol, amountCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(label, table);

        StackPane sp = new StackPane();
        sp.setId("backgroundDefault");
        Scene chooseWareToEditScene = new Scene(new Group());
        ((Group)chooseWareToEditScene.getRoot()).getChildren().addAll(vbox);
        chooseWareToEditScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        chooseWareToEditObject.setTitle("Odense Airsoft alpha 1.0 - Valg af vare til redigering");
        chooseWareToEditObject.setScene(chooseWareToEditScene);
       /* chooseWareToEditObject.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });*/
        chooseWareToEditObject.initModality(Modality.APPLICATION_MODAL);
        chooseWareToEditObject.show();
        System.out.println(wareList);
    }
    private void closeProgram(){

        Boolean answer = ConfirmBox.display("Luk", "Er du sikker på, at du vil lukke?");

        if (answer.equals(true)) {
            chooseWareToEditObject.close();
        }
    }
}
