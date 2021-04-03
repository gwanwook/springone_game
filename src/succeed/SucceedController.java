package succeed;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import ex01.Controller;
import ex01.common.CommonClass;
import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.member.service.MemberService;
import ex01.member.service.MemberServiceImpl;
import ex01.memberDTO.MemberDTO;
import ex01.record.RecordMain;
import ex01.record.service.RecordService;
import ex01.record.service.RecordServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import listview.ListviewMain;

public class SucceedController implements Initializable{

	@FXML Label lblSucceed;
	Parent root;
	MemberService ms;
	RecordMain rm;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	public void cancelProc() {
		Controller.cs.exit(root);
	}
	
	public void viewProc() {
		System.out.println("기록보기");
		rm.recordDisplay();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rm = new RecordMain();
		String nickName = "nickName";
		nickName = CommonClass.getNickName();
		lblSucceed.setText(nickName+"님 탈출에 성공했습니다!");
	}

}
