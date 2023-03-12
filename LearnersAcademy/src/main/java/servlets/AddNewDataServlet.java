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
import entity.ClassCurriculum;
import entity.Classes;
import entity.Subjects;
import entity.TeacherSchedule;
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
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		response.sendRedirect("logout.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				
				response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
				response.setHeader("Pragma", "no-cache");//http1.0
				response.setHeader("Pragma", "0");//proxies	
				
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
							{
								RequestDispatcher dispatcher = request.getRequestDispatcher("subjects");
								request.setAttribute("error", "Please recheck the values - inocrrect/duplicate");
								dispatcher.forward(request, response);
							}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						RequestDispatcher dispatcher = request.getRequestDispatcher("subjects");
						request.setAttribute("error", "Something went wrong...Please try after sometime");
						dispatcher.forward(request, response);
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
						{
							RequestDispatcher dispatcher = request.getRequestDispatcher("teachers");
							request.setAttribute("error", "Please recheck the values - inocrrect/duplicate");
							dispatcher.forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						RequestDispatcher dispatcher = request.getRequestDispatcher("teachers");
						request.setAttribute("error", "Something went wrong...Please try after sometime");
						dispatcher.forward(request, response);
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
							{
								RequestDispatcher dispatcher = request.getRequestDispatcher("classes");
								request.setAttribute("error", "Please recheck the values - inocrrect/duplicate");
								dispatcher.forward(request, response);
							}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						RequestDispatcher dispatcher = request.getRequestDispatcher("classes");
						request.setAttribute("error", "Something went wrong...Please try after sometime");
						dispatcher.forward(request, response);
					}
					
				}
				
				String selected_class = request.getParameter("selected_class");
				String[] selected_sub = request.getParameterValues("selected_sub");
				
				if(selected_class != null && selected_sub != null)
				{
					ClassCurriculumDatabase db = new ClassCurriculumDatabase();
					ClassCurriculum class_curr = new ClassCurriculum();
					class_curr.setClass_name(selected_class);
					String subjects = String.join(",", selected_sub);
					System.out.println(subjects);
					class_curr.setSubjects(subjects);
					try {
						if(db.addNewCurriculum(class_curr))
						{
							response.sendRedirect("classcurr");
						}
						else
							{
								RequestDispatcher dispatcher = request.getRequestDispatcher("classcurr");
								request.setAttribute("error", "Please recheck the values - inocrrect/duplicate");
								dispatcher.forward(request, response);
							}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						RequestDispatcher dispatcher = request.getRequestDispatcher("classcurr");
						request.setAttribute("error", "Something went wrong...Please try after sometime");
						dispatcher.forward(request, response);
					}
					
				}
				
				String schedule_teach = request.getParameter("schedule_teach");
				String schedule_classcurr = request.getParameter("schedule_classcurr");
				
				
				if(schedule_teach != null && schedule_classcurr != null )
				{
					String classcurr[]=schedule_classcurr.split(",");
					TeacherScheduleDatabase tdb = new TeacherScheduleDatabase();
					TeacherSchedule teach_sched = new TeacherSchedule();
					teach_sched.setTeach_name(schedule_teach);
					teach_sched.setClass_name(classcurr[0]);
					teach_sched.setSub_name(classcurr[1]);
					try {
						if(tdb.addNewSchedule(teach_sched))
						{
							response.sendRedirect("teachersschedule");
						}
						else
							{
								RequestDispatcher dispatcher = request.getRequestDispatcher("teachersschedule");
								request.setAttribute("error", "Please recheck the values - inocrrect/duplicate");
								dispatcher.forward(request, response);
							}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						RequestDispatcher dispatcher = request.getRequestDispatcher("teachersschedule");
						request.setAttribute("error", "Something went wrong...Please try after sometime");
						dispatcher.forward(request, response);
					}
				}				
				}
	}
