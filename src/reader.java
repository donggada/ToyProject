import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class reader {
public static void main(String[] args) { 
ToyDAO tdao=new ToyDAO();


	
	List<String> quiz=new ArrayList<String>();
	
	
	try(BufferedReader br=new BufferedReader(new FileReader("/Users/gimdongmin/eclipse-workspace/ToyProject/src/문제1.txt"))){
		Connection con= tdao.getConnection();
		String sql="insert into quiz values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
	
		
	String str= br.readLine();
	while(str!=null) {
		quiz.add(str);
		
		str=br.readLine();
		
	}
		for (int i = 2; i < quiz.size(); i+=8) {
		
			pstmt.setString(1,quiz.get(i));
			pstmt.setString(2,quiz.get(i+2));
			pstmt.executeUpdate();
			
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
