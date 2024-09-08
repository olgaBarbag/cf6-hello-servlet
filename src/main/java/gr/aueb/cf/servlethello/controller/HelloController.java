package gr.aueb.cf.servlethello.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/hello")
public class HelloController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;

    //Init method is part of lifecycle of servlet
    //Initialize the servlet
    @Override
    public void init(ServletConfig config) throws ServletException {
        message = "Hello World!";
    }


    //2nd step of Servlet'S Lifecycle is the request receiving
    //Jakarta provides "doSomthing" methods that are http methods (GET, POST, DELETE, PUT)


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Header*/
        //This setting indicates context type to the client (html/pdf/img etc)
        //This info indicates the content type and eventually the program to open this content
        response.setContentType("text/html; charset=utf-8");

        /*Data*/
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Hello World!</h1></body></html>");
    }

    //Last step of Lifecycle. Detach from web server/Disconnect from DB
    //But this is not the proper way to disconnect from the DB
    @Override
    public void destroy() {
        super.destroy();
    }
}
