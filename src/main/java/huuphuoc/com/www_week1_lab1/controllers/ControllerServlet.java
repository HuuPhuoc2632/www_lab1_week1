package huuphuoc.com.www_week1_lab1.controllers;

import huuphuoc.com.www_week1_lab1.database.ConnectionDB;
import huuphuoc.com.www_week1_lab1.models.Account;
import huuphuoc.com.www_week1_lab1.respository.AccountRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccountRespository accResp = new AccountRespository();

//        Account acc = new Account("acc002", "Huynh Huu Phuoc", "12345", "huuphuoc@gmail.com", "0123456789", 1 );
//        boolean b;
//        try {
//            b= accResp.insertAccount(acc);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        Account acc = new Account();
////        try {
////            acc = accResp.getById("acc001");
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
//
        List<Account> ls = new ArrayList<>();
        try {
            ls = accResp.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + ls + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("login".equals(action)) {
            Login(req, resp);
        }
    }

    private void Login(HttpServletRequest req, HttpServletResponse resp) {
        AccountRespository accResp = new AccountRespository();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            Account account = accResp.login(username, password);
            if(account!=null){
                HttpSession session = req.getSession();
                session.setAttribute("loginSuccessful", account);
                if (account.getRole().getRole_name()!="admin"){
                    List<Account> ls = new ArrayList<>();
                    try {
                        ls = accResp.getAll();
                        session.setAttribute("listUser", ls);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    resp.sendRedirect("dashboard.jsp");
                }
                else resp.sendRedirect("info.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}
