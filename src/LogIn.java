import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 * Created by Flemmer on 13-04-2016.
 */
public class LogIn extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage logInWindow;
    MainMenu2 mainMenu2;
    TextField usernameField;
    PasswordField passwordField;

    @Override
    public void start(Stage primaryStage) throws Exception {

        logInWindow = primaryStage;
        mainMenu2 = new MainMenu2();

        // Labels
        final Label welcomeLabel = new Label("          Odense Airsoft build 1.0 \n\n                 Venligst log ind");
        welcomeLabel.setFont(Font.font("Verdana", 14));
        final Label usernameLabel = new Label("Brugernavn: ");
        usernameLabel.setFont(Font.font("Arial", FontPosture.ITALIC, 10));
        final Label passwordLabel = new Label("Kodeord: ");
        passwordLabel.setFont(Font.font("Arial", FontPosture.ITALIC, 10));

        // Textfields
        usernameField = new TextField();
        passwordField = new PasswordField();
        usernameField.setPromptText("brugernavn");
        passwordField.setPromptText("kodeord");
        usernameField.setMaxSize(250, 100);
        passwordField.setMaxSize(250, 100);

        // Buttons
        final Button logInButton = new Button("Log ind");
        logInButton.setCursor(Cursor.HAND);
        logInButton.setDefaultButton(true);
        logInButton.setOnAction(e -> {
            usernameField.clear();
            passwordField.clear();
            logInWindow.close();
            mainMenu2.mainMenu2(logInWindow);
        });

        final Button helpButton = new Button("?");
        helpButton.setCursor(Cursor.HAND);
        helpButton.setOnAction(e -> PopupBox.display("Hjælp", "For at kunne logge ind, skal bruge et brugernavn og password."));

        // HBox til at samle label og textfield[username], så de står ved siden af hinanden i programmet
        HBox usernameAndUserTextField = new HBox();
        usernameAndUserTextField.setSpacing(5);
        usernameAndUserTextField.getChildren().addAll(usernameLabel, usernameField);

        // HBox til at samle label og textfield[password], så de står ved siden af hinanden i programmet
        HBox passwordAndPassWordTextField = new HBox();
        passwordAndPassWordTextField.setSpacing(19);
        passwordAndPassWordTextField.getChildren().addAll(passwordLabel, passwordField);

        // HBox til at samle de to knapper, så de står ved siden af hinanden i programmet
        HBox helpAndLogInButtons = new HBox();
        helpAndLogInButtons.setSpacing(135);
        helpAndLogInButtons.getChildren().addAll(logInButton, helpButton);

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.getChildren().addAll(welcomeLabel, usernameAndUserTextField, passwordAndPassWordTextField, helpAndLogInButtons);
        vBox.setPadding(new Insets(50, 0, 0, 120));

        StackPane sp = new StackPane();
        sp.getChildren().add(vBox);
        sp.setId("backgroundDefault");

        Scene scene = new Scene(sp);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        logInWindow.setScene(scene);
        logInWindow.setTitle("Odense Airsoft alpha 1.0 - LOG IND");
        logInWindow.setResizable(false);
        logInWindow.setHeight(350);
        logInWindow.setWidth(500);
        logInWindow.show();

    }
}