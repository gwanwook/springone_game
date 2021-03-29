package ex01.database;

import ex01.memberDTO.MemberDTO;
import javafx.scene.control.TextField;

public interface DataBaseService {
	public int saveMember(MemberDTO dto);
	public String loginCheck(String userId);
	public String nickNameCheck(String userId);
	public boolean chkId(String id);
	public boolean chkName(String nickname);
	public int deleteMember(String id);
}
