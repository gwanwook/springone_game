package quiz02;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import quiz02.media.MediaMain;
import quiz02.mediaService.MediaServer;
import quiz02.mediaService.MediaServiceImpl;

public class Controller implements Initializable{
	@FXML RadioButton rdoA;
	@FXML RadioButton rdoB;
	@FXML RadioButton rdoC;
	@FXML RadioButton rdoD;

	@FXML Label lblQuiz2;
	
	Parent root;
	MediaServer ms;
	MediaMain mm;
	DataBaseService ds;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MediaServiceImpl();
		mm = new MediaMain();
		
ds = new DatabaseServiceImpl();
		
		rdoA.setText(ds.getChoiceContent(CommonClass.getListNo(), "2", "1"));
		rdoB.setText(ds.getChoiceContent(CommonClass.getListNo(), "2", "2"));
		rdoC.setText(ds.getChoiceContent(CommonClass.getListNo(), "2", "3"));
		rdoD.setText(ds.getChoiceContent(CommonClass.getListNo(), "2", "4"));
		
		lblQuiz2.setText(ds.getQuestionContent(CommonClass.getListNo(), "2"));
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
