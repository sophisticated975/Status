package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.IClassServices;
import services.IStudentServices;
import services.impl.IClassServicesImpl;
import services.impl.IStudentServicesImpl;

/**
 * Servlet implementation class RemoveStudentServlet
 */
@WebServlet("/removestudent.do")
public class RemoveStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentServices istudentServices = new IStudentServicesImpl();
	private IClassServices iclassServices = new IClassServicesImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String classname = (String) request.getSession().getAttribute("myclass");
		boolean result = istudentServices.removeClass(username);
		if(result) {
			iclassServices.removeStudent(classname);
			request.getRequestDispatcher("manage.do").forward(request, response);
			
		}else {
			request.getRequestDispatcher("removestudent.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
