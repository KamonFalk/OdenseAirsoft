import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
        Label labelHovedMenu = new Label("                      " + "Velkommen!\n Brug knapperne til at navigere rundt");
        labelHovedMenu.setFont(Font.font(null, FontWeight.BOLD, 24));
        labelHovedMenu.setAlignment(Pos.TOP_CENTER);
        Label l_medlem = new Label("Medlem");
        Label l_kiosk = new Label("Kiosk");
        Label l_udstyr = new Label("Udstyr");

        // Buttons
        Button b_opret = new Button("Opret medlem");
               b_opret.setOnAction(e -> createMemberObject.createMember());
        Button b_lister = new Button("Lister");
        Button b_check = new Button("Check");

        Button b_varesortiment = new Button("Varesortiment");
        Button b_salg = new Button("Salg");

        Button b_udlej = new Button("Udlej");

        Button b_logud = new Button("Log ud");

        // HBox til label
        HBox label = new HBox();
        label.setSpacing(30);
        label.setPadding(new Insets(35, 0, 35, 0));
        label.setAlignment(Pos.TOP_CENTER);
        label.getChildren().add(labelHovedMenu);

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
        vBox.getChildren().addAll(label, medlemBox, kioskBox, udstyrBox);

        StackPane sp = new StackPane();
        sp.getChildren().addAll(vBox);
        sp.setId("backgroundDefault");

        Scene scene2 = new Scene(sp, 500, 350);
        scene2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        mainMenu2.setTitle("Odense Airsoft alpha 1.0 - HOVEDMENU ");
        mainMenu2.setScene(scene2);
        mainMenu2.show();

    }

}