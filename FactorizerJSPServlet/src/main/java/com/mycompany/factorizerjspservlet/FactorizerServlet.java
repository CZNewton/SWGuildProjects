/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorizerjspservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "FactorizerServlet", urlPatterns = {"/FactorizerServlet"})
public class FactorizerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

        // A List to hold our factors
        List<Integer> factorList = new ArrayList<>();
        // A sum to help us calculate whether or not the number
        // is perfect
        int factorSum = 0;
        boolean isPrime = false;
        boolean isPerfect = false;
        // Get the input from the user and convert it to an int
        String input = request.getParameter("numberToFactor");
        int numberToFactor = Integer.parseInt(input);

        // Factor the number - there are more efficient ways
        // of doing this!
        for (int i = 1; i < numberToFactor; i++) {
            if (numberToFactor % i == 0) {
                // i goes into numberToFactor evenly so it
                // is a factor, add it to the list and add
                // it to the sum
                factorList.add(i);
                factorSum += i;
            }
        }

        if (factorSum == numberToFactor) {
            isPerfect = true;
        }

        if (factorSum == 1) {
            isPrime = true;
        }

        // Set all the results as attributes on the request to they
        // are available to result.jsp
        request.setAttribute("numberToFactor", numberToFactor);
        request.setAttribute("factors", factorList);
        request.setAttribute("isPrime", isPrime);
        request.setAttribute("isPerfect", isPerfect);
        // Get the Request Dispatcher for result.jsp and forward the 
        // request to result.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
