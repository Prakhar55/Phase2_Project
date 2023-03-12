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
import database.ClassesDatabase;
import database.StudentsDatabase;
import database.TeacherScheduleDatabase;
import entity.ClassCurriculum;
import entity.Classes;
import entity.Students;
import entity.TeacherSchedule;

/**
 * Servlet implementation class ClassReport
 */
@WebServlet("/classreport")
public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReport() {
  
      	System.out.println("Class Report Servlet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
		System.out.println(getServletContext().getContextPath() );
		
		ClassesDatabase db = new ClassesDatabase();
		try {
			List<Classes> classes = db.getAllClasses();
			RequestDispatcher dispatcher = request.getRequestDispatcher("classreport.jsp");
			request.setAttribute("classes", classes);
			dispatcher.forward(request, response);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("classreport.jsp");
			request.setAttribute("error", "Something went wrong..Please try after sometime");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
		String class_name =request.getParameter("classes");

		if(class_name != null)
		{
			StudentsDatabase sdb = new StudentsDatabase();
			ClassCurriculumDatabase ccdb = new ClassCurriculumDatabase();
			TeacherScheduleDatabase tsdb = new TeacherScheduleDatabase();
			ClassesDatabase db = new ClassesDatabase();
			try {
				List<Students> students =sdb.getStudentForClass(class_name);
				List<ClassCurriculum> classcurr =ccdb.getAllSubjectsSingleClass(class_name);
				List<TeacherSchedule> teachsched =tsdb.getTeachersforClass(class_name);
				List<Classes> classes = db.getAllClasses();
				RequestDispatcher dispatcher = request.getRequestDispatcher("classreport.jsp");
				request.setAttribute("students", students);
				request.setAttribute("classcurr", classcurr);
				request.setAttribute("teachsched", teachsched);
				request.setAttribute("classes", classes);
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("classreport.jsp");
				request.setAttribute("error", "Something went wrong..Please try after sometime");
				dispatcher.forward(request, response);
			}
		}

}
}