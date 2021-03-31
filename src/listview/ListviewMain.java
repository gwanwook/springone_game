package listview;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListviewMain {

	public void gameStart() {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("listview.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
}
