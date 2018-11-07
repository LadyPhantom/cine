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


        bw.write("<p>Classement par note décroissante:</p>");


//        bw.write("<LI>");
//        bw.write("Le juge et l'assassin");
//        bw.write("</LI>");
//
//        bw.write("<LI>");
//        bw.write("La guerre des étoiles");
//        bw.write("</LI>");
//
//        bw.write("<LI>");
//        bw.write("Pretty woman");
//        bw.write("</LI>");
//
//        bw.write("<LI>");
//        bw.write("Légendes d'automne");
//        bw.write("</LI>");
//
//        bw.write("<LI>");
//        bw.write("E.T. l'extra-terrestre");
//        bw.write("</LI>");
//
//        bw.write("<LI>");
//        bw.write("BEN-HUR");
//        bw.write("</LI>");
//
//        bw.write("<LI>");
//        bw.write("La jurée");
//        bw.write("</LI>");

        bw.write("</ul></body></html>");
        bw.newLine();
        bw.flush();

    }

}
