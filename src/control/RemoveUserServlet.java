package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.IClassServices;
import services.IStudentServices;
import services.ITeacherServices;
import services.IUserServices;
import services.impl.IClassServicesImpl;
import services.impl.IStudentServicesImpl;
import services.impl.ITeacherServicesImpl;
import services.impl.IUserServicesImpl;

/**
 * Servlet implementation class RemoveUserServlet
 */
@WebServlet("/removeuser.do")
public class RemoveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserServices iuserServices = new IUserServicesImpl();
    private ITeacherServices iteacherServices = new ITeacherServicesImpl();
    private IStudentServices istudentServices = new IStudentServicesImpl();
    private IClassServices iclassServices = new IClassServicesImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String identity = request.getParameter("identity");
		boolean removed = iuserServices.removeUser(username, identity);
		if(removed) {
			if(identity.equals("老师")) {
				int tid = iteacherServices.seeTid(username);
				String classname = iteacherServices.seeClassname(username);
				iteacherServices.changeClass("空", username);
				iteacherServices.removeTeacher(username);
				iclassServices.changeTid(classname, 0);
				
				
			}else if(identity.equals("同学")) {
				istudentServices.removeClass(username);
				istudentServices.removeStudent(username);
				String classname = istudentServices.showClass(username);
				iclassServices.removeStudent(classname);
			}
			request.getRequestDispatcher("teachermanage.do").forward(request, response);
		}else {
			request.setAttribute("info", "用户名或身份错误");
			request.getRequestDispatcher("removeuser.jsp").forward(request, response);
		}
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
