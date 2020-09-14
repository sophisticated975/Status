package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.IClassServices;
import services.ITeacherServices;
import services.impl.IClassServicesImpl;
import services.impl.ITeacherServicesImpl;

/**
 * Servlet implementation class GiveClassServlet
 */
@WebServlet("/giveclass.do")
public class GiveClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClassServices iclassServices = new IClassServicesImpl();
	private ITeacherServices iteacherServices = new ITeacherServicesImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String classname = request.getParameter("classname");
		boolean exist = iclassServices.isExist(classname);
		if(exist) {
			int tid = iclassServices.seeTid(classname);
			String oldusername = iteacherServices.seeUsername(tid);
			iteacherServices.changeClass("空", oldusername);
			int newtid = iteacherServices.seeTid(username);
			iclassServices.changeTid(classname, newtid);
		}else {
			iclassServices.addClass(classname, username);
		}
		iteacherServices.changeClass(classname, username);
		request.getRequestDispatcher("teachermanage.do").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
