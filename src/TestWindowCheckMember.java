import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by tomas on 5/1/16.
 *
 * NOT NEEDED. WindowCheckMember can be run directly via intellijs run configurations.
 */
public class TestWindowCheckMember extends Application{
	public static void main(String[] args){ launch(args);}

	@Override
	public void start(Stage primaryStage) throws Exception {
		WindowCheckMember wcm = new WindowCheckMember();
		wcm.start(new Stage());
	}
}