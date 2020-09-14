package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import services.ITeacherServices;
import services.IUserServices;
import services.impl.ITeacherServicesImpl;
import services.impl.IUserServicesImpl;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/addteacher.do")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITeacherServices iteacherServices = new ITeacherServicesImpl();
    private IUserServices iuserServices = new IUserServicesImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//老师信息
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String username = request.getParameter("username");
		
		boolean exist = iteacherServices.isExist(username);
		if(exist) {
			request.setAttribute("info", "教师已存在");
			request.getRequestDispatcher("addteacher.jsp").forward(request, response);
		}else {
			Teacher teacher = new Teacher(name,sex,username);
			iteacherServices.addTeacher(teacher);
			iuserServices.addUser(username, "老师");
			request.getRequestDispatcher("teachermanage.do").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
