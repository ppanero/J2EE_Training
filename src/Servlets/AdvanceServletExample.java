package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdvanceServletExample", description = "A simple example servlet", urlPatterns = {"/AdvanceServletExample"})
public class AdvanceServletExample extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Print in the tomcat logs
        System.out.println("POST method called");
        //Show in the browser
        response.setContentType("text/html");
        String userName = request.getParameter("userName");
        HttpSession userSession = request.getSession();
        if(userName != null){
            if(userName.equals("")) {
                userName = "user name not given";
            }
            userSession.setAttribute("userName", userName);
        }
        else{
            if(userName.equals(""))
                userName = "user name not given";
        }

        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Advance servlet example</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div><h3>Hello " + userName + "! (request name)</h3></div>\n" +
                "<div><h3>Hello " + (String)userSession.getAttribute("userName") + "! (session name)</h3></div>\n" +
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
        String userName = request.getParameter("userName");
        HttpSession userSession = request.getSession();
        if(userName != null){
            if(userName.equals("")) {
                userName = "user name not given";
            }
            userSession.setAttribute("userName", userName);
        }
        else{
            userName = "user name not given";
        }

        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Advance servlet example</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div><h3>Hello " + userName + "! (request name)</h3></div>\n" +
                "<div><h3>Hello " + (String)userSession.getAttribute("userName") + "! (session name)</h3></div>\n" +
                "<div><p>You called through GET</p></div>\n" +
                "<div><p>http://localhost:8080/Web_App_Example/AdvanceServletExample?userName=yourName</p></div>\n" +
                "</body>\n" +
                "</html>");
    }
}
