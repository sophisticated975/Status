package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.IStudentServices;
import services.impl.IStudentServicesImpl;

/**
 * Servlet implementation class VarScoreServlet
 */
@WebServlet("/varscore.do")
public class VarScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IStudentServices istudentServices = new IStudentServicesImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String myscore = request.getParameter("score");
		int score = new Integer(myscore);
		String stuclass = istudentServices.showClass(username);
		String myclass = (String) request.getSession().getAttribute("myclass");
		if(myclass.equals(stuclass)) {//确认是本班学生
			istudentServices.putScore(username, score);
			request.getRequestDispatcher("manage.do").forward(request, response);
		}else {
			request.setAttribute("info", "该学生不是本班学生");
			request.getRequestDispatcher("varscore.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
