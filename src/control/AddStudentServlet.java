package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import services.IClassServices;
import services.IStudentServices;
import services.IUserServices;
import services.impl.IClassServicesImpl;
import services.impl.IStudentServicesImpl;
import services.impl.IUserServicesImpl;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/addstudent.do")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IStudentServices istudentServices = new IStudentServicesImpl();
    private IUserServices iuserServices = new IUserServicesImpl();
    private IClassServices iclassServices = new IClassServicesImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//得到学生信息
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String username = request.getParameter("username");
		//得到班级专业信息
		String school = (String) request.getSession().getAttribute("school");
		String department = (String) request.getSession().getAttribute("department");
		String major = (String) request.getSession().getAttribute("major");
		String myclass = (String) request.getSession().getAttribute("myclass");
		Student student = null;
		boolean exist = istudentServices.isExist(username);
		if(exist) {//学生已经存在
			String sclass = istudentServices.showClass(username);
			if(sclass.equals("空")) {//此学生没有班级
				istudentServices.changeClass(username, myclass);
				request.getRequestDispatcher("manage.do").forward(request, response);
			}else {//此学生有班级
				request.setAttribute("info", "增加失败，此学生已有班级");
				request.getRequestDispatcher("addstudent.jsp").forward(request, response);
			}
		}else {//学生未存在
			student = new Student(name,sex,username,school,department,major,myclass);
			System.out.println(name);
			istudentServices.insertStudent(student);
			//设立用户
			iuserServices.addUser(username, "同学");
			//班级人数增加
			iclassServices.addStudent(myclass);
			request.getRequestDispatcher("manage.do").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
