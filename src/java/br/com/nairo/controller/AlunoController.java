/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nairo.controller;

import br.com.nairo.controller.jpa.AlunoJpaController;
import br.com.nairo.entity.Aluno;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eders
 */
@WebServlet
public class AlunoController extends HttpServlet {

    protected EntityManager entityManager;
    
    private EntityManager getEntityManager() { 
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FatecResponsive"); 
        if (entityManager == null) { 
            entityManager = entityManagerFactory.createEntityManager(); 
        } 
        return entityManager; 
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String acaoCRUD = "";
        
        try {
            
            acaoCRUD = request.getParameter("acaoCRUD");
            
            if (acaoCRUD.equalsIgnoreCase("I")) {
                acaoCRUDIncluir(request, response, acaoCRUD);
            } else if (acaoCRUD.equalsIgnoreCase("A")) {
                acaoCRUDAlterar(request, response, acaoCRUD);
            } else if (acaoCRUD.equalsIgnoreCase("E")) {
                acaoCRUDExcluir(request, response, acaoCRUD);
            } else {
                acaoCRUDConsultar(request, response);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("erro_aluno.html");
            requestDispatcher.forward(request, response);
        }
    }
    
    private Aluno preencheAluno (HttpServletRequest request, String acaoCRUD) {
        
        Integer codigoAluno = null;
        
        if (acaoCRUD.equalsIgnoreCase("A")) {
            codigoAluno = Integer.parseInt(request.getParameter("codigoAluno"));
        }
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nomeAluno = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        Integer numero = Integer.parseInt(request.getParameter("numero"));
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");
        
        Aluno aluno = new Aluno();
        
        if (acaoCRUD.equalsIgnoreCase("A")) {
            aluno.setCodigoAluno(codigoAluno);
        }
        
        aluno.setEmail(email);
        aluno.setSenha(senha);
        aluno.setNomeAluno(nomeAluno);
        aluno.setRg(rg);
        aluno.setCpf(cpf);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
        
        return aluno;
    }
    
    private void acaoCRUDIncluir (HttpServletRequest request, HttpServletResponse response, String acaoCRUD) throws ServletException, IOException {
        
        try {
            
            Aluno aluno = preencheAluno(request, acaoCRUD);
            
            EntityManager em = getEntityManager();
            AlunoJpaController alunoJpaController = new AlunoJpaController(em.getEntityManagerFactory());
            alunoJpaController.create(aluno);
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("aluno_erro.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("aluno_sucesso.html");
        requestDispatcher.forward(request, response);
    }
    
    private void acaoCRUDAlterar (HttpServletRequest request, HttpServletResponse response, String acaoCRUD) throws ServletException, IOException {
        
        try {
            
            Aluno aluno = preencheAluno(request, acaoCRUD);
            
            EntityManager em = getEntityManager();
            AlunoJpaController alunoJpaController = new AlunoJpaController(em.getEntityManagerFactory());
            alunoJpaController.edit(aluno);
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("aluno_erro.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("aluno_sucesso.html");
        requestDispatcher.forward(request, response);
    }
    
    private void acaoCRUDExcluir (HttpServletRequest request, HttpServletResponse response, String acaoCRUD) throws ServletException, IOException {
        
        try {
            
            Integer codigoAluno = Integer.parseInt(request.getParameter("codigoAluno"));
            
            EntityManager em = getEntityManager();
            AlunoJpaController alunoJpaController = new AlunoJpaController(em.getEntityManagerFactory());
            alunoJpaController.destroy(codigoAluno);
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("aluno_erro.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("aluno_sucesso_excluir.html");
        requestDispatcher.forward(request, response);
    }
    
    private void acaoCRUDConsultar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            EntityManager em = getEntityManager();
            AlunoJpaController alunoJpaController = new AlunoJpaController(em.getEntityManagerFactory());
            Aluno aluno = alunoJpaController.findByEmailAndSenha(email, senha);
            
            if (aluno == null) {
                RequestDispatcher requestDispatcher = null;
                requestDispatcher = request.getRequestDispatcher("aluno_nao_encontrado.html");
                requestDispatcher.forward(request, response);
                
                return;
            } else {
                request.setAttribute("aluno", aluno);
            }
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("aluno_erro_consultar.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("aluno_alterar.jsp");
        requestDispatcher.forward(request, response);
    }
}
