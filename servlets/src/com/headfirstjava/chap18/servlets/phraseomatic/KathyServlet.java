package com.headfirstjava.chap18.servlets.phraseomatic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class KathyServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String title = "PhraseOMatic has generated the following phrase.";

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>");
        out.println("PhraseOMatic");
        out.println("</title></head><body>");
        out.println("<h1>" + title + "</h1>");
        // Сервлет может вызывать методы из другого класса.
        out.println("<p>" + PhraseOMatic.makePhrase());
        out.println("<p><a href=\"Phrase\">Создать другую фразу</a></p>");
        out.println("</body></html>");

        out.close();
    }
}
