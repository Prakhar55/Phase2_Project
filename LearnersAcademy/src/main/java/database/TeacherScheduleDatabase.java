package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.TeacherSchedule;

public class TeacherScheduleDatabase {
	
	public List<TeacherSchedule> getTeachersSchedule() throws SQLException 
	{			
		List<TeacherSchedule> teachsched = new ArrayList<TeacherSchedule>();
		
		String sql = "select teach_name,class_name,sub_name from teacherschedule order by teach_name ";
		Connection conn = DBConnection.dbConn();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			TeacherSchedule t1 = new TeacherSchedule();
			t1.setTeach_name(rs.getString(1));
			t1.setClass_name(rs.getString(2));
			t1.setSub_name(rs.getString(3));
			teachsched.add(t1);
		}
		conn.close();
		return teachsched;		
	}
	
	public boolean addNewSchedule (TeacherSchedule teachsched) throws SQLException
	{
		Connection conn = DBConnection.dbConn();
		String sql = "insert into teacherschedule values(?,?,?)";			
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, teachsched.getTeach_name());
		pstat.setString(2, teachsched.getClass_name());
		pstat.setString(3, teachsched.getSub_name());
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
	
	public boolean deleteSchedule (TeacherSchedule teachsched) throws SQLException
	{								
		String sql = "delete from teacherschedule where teach_name=? and class_name=? and sub_name=?";	
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, teachsched.getTeach_name());
		pstat.setString(2, teachsched.getClass_name());
		pstat.setString(3, teachsched.getSub_name());
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
	
	public List<TeacherSchedule> getTeachersforClass(String class_name) throws SQLException 
	{			
		List<TeacherSchedule> teachsched = new ArrayList<TeacherSchedule>();
		
		String sql = "select teach_name,sub_name from teacherschedule where class_name=? order by teach_name ";
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, class_name);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()) {
			TeacherSchedule t1 = new TeacherSchedule();
			t1.setTeach_name(rs.getString(1));
			t1.setSub_name(rs.getString(2));
			teachsched.add(t1);
		}
		conn.close();
		return teachsched;		
	}


}
