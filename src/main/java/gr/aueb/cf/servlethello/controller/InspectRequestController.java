package gr.aueb.cf.servlethello.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Serial;
import java.util.Enumeration;

@WebServlet("/inspect-request")
public class InspectRequestController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*Inspect Parameter*/
        String username = request.getParameter("username");
        System.out.printf("Username: %s\n", username);
        //.write() display in Front-End data in html
        response.getWriter().write("Username: " + username + "\n");

        /*Inspect Request Headers*/

        //Enumeration<> is obsolete and has been replaced by collections
        //getHeaderNames() returns a vector
        //Like ResultSet, Enumeration provides 2 methods:
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
            response.getWriter().write(headerName + ": " + headerValue + "\n");
        }

        /*Inspect Cookies*/
        //Table with cookies
        Cookie[] cookies = request.getCookies();
        //if cookies is not empty
        if (cookies != null) {
            //for every cookie
            for (Cookie cookie : cookies) {
                //if cookie is valid and corresponds in this session so its name is the same with the session JSESSIONID
                if (cookie.getName().equals("JSESSIONID")) {
                    //Display it in BROWSER
                    System.out.println("Cookie name: " + cookie.getName() + ", value: " + cookie.getValue());
                    response.getWriter().write("Cookie: " + cookie.getName() + cookie.getValue() + "\n");
                }
            }
        }

        /*Inspect JSESSIONID*/
        //Should be the same with cookie
        //If there is not any session, it is created by request.getSession(), else it is drawn
        //false: Creation of a new session it is forbidden
        //session == Session Object
        HttpSession session = request.getSession(false);
        String sessionId = session == null ? "" : session.getId();
        System.out.println("JSESSIONID: " + sessionId);
        response.getWriter().write("JSESSIONID: " + sessionId + "\n");

        /*Inspect Session Attribute*/
        //scope of setting attribute:
        //page:
        //request: may related with a collection of pages
        //session: the global scope

        //set/write in session object the credentials
        request.getSession().setAttribute("username", username);
        //In every page of session I can get/retrieve the username attr
        String sessionUsername = (String) request.getSession().getAttribute("username");
        System.out.println("Username: " + username);
        response.getWriter().write("Username: " + username + "\n");

        /*Inspect request URI and context path*/
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Context Path: " + request.getContextPath());
        System.out.println("Servlet Path: " + request.getServletPath());

        response.getWriter().write("Request URI: " + request.getRequestURI());
        response.getWriter().write("Context Path: " + request.getContextPath());
        response.getWriter().write("Servlet Path: " + request.getServletPath());
    }
}
