package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;

public class RechercheFilmByNom extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Initialisations ----------------------------------------------
        BufferedWriter bw = new BufferedWriter(response.getWriter());
        String nom_film = request.getParameter("nom_film");
        FilmsDonnees fd = new FilmsDonnees();
        boolean resultat_obtenu = true;

        bw.write("<html>" +
                "<head>" +
                "<title>Recherche par nom</title>" +
                "</head>" +
                "<body>");

        // Index ---------------------------------------------------------
        bw.write("<a href=\"/\">Index</a><br><br>");

        // Affichage -----------------------------------------------------
        bw.write("<ul>");
        bw.write("<p>Films correspondant à votre recherche:</p>");
        for (Film f : fd.lesFilms){
            if (f.titre.toLowerCase().contains(nom_film)){
                resultat_obtenu = false;
                bw.write("<li><a href=\"/detail?id=" + f.id + "\">" + f.titre + "</a></li>");
            }
        }
        if (resultat_obtenu){
            bw.write("<li>Aucun film correspondant trouvé.</li>");
        }

        bw.write("</ul><br><br><a href=\"/historique\">Allez à l'historique</a>");;
        bw.write("</body></html>");
        bw.newLine();
        bw.flush();

    }
}
