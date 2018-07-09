<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Fatec Americana - Lista Notícias</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    </head>
    <body>
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity=sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        
        <h1 style="text-align: center">Lista - Notícias</h1>
        
        <br/>
        <br/>
        
        <div style="text-align: center">
            <form id="formNoticia" name="formNoticia" action="NoticiaController" method="post">
                <div class="form-group">
                    <input type="hidden" class="form-control" name="acaoCRUD" value="L">
                </div>
                <button type="submit" class="btn btn-default">Pesquisar</button>    
                <a class="btn btn-primary" href="intranet.html" role="button">Voltar</a>
            </form>
        </div>
        
        <br/>
        <br/>
        
        <c:if test="${p}">
            <table class="table table-responsive">
                <tr>
                    <th>Código</th>
                    <th>Descrição</th>
                </tr>
                <c:forEach var="noticia" items="${listNoticia}">
                    <tr>
                        <th> </th>
                        <td> <c:out value="${noticia.codigoNoticia}"></c:out> </td>
                        <td> <c:out value="${noticia.descricaoNoticia}"></c:out> </td>
                        <td>             
                            <form id="formListNoticia" name="formListNoticia" action="NoticiaController" method="post">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="acaoCRUD" value="C">
                                </div>
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="codigoNoticia" value="${noticia.codigoNoticia}">
                                </div>
                                <button type="submit" class="btn btn-default">Alterar</button>
                            </form>
                            <form id="formListNoticia" name="formListNoticia" action="NoticiaController" method="post">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="acaoCRUD" value="E">
                                </div>
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="codigoNoticia" value="${noticia.codigoNoticia}">
                                </div>
                                <button type="submit" class="btn btn-default">Excluir</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>