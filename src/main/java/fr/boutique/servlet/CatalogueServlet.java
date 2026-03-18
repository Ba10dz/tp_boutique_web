package fr.boutique.servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {
    public static final List<Article> ARTICLES = List.of(
            new Article("REF-001", "Stylo bille bleu", "Papeterie", 1.50),
            new Article("REF-002", "Cahier A4", "Papeterie", 3.20),
            new Article("REF-003", "Souris sans fil", "Informatique", 15.00),
            new Article("REF-004", "Clavier USB", "Informatique", 25.50),
            new Article("REF-005", "Sac à dos", "Bagagerie", 45.00),
            new Article("REF-006", "Gourde Inox", "Accessoires", 12.00),
            new Article("REF-007", "Lampe bureau", "Mobilier", 19.90),
            new Article("REF-008", "Agenda 2026", "Papeterie", 8.50)
    );
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("articles", ARTICLES);
        req.getRequestDispatcher("/WEB-INF/jsp/catalogue.jsp").forward(req, resp);
    }
}