import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ToyDAO {
	public Connection getConnection() throws Exception {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jspdb5?serverTimezone=Asia/Seoul&useSSL=false";
		String user = "root";
		String password = "12345678";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	public void Membership(String id ,String pass) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="insert into toymember values(?,?,0)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pass);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
		System.out.println("Membership 오류 "+e);
		}finally {
			if (pstmt!=null) {try {pstmt.close();} catch (SQLException e) {}	}
			if (con!=null) {try {con.close();} catch (SQLException e) {} }	
					}
		}
	
	public void Membership(String id ,String pass,int score) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="update toymember set score=? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, score);
			pstmt.setString(2,id);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
		System.out.println("Membership 오류 "+e);
		}finally {
			if (pstmt!=null) {try {pstmt.close();} catch (SQLException e) {}	}
			if (con!=null) {try {con.close();} catch (SQLException e) {} }	
					}
		}
	
	
	public int Login(String id ,String pass) {
		int num=-1;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		con=getConnection();
		String sql="select *from toymember where id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			if(pass.equals(rs.getString(2))) {
				num=1;
			}else {
				num=0;
			}
		}
		
			
		} catch (Exception e) {
			System.out.println("Login 오류 "+e);
		}finally {
			if (rs!=null) {try {rs.close();} catch (SQLException e) {} }	
			if (pstmt!=null) {try {pstmt.close();} catch (SQLException e) {} }
			if (con!=null) {try {con.close();} catch (SQLException e) {} }	
	
					}
		
		
		return num;
	}
	
	public int Login(String id) {
		int num=-1;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		con=getConnection();
		String sql="select *from toymember where id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		rs=pstmt.executeQuery();
		if(rs.next()) {
		num=rs.getInt(3);
		}
		
			
		} catch (Exception e) {
			System.out.println("Login 오류 "+e);
		}finally {
			if (rs!=null) {try {rs.close();} catch (SQLException e) {} }	
			if (pstmt!=null) {try {pstmt.close();} catch (SQLException e) {} }
			if (con!=null) {try {con.close();} catch (SQLException e) {} }	
	
					}
		
		
		return num;
	}
	
	
	public String quiz(int i ,int j) {
		String v=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			String sql="select *from quiz where idx=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, i);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(j==1) {
				v=rs.getString(2);
				}
				if(j==2) {
					v=rs.getString(3);
				}
				
						
			}
			
			
		} catch (Exception e) {
		System.out.println("Quiz 오류"+e);
		}finally {
			if (rs!=null) {try {rs.close();} catch (SQLException e) {} }	
			if (pstmt!=null) {try {pstmt.close();} catch (SQLException e) {}	}
			if (con!=null) {try {con.close();} catch (SQLException e) {} }	
	
	}
		return v;
	}
	
	public boolean check(String problem ,String answer) {
		boolean v=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			String sql="select *from quiz where problem=? and answer=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, problem);
			pstmt.setString(2, answer);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				v=true;
			}
			
			
		} catch (Exception e) {
		System.out.println("Quiz 오류"+e);
		}finally {
			if (rs!=null) {try {rs.close();} catch (SQLException e) {} }	
			if (pstmt!=null) {try {pstmt.close();} catch (SQLException e) {}	}
			if (con!=null) {try {con.close();} catch (SQLException e) {} }	
	
	}
		return v;
	}
	

	public String quiz(int i) {
		String v=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			String sql="select *from toymember order by score limit ?,1";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, i);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				v=rs.getString(1)+"  Score :"+rs.getString(3);
				}
			
			
		} catch (Exception e) {
		System.out.println("Quiz 오류"+e);
		}finally {
			if (rs!=null) {try {rs.close();} catch (SQLException e) {} }	
			if (pstmt!=null) {try {pstmt.close();} catch (SQLException e) {}	}
			if (con!=null) {try {con.close();} catch (SQLException e) {} }	
	
	}
		return v;
	}
	
	public int getcount() {
		int count=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			String sql="select count(*) from quiz";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
			
		} catch (Exception e) {
		System.out.println("count 오류"+e);
		}finally {
			if (rs!=null) {try {rs.close();} catch (SQLException e) {} }	
			if (pstmt!=null) {try {pstmt.close();} catch (SQLException e) {}	}
			if (con!=null) {try {con.close();} catch (SQLException e) {} }	
	
	}
		
		return count;
	}
	
}
