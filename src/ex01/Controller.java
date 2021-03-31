package ex01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.deletemember.DeleteController;
import ex01.deletemember.DeleteMain;
import ex01.loginService.LoginService;
import ex01.loginService.LoginServiceImpl;
import ex01.member.MemberMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import listview.ListviewMain;

public class Controller implements Initializable{
	@FXML TextField fxId;
	Parent root;
	LoginService ls;
	MemberMain mm;
	DataBaseService ds;
	DeleteMain dm;
	
	public static CommonService cs;
	static {
		cs = new CommonClass();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void loginProc() {
		ls.loginCheck(root);
//		ListviewMain lvm = new ListviewMain();
//		lvm.gameStart();
	}
	
	public void cancelProc() {
		System.out.println("³ª°¡±â");
		Controller.cs.exit(root);
	}
	
	public void memberProc() {
		System.out.println("È¸¿ø°¡ÀÔ");
		mm.setMemberStage();
	}
	
	public void memberOutProc() {
		System.out.println("Å»Åð");
		dm.setMemberStage();
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginServiceImpl();
		mm = new MemberMain();
		ds = new DatabaseServiceImpl();
		dm = new DeleteMain();
	}
}
