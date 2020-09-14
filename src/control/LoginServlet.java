package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.Teacher;
import bean.User;
import services.IStudentServices;
import services.ITeacherServices;
import services.IUserServices;
import services.impl.IStudentServicesImpl;
import services.impl.ITeacherServicesImpl;
import services.impl.IUserServicesImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserServices iuserServices = new IUserServicesImpl();
	private IStudentServices istudentServices = new IStudentServicesImpl();
	private ITeacherServices iteacherServices = new ITeacherServicesImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		User user = new User();
		//得到登录信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user.setUsername(username);
		user.setPassword(password);
		String identity = iuserServices.login(user);
		if(null != identity) {
			//吧登录信息存进Session对象中
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("identity", identity);
			request.getSession().setAttribute("password", password);
			if(identity.equals("同学")) {
				Student student = istudentServices.stuShow(username);
				request.getSession().setAttribute("name",student.getName());
				request.getSession().setAttribute("sex",student.getSex());
				request.getSession().setAttribute("school",student.getSchool());
				request.getSession().setAttribute("department",student.getDepartment());
				request.getSession().setAttribute("major",student.getMajor());
				request.getSession().setAttribute("myclass",student.getMyclass());
				request.getSession().setAttribute("score", student.getScore());
			}else if(identity.equals("老师")) {
				Teacher teacher = iteacherServices.teaShow(username);
				request.getSession().setAttribute("tid",teacher.getTid());
				request.getSession().setAttribute("name",teacher.getName());
				request.getSession().setAttribute("sex",teacher.getSex());
				request.getSession().setAttribute("school",teacher.getSchool());
				request.getSession().setAttribute("department",teacher.getDepartment());
				request.getSession().setAttribute("major",teacher.getMajor());
				request.getSession().setAttribute("myclass",teacher.getMyclass());
				request.getSession().setAttribute("course",teacher.getCourse());
			}
			request.getRequestDispatcher("index.jsp").forward(request,response); 
		}else { 
			request.setAttribute("info","用户名或密码错误,请重新登录"); 
			request.getRequestDispatcher("login.jsp").forward(request,response); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
