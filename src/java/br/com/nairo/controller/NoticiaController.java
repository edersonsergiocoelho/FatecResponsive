/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nairo.controller;

import br.com.nairo.controller.jpa.NoticiaJpaController;
import br.com.nairo.entity.Noticia;
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
public class NoticiaController extends HttpServlet {

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
    public NoticiaController() {
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
            } else if (acaoCRUD.equalsIgnoreCase("C")) {
                acaoCRUDConsultar(request, response);
            } else if (acaoCRUD.equalsIgnoreCase("LI")) {
                acaoCRUDListConsultarIndex(request, response);    
            } else {
                acaoCRUDListConsultar(request, response);    
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("noticia_erro.html");
            requestDispatcher.forward(request, response);
        }
    }
    
    private Noticia preencheNoticia (HttpServletRequest request, String acaoCRUD) {
        
        Integer codigoNoticia = null;
        
        if (acaoCRUD.equalsIgnoreCase("A")) {
            codigoNoticia = Integer.parseInt(request.getParameter("codigoNoticia"));
        }
        
        String descricaoNoticia = request.getParameter("descricaoNoticia");
        
        Noticia noticia = new Noticia();
        
        if (acaoCRUD.equalsIgnoreCase("A")) {
            noticia.setCodigoNoticia(codigoNoticia);
        }
        
        noticia.setDescricaoNoticia(descricaoNoticia);
        
        return noticia;
    }
    
    private void acaoCRUDIncluir (HttpServletRequest request, HttpServletResponse response, String acaoCRUD) throws ServletException, IOException {
        
        try {
            
            Noticia noticia = preencheNoticia(request, acaoCRUD);
            
            EntityManager em = getEntityManager();
            NoticiaJpaController noticiaJpaController = new NoticiaJpaController(em.getEntityManagerFactory());
            noticiaJpaController.create(noticia);
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("noticia_erro.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("noticia_sucesso.html");
        requestDispatcher.forward(request, response);
    }
    
    private void acaoCRUDAlterar (HttpServletRequest request, HttpServletResponse response, String acaoCRUD) throws ServletException, IOException {
        
        try {
            
            Noticia noticia = preencheNoticia(request, acaoCRUD);
            
            EntityManager em = getEntityManager();
            NoticiaJpaController noticiaJpaController = new NoticiaJpaController(em.getEntityManagerFactory());
            noticiaJpaController.edit(noticia);
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("noticia_erro.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("noticia_sucesso.html");
        requestDispatcher.forward(request, response);
    }
    
    private void acaoCRUDExcluir (HttpServletRequest request, HttpServletResponse response, String acaoCRUD) throws ServletException, IOException {
        
        try {
            
            Integer codigoNoticia = Integer.parseInt(request.getParameter("codigoNoticia"));
            
            EntityManager em = getEntityManager();
            NoticiaJpaController noticiaJpaController = new NoticiaJpaController(em.getEntityManagerFactory());
            noticiaJpaController.destroy(codigoNoticia);
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("noticia_erro.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("noticia_sucesso_excluir.html");
        requestDispatcher.forward(request, response);
    }
    
    private void acaoCRUDConsultar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            Integer codigoNoticia = Integer.parseInt(request.getParameter("codigoNoticia"));
            
            EntityManager em = getEntityManager();
            NoticiaJpaController noticiaJpaController = new NoticiaJpaController(em.getEntityManagerFactory());
            Noticia noticia = noticiaJpaController.findNoticia(codigoNoticia);
            
            if (noticia == null) {
                RequestDispatcher requestDispatcher = null;
                requestDispatcher = request.getRequestDispatcher("noticia_nao_encontrado.html");
                requestDispatcher.forward(request, response);
                
                return;
            } else {
                request.setAttribute("noticia", noticia);
            }
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("noticia_erro_consultar.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("noticia_alterar.jsp");
        requestDispatcher.forward(request, response);
    }

    private void acaoCRUDListConsultarIndex (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            EntityManager em = getEntityManager();
            NoticiaJpaController noticiaJpaController = new NoticiaJpaController(em.getEntityManagerFactory());
            List<Noticia> listNoticia = noticiaJpaController.findNoticiaEntities();
            
            if (listNoticia == null || listNoticia.isEmpty()) {
                RequestDispatcher requestDispatcher = null;
                requestDispatcher = request.getRequestDispatcher("noticia_nao_encontrado.html");
                requestDispatcher.forward(request, response);
                
                return;
            } else {
                request.setAttribute("listNoticia", listNoticia);
                request.setAttribute("p", Boolean.TRUE);
            }
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("noticia_erro_consultar.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("fatec_index.jsp");
        requestDispatcher.forward(request, response);
    }
    
    private void acaoCRUDListConsultar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            EntityManager em = getEntityManager();
            NoticiaJpaController noticiaJpaController = new NoticiaJpaController(em.getEntityManagerFactory());
            List<Noticia> listNoticia = noticiaJpaController.findNoticiaEntities();
            
            if (listNoticia == null || listNoticia.isEmpty()) {
                RequestDispatcher requestDispatcher = null;
                requestDispatcher = request.getRequestDispatcher("noticia_nao_encontrado.html");
                requestDispatcher.forward(request, response);
                
                return;
            } else {
                request.setAttribute("listNoticia", listNoticia);
                request.setAttribute("p", Boolean.TRUE);
            }
            
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = null;
            requestDispatcher = request.getRequestDispatcher("noticia_erro_consultar.html");
            requestDispatcher.forward(request, response);
        }
        
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("noticia_listar.jsp");
        requestDispatcher.forward(request, response);
    }
}
