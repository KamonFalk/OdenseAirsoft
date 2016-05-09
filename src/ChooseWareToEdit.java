import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Falk on 09/05/2016.
 */
public class ChooseWareToEdit {

    Stage chooseWareToEditObject;

    //Retrieves a list of wares from the database the user then selects a ware from to edit
    public void chooseWareToEdit(){

        GridPane gridPane = new GridPane();
        Scene editWareScene = new Scene(gridPane, 500, 500);
        editWareScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        chooseWareToEditObject.setTitle("Odense Airsoft alpha 1.0 - Valg af Vare");
        chooseWareToEditObject.setScene(editWareScene);
    }
}
