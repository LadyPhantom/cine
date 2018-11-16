package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Detail extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Integer> listeFilmUser = (List<Integer>) session.getAttribute("filmVu");

        Integer id = Integer.parseInt( request.getParameter("id"));
        FilmsDonnees fd = new FilmsDonnees();
        Film film = fd.getById(id);

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

    }
}
