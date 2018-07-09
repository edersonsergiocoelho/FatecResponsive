/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nairo.controller;

import br.com.nairo.controller.jpa.AlunoJpaController;
import br.com.nairo.entity.Aluno;
import java.io.IOException;
import java.util.List;
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
public class AlunoListController extends HttpServlet {

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
    public AlunoListController() {
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
        
        try {
            
            EntityManager em = getEntityManager();
            AlunoJpaController alunoJpaController = new AlunoJpaController(em.getEntityManagerFactory());
            List<Aluno> listAluno = alunoJpaController.findAlunoEntities();
            
            if (listAluno == null || listAluno.isEmpty()) {
                RequestDispatcher requestDispatcher = null;
                requestDispatcher = request.getRequestDispatcher("aluno_nao_encontrado.html");
                requestDispatcher.forward(request, response);
                
                return;
            } else {
                request.setAttribute("listAluno", listAluno);
                request.setAttribute("p", Boolean.TRUE);
            }
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("aluno_erro_consultar.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("aluno_listar.jsp");
        requestDispatcher.forward(request, response);
    }
}