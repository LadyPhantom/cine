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

        Integer id = Integer.parseInt( request.getParameter("id"));
        FilmsDonnees fd = new FilmsDonnees();
        Film film = fd.getById(id);

        BufferedWriter bw = new BufferedWriter(response.getWriter());
        bw.write("<html>" +
                "<head>" +
                "<title>Detail</title>" +
                "</head>" +
                "<body>");
        bw.write("<ul>");

        bw.write("<li>Titre: " + film.titre + "</li>");

        bw.write("<li>Affiche:");
        bw.write("<a href=\"/affiche?id=" + id + "\">" +
                            "<img src=\"/affiche?id=" + id + "\"" +
                            " width=\"200\" " +
                            "height=\"100\" >" +
                      "</a>");
        bw.write("</li>");

        bw.write("<li>Note: " + film.note +"</li>");


        bw.write("</ul></body></html>");
        bw.newLine();
        bw.flush();

    }
}
