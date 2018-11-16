package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RechercheFilmByNom extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Initialisations ----------------------------------------------
        String nom_film = request.getParameter("nom_film");
        FilmsDonnees fd = new FilmsDonnees();
        boolean aucun_resultat_obtenu = true;

        // Affichage -----------------------------------------------------
        List<Film> filmsVu = new ArrayList<>();

        for (Film f : fd.lesFilms){
            if (f.titre.toLowerCase().contains(nom_film)){
                aucun_resultat_obtenu = false;
                filmsVu.add(f);
            }
        }

        request.setAttribute("films", filmsVu);
        request.setAttribute("aucunResultatObtenu", aucun_resultat_obtenu);

        String jspview = "recherche.jsp";

        getServletConfig().getServletContext().getRequestDispatcher("/jsp/"+jspview).forward(request, response);

    }
}
