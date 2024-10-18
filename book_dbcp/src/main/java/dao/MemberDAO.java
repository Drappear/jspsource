package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ChangeDTO;
import dto.MemberDTO;

public class MemberDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 드라이버 로드
//	static {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	public Connection getConnection(){
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/oracle");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con , PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con , PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO isLogin(MemberDTO loginDto) {
		MemberDTO dto = null;
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM membertbl WHERE userid = ? AND password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginDto.getUserId());
			pstmt.setString(2, loginDto.getPassword());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				
				dto.setUserId(rs.getString("userid"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		
		return dto;
	}
	
	public boolean dupId(String userId) {
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM membertbl WHERE userid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 아이디 있음
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		
		// 중복 아이디 없음
		return true;
	}
	
	public int insert(MemberDTO insertDto) {
		int insertRow = 0;
		try {
			con = getConnection();
			String sql = "INSERT INTO membertbl(userid, name, password) VALUES(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, insertDto.getUserId());
			pstmt.setString(2, insertDto.getName());
			pstmt.setString(3, insertDto.getPassword());
			
			insertRow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return insertRow;
	}
	
	// update
	public int update(ChangeDTO chgDto) {		
		int updateRow = 0;
		try {
			con = getConnection();
			String sql = "UPDATE membertbl SET password = ? WHERE userid = ? AND password = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, chgDto.getChangePassword());
			pstmt.setString(2, chgDto.getUserId());
			pstmt.setString(3, chgDto.getCurrentPassword());
			
			updateRow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		
		return updateRow;
	}
}	
