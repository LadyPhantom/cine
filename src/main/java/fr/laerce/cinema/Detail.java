package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Detail extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Initialisations ----------------------------------------------
        HttpSession session = request.getSession();
        List<Integer> listeFilmUser = (List<Integer>) session.getAttribute("filmVu");

        Integer id = Integer.parseInt( request.getParameter("id"));
        FilmsDonnees fd = new FilmsDonnees();
        Film film = fd.getById(id);
//        BufferedWriter bw = new BufferedWriter(response.getWriter());

        if(listeFilmUser == null){
            listeFilmUser = new ArrayList<Integer>();
            session.setAttribute("filmVu", listeFilmUser);
        }


        if (!listeFilmUser.contains(id)){
            listeFilmUser.add(id);
        }

        request.setAttribute("film", film);

        String jspview = "detail.jsp";

        getServletConfig().getServletContext().getRequestDispatcher("/jsp/"+jspview).forward(request, response);

//        bw.write("<html>" +
//                "<head>" +
//                "<title>Detail</title>" +
//                "</head>" +
//                "<body>");
//
//        // Index ----------------------------------------------------------
//        bw.write("<a href=\"/\">Index</a><br><br>");
//
//        // Affichage ------------------------------------------------------
//        bw.write("<ul>");
//        bw.write("<li>Titre: " + film.titre + "</li>");
//
//        bw.write("<li>");
//        bw.write("<a href=\"/affiche?id=" + id + "\">" +
//                            "<img src=\"/affiche?id=" + id + "\"" +
//                            "height=\"50%\" >" +
//                      "</a>");
//        bw.write("</li>");
//
//        bw.write("<li>Note: " + film.note +"</li>");
//
//        bw.write("</ul><br><br><a href=\"/historique\">Allez à l'historique</a>");
//        bw.write("</body></html>");
//        bw.newLine();
//        bw.flush();


    }
}
