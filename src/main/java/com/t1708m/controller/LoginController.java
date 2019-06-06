package com.t1708m.controller;

import com.t1708m.entity.Student;
import com.t1708m.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        StudentModel model = new StudentModel();
        Student student = model.findByUsernameAndStatus(username, Student.Status.ACTIVE);
        if (student == null) {
            resp.setStatus(404);
            resp.getWriter().println("tai khoan khong ton tai");
        } else {
            if (student.getPassword().equals(password)) {
                resp.setStatus(200);
                if (student.getRole() == 1) {
                    req.getRequestDispatcher("/userlist.jsp").forward(req, resp);
                }
                if (student.getRole() == 2) {
                    req.getRequestDispatcher("/adminlist.jsp").forward(req, resp);
                }

            } else {
                resp.setStatus(401);
                req.getRequestDispatcher("/test.jsp").forward(req, resp);
            }
        }
    }
}
