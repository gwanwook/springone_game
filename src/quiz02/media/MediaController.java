package quiz02.media;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import quiz02.mediaService.MediaServer;
import quiz02.mediaService.MediaServiceImpl;

public class MediaController implements Initializable{
	Parent root;
	MediaServer ms;

	public void setRoot(Parent root,RadioButton rdoA, RadioButton rdoB, RadioButton rdoC, RadioButton rdoD) {
		this.root = root;
		if(rdoA.isSelected()) {
			ms.setMedia(root, "../../game_resources/media/horror01_1.mp4");
		}
		if(rdoB.isSelected()) {
			ms.setMedia(root, "../../game_resources/media/horror02_2.mp4");
		}
		if(rdoC.isSelected()) {
			ms.setMedia(root, "../../game_resources/media/horror01_1.mp4");
		}
		if(rdoD.isSelected()) {
			ms.setMedia(root, "../../game_resources/media/horror01_4.mp4");
		}		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MediaServiceImpl();	
	}

	public void myBtn0() {
		ms.myBtn0();
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public void myBtn1() {
		ms.myBtn1();
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public void myBtn2() {
		ms.myBtn2();
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
}
