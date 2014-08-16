package net.trajano.example.jpa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	@EJB
	AddEjb ejb;

	@Override
	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse resp) throws ServletException,
			IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		out.println(ejb.addSomething());
		out.println("====");
		for (final BeanWithJodaTime b : ejb.listAll()) {
			out.println(b);
		}
	}
}
