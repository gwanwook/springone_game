package quiz01;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuizMain {

	public void quiz01() {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("eventTest.fxml"));		
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		quiz01.Controller controller = loader.getController();
		controller.setRoot(root);
		
		stage.setScene(scene);
		stage.setTitle("Game.1");
		stage.show();
	}
}