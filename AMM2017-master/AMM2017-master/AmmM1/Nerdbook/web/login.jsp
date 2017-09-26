<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdbook:Social di cultura NERD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Social,Nerdbook,Informatica,Inserisci,Programmazione,Studenti,AMM,Login,Accedi">
        <meta name="login" content="Nerdbook , il social di AMM">
        <meta name="author" content="Mauro Curridori">
        <link rel="stylesheet" href="style.css" type="text/css" media="all" />
    </head>
    <body id="login_color">
        
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="loginheader.jsp"/>
        <!--Definizione del form che permette all'utente di inserire dati e di essere 
        elaborati, di conseguenza, da un'altra pagina(PHP)-->
        <div id="login_insert">
                <div id="login_input_form">            
                <!--Definizione del metodo di invio dei dati con 'GET'. Per ora i dati sono 
                ancora in chiaro nell'URL. Con il metodo POST non accedeva alla pagina destinazione
                -->
                    <form method="get" action="Login" >
                        <div id="login_usr">
                            <h3><label for="usrname">Username:</label></h3>
                            <!--Casella di inserimento della stringa in chiaro-->
                            <input name="usrname" id="usrname" type="text"/>
                        </div>

                        <div id="login_pass">
                            <h3><label for="pswd">Password:</label></h3>
                            <!--Casella di inserimento della stringa oscurata(pallini)-->
                            <input name="pswd" id="pswd" type="password"/>
                            <!--Input delle info del form tramite tasto semplice(senza immagini)
                            con etichetta definita dall'autore(value='Accedi')-->
                        </div>

                        <div id="login_button">
                        <button type="submit">Accedi</button>
                        </div>

                    </form>
                    <c:if test="${Logged == false}">
                        <h2>ERRORE </h2>
                    </c:if>
                        
                </div>
        </div>
    </body>
</html>
