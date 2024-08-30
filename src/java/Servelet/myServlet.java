/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = {"/myServlet"})
public class myServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
     private String resultMedia (double media) {
        if (media < 3) {
            return "Não passou. Sua média é inferior a 3.";
        } else if (media >= 3 && media <= 6) {
            return "Exame. Sua média está entre 3 e 6.";
        } else {
            return "Aprovado! Sua média é superior a 6.";
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double n1 = Double.parseDouble(request.getParameter("nota1"));
        double n2 = Double.parseDouble(request.getParameter("nota2"));
        double n3 = Double.parseDouble(request.getParameter("nota3"));
        
        double media = (n1 + n2 + n3) / 3 ;
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CALCULADORA</title>"); 
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; }");
            out.println("body { margin: 0 auto; }");
            out.println("body { text-align: center; }");
            out.println("body { background-color: #22272D; }");
            out.println("h1 {  color: #F6158F; }");
            out.println("h2 { color: #fff; }");
            out.println("h3 { color: #fff; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Resultado Da Média das Notas </h1>");
            out.println("<h2> A sua média desse semestre foi : " + media + "</h2>");
            out.println("<h3> Seu resultado foi: " + resultMedia(media) + "</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}