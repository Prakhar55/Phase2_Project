package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ClassesDatabase;
import database.SubjectsDatabase;
import database.TeachersDatabase;
import entity.Classes;

/**
 * Servlet implementation class DeleteDataServlet
 */
@WebServlet("/delete")
public class DeleteDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDataServlet() {
    	System.out.println("Delete Servlet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sub_name = request.getParameter("sub_name");
		
		if(sub_name != null )
		{
			SubjectsDatabase sdb = new SubjectsDatabase();
			try {
				if(sdb.deleteSubject(sub_name))
				{
					response.sendRedirect("subjects");
				}
				else
					response.sendRedirect("subjects");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String teach_name = request.getParameter("teach_name");
		
		if(teach_name != null )
		{
			TeachersDatabase tdb = new TeachersDatabase();
			try {
				if(tdb.deleteTeacher(teach_name))
				{
					response.sendRedirect("teachers");
				}
				else
					response.sendRedirect("teachers");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String class_name = request.getParameter("class_name");
		
		if(class_name != null )
		{
			ClassesDatabase db = new ClassesDatabase();
			try {
				if(db.deleteClass(class_name))
				{
					response.sendRedirect("classes");
				}
				else
					response.sendRedirect("classes");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
