package ex01.common;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonClass implements CommonService{

	@Override
	public void exit(Parent root) {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

	@Override
	public void alert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
	
	public static String nickName;
	public static String listNo;
	
	
	public static String getListNo() {
		return listNo;
	}

	public static void setListNo(String listNo) {
		CommonClass.listNo = listNo;
	}


	public static String getNickName() {
		return nickName;
	}

	public static void setNickName(String nickName) {
		CommonClass.nickName = nickName;
	}

}
