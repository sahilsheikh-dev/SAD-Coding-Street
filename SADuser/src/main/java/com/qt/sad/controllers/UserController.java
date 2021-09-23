/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.controllers;

import com.qt.sad.beans.UserBean;
import com.qt.sad.models.UserModel;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azher
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

      UserBean ub = new UserBean();
        UserModel umod = new UserModel();
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
      

        switch (request.getParameter("action")) {
            case "insert":
               insertUser(request, response);
                break;
            case "update":
                userUpdate(request, response);
                break;
            case "delete":
                ub.setId(Integer.parseInt(request.getParameter("id")));
                umod.delete(ub, request, response);
                break;
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
                ub.setName(request.getParameter("txtFirstName") + " " + request.getParameter("txtLastName"));
                ub.setMob(request.getParameter("txtContact"));
                ub.setEmail(request.getParameter("txtEmail"));
                ub.setPassword(request.getParameter("txtPass"));
                ub.setEducation(request.getParameter("selectEdu")+ " - " + request.getParameter("selectSem"));
                ub.setCollege(request.getParameter("txtCollege"));
                ub.setCity(request.getParameter("txtCity"));
                umod.insert(ub, request, response);
    }

    private void userUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
   
        ub.setId(Integer.parseInt(request.getParameter("id")));
                ub.setName(request.getParameter("txtFirstName") + " " + request.getParameter("txtLastName"));
                ub.setMob(request.getParameter("txtContact"));
                ub.setEmail(request.getParameter("txtEmail"));
                ub.setPassword(request.getParameter("txtPass"));
                ub.setEducation(request.getParameter("txtEducation")+ " - " + request.getParameter("selectSem"));
                ub.setCollege(request.getParameter("txtCollege"));
                ub.setCity(request.getParameter("txtCity"));
                umod.update(ub, request, response);
    }

}
