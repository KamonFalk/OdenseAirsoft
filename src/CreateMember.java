import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Flemmer on 28-04-2016.
 */
public class CreateMember extends MainMenu{

    Stage createMemberObject;

    public void createMember(){

        createMemberObject = new Stage();

        // Labels
        final Label title1 = new Label("                                    " +
                "Opret medlem\n\n\n");
        title1.setFont(Font.font("Verdana", 14));
        final Label l_full_name = new Label("          Fulde navn:                  ");
        final Label l_address = new Label("          Adresse:                       ");
        final Label l_city = new Label("          By:                                ");
        final Label l_zip_code = new Label("Post nr:");
        final Label l_email_address = new Label("          E-mail adresse:            ");
        final Label l_phone_number = new Label("          Telefon nr:                   ");
        final Label l_birth_day = new Label("          Fødselsdag:                 ");
        final Label l_membership_period = new Label("          Medlemsperiode:        ");
        final Label l_driverlicense_or_passport = new Label("          Kørekort-/-\n          pas nummer:               ");

        // Textfields
        final TextField tf_full_name = new TextField();
            tf_full_name.setPrefSize(300, 15);
        final TextField tf_address = new TextField();
            tf_address.setPrefSize(300, 15);
        final TextField tf_city = new TextField();
            tf_city.setPrefSize(170, 15);
        final TextField tf_zip_code = new TextField();
            tf_zip_code.setPrefSize(80, 15);
        final TextField tf_email_address =  new TextField();
            tf_email_address.setPromptText("example@example.com");
            tf_email_address.setPrefSize(300, 15);
        final TextField tf_phone_number = new TextField();
            tf_phone_number.setPromptText("+45");
            tf_phone_number.setPrefSize(130, 15);
        final TextField tf_birth_day = new TextField();
            tf_birth_day.setPromptText("dd-mm-yyyy");
            tf_birth_day.setPrefSize(130, 15);
        final TextField tf_membership_period = new TextField();
            tf_membership_period.setPrefSize(250, 15);
        final TextField tf_driverlicense_or_passport = new TextField();
            tf_driverlicense_or_passport.setPrefSize(250, 15);

        // Checkboxes
        Label fillspace = new Label("                                         ");
        ToggleGroup group = new ToggleGroup();
        RadioButton box1 = new RadioButton("Basis medlem");
        box1.setToggleGroup(group);
        box1.setSelected(true);
        RadioButton box2 = new RadioButton("Fuldt medlem");
        box2.setToggleGroup(group);

        // Create button
        Button b_create = new Button("Opret medlem");
            b_create.getStyleClass().add("buttonGreen");
            b_create.getStyleClass().add("button:hover");
            b_create.setCursor(Cursor.HAND);

        // Clear button
        Button b_clear = new Button("Ryd alle felter");
            b_clear.getStyleClass().add("buttonRed");
            b_clear.setCursor(Cursor.HAND);
           b_clear.setOnAction(e -> {
               tf_address.clear();
               tf_birth_day.clear();
               tf_city.clear();
               tf_driverlicense_or_passport.clear();
               tf_email_address.clear();
               tf_full_name.clear();
               tf_membership_period.clear();
               tf_phone_number.clear();
               tf_zip_code.clear();
           });

        // Close button
        Button b_close = new Button("Luk");
        b_close.setCursor(Cursor.HAND);
        b_close.setOnAction(e -> {
            Boolean result = ConfirmBox.display("Luk", "Er du sikker på, at du vil lukke?");

            if(result.equals(true)){
                   createMemberObject.close();
            }
        });

        // HBoxes for buttons
        HBox hb_buttons = new HBox();
        hb_buttons.setSpacing(20);
        hb_buttons.setAlignment(Pos.BOTTOM_CENTER);
        hb_buttons.setPadding(new Insets(20, 0, 0, 70));
        hb_buttons.getChildren().addAll(b_create, b_clear, b_close);

        // HBoxes for radiobuttons
        HBox hb_checkbox = new HBox();
        hb_checkbox.setSpacing(20);
        hb_checkbox.setPadding(new Insets(20, 0, 0, 0));
        hb_checkbox.getChildren().addAll(fillspace, box1, box2);

        // HBoxes to set label and textfield next to each other
        HBox fullname = new HBox();
        fullname.setSpacing(5);
        fullname.getChildren().addAll(l_full_name, tf_full_name);

        HBox address = new HBox();
        address.setSpacing(5);
        address.getChildren().addAll(l_address, tf_address);

        HBox city_zipcode = new HBox();
        city_zipcode.setSpacing(5);
        city_zipcode.getChildren().addAll(l_city, tf_city, l_zip_code, tf_zip_code);

        HBox emailaddress = new HBox();
        emailaddress.setSpacing(5);
        emailaddress.getChildren().addAll(l_email_address, tf_email_address);

        HBox phonenumber = new HBox();
        phonenumber.setSpacing(5);
        phonenumber.getChildren().addAll(l_phone_number, tf_phone_number);

        HBox birthday = new HBox();
        birthday.setSpacing(5);
        birthday.getChildren().addAll(l_birth_day, tf_birth_day);

        HBox membershipperiod = new HBox();
        membershipperiod.setSpacing(5);
        membershipperiod.getChildren().addAll(l_membership_period, tf_membership_period);

        HBox driverlicensepassport = new HBox();
        driverlicensepassport.setSpacing(5);
        driverlicensepassport.getChildren().addAll(l_driverlicense_or_passport, tf_driverlicense_or_passport);

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(title1, fullname, address, city_zipcode, emailaddress, phonenumber, birthday,
                membershipperiod, driverlicensepassport, hb_checkbox, hb_buttons);

        StackPane sp = new StackPane();
        sp.getChildren().addAll(vBox);
        sp.setId("backgroundDefault");

        Scene scene2 = new Scene(sp, 500, 406);
        scene2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        createMemberObject.setTitle("Odense Airsoft alpha 1.0 - OPRET MEDLEM");
        createMemberObject.setScene(scene2);
        createMemberObject.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        createMemberObject.show();

        }

        public void closeProgram(){
            Boolean answer = ConfirmBox.display("Luk", "Er du sikker på, at du vil lukke?");

            if (answer.equals(true)) {
                createMemberObject.close();
            }
        }

    }