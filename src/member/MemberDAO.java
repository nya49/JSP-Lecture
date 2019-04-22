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
        String query = "insert into member (pass, name, birthday, address, hashed) values (?, ?, ?, ?, ?);";
        PreparedStatement pStmt = null;
	       
        try { 
	        String hashedPassword = BCrypt.hashpw(mem.getPass(), BCrypt.gensalt());
	        pStmt = conn.prepareStatement(query);
	        pStmt.setString(1, "*");
	        pStmt.setString(2, mem.getName());
	        pStmt.setString(3, mem.getBirthday());
	        pStmt.setString(4, mem.getAddress());
	        pStmt.setString(5, hashedPassword);
	        
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

	public MemberDTO selectOne(String query) {		
        PreparedStatement pStmt = null;
        MemberDTO mem = new MemberDTO();
        try { 
	        pStmt = conn.prepareStatement(query);
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
	
	public MemberDTO recentId() {
    	String sql = "select * from member order by id desc limit 1;";
    	MemberDTO mDto = selectOne(sql);
    	return mDto;
    }
	
	public MemberDTO searchById(int memberId) {
    	String sql = "select * from member where id=" + memberId + ";";
    	MemberDTO mDto = selectOne(sql);
    	return mDto;
    }
    
    public MemberDTO searchByName(String memberName) {
    	String sql = "select * from member where name like '" + memberName + "';";
    	MemberDTO mDto = selectOne(sql);
    	return mDto;
    }
   
	public int verifyIdPassword(int id, String password) {
		System.out.println("verifyIdPAssword() : " + id + ", " + password);
		String query = "select hashed from member where id=?;";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String hashedPassword = "";
		try{
			pStmt = conn.prepareStatement(query);
	        pStmt.setInt(1, id);
	        rs = pStmt.executeQuery();
	        while(rs.next()) {
	        	hashedPassword = rs.getString(1);
	        	if(BCrypt.checkpw(password, hashedPassword))
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
	
	 public void initPassword() {
	    	List<MemberDTO> mList = selectCondition();
	    	for (MemberDTO member: mList) {
	    		int id = member.getId();
	    		String plainPassword = member.getPass();
	    		String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
	    		updatePassword(id, hashedPassword);
	    	}
	    }
	    
    public void updatePassword(int id, String hashed) {
    	String query = "update member set hashed=? where id=?;";
    	PreparedStatement pStmt = null;
    	try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, hashed);
			pStmt.setInt(2, id);
			
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}	
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
