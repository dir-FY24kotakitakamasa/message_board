package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import models.Message;
import utils.DBUtil;

@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NewServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("_token", request.getSession().getId());
        
        request.setAttribute("message", new Message());
        
        var rd = request.getRequestDispatcher("/WEB-INF/views/messages/new.jsp");
        rd.forward(request, response);
        
        /*EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();
        
        Message m = new Message();
        
        String title = "taro";
        m.setTitle(title);
        
        String content = "hello";
        m.setContent(content);
        
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        m.setCreated_at(currentTime);
        m.setUpdated_at(currentTime);
        
        em.persist(m);
        em.getTransaction().commit();
 
        response.getWriter().append(Integer.valueOf(m.getId()).toString());
    
        em.close();*/
    }

}
