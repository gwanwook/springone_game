package quiz02.media;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class MediaMain {
	public void setMediaStage(RadioButton rdoA, RadioButton rdoB, RadioButton rdoC, RadioButton rdoD) {
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mediaTest.fxml"));		
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		MediaController controller = loader.getController();
		controller.setRoot(root,rdoA, rdoB, rdoC, rdoD);
		
		stage.setScene(scene);
		stage.show();
	}


}
