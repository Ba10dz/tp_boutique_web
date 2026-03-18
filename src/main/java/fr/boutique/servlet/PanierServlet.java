package fr.boutique.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/panier.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<String, LignePanier> panier = (Map<String, LignePanier>) session.getAttribute("panier");
        if (panier == null) { panier = new HashMap<>(); session.setAttribute("panier", panier); }

        String action = req.getParameter("action");
        String ref = req.getParameter("ref");

        if ("vider".equals(action)) panier.clear();
        else if ("supprimer".equals(action)) panier.remove(ref);
        else {
            Article art = CatalogueServlet.ARTICLES.stream().filter(a -> a.ref().equals(ref)).findFirst().orElse(null);
            if (art != null) {
                if (panier.containsKey(ref)) panier.get(ref).setQuantite(panier.get(ref).getQuantite() + 1);
                else panier.put(ref, new LignePanier(art, 1));
            }
        }
        resp.sendRedirect("panier");
    }
}