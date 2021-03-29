package ex01.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ex01.memberDTO.MemberDTO;
import javafx.scene.control.TextField;

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

}
