package ex01.member;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.Controller;
import ex01.member.service.MemberService;
import ex01.member.service.MemberServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MemberController implements Initializable {

	Parent root;
	MemberService ms;
	
	public void setRoot(Parent root) {
		this.root = root;
		ms.setRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MemberServiceImpl();
	}
	
	public void memberProc() {
		ms.memberShip();
	}
	
	public void cancelProc() {
		Controller.cs.exit(root);
	}
	
	public void chkIdProc() {
		ms.idCheck();
	}
	
	public void chkNameProc() {
		ms.nameCheck();
	}

}
