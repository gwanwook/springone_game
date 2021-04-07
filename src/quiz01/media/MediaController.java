package quiz01.media;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import quiz01.QuizMain;
import quiz01.mediaService.MediaServer;
import quiz01.mediaService.MediaServiceImpl;

public class MediaController implements Initializable{
	Parent root;
	MediaServer ms;
	QuizMain qm;
	DataBaseService ds;

	public void setRoot(Parent root,RadioButton rdoA, RadioButton rdoB, RadioButton rdoC, RadioButton rdoD) {
		this.root = root;
		ds = new DatabaseServiceImpl();
		if(rdoA.isSelected()) {
			ms.setMedia(root, ds.getChoiceMediaPath(CommonClass.getListNo(), "1", "1"));
		}
		if(rdoB.isSelected()) {
			ms.setMedia(root, ds.getChoiceMediaPath(CommonClass.getListNo(), "1", "2"));
		}
		if(rdoC.isSelected()) {
			ms.setMedia(root, ds.getChoiceMediaPath(CommonClass.getListNo(), "1", "3"));
		}
		if(rdoD.isSelected()) {
			ms.setMedia(root, ds.getChoiceMediaPath(CommonClass.getListNo(), "1", "4"));
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MediaServiceImpl();	
		qm = new QuizMain();
	}

	public void myBtn0() {
		ms.myBtn0();
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		qm.quiz01();
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
