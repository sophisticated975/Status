package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MyClass;
import services.IClassServices;
import services.impl.IClassServicesImpl;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/manage.do")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IClassServices iclassServices = new IClassServicesImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int tid = (int) request.getSession().getAttribute("tid");
		MyClass myclass = iclassServices.showClass(tid);
		if(null == myclass) {
			
		}else {
			request.getSession().setAttribute("number",myclass.getNumber());
			request.getSession().setAttribute("list", myclass.getList());
		}
		
		request.getRequestDispatcher("manage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
