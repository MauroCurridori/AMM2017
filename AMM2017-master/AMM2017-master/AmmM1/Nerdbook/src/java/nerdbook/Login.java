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
import nerdbook.modelli.UtenteFactory;
import nerdbook.modelli.PostFactory;
import nerdbook.modelli.Utente;

/**
 *
 * @author Meuro
 */
@WebServlet(name="Login" , urlPatterns={"/login.jsp"}, loadOnStartup = 0)
public class Login extends HttpServlet {

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
       PostFactory.getInstance().setConnectionString(dbConnection);
       
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
        
        
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        String username = request.getParameter("usrname");
        String password = request.getParameter("pswd");
        
        if(username != null && password != null)
        {
                        
        UtenteFactory us = UtenteFactory.getInstance();
        
        int id_utente = us.getIdUtente(username, password);
        
        if(id_utente != -1 )
        {
            Utente user = UtenteFactory.getInstance().getUtenteById(id_utente);
            
            boolean fields = us.getEmptyfields(username, password);
            
            session.setAttribute("utente", user);
            session.setAttribute("Logged", true);
            
            if(id_utente == 1)
            {
                
                
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                
            }
            else
            {    if(fields == true)
                {
                    
                    
                    request.getRequestDispatcher("profilo.jsp").forward(request, response);
                }
                else
                {
                    
                    
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }
               
                
            }
          
        }
        else
        {
        
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
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
