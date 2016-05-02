import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by tomas on 5/1/16.
 */
public class WindowCheckMember extends Application {
	private Label labelWindowHeader = new Label("CHECK");
	private String labelInput = "Indtast navn";
	private String labelButtonCheck = "Check";
	private String labelButtonClose = "Luk";
	private String labelButtonCreateMember = "Opret";

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Fiddle with header
		labelWindowHeader.setFont(new Font("Verdana", 100));

		// Buttons
		Button buttonCheck = new Button(labelButtonCheck);
		buttonCheck.setDefaultButton(true);

		Button buttonClose = new Button(labelButtonClose);
		buttonClose.setOnAction(e -> primaryStage.close());

		Button buttonCreateMember = new Button(labelButtonCreateMember);

		// Textfield
		TextField inputField = new TextField(labelInput);

		// ResultBox for output after check.
		Label labelOK = new Label("OK");
		labelOK.setFont(new Font(50));
		Label labelNOTok = new Label("Er ikke medlem");
		HBox resultBox = new HBox();

		// Press this button check name.
		buttonCheck.setOnAction(e -> {
			if(MemberCheck.check(inputField.getText())){
				resultBox.getChildren().clear();
				resultBox.getChildren().addAll(labelOK);
			} else{
				resultBox.getChildren().clear();
				resultBox.getChildren().addAll(labelNOTok, buttonCreateMember);
			}
		});

		// Name is not a memeber, so create.
		buttonCreateMember.setOnAction(e -> CreateMember.createMember());

		//Layout.
		HBox inputBox = new HBox(inputField, buttonCheck);	//Write name to be checked in inputField
		VBox layout = new VBox();
		// Content of resultBox is set with buttonCheck.setOnAction()
		layout.getChildren().addAll(labelWindowHeader, inputBox, resultBox, buttonClose);


		// Set scene and stage.
		primaryStage.setScene(new Scene(layout, 400, 400));
		primaryStage.show();
	}
}
