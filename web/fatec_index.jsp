<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Bem-Vindo A Fatec - Americana</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

        <link rel="stylesheet" href="css/menu.css">
  
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
        <script src="script/menu.js"></script>
                
    </head>
        <body>

        <nav>

            <img src="imagens/logo_fatec.png" class="img-fluid">
            
            <br/>
            <br/>
            <h1>Bem-Vindo A Fatec - Americana</h1>
            <br/>

            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity=sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

            <ul> 
                <li><a href="instuticional.html">Institucional</a></li> 
                <li><a href="historia.html">História</a></li> 
                <li><a href="missao.html">Missão, Visão e Valores</a></li> 
                <li><a href="infraestrutura.html">Infraestrutura</a></li> 
                <li><a href="corpo_tecnico.html">Corpo Técnico Administrativo</a></li> 
                <li><a href="corpo_docente.html">Corpo Docente</a></li> 
                <li><a href="aluno_login.html">Area do Aluno</a></li>
                <li><a href="intranet.html">Intranet</a></li>
            </ul>

        </nav>
            
        <div style="text-align: center">
            <form id="formNoticia" name="formNoticia" action="NoticiaController" method="post">
                <div class="form-group">
                    <input type="hidden" class="form-control" name="acaoCRUD" value="LI">
                </div>
                <button type="submit" class="btn btn-default">Carregar Notícias</button>    
            </form>
        </div>
        
        <br/>
        <br/>
            
        <c:set var="count" value="0" scope="page" />

        <c:if test="${p}">
            <div class="card-columns">
                
                <c:forEach var="noticia" items="${listNoticia}">
                    <div class="card">
                        <div class="card-body">
                            <c:set var="count" value="${count + 1}" scope="page"/>
                            <h4 class="card-title">Notícia <c:out value="${count}"></c:out></h4>
                            <p class="card-text"> <c:out value="${noticia.descricaoNoticia}"></c:out> </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>

        </body>
</html>
