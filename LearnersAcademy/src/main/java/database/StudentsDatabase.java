package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Students;

public class StudentsDatabase {

	public List<Students> getAllStudents() throws SQLException 
	{			
		List<Students> students = new ArrayList<Students>();
		
		String sql = "select id,stud_name,class_name from students order by id ";
		Connection conn = DBConnection.dbConn();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			Students s1 = new Students();
			s1.setId(rs.getInt(1));
			s1.setStud_name(rs.getString(2));
			s1.setClass_name(rs.getString(3));
			students.add(s1);
		}
		conn.close();
		return students;		
	}
	
	
	public List<Students> getStudentForClass(String class_name) throws SQLException 
	{			
		List<Students> students = new ArrayList<Students>();
		
		String sql = "select id,stud_name from students where class_name=?";
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, class_name);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()) {
			Students s1 = new Students();
			s1.setId(rs.getInt(1));
			s1.setStud_name(rs.getString(2));
			students.add(s1);
		}
		conn.close();
		return students;		
	}
}
