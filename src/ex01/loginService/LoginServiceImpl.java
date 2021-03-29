package ex01.loginService;

import ex01.Controller;
import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService {

	@Override
	public void loginCheck(Parent root) {
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPw");
		
		
		DataBaseService ds = new DatabaseServiceImpl();
		String dbPwd = ds.loginCheck(id.getText());
		String dbNickName = ds.nickNameCheck(id.getText());
		if(dbPwd == null) {
			Controller.cs.alert("존재하지 않는 회원입니다");
		} else {
			if(dbPwd.equals(pwd.getText())) {
				Controller.cs.alert(dbNickName + "님 게임을 시작합니다");
			} else {
				Controller.cs.alert("비밀번호를 다시 입력하세요");
			}
		}
	}
}
