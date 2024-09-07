package gr.aueb.cf.servlethello.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/date")
public class DataController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");

        //Instance of datetime now
        LocalDateTime now = LocalDateTime.now();
        //Defining the pattern of datetime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //Convert date to string
        String formattedNow = now.format(formatter);


        request.setAttribute("now", formattedNow);

        request.getRequestDispatcher("/WEB-INF/jsp/date.jsp").forward(request, response); //return from controller the data of request date.jsp to client
    }
}
