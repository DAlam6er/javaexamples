package com.headfirstjava.chap18.servlets.simpleservlet;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServletA extends HttpServlet
{
    // веб-сервер вызывает этот метод, передавая ему клиентский запрос
    // и объект response, который вы будете использовать для возвращения ответа
    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response)
        throws IOException
    {
        // Этим мы говорим серверу и клиенту, какой тип ответа
        // будет возвращен сервером в качестве результата выполнения сервлета
        response.setContentType("text/html;charset=UTF-8");

        // В переменной response хранится исходящий поток, с помощью которого
        // можно записывать информацию обратно на сервер
        PrintWriter out = response.getWriter();

        String message = "Если вы это читаете, сервлет работает";

        // код, который будет доставлен в браузер через сервер
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        out.close();
    }
}
