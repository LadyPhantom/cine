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

    }

}
