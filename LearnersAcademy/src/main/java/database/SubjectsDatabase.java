package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Subjects;

public class SubjectsDatabase {
	
	public List<Subjects> getAllSubjects() throws SQLException 
	{			
		List<Subjects> subjects = new ArrayList<Subjects>();
		
		String sql = "select sub_name from subjects order by sub_name";
		Connection conn = DBConnection.dbConn();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			Subjects s1 = new Subjects();
			s1.setSub_name(rs.getString(1));
			subjects.add(s1);
		}
		conn.close();
		return subjects;		
	}
	
	public boolean addNewSubject(Subjects subjects) throws SQLException
	{
		Connection conn = DBConnection.dbConn();
		String sql = "insert into subjects values(?)";			
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, subjects.getSub_name());
		try {
			pstat.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error "+e.getMessage());
			conn.close();
			return false;
		}
		conn.close();
		return true;
	}
	
	public boolean deleteSubject(String sub_name) throws SQLException
	{								
		String sql = "delete from subjects where sub_name=?";	
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, sub_name);
		try {
			pstat.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error "+e.getMessage());
			conn.close();
			return false;
		}
		conn.close();
		return true;
	}
	
}
