package quiz02;

import java.io.IOException;

import ex01.common.CommonClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuizMain {

	public void quiz02() {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("eventTest.fxml"));		
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		quiz02.Controller controller = loader.getController();
		controller.setRoot(root);
		
		stage.setScene(scene);
		stage.setTitle("horrorGame."+CommonClass.getListNo());
		stage.show();
	}
}
