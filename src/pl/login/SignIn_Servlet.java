package pl.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignIn_Servlet
 */
@WebServlet({ "/SignIn_Servlet", "/signin.do" })
public class SignIn_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = "/main.jsp";
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if (login == null || login.length() == 0 || password == null || password.length() == 0) {
			url = "/login.jsp";
			request.setAttribute("signin_message", "Podany login/has³o nie mo¿e byæ pusty");
		}
		else {
			try {
				if(new Database().signin(login, password) > 0) {
					if(new Database().isExpired(login, password) > 0) {
						request.setAttribute("loginout", login);
						request.setAttribute("loghistory", new Database().getLogHistory(login));
						request.setAttribute("wrongloghistory", new Database().getWrongLogHistory(login));
					}
					else {
						url = "/login.jsp";
						request.setAttribute("signin_message", "Has³o straci³o okres wa¿noœci");
					}
				}
				else {
					url = "/login.jsp";
					request.setAttribute("signin_message", "Podany login/has³o jest nieprawid³owe");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
