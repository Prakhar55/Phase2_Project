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
import database.SubjectsDatabase;
import entity.ClassCurriculum;
import entity.Classes;
import entity.Subjects;


/**
 * Servlet implementation class ClassCurrServlet
 */
@WebServlet("/classcurr")
public class ClassCurrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassCurrServlet() {
    	System.out.println("Class Curriculum Servlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
		System.out.println(getServletContext().getContextPath() );
		
		ClassCurriculumDatabase db = new ClassCurriculumDatabase();
		try {
			List<ClassCurriculum> clascur = db.getAllSubjectsforClasses();
			RequestDispatcher dispatcher = request.getRequestDispatcher("classcurr.jsp");
			request.setAttribute("clascur", clascur);
			dispatcher.forward(request, response);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			RequestDispatcher dispatcher = request.getRequestDispatcher("classcurr.jsp");
			request.setAttribute("error", "Something went wrong..Please try after sometime");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
		ClassesDatabase cdb = new ClassesDatabase();
		SubjectsDatabase sdb = new SubjectsDatabase();
		try {
			List<Classes> classes = cdb.getAllClasses();
			List<Subjects> subjects = sdb.getAllSubjects();
			RequestDispatcher dispatcher = request.getRequestDispatcher("newcurr.jsp");
			request.setAttribute("classes", classes);
			request.setAttribute("subjects", subjects);
			dispatcher.forward(request, response);				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("newcurr.jsp");
			request.setAttribute("error", "Something went wrong..Please try after sometime");
			dispatcher.forward(request, response);
		}
	}

}
