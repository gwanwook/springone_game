package ex01.database;

import java.util.ArrayList;

import ex01.memberDTO.MemberDTO;

public interface DataBaseService {
	public int saveMember(MemberDTO dto);
	public String loginCheck(String userId);
	public String nickNameCheck(String userId);
	public boolean chkId(String id);
	public boolean chkName(String nickname);
	public int deleteMember(String id);
	public ArrayList<String> getNick();
	public ArrayList<Number> getCnt();
	
	public String getChoiceContent(String listNo, String quizNo, String choiceNo);
	public String getQuestionContent(String listNo, String stageNo);
	
	public String getChoiceMediaPath(String listNo, String stageNo, String choiceNo);
	public void setCnt(String userId, int count);
}
