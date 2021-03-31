package ex01.deletemember;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.Controller;
import ex01.loginService.LoginService;
import ex01.loginService.LoginServiceImple2;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class DeleteController implements Initializable {

	Parent root;
	LoginService ls;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void memberoutProc() {
		ls.loginCheck(root);
	}
	
	public void cancelProc() {
		Controller.cs.exit(root);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginServiceImple2();
	}

}
