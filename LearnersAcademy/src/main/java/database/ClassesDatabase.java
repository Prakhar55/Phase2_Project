package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Classes;

public class ClassesDatabase {

		public List<Classes> getAllClasses() throws SQLException 
		{			
			List<Classes> classes = new ArrayList<Classes>();
			
			String sql = "select id,class_name from classes order by id ";
			Connection conn = DBConnection.dbConn();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				Classes c1 = new Classes();
				c1.setId(rs.getInt(1));
				c1.setClass_name(rs.getString(2));
				classes.add(c1);
			}
			conn.close();
			return classes;		
		}
		
		public boolean addNewClass(Classes classes) throws SQLException
		{
			String max_id_sql = "select max(id) from classes";
			Connection conn = DBConnection.dbConn();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(max_id_sql);
			int max_id=1;
			while(rs.next()) {
				max_id +=rs.getInt(1);
			}
			
			String sql = "insert into classes values(?,?)";			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, max_id);
			pstat.setString(2, classes.getClass_name());
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
		
		
		public boolean deleteClass(String class_name) throws SQLException
		{								
			String sql = "delete from classes where class_name=?";	
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
		
}
