/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nerdbook.modelli.UtenteFactory;
import nerdbook.modelli.PostFactory;
import nerdbook.modelli.Utente;
import nerdbook.modelli.Post;
        

/**
 *
 * @author Meuro
 */
@WebServlet(name="Bacheca" , urlPatterns={"/bacheca.jsp"}, loadOnStartup = 0)
public class Bacheca extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/amm_db";
    private static final String DB_BUILD_PATH = "WEB-INF/db/amm_db";
    
    @Override
   public void init(){
       String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
       try {
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
       UtenteFactory.getInstance().setConnectionString(dbConnection);
   }

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
        
        Utente utente = (Utente)session.getAttribute("utente");
        
        if (session.getAttribute("Logged") != null &&
            session.getAttribute("Logged").equals(true)) 
        {  
            request.setAttribute("utente",utente);
                List<Post> posts = PostFactory.getInstance().getPostList(utente);
                request.setAttribute("posts", posts);
                
                                
               
                request.getRequestDispatcher("Bacheca").forward(request, response);
        }
        else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
                        
            request.getRequestDispatcher("Login").forward(request, response);
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
