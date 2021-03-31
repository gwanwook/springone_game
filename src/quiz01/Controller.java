package quiz01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import quiz01.media.MediaMain;
import quiz01.mediaService.MediaServer;
import quiz01.mediaService.MediaServiceImpl;


public class Controller implements Initializable{	
	@FXML RadioButton rdoA;
	@FXML RadioButton rdoB;
	@FXML RadioButton rdoC;
	@FXML RadioButton rdoD;

	Parent root;
	MediaServer ms;
	MediaMain mm;
	ToggleGroup tg = new ToggleGroup();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MediaServiceImpl();
		mm = new MediaMain();
	}

	public void setRoot(Parent root) {
		this.root = root;
	}

	public void saveBtn() {
		System.out.println("확인버튼 클릭");
		mm.setMediaStage(rdoA, rdoB, rdoC, rdoD);
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
}