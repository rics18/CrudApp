package com.example.crud.session;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.example.crud.models.User;
import com.google.gson.Gson;

@Component
public class AuthFilter implements Filter {

	// @Autowired
	// LoginServlet loginServlet;

	private final String username = "admin";
	private final String password = "password";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// loginServlet.doPost(request, response);
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		InputStreamReader reader = new InputStreamReader(request.getInputStream());
		User msg = getLoginMsgFromReader(reader);

		// call next filter in the filter chain
		filterChain.doFilter(request, response);

		// get request parameters for username and password
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");

		System.out.println(username + " " + password);
		if (this.username.equals(username) && this.password.equals(password)) {
			// get the old session and invalidate
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			// generate a new session
			HttpSession newSession = request.getSession(true);

			// setting session to expiry in 5 mins
			newSession.setMaxInactiveInterval(5 * 60);

			Cookie message = new Cookie("message", "Welcome");
			response.addCookie(message);
			// response.sendRedirect("admin/LoginSuccess.jsp");
		} else {
			// RequestDispatcher rd =
			// getServletContext().getRequestDispatcher("/loginPage.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either username or password is wrong.</font>");
			// rd.include(request, response);
		}

		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk ");
	}

	@Override
	public void destroy() {

	}

	private User getLoginMsgFromReader(InputStreamReader reader) {
		User msg = null;
		try {
			Gson gson = new Gson();
			msg = gson.fromJson(reader, User.class);
		} catch (Exception exp) {
		} finally {
			try {
				reader.close();
			} catch (Exception io) {
			}
		}
		return msg;
	}
}
