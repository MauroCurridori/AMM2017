<%-- 
    Document   : header
    Author     : Meuro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <header class="intro">
            <div class="intro_logo"><h1 class="intro_title">NerdBook</h1></div>

            <div class="intro_nav_bar">
                <nav class="nav_link">
                    <ul class="nav_link_ul">
                        <li> <a href="Profilo">Profilo</a></li>
                        <li> <a id ="logout" href="Login?logout=1">Logout</a></li>
                        <li> <a href="descrizione.jsp">Descrizione</a></li>
                        <li> <a href="Bacheca">Bacheca</a></li>
                    </ul>
                </nav>
            </div>
             <div class="intro_user">
                 <p>Benvenuto <u><a href="Profilo?utente">Nerd</a></u></p> 
                <img title="dv" alt="img_dv" src="img/images.png">
            </div>
    </header>
