package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.ClassCurriculum;

public class ClassCurriculumDatabase {
	
	public List<ClassCurriculum> getAllSubjectsforClasses() throws SQLException 
	{			
		List<ClassCurriculum> clascur = new ArrayList<ClassCurriculum>();
		
		String sql = "select class_name,subjects from classcurriculum order by class_name ";
		Connection conn = DBConnection.dbConn();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			ClassCurriculum c1 = new ClassCurriculum();
			c1.setClass_name(rs.getString(1));
			c1.setSubjects(rs.getString(2));
			clascur.add(c1);
		}
		conn.close();
		return clascur;		
	}
	
	public boolean addNewCurriculum (ClassCurriculum classcur) throws SQLException
	{
		Connection conn = DBConnection.dbConn();
		String sql = "insert into classcurriculum values(?,?)";			
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, classcur.getClass_name());
		pstat.setString(2, classcur.getSubjects());
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
	
	public boolean deleteCurriculum (String class_name) throws SQLException
	{								
		String sql = "delete from classcurriculum where class_name=?";	
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, class_name);
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
	
	public List<ClassCurriculum> getAllSubjectsSingleClass(String class_name) throws SQLException 
	{			
		List<ClassCurriculum> clascur = new ArrayList<ClassCurriculum>();
		
		String sql = "select subjects from classcurriculum where class_name=? order by class_name ";
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, class_name);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()) {
			ClassCurriculum c1 = new ClassCurriculum();
			c1.setSubjects(rs.getString(1));
			clascur.add(c1);
		}
		conn.close();
		return clascur;		
	}
	
}
