package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ClassCurriculumDatabase;
import database.TeacherScheduleDatabase;
import database.TeachersDatabase;
import entity.ClassCurriculum;
import entity.TeacherSchedule;
import entity.Teachers;

/**
 * Servlet implementation class TeachersSchedule
 */
@WebServlet("/teachersschedule")
public class TeachersSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachersSchedule() {
    	System.out.println("Teacher's Schedule Servlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//p
		
		TeacherScheduleDatabase tdb = new TeacherScheduleDatabase();
		try {
			List<TeacherSchedule> teachsched = tdb.getTeachersSchedule();
			RequestDispatcher dispatcher = request.getRequestDispatcher("teachersschedule.jsp");
			request.setAttribute("teachsched", teachsched);
			dispatcher.forward(request, response);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("teachersschedule.jsp");
			request.setAttribute("error", "Something went wrong..Please try after sometime");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//p
		
		TeachersDatabase tdb = new TeachersDatabase();
		ClassCurriculumDatabase ccdb= new ClassCurriculumDatabase();
		try {
			List<Teachers> teachers = tdb.getAllTeachers();
			List<ClassCurriculum> classcurr = ccdb.getAllSubjectsforClasses();
			RequestDispatcher dispatcher = request.getRequestDispatcher("newschedule.jsp");
			request.setAttribute("teachers", teachers);
			request.setAttribute("classcurr", classcurr);
			dispatcher.forward(request, response);				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("newschedule.jsp");
			request.setAttribute("error", "Something went wrong..Please try after sometime");
			dispatcher.forward(request, response);
		}
	}

}
