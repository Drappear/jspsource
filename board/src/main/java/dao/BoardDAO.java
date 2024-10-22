package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

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
	
	public List<BoardDTO> getList(){
		List<BoardDTO> list = new ArrayList();
		
		try {
			con = getConnection();
			String sql = "SELECT bno, name, title, readcnt, regdate, re_lev FROM board ORDER BY re_ref DESC, re_seq ASC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setReadCnt(rs.getInt("readcnt"));
				dto.setRegDate(rs.getDate("regdate"));	
				dto.setReLev(rs.getInt("re_lev"));				
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}
	
	public BoardDTO read(int bno) {
		BoardDTO dto = null;
		
		try {
			con = getConnection();
			String sql = "SELECT * FROM board WHERE bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
				
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setPassword(rs.getString("password"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
				dto.setReadCnt(rs.getInt("readcnt"));
				dto.setRegDate(rs.getDate("regdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		
		return dto;
	}
		
	public int update(BoardDTO updateDto) {
		
		int updateRow = 0;
		
		try {
			con = getConnection();
			String sql = "UPDATE board SET title = ?, content = ? WHERE bno = ? AND password = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, updateDto.getTitle());
			pstmt.setString(2, updateDto.getContent());
			pstmt.setInt(3, updateDto.getBno());
			pstmt.setString(4, updateDto.getPassword());
			
			updateRow = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		
		return updateRow;
	}
	
	public int delete(int bno, String password) {
		
		int deleteRow = 0;
		
		try {
			con = getConnection();
			String sql = "DELETE FROM board WHERE bno = ? AND password = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			pstmt.setString(2, password);
			
			deleteRow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		
		return deleteRow;
	}
	
	public int insert(BoardDTO insertDto) {
		int insertRow = 0;
		int bno = 0;
		
		try {
			con = getConnection();
			
//			String sql = "SELECT board_seq.nexval FROM DUAL";
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				bno = rs.getInt(1);
//			}
//			
//			sql = "INSERT INTO board(bno, name, password, title, content, re_ref, re_lev, re_seq) ";
//			sql += "VALUES(?, ?, ?, ?, ?, ?, 0, 0)";
//			pstmt = con.prepareStatement(sql);
//			
//			pstmt.setInt(1, bno);
//			pstmt.setString(2, insertDto.getName());
//			pstmt.setString(3, insertDto.getPassword());
//			pstmt.setString(4, insertDto.getTitle());
//			pstmt.setString(5, insertDto.getContent());
//			pstmt.setInt(6, bno);
			
			String sql = "INSERT INTO board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) ";
			sql += "VALUES(board_seq.nextval, ?, ?, ?, ?, ?, board_seq.currval, 0, 0)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, insertDto.getName());
			pstmt.setString(2, insertDto.getPassword());
			pstmt.setString(3, insertDto.getTitle());
			pstmt.setString(4, insertDto.getContent());
			pstmt.setString(5, insertDto.getAttach());
			
			insertRow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return insertRow;
	}
	
	// 조회수 증가
	public int updateReadCnt(int bno) {
		int updateRow = 0;
		try {
			con = getConnection();
			String sql = "UPDATE board SET readcnt = readcnt + 1 WHERE bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			updateRow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return updateRow;
	}
}
