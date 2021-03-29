package ex01.member.service;

import ex01.Controller;
import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.memberDTO.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class MemberServiceImpl implements MemberService{

	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void memberShip() {
		TextField id = (TextField)root.lookup("#fxId");
		TextField pw = (TextField)root.lookup("#fxPw");
		TextField nickName = (TextField)root.lookup("#fxName");
		CheckBox chkId = (CheckBox)root.lookup("#chkId");
		CheckBox chkName = (CheckBox)root.lookup("#chkName");
		
		if(chkName.isSelected() == false) Controller.cs.alert("닉네임 중복체크 해주세요");
		if(chkId.isSelected() == false) Controller.cs.alert("아이디 중복체크 해주세요");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setPw(pw.getText());
		dto.setNickName(nickName.getText());
		
		if(chkName.isSelected() == true && chkId.isSelected() == true) {
			DataBaseService ds = new DatabaseServiceImpl();
			int result = ds.saveMember(dto);
			if(result == 1) {
				Controller.cs.alert("가입되었습니다");
				Controller.cs.exit(root);
			} else {
				Controller.cs.alert("가입 실패하였습니다");
			}
		} 
		
		
	}

	@Override
	public void idCheck() {
		DataBaseService ds = new DatabaseServiceImpl();
		TextField id = (TextField)root.lookup("#fxId");
		if(ds.chkId(id.getText()) == true) {
			Controller.cs.alert("아이디 중복, 다른 아이디 입력하세요");
		} else{
			Controller.cs.alert("아이디 중복 아닙니다, 사용하세요");
		}
	}

	@Override
	public void nameCheck() {
		DataBaseService ds = new DatabaseServiceImpl();
		TextField nickName = (TextField)root.lookup("#fxName");
		if(ds.chkName(nickName.getText()) == true) {
			Controller.cs.alert("닉네임 중복, 다른 닉네임 입력하세요");
		} else{
			Controller.cs.alert("닉네임 중복 아닙니다, 사용하세요");
		}
		
	}
	
	
	

}
