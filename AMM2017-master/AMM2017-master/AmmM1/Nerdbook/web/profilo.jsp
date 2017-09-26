<%-- 
    Document   : profilo
    Author     : Meuro
    Comment    : Problematiche incomprese per morte improvvisa della sessione e non riconoscimento della foto da Url
                 (test da Debug).
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdbook:Social di cultura NERD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Social,Nerdbook,Informatica,User,informazioni,Nome,Cognome,Email,Password,Frase,Data di nascita,Programmazione,Studenti,AMM,Profilo,Utente">
        <meta name="bacheca" content="Nerdbook , il social di AMM">
        <meta name="author" content="Mauro Curridori">
        <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
    </head>
    <body>
        <c:set var="title" value="Profilo" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <div class="central_body">
            <div class="post">
                <h2 class="left_nav_item">Raccontaci qualcosa di te!</h2>
                <c:if test="${ok == -1}">
                        <h2>ERRORE</h2>
                    </c:if>
                 <c:if test="${ok == 1}">
                        <h2>Profilo aggiornato</h2>
                    </c:if>
                 <c:if test="${ok == 2}">
                     <h2>Password diverse</h2>
                    </c:if>
                
                <form class="formpro" method="get" action="Profilo">
                    
                    <div id="usrnome">
                        <div id="prof_text"><h4><label for="nome">Nome</label></h4></div>
                        <div id="prof_in">
                            <c:if test="${ok != 1}"><input name="nome"  id="nome" type="text">
                            </c:if>
                            <c:if test="${ok == 1}">
                                <input name="nome" id="nome" value="${utente.nome}" type="text">
                            </c:if>
                        </div>
                    </div>
                    
                    <div id="usrcognome">
                        <div id="prof_text"><h4><label for="cognome">Cognome</label></h4></div>
                        <div id="prof_in">
                            <c:if test="${ok != 1}">
                                <input name="cognome" id="cognome"  type="text">
                            </c:if>
                            <c:if test="${ok == 1}">
                                <input name="cognome" id="cognome" value="${utente.cognome}" type="text">
                            </c:if>
                        </div>
                    </div>
                    
                        <div id="usrdata">
                        <div id="prof_text"><h4><label for="nato">Giorno di<br> nascita  </label></h4></div>
                        <!--Casella per l'inserimento interattivo della data-->
                        <c:if test="${ok != 1}">
                            <div id="prof_in"><input name="nato" id="nato" type="text"></div>
                        </c:if>
                        <c:if test="${ok == 1}">
                            <div id="prof_in"><input name="nato" id="nato" value="${utente.anno}" type="text"></div>
                        </c:if>
                    </div> 
                    
                    <div id="usrimgurl">
                        <div id="prof_text"><h4><label for="usrimgurl">URL foto</label></h4></div>
                    <!--Casella per l'inserimento di un URL-->
                        <div id="prof_in">
                        <c:if test="${ok != 1}"><input name="usrimgurl" id="usrimgurl" type="text"></c:if>
                        <c:if test="${ok == 1}"><input name="usrimgurl" id="usrimgurl" value="${utente.urlfoto}" type="text"></c:if>
                        
                        </div>
                    </div>
                        
                    <div id="usremail">
                        <div id="prof_text"><h4><label for="email">Email</label></h4></div>
                    <!--Casella per l'inserimento della mail-->
                        <div id="prof_in">
                        <c:if test="${ok != 1}"><input name="email" id="usremail" type="text"></c:if>
                        <c:if test="${ok == 1}"><input name="email" id="usremail"  value="${utente.email}" type="text"></c:if>
                        
                        </div>
                    </div>
                    
                    <div id="usrphrase">
                        <div id="prof_text_phrase"><h4><label for="frase">Frase<br> personale</label></h4></div>
                        <!--Casella per l'inserimento di un testo lungo, dove ne viene visuualizzato  solo i primi rows*cols caratteri
                            Dopo di che si inserisce in automatico una barra verticale di scorrimento-->
                        <div id="prof_in_phrase">
                             <c:if test="${ok != 1 }"><textarea rows="4" cols="40" name="frase" id="frase" ></textarea></c:if>
                             <c:if test="${ok == 1}"><textarea rows="4" cols="40" name="frase" id="frase" value="${utente.frase}"></textarea></c:if>
                        </div>  
                    </div>
                    <div id="usrnome">
                        <div id="prof_text"><h4><label for="nome">Username</label></h4></div>
                        <div id="prof_in">
                            <c:if test="${ok != 1}"><input name="username" id="username"  type="text"></c:if>
                            <c:if test="${ok == 1}"><input name="username" id="username" values="${utente.username}" type="text"></c:if>
                        </div>
                    </div>
                    <div id="pwdform">
                        <div id="passusr1">
                        <div id="prof_text"><h4><label for="password">Password</label></h4></div>
                            <div id="prof_in">
                            <c:if test="${ok != 1}"><input name="password" id="password"  type="password"></c:if>
                            <c:if test="${ok == 1}"><input name="password" id="password" values="${utente.password}" type="text"></c:if>
                            </div>
                        </div>
                        <c:if test="${ok != 1}">
                            <div id="passusr2">
                            <div id="prof_text"><h4><label for="password2">Conferma<br>password</label></h4></div>
                            <div id="prof_in"><input name="password2" id="password2" type="password"></div>
                        </div>
                        </c:if>
                    </div>
                    <div id="formbutton">
                        <button type="submit" name="aggiorna">Conferma</button>
                    </div>
                    
                </form>
            </div>
        </div>
    </body>
</html>

