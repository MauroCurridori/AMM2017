<%-- 
    Document   : bacheca
    Author     : Meuro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdbook:Social di cultura NERD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Social,Nerdbook,Informatica,Programmazione,Immagini,Link,Studenti,AMM,Bacheca,Post">
        <meta name="descriprtion" content="Nerdbook , il social di AMM">
        <meta name="author" content="Mauro Curridori">
        <link rel="stylesheet" href="style.css" type="text/css" media="all"/>
    </head>
    <body>
        
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>
        
            
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="left_nav.jsp"/>
        
        <div class="central_body">
            
                <c:set var="title" value="Bacheca Personale" scope="request"/>
                <jsp:include page="nuovopost.jsp"/>
            
            <c:forEach var="posts" items="${posts}">
            <div class="post">
              
                <div class="post_prof">
                    <h2>${utente.username}</h2>
                    <img title="profilo" alt="nerd">
                </div>
                <div class="post_cont">
                    <c:if test="${post.tipo_all == 1}">
                        <img title="imgpost" alt="imgpost" src="${post.cont_all}" >
                    </c:if>
                    <c:if test="${post.tipo_all == 2}">
                        <strong><a href="${post.cont_all}" target='blank'></a></strong>
                    </c:if>
                <p>${post.cont_testo}</p>
                </div>
                
            </div> 
           </c:forEach> 
          <!--      
            <div class="post">
                <div class="post_prof">
                    <h2>Nvidio</h2>
                    <img title="profilo2" alt="NERD2" src="img/nerd2.jpg">
            </div>
                <div class="post_cont">
                    <
                    <img title="mcrft" alt="MINECRAFT" src="img/mcrft.jpg" >
                    <p>Ho passato la notte a giocarci!LOL che belloXDXD</p>
                </div>
            </div>
            
            <div class="post">
                <div class="post_prof">
                    <h2>National GeoNerding</h2>
                    <img title="profilo3" alt="NERD3" src="img/nerd3.jpg">
                </div>
                <div class="post_cont">
               
                <p>WOW!Uscire a comprare il pane mi ha stancato troppo,passerò il pomeriggio a 
                    guardare <strong><a href='https://eurostreaming.club/the-big-bang-theory-40/'
                            target='blank'>The Big Bang Theory</a></strong>...SUPER WOW</p>
                </div>    
            </div> -->
            
        </div>
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="footer.jsp"/>
      </body>  
</html>
