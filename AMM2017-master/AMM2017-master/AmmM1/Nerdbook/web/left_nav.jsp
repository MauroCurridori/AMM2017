<%-- 
    Document   : left_nav
    Author     : Meuro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="left_nav">
            <h2 class='left_nav_item'>Amicizie:</h2><br>
            <a class='left_nav_prof' href="Profilo?username=nvidio">Nvidio</a><br>
            <a class='left_nav_prof' href="Profilo?username=giollone">Giollone</a><br>
            <a class='left_nav_prof' href="Profilo?username=nationalgeonerding">NationalGeoNerding</a><br>
            <h2 class='left_nav_item'>Gruppi:</h2><br>
            <h3>Crea nuovo GRUPPO:</h3>
            <form action="Gruppo" method="post">
                <input type="text" name="addgruppo"><button type="submit" value="Conferma">+</button>
            </form>
            
            <a class='left_nav_prof' href="Bacheca?gruppo=I 10 Comandamenti di Tesla">I 10 Comandamenti di Tesla</a><br>
            <a class='left_nav_prof' href="Bacheca?gruppo=Tom's HW & Jerry's SW">Tom's HW & Jerry's SW</a><br>
            
</div>
