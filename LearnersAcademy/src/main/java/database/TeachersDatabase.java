package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Teachers;

public class TeachersDatabase {
	
	public List<Teachers> getAllTeachers() throws SQLException 
	{			
		List<Teachers> teachers = new ArrayList<Teachers>();
		
		String sql = "select id,teach_name from teachers order by id";
		Connection conn = DBConnection.dbConn();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			Teachers t1 = new Teachers();
			t1.setId(rs.getInt(1));
			t1.setTeach_name(rs.getString(2));
			teachers.add(t1);
		}
		conn.close();
		return teachers;		
	}
	
	public boolean addNewTeacher(Teachers teachers) throws SQLException
	{
		String max_id_sql = "select max(id) from teachers";
		Connection conn = DBConnection.dbConn();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(max_id_sql);
		int max_id=1;
		while(rs.next()) {
			max_id +=rs.getInt(1);
		}
		
		String sql = "insert into teachers values(?,?)";			
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, max_id);
		pstat.setString(2, teachers.getTeach_name());
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
	
	public boolean deleteTeacher(String teach_name) throws SQLException
	{								
		String sql = "delete from teachers where teach_name=?";	
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, teach_name);
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
