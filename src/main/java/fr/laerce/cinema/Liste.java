package fr.laerce.cinema;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Collections;

public class Liste extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedWriter bw = new BufferedWriter(response.getWriter());
        bw.write("<HTML><BODY>");
        bw.write("<UL>");

        FilmsDonnees fd = new FilmsDonnees();
        Collections.sort(fd.lesFilms, new FilmComparator());

        for (Film f : fd.lesFilms){
            bw.write("<LI>");
            bw.write(f.titre);
            bw.write("</LI>");
        }

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

        bw.write("</UL></BODY></HTML>");
        bw.newLine();
        bw.flush();

    }

}
