<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Fatec Americana - Alterar Aluno</title>
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
        
        <h1 style="text-align: center">Alterar Aluno</h1>
        
        <br/>
        <br/>
        
        <form id="formAluno" name="formAluno" action="AlunoController" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${aluno.email}" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" required>
                </div>
            </div>
            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" id="nome" name="nome" placeholder="Ex: João Pereira da Silva" value="${aluno.nomeAluno}" required>
            </div>
            <div class="form-group">
                <label for="rg">RG</label>
                <input type="text" class="form-control" id="rg" name="rg" placeholder="Ex: 123456789" value="${aluno.rg}" required>
            </div>
            <div class="form-group">
                <label for="cpf">CPF</label>
                <input type="text" class="form-control" id="cpf" name="cpf" placeholder="Ex: 12345678901" value="${aluno.cpf}" required>
            </div>
            <div class="form-group">
                <label for="endereco">Endereço</label>
                <input type="text" class="form-control" id="endereco" name="endereco" placeholder="Ex: Av. Paulista" value="${aluno.endereco}" required>
            </div>
            <div class="form-group">
                <label for="numero">N°</label>
                <input type="number" class="form-control" id="numero" name="numero" placeholder="Ex: 100" value="${aluno.numero}" required>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="cidade">Cidade</label>
                    <input type="text" class="form-control" name="cidade" id="cidade" value="${aluno.cidade}" required>
                </div>
                <div class="form-group col-md-4">
                    <label for="estado">Estado</label>
                    <input type="text" class="form-control" name="estado" id="estado" value="${aluno.estado}" required>
                </div>
                <div class="form-group col-md-2">
                    <label for="cep">CEP</label>
                    <input type="text" class="form-control" id="cep" name="cep" value="${aluno.cep}" required>
                </div>
            </div>
            <div class="form-group">
                <input type="hidden" class="form-control" name="acaoCRUD" value="A">
            </div>
            <div class="form-group">
                <input type="hidden" class="form-control" name="codigoAluno" value="${aluno.codigoAluno}">
            </div>
            <button type="submit" class="btn btn-default">Alterar</button>
        </form>
        <form id="formAluno" name="formAluno" action="AlunoController" method="post">
            <div class="form-group">
                <input type="hidden" class="form-control" name="acaoCRUD" value="E">
            </div>
            <div class="form-group">
                <input type="hidden" class="form-control" name="codigoAluno" value="${aluno.codigoAluno}">
            </div>
            <button type="submit" class="btn btn-default">Excluir</button>    
        </form>
    </body>
</html>