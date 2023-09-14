package huuphuoc.com.www_week1_lab1.controllers;

import huuphuoc.com.www_week1_lab1.database.ConnectionDB;
import huuphuoc.com.www_week1_lab1.models.Account;
import huuphuoc.com.www_week1_lab1.respository.AccountRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccountRespository accResp = new AccountRespository();

//        Account acc = new Account("acc001", "Huynh Huu Phuoc", "12345", "huuphuoc@gmail.com", "0123456789", 1 );
//        boolean b;
//        try {
//            b= accResp.insertAccount(acc);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        Account acc = new Account();
        try {
            acc = accResp.getById("acc001");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + acc + "</h1>");
        out.println("</body></html>");
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
    public void destroy() {
    }
}
