package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collections;

public class Detail extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedWriter bw = new BufferedWriter(response.getWriter());
        bw.write("<html>" +
                "<head>" +
                "<title>Liste</title>" +
                "</head>" +
                "<body>");
        bw.write("<ul>");

        FilmsDonnees fd = new FilmsDonnees();
        Collections.sort(fd.lesFilms, new FilmComparator());

        bw.write("<p>Classement par ordre alphanum:</p>");
        for (Film f : fd.lesFilms){
            bw.write("<li>");
            bw.write("<a href=\"/affiche?id=" + f.id + "\">"
                    + f.titre +
                    "</a>");
            bw.write("</li>");
        }


        bw.write("<p>e:</p>");

        bw.write("</ul></body></html>");
        bw.newLine();
        bw.flush();

    }
}
