import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Flemmer on 04-05-2016.
 */
public class MainMenu2 extends LogIn{

    Stage mainMenu2;
    CreateMember createMemberObject;

    public void mainMenu2(){
        mainMenu2 = new Stage();
        createMemberObject = new CreateMember();

        // Labels
        Label l_medlem = new Label("Medlem");
        Label l_kiosk = new Label("Kiosk");
        Label l_udstyr = new Label("Udstyr");

        // Buttons
        Button b_opret = new Button("Opret medlem");
        Button b_lister = new Button("Lister");
        Button b_check = new Button("Check");

        Button b_varesortiment = new Button("Varesortiment");
        Button b_salg = new Button("Salg");

        Button b_udlej = new Button("Udlej");

        Button b_logud = new Button("Log ud");

        // HBox til at sætte labels + knapper langs med hinanden [MEDLEM]
        HBox medlemBox = new HBox();
        medlemBox.setSpacing(30);
        medlemBox.setAlignment(Pos.TOP_CENTER);
        medlemBox.setPadding(new Insets(0, 0, 20, 0));
        medlemBox.getChildren().addAll(l_medlem, b_opret, b_lister, b_check);

        // HBox til at sætte labels + knapper langs med hinanden [KIOSK]
        HBox kioskBox = new HBox();
        kioskBox.setSpacing(30);
        kioskBox.setAlignment(Pos.BASELINE_CENTER);
        kioskBox.setPadding(new Insets(0, 0, 20, 0));
        kioskBox.getChildren().addAll(l_kiosk, b_varesortiment, b_salg);

        // HBox til at sætte labels + knapper langs med hinanden [UDSTYR]
        HBox udstyrBox = new HBox();
        udstyrBox.setSpacing(30);
        udstyrBox.setAlignment(Pos.BOTTOM_CENTER);
        udstyrBox.setPadding(new Insets(0, 0, 20, 0));
        udstyrBox.getChildren().addAll(l_udstyr, b_udlej, b_logud);

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(medlemBox, kioskBox, udstyrBox);

        StackPane sp = new StackPane();
        sp.getChildren().addAll(vBox);
        sp.setId("backgroundDefault");

        Scene scene2 = new Scene(sp, 900, 506);
        scene2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        mainMenu2.setTitle("Odense Airsoft alpha 1.0 - HOVED MENU ");
        mainMenu2.setScene(scene2);
        mainMenu2.show();

    }

}