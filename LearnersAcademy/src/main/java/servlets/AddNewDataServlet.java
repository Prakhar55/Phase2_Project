package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ClassesDatabase;
import database.SubjectsDatabase;
import database.TeachersDatabase;
import entity.Classes;
import entity.Subjects;
import entity.Teachers;

/**
 * Servlet implementation class AddNewDataServlet
 */
@WebServlet("/add")
public class AddNewDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewDataServlet() {
    	System.out.println("Add Servlet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				
				String sub_name =request.getParameter("sub_name");
				
				if(sub_name != null)
				{
					SubjectsDatabase sdb = new SubjectsDatabase();
					Subjects subject = new Subjects();
					subject.setSub_name(sub_name);
					try {
						if(sdb.addNewSubject(subject))
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
				
				String teach_name =request.getParameter("teach_name");
				
				if(teach_name != null)
				{
					TeachersDatabase tdb = new TeachersDatabase();
					Teachers teacher = new Teachers();
					teacher.setTeach_name(teach_name);
					try {
						if(tdb.addNewTeacher(teacher))
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
				
				String class_name =request.getParameter("class_name");
				
				if(class_name != null )
				{
					ClassesDatabase db = new ClassesDatabase();
					Classes classes = new Classes();
					classes.setClass_name(class_name);
					try {
						if(db.addNewClass(classes))
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
