package fr.laerce.cinema;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;

public class Liste extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Initialisations ----------------------------------------------
//        BufferedWriter bw = new BufferedWriter(response.getWriter());
//        bw.write("<html>" +
//                "<head>" +
//                "<title>Liste</title>" +
//                "</head>" +
//                "<body>");
//
//        bw.write("<a href=\"/\">Index</a><br><br>");
//
//        bw.write("<ul>");

        FilmsDonnees fd = new FilmsDonnees();

        //----Tri des films-----------------------------------------------
        String sort = request.getParameter("sort");
        if (sort == null) {
            Collections.sort(fd.lesFilms, new FilmComparator());
        }else if ("note".equals(sort)) {
            Collections.sort(fd.lesFilms, (o1, o2) -> Double.compare(o1.note, o2.note));
        }


        request.setAttribute("films", fd.lesFilms);

        String jspview = "liste.jsp";

        getServletConfig().getServletContext().getRequestDispatcher("/jsp/"+jspview).forward(request, response);

        //----Afficher films-----------------------------------------------
//        for (Film f : fd.lesFilms){
//            bw.write("<li>");
//            bw.write("<a href=\"/detail?id=" + f.id + "\">"
//
//                    + f.titre + " (" + f.note + ")" +
//                    "</a>");
//            bw.write("</li>");
//        }

        //--Tri alternatif, sans fonction lambda-----------
//        String sort = request.getParameter("sort");
//        if (sort == null) {
//            Collections.sort(fd.lesFilms, new FilmComparator());
//        }else if ("note".equals(sort)) {
//            Collections.sort(fd.lesFilms, new Comparator<Film>() {
//                @Override
//                public int compare(Film o1, Film o2) {
//                    return Double.compare(o1.note, o2.note);
//                }
//            });
//        }
//
//        bw.write("</ul><br><br><a href=\"/historique\">Allez à l'historique</a>");
//        bw.write("</body></html>");
//        bw.newLine();
//        bw.flush();

    }

}
