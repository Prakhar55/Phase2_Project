package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ClassCurriculumDatabase;
import database.ClassesDatabase;
import database.SubjectsDatabase;
import database.TeacherScheduleDatabase;
import database.TeachersDatabase;
import entity.TeacherSchedule;

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
		
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
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
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher("subjects");
						request.setAttribute("error", "Deletion Failed");
						dispatcher.forward(request, response);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("subjects");
				request.setAttribute("error", "Something went wrong..Please try again later");
				dispatcher.forward(request, response);
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
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher("teachers");
						request.setAttribute("error", "Deletion Failed");
						dispatcher.forward(request, response);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("teachers");
				request.setAttribute("error", "Something went wrong..Please try again later");
				dispatcher.forward(request, response);
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
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher("classes");
						request.setAttribute("error", "Deletion Failed");
						dispatcher.forward(request, response);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("classes");
				request.setAttribute("error", "Something went wrong..Please try again later");
				dispatcher.forward(request, response);
			}
		}
		
		String classcurr = request.getParameter("classcurr");
		
		if(classcurr != null )
		{
			ClassCurriculumDatabase db = new ClassCurriculumDatabase();
			try {
				if(db.deleteCurriculum(classcurr))
				{
					response.sendRedirect("classcurr");
				}
				else
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("classcurr");
					request.setAttribute("error", "Deletion Failed");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("classcurr");
				request.setAttribute("error", "Something went wrong..Please try again later");
				dispatcher.forward(request, response);
			}
		}
		
		String teachschedule = request.getParameter("teachschedule");
		System.out.println(teachschedule);
		
		if(teachschedule != null )
		{
			TeacherScheduleDatabase tdb = new TeacherScheduleDatabase();
			TeacherSchedule teachsched = new TeacherSchedule();
			String[] teachsch_param = teachschedule.split(",");
			teachsched.setTeach_name(teachsch_param[0]);
			teachsched.setClass_name(teachsch_param[1]);
			teachsched.setSub_name(teachsch_param[2]);
			try {
				if(tdb.deleteSchedule(teachsched))
				{
					response.sendRedirect("teachersschedule");
				}
				else
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher("teachersschedule");
						request.setAttribute("error", "Deletion Failed");
						dispatcher.forward(request, response);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("teachersschedule");
				request.setAttribute("error", "Something went wrong..Please try again later");
				dispatcher.forward(request, response);
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
}
