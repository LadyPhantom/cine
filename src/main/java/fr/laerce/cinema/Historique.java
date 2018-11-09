package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Historique extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Initialisations ----------------------------------------------
        HttpSession session = request.getSession();
        List<Integer> listeFilmUser = (List<Integer>) session.getAttribute("filmVu");
        FilmsDonnees fd = new FilmsDonnees();
        BufferedWriter bw = new BufferedWriter(response.getWriter());
        boolean vu_empty = true;

        if(listeFilmUser == null){
            listeFilmUser = new ArrayList<Integer>();
            session.setAttribute("filmVu", listeFilmUser);
        }

        bw.write("<html>" +
                "<head>" +
                "<title>Historique</title>" +
                "</head>" +
                "<body>");
        // Index ---------------------------------------------------------
        bw.write("<a href=\"/\">Index</a><br><br>");

        // Affichage -----------------------------------------------------
        bw.write("<ul>");
        for (Film f : fd.lesFilms){
            for (Integer fUser : listeFilmUser){
                //boucle externe: boucle sur la liste de film pour afficher chq film 1 seul fois
                if (fUser == f.id){
                    vu_empty = false;
                    bw.write("<li>" +
                            f.titre +
                            "</li>");
                }
            }
        }

        if (vu_empty){
            bw.write("<p>Vous n'avez vu aucun film.</p>");
        }
        bw.write("</ul></body></html>");
        bw.newLine();
        bw.flush();

    }

}
