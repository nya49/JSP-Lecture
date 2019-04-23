package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BbsDAO {

	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String USERPASSWORD = "javauser";
	private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";
	
	public BbsDAO() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
		}  catch (Exception ex) {
            ex.printStackTrace();
		}
	}	//MemberDAO 
	
	public void createBbsTable() {
    	String query = "create table if not exists bbs (" + 
    			"  id int unsigned not null auto_increment," + 
    			"  memberId int unsigned not null," + 
    			"  title varchar(50) not null," + 
    			"  date datetime not null default current_timestamp," + 
    			"  content varchar(400)," + 
    			"  primary key(id)," + 
    			"  foreign key(memberId) references member(id)" + 
    			") default charset=utf8;";
    	PreparedStatement pStmt = null;
    	try {
			pStmt = conn.prepareStatement(query);
			
			pStmt.execute();
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
	public BbsDTO selectOne(String query) {
		PreparedStatement pStmt = null;
		BbsDTO bDto = new BbsDTO();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			BbsMember mem = new BbsMember();
			while (rs.next()) {				
				bDto.setId(rs.getInt(1));
				bDto.setMemberid(rs.getInt(2));
				bDto.setTitle(rs.getString(3));
				bDto.setDate(rs.getString(4));
				bDto.setContent(rs.getString(5));
			}
			rs.close();
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
		return bDto;
	}
	
	public void updateBbs(BbsDTO bDto) {	
		
        String query = "update bbs set title=?, date=now(), content=? where id=?;";
        PreparedStatement pStmt = null;
        try { 
	        	
	        pStmt = conn.prepareStatement(query);
	        pStmt.setString(1, bDto.getTitle());
	        pStmt.setString(2, bDto.getContent());
	        pStmt.setInt(3, bDto.getId());
	        
	            
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
	
	
	public void insertBbs(BbsDTO bDto) {
		PreparedStatement pStmt = null;
		String query = "insert into bbs (memberId, title, content) values(?, ?, ?);";
		pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, bDto.getMemberid());
			pStmt.setString(2, bDto.getTitle());
			pStmt.setString(3, bDto.getContent());	
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
	
	public void deleteBbs(int id) {
		String query = "delete from bbs where id=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, id);
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
	
	
	public List<BbsMember> selectAll() {
		String query = "select bbs.id, member.name, bbs.title, bbs.date, bbs.content from bbs " +
						"inner join member on bbs.memberId=member.id;";
		PreparedStatement pStmt = null;
		List<BbsMember> bmList = new ArrayList<BbsMember>();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {	
				BbsMember bmDto = new BbsMember();
				bmDto.setId(rs.getInt(1));
				bmDto.setName(rs.getString(2));
				bmDto.setTitle(rs.getString(3));
				bmDto.setDate(rs.getString(4));
				bmDto.setContent(rs.getString(5));
				bmList.add(bmDto);
			}
			rs.close();
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
		return bmList;
	}
	
	
	public BbsDTO searchById(int memberId) {
    	String sql = "select * from bbs where id=" + memberId + ";";
    	BbsDTO bDto = selectOne(sql);
    	return bDto;
    }
	
	public void close() {
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception se1) { }
	}
}
