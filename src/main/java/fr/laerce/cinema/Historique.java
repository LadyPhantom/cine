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

        HttpSession session = request.getSession();
        List<Integer> listeFilmUser = (List<Integer>) session.getAttribute("filmVu");
        FilmsDonnees fd = new FilmsDonnees();
        boolean vu_empty = true;

        if(listeFilmUser == null){
            listeFilmUser = new ArrayList<Integer>();
            session.setAttribute("filmVu", listeFilmUser);
        }

        List<Film> filmsVu = new ArrayList<>();
        for (Film f : fd.lesFilms){
            for (Integer fUser : listeFilmUser){
                if (fUser == f.id){
                    vu_empty = false;
                    filmsVu.add(f);
                }
            }
        }

        request.setAttribute("films", filmsVu);
        request.setAttribute("vuEmpty", vu_empty);

        String jspview = "historique.jsp";

        getServletConfig().getServletContext().getRequestDispatcher("/jsp/"+jspview).forward(request, response);

    }

}
