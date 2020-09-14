package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import services.IStudentServices;
import services.impl.IStudentServicesImpl;

/**
 * Servlet implementation class PutScoreServlet
 */
@WebServlet("/putscore.do")
public class PutScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IStudentServices istudentServices = new IStudentServicesImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		List<Student> list = (List<Student>) request.getSession().getAttribute("list");
		for(int i=0;i<list.size();i++) {
			String myscore = request.getParameter(list.get(i).getUsername());
			int score =  new Integer(myscore);
			istudentServices.putScore(list.get(i).getUsername(), score);
		}
		request.getRequestDispatcher("manage.do").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
