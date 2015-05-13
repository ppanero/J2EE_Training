package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Light on 13/05/15.
 */
@WebServlet(name = "AdvanceServletExample", description = "A simple example servlet", urlPatterns = {"/AdvanceServletExample"})
public class AdvanceServletExample extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Print in the tomcat logs
        System.out.println("GET method called");
        //Show in the browser
        response.setContentType("text/html");
        String user = request.getParameter("userName");
        if(user == null) user = "Not called properlly";

        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Advance servlet example</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div><h3>Hello " + user + "!</h3></div>\n" +
                "<div><p>You called through POST</p></div>\n" +
                "<div><p>http://localhost:8080/Web_App_Example/AdvanceServletExample?userName=yourName</p></div>\n" +
                "</body>\n" +
                "</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //Print in the tomcat logs
        System.out.println("GET method called");
        //Show in the browser
        response.setContentType("text/html");
        String user = request.getParameter("userName");
        if(user == null) user = "Not called properlly";

        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Advance servlet example</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div><h3>Hello " + user + "!</h3></div>\n" +
                "<div><p>You called through GET</p></div>\n" +
                "<div><p>http://localhost:8080/Web_App_Example/AdvanceServletExample?userName=yourName</p></div>\n" +
                "</body>\n" +
                "</html>");
    }
}
