package fr.boutique.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("login"), p = req.getParameter("password");
        if (("alice".equals(u) && "alice123".equals(p)) || ("admin".equals(u) && "admin".equals(p))) {
            req.getSession().setAttribute("user", u);
            resp.sendRedirect("catalogue");
        } else {
            req.setAttribute("error", "Identifiants incorrects");
            doGet(req, resp);
        }
    }
}