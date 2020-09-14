package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import services.IUserServices;
import services.impl.IUserServicesImpl;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/modify.do")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserServices iuserServices = new IUserServicesImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String password = request.getParameter("password");
		String oldpassword = (String)request.getSession().getAttribute("password");
		if(password.equals(oldpassword)) {//确定密码 ！！！字符串的匹配不能用==
			String newpassword = request.getParameter("newpassword");
			User user = new User();
			user.setPassword(newpassword);
			user.setUsername((String) request.getSession().getAttribute("username"));
			boolean result = iuserServices.modify(user);
			if(result) {
				request.getRequestDispatcher("userinfo.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("modify.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("info", "密码不正确");
			request.getRequestDispatcher("modify.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
