package fr.laerce.cinema;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Liste extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedWriter bw = new BufferedWriter(response.getWriter());
        bw.write("<HTML><BODY>");
        bw.write("<UL>");

        bw.write("<LI>");
        bw.write("a");
        bw.write("</LI>");

        bw.write("<LI>");
        bw.write("b");
        bw.write("</LI>");

        bw.write("<LI>");
        bw.write("c");
        bw.write("</LI>");

        bw.write("</UL></BODY></HTML>");
        bw.newLine();
        bw.flush();

    }

}
