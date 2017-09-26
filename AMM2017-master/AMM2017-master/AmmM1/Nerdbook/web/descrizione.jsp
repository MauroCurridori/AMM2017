<%-- 
    Document   : descrizione
    Author     : Meuro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--I meta sono dati che aiutano il browser a leggere e 'interpretare' il codice
        della pagina HTML.Info sulla lettura dei caratteri(UTF-8 prende anche molti
        caratteri accentati),sulle parole chiave quando si inseriscono sul brower
        (parole che si ricollegano al tema del sito),una descrizione ridotta e altre info 
        che l'autore vuole rilasciare(come i suoi dati)-->
        <title>Nerdbook:Social di cultura NERD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Social,Nerdbook,Informatica,Programmazione,Studenti,AMM,Descrizione,Info">
        <meta name="description" content="Nerdbook , il social di AMM">
        <meta name="author" content="Mauro Curridori">
        <link rel="stylesheet" href="style.css" type="text/css" media="all"/>
    </head>
    <body>
        
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="descheader.jsp"/>
        
        
        
        <div id="body">
            <div id="sommario">
                <ul>
                    <!--Definizione del segnalibro 'href="#nome"-->
                    <li><a href="#cose">Cos'è Nerdbook</a></li>
                    <li><a href="#chi">A chi è rivolto</a></li>
                    <li><a href="#paga">E' un servizio a pagamento</a></li>
                    <li><a href="#entra">Voglio iscrivermi!</a></li>
                </ul>
            </div>
            
            <div id="aboutnb">
                <!--Richiamo del segnalibro definito sopra, con la stessa etichetta-->
                <a id="cose"><h3>Cos'è Nerdbook</h3></a>
                <!--<p> si differenzia dagli 'h' perchè è la sezione meno importante.Utile al browser
                per capire la struttura della pagina-->
                <p>E' uno spazio social dove poter comunicare e stringere amicizie , 
                condividendo immagini,documenti e tanto altro</p>
            </div>
            
            <div id="whocan">
                <a id="chi"><h3>A chi è rivolto</h3></a>
                <p>Tutti possono entrare su Nerdbook! Non c'è limite di età o cultura per essere dei Nerd e condividere
                contenuti, quindi "GG"!</p>
            </div>
            
            <div id="pay">
                <a id="paga"><h3>E' un servizio a pagamento</h3></a>
                <p>Nerdbook è un servizio interamente gratuito,ma le donazioni sono sempre ben gradite.
                Chiunque voglia ci contatti e manderemo gli estremi per il pagamento </p>
            </div>
            
            <div id="signin">
                <a id="entra"><h3>Voglio iscrivermi!</h3></a>
                <p>Per potersi iscrivere è semplice!Scopri subito i contenuti cliccando su login in alto</p>
            </div>
            
        </div> 
    </body>
</html>
