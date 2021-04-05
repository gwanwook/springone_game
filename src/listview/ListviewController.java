package listview;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import quiz01.QuizMain;

public class ListviewController implements Initializable{
	ObservableList<String> gameString;
	@FXML ListView<String> fxListview;
	@FXML ImageView fxImageview;
	String url = "game_resources/image/horror0";
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setListview();
		fxListview.getSelectionModel().selectedIndexProperty().addListener( (obj,oldValue,newValue) -> {
			fxImageview.setImage(new Image(url+((int)newValue+1)+".png"));	
		});
	}
	public void setListview() {
		fxImageview.setImage(new Image("game_resources/image/horror01.png"));
		gameString = FXCollections.observableArrayList();
		gameString.add("공포게임 1");
		gameString.add("공포게임 2");
		gameString.add("공포게임 3");
		fxListview.setItems(gameString);
	}
	public void nextView() {
		if(fxListview.getSelectionModel().isSelected(0)) {
			System.out.println("공포게임 1 시작");
			CommonClass.setListNo("1");
			
			QuizMain quizMain = new QuizMain();
			quizMain.quiz01();
		}
		if(fxListview.getSelectionModel().isSelected(1)) {
			System.out.println("공포게임 2 시작");
			CommonClass.setListNo("2");
			
			QuizMain quizMain = new QuizMain();
			quizMain.quiz01();
		}
		if(fxListview.getSelectionModel().isSelected(2)) {
			System.out.println("공포게임 3 시작");
			CommonClass.setListNo("3");
			
			QuizMain quizMain = new QuizMain();
			quizMain.quiz01();
		}
	}
}
