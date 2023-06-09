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

import database.TeachersDatabase;
import entity.Teachers;


/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/teachers")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
    	System.out.println("Teacher Servlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//p	
		System.out.println(getServletContext().getContextPath() );
		
		TeachersDatabase db = new TeachersDatabase();
		try {
			List<Teachers> teachers = db.getAllTeachers();
			RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
			request.setAttribute("teachers", teachers);
			dispatcher.forward(request, response);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
			request.setAttribute("error", "Something went wrong..Please try after sometime");
			dispatcher.forward(request, response);
			
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
