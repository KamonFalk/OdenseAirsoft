import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainMenu extends LogIn{

    Stage mainMenu;
    CreateMember createMemberObject;

    public void mainMenu(){
        mainMenu = new Stage();
        createMemberObject = new CreateMember();

        // Dropshadow effekt til labels/text
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        // Labels
        Label labelHovedMenu = new Label("                      " +
                "Velkommen!\n Brug knapperne til at navigere rundt");
        labelHovedMenu.setEffect(ds);
        labelHovedMenu.setCache(true);
        labelHovedMenu.setFont(Font.font(null, FontWeight.BOLD, 32));
        labelHovedMenu.setAlignment(Pos.TOP_CENTER);

        // Buttons
        Button buttonMedlem = new Button("Medlem");
        buttonMedlem.setCursor(Cursor.HAND);
        buttonMedlem.setMinSize(100, 100);
        buttonMedlem.getStyleClass().add("button");
        buttonMedlem.setOnAction(e ->
                createMemberObject.createMember()
        );

        Button buttonSpilleDag = new Button("Spilledag");
        buttonSpilleDag.setCursor(Cursor.HAND);
        buttonSpilleDag.setMinSize(100, 100);
        buttonSpilleDag.getStyleClass().add("button");

        Button buttonUdstyr = new Button("Udstyr");
        buttonUdstyr.setCursor(Cursor.HAND);
        buttonUdstyr.setMinSize(100, 100);
        buttonUdstyr.getStyleClass().add("button");

        Button buttonVarer = new Button("Varer");
        buttonVarer.setCursor(Cursor.HAND);
        buttonVarer.setMinSize(100, 100);
        buttonVarer.getStyleClass().add("button");

        Button buttonLogUd = new Button("Log ud");
        buttonLogUd.setCursor(Cursor.HAND);

        // HBox til at sætte knapperne vandret med hinanden
        HBox medlemOgSpilleDag = new HBox();
        medlemOgSpilleDag.setSpacing(30);
        medlemOgSpilleDag.setAlignment(Pos.BOTTOM_CENTER);
        medlemOgSpilleDag.setPadding(new Insets(0, 0, 20, 0));
        medlemOgSpilleDag.getChildren().addAll(buttonMedlem, buttonSpilleDag);

        // HBoxes til at sætte knapperne vandret med hinanden
        HBox udstyrOgVarer = new HBox();
        udstyrOgVarer.setSpacing(30);
        udstyrOgVarer.setAlignment(Pos.TOP_CENTER);
        udstyrOgVarer.setPadding(new Insets(15, 0, 0, 0));
        udstyrOgVarer.getChildren().addAll(buttonUdstyr, buttonVarer);

        // HBoxes til at sætte logUd knappen nede i højre hjørne
        HBox logUd = new HBox();
        logUd.setSpacing(50);
        logUd.setPadding(new Insets(32, 15, 15, 0));
        logUd.setAlignment(Pos.BOTTOM_RIGHT);
        logUd.getChildren().add(buttonLogUd);

        // HBox til label
        HBox label = new HBox();
        label.setSpacing(30);
        label.setPadding(new Insets(35, 0, 35, 0));
        label.setAlignment(Pos.TOP_CENTER);
        label.getChildren().add(labelHovedMenu);

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(label, medlemOgSpilleDag, udstyrOgVarer, logUd);

        StackPane sp = new StackPane();
        sp.getChildren().addAll(vBox);
        sp.setId("backgroundDefault");

        Scene scene2 = new Scene(sp, 900, 506);
        scene2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        mainMenu.setTitle("Odense Airsoft alpha 1.0 - MAIN MENU ");
        mainMenu.setScene(scene2);
        mainMenu.show();

    }

}
