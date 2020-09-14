package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import services.ITeacherServices;
import services.impl.ITeacherServicesImpl;

/**
 * Servlet implementation class TeacherManageServlet
 */
@WebServlet("/teachermanage.do")
public class TeacherManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITeacherServices iteacherServices = new ITeacherServicesImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Teacher> tlist = iteacherServices.getAllTeacher();
		request.getSession().setAttribute("tlist", tlist);
		request.getRequestDispatcher("teachermanage.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
