/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nerdbook.modelli.Post;
import nerdbook.modelli.UtenteFactory;
import nerdbook.modelli.PostFactory;
import nerdbook.modelli.Utente;

/**
 *
 * @author Meuro
 */
public class NuovoPost extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
        HttpSession session = request.getSession();
        
               
        if (session.getAttribute("Logged") != null &&
            session.getAttribute("Logged").equals(true)) {

            Utente utente = (Utente)session.getAttribute("utente");
            
                String conferma = request.getParameter("Conferma");
                 
                String conttesto = request.getParameter("conttesto");
                int tipoall = Integer.parseInt(request.getParameter("tipo_all"));
                String contall = request.getParameter("cont_all");
                int user = utente.getId();
                int bach = Integer.parseInt(request.getParameter("bacheca"));
                
                if(conferma.equals("Conferma"))
                {
                                                   
                    Post post = new Post();
                    post.setContTesto(conttesto);
                    post.setTipoAll(tipoall);
                    post.setContAll(contall);
                    post.setUser(user);
                    post.setIdBach(bach);
                               
                    PostFactory.getInstance().addPost(post,utente);
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    
                }
            }
            
 }
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
