package Servlets;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "A simple example servlet", urlPatterns = {"/ServletClassExamplePath"})
public class ServletExample extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //Print in the tomcat logs
        System.out.println("GET method called");
        //Show in the browser
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head lang=\"en\">\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Servlet example</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<div><p>This is the body of the servlet example you can access this file via:</p></div>\n" +
                        "<div><p>http://localhost:8080/Web_App_Example/ServletClassExamplePath defined in the servlet class</p></div>\n" +
                        "<div><p>http://localhost:8080/Web_App_Example/ServletWebxmlExamplePath defined in the web.xml file</p></div>\n" +
                        "</body>\n" +
                        "</html>");
    }
}
