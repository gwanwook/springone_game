package ex01.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ex01.loginService.LoginService;
import ex01.loginService.LoginServiceImpl;
import ex01.memberDTO.MemberDTO;

public class DatabaseServiceImpl implements DataBaseService {

	String url = "jdbc:oracle:thin:@210.108.48.214:1521:xe";
	String id = "springone";
	String pwd = "1234";
	
	public DatabaseServiceImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int saveMember(MemberDTO dto) {
		String sql = "insert into member(id, pw, nickName, count) values(?,?,?,?)";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getNickName());
			ps.setInt(4, dto.getCount());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String loginCheck(String userId) {
		String sql = "select pw from member where id = '"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return rs.getString("pw");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String nickNameCheck(String userId) {
		String sql = "select nickName from member where id = '"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return rs.getString("nickName");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean chkId(String id) {
		String sql = "select id from member";
		try {
			Connection con = DriverManager.getConnection(url, this.id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("id").equals(id)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean chkName(String nickname) {
		String sql = "select nickName from member";
		try {
			Connection con = DriverManager.getConnection(url, this.id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("nickName").equals(nickname)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public int deleteMember(String id) {
		String sql = "delete from member where id  = ?";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url, this.id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<String> getNick() {
		String sql = "select nickname from member";
		ArrayList<String> arrNick = new ArrayList<String>();
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arrNick.add(rs.getString("nickname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrNick;
	}
	public ArrayList<Number> getCnt() {
		String sql = "select count from member";
		ArrayList<Number> arrCnt = new ArrayList<Number>();
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arrCnt.add(rs.getInt("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrCnt;
	}
	
	@Override
	public String getQuestionContent(String listNo, String stageNo) {
		String sql = "select CONTENT from QUESTION where listNo='"+listNo+"' and stageNo='"+stageNo+"'";
				
		String questionContent = null;
		ResultSet rs = null;
		
		try {
			Connection con = DriverManager.getConnection(url, this.id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				questionContent = rs.getString("content");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionContent;
	}
	
	@Override
	public String getChoiceContent(String listNo, String stageNo, String choiceNo) {
		String sql = "select content from choice where listNo='"+listNo+"' and stageNo='"+stageNo+"'and choiceNo='"+choiceNo+"'";
		String choiceContent = null;
		ResultSet rs = null;
		try {
			Connection con = DriverManager.getConnection(url, this.id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				choiceContent = rs.getString("content");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return choiceContent;
	}
	
	@Override
	public String getChoiceMediaPath(String listNo, String stageNo, String choiceNo) {
		String sql = "select mediaPath from choice where listNo='"+listNo+"' and stageNo='"+stageNo+"'and choiceNo='"+choiceNo+"'";
		String mediaPath = null;
		ResultSet rs = null;
		try {
			Connection con = DriverManager.getConnection(url, this.id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				mediaPath = rs.getString("mediaPath");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mediaPath;
	}
	public void setCnt(String userId, int count) {
		String sql = "update member set count = "+count+" where id = '"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
