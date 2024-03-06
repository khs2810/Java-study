package com.kh.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.movie.vo.Member;

public class MemberDao {
	
	/**
	 *  1-1. 회원가입 
	 *  		가. Scanner id, pwd, name, hp
	 *  		나. insert into member (id, pwd, name, hp, regDt) values(?, ?, ?, ?, sysdate, sysdate, 'Y')
	 *  		다. 1-2
	 */
	
	public int insertMember(Member m) {
		
		int result = 0; 
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER VALUES(SEQ_NO.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KHSP", "KHSP");
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getHp());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	public ArrayList<Member> selectList() {
		
		ArrayList<Member> list = new ArrayList<Member>(); 

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
String sql = "SELECT * FROM MEMBER";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				Member m = new Member();
				m.setId(rset.getString("userid"));
				m.setPwd(rset.getString("pwd"));
				m.setName(rset.getString("name"));
				m.setHp(rset.getString("hp"));
				
				list.add(m);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return list;
	}
	
	/**
	 * 2-4 회원정보 수정
	 * 		가. Scanner pwd, name, hp 
	 * 		나. update member set pwd = ?, name = ?, hp = ?, udtDt = sysdate where id = ?;
	 *      다. 2
	 */
	
	public int updateMember(Member m) {
		
		int result = 0;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER "
				+ "SET PWD = ?,"
				    + "name = ?,"
				    + "hp = ?,"
				    + "udtDt = sysdate"
				 + "WHERE ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KHSP", "KHSP");
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getHp());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	/**
	 * 2-5 회원 탈퇴
	 * 		가. "탈퇴하시겠습니까?"
	 * 		나. DELETE FROM MEMBER WHERE ID = ?;
	 *      다. 1
	 */
	
	public int deleteMember(String Id) {
		
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE ID = '" + Id + "'";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	

}
