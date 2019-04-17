package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String USERPASSWORD = "javauser";
	private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";
	
	public MemberDAO() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
		}  catch (Exception ex) {
            ex.printStackTrace();
		}
	}	//MemberDAO 
	
	// 1. 가입
	public void insertMember(MemberDTO mem) {		
        String query = "insert into member values (?, ?, ?, ?, ?);";
        PreparedStatement pStmt = null;
	       
        try { 
	        	
	        pStmt = conn.prepareStatement(query);
	        pStmt.setInt(1, mem.getId());
	        pStmt.setString(2, mem.getPass());
	        pStmt.setString(3, mem.getName());
	        pStmt.setString(4, mem.getBirthday());
	        pStmt.setString(5, mem.getAddress());
	            
	        pStmt.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
	        try {
	            if (pStmt != null && !pStmt.isClosed());
	            pStmt.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
        }
    }
	
	// 2. 조회
	public List<MemberDTO> selectCondition() {	
		String query = "select * from member order by id desc;";
        PreparedStatement pStmt = null;
        List<MemberDTO> memberList = new ArrayList<MemberDTO>();
        try { 
	        pStmt = conn.prepareStatement(query);
	        ResultSet rs = pStmt.executeQuery();
           
	        while(rs.next()){
	        	MemberDTO mem = new MemberDTO();
	        	mem.setId(rs.getInt(1));
	        	mem.setPass(rs.getString(2));
	        	mem.setName(rs.getString(3));
	        	mem.setBirthday(rs.getString(4));
	        	mem.setAddress(rs.getString(5));
	        	memberList.add(mem);
	        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
	        try {
	            if (pStmt != null && !pStmt.isClosed());
	            pStmt.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
        }
        return memberList;
    }
	
	// 3. 변경
	public void updateMember(MemberDTO mem) {	
		
        String query = "update member set pass=?, name=?, birthday=?, address=? where id=?;";
        PreparedStatement pStmt = null;
        try { 
	        	
	        pStmt = conn.prepareStatement(query);
	        pStmt.setString(1, mem.getPass());
	        pStmt.setString(2, mem.getName());
	        pStmt.setString(3, mem.getBirthday());
	        pStmt.setString(4, mem.getAddress());
	        pStmt.setInt(5, mem.getId());
	            
	        pStmt.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
	        try {
	            if (pStmt != null && !pStmt.isClosed());
	            pStmt.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
        }
    }	
	
	// 4. 삭제
	public void deleteMember(int id) {		
		
        String query = "delete from member where id=?;";
        PreparedStatement pStmt = null;
	       
        try { 
	        pStmt = conn.prepareStatement(query);
	        pStmt.setInt(1, id);

	        pStmt.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
	        try {
	            if (pStmt != null && !pStmt.isClosed());
	            pStmt.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
        }
    }

	// 5. 검색
	public MemberDTO selectOne(String name) {		
        String query = "select * from member where name=?;";
        PreparedStatement pStmt = null;
        MemberDTO mem = new MemberDTO();
        try { 
	        pStmt = conn.prepareStatement(query);
	        pStmt.setString(1, name);
	        ResultSet rs = pStmt.executeQuery();
           
	        while(rs.next()){
	        	mem.setId(rs.getInt(1));
	        	mem.setPass(rs.getString(2));
	        	mem.setName(rs.getString(3));
	        	mem.setBirthday(rs.getString(4));
	        	mem.setAddress(rs.getString(5));
	        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
	        try {
	            if (pStmt != null && !pStmt.isClosed());
	            pStmt.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
        }
        return mem;
    }
	
	// 변경할때 필요
	public MemberDTO selectMod(int id) {		
        String query = "select * from member where id=?;";
        PreparedStatement pStmt = null;
        MemberDTO mem = new MemberDTO();
        try { 
	        pStmt = conn.prepareStatement(query);
	        pStmt.setInt(1, id);
	        ResultSet rs = pStmt.executeQuery();
           
	        while(rs.next()){
	        	mem.setId(rs.getInt(1));
	        	mem.setPass(rs.getString(2));
	        	mem.setName(rs.getString(3));
	        	mem.setBirthday(rs.getString(4));
	        	mem.setAddress(rs.getString(5));
	        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
	        try {
	            if (pStmt != null && !pStmt.isClosed());
	            pStmt.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
        }
        return mem;
    }
	
	
	// 6. 로그인
	public MemberDTO login(int id) {		
        String query = "select * from member where id=?;";
        PreparedStatement pStmt = null;
        MemberDTO mem = new MemberDTO();
        try { 
	        pStmt = conn.prepareStatement(query);
	        pStmt.setInt(1, id);
	        ResultSet rs = pStmt.executeQuery();
           
	        while(rs.next()){
	        	mem.setId(rs.getInt(1));
	        	mem.setPass(rs.getString(2));
	        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
	        try {
	            if (pStmt != null && !pStmt.isClosed());
	            pStmt.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
        }
        return mem;
    }
	
	public int verifyIdPAssword(int id, String password) {
		System.out.println("verifyIdPAssword() : " + id + ", " + password);
		String query = "select pass from member where id=?;";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String dbPassword = "";
		try{
			pStmt = conn.prepareStatement(query);
	        pStmt.setInt(1, id);
	        rs = pStmt.executeQuery();
	        while(rs.next()) {
	        	dbPassword = rs.getString(1);
	        	if(dbPassword.equals(password))
	        		return ID_PASSWORD_MATCH;
	        	else 
	        		return PASSWORD_IS_WRONG;
	        }
	        return ID_DOES_NOT_EXIST;
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
	        try {
	            if (pStmt != null && !pStmt.isClosed());
	            pStmt.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
        }
		return DATABASE_ERROR;
	}
	
	public void close() {
    	try {
			if (conn != null && !conn.isClosed()) 
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
