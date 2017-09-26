<%-- 
    Document   : nuovopost
    Author     : Meuro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 
        <!--Contenuti della pagina-->
        
            
                
                    <div class="nuovopost">
                        <form action="Bacheca" method="post">
                            <div class="post_prof">
                                <h2>${utente.username}</h2>
                                <img title="profilo" name="usrimgurl" alt="Foto">
                            </div>
                            <div class="tipopost">                                
                                    <h2><label for="url">Link</label>
                                    <input type="radio" name="tipoall" value=1 id="urlType" checked="checked">
                                
                                    <label for="img">Immagine</label>
                                    <input type="radio" name="tipoall" value=2  id="imgType" checked="checked"></h2>
                            </div> 
                            <div class="input_url_post">
                                <input name="contall" id="usrimg" type="url" size="40">
                            </div>
                            <h2><label for="conttesto">Contenuto</label></h2>
                            <div class="post_cont_new">
                                <div>
                                    <textarea rows="4" cols="40" name="conttesto" id="frase"></textarea>
                                </div>
                            </div>
                            <button type="submit" value="Conferma">Conferma</button>
                        </form>     
                    </div>
             </body>
</html>
