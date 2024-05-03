package controller;

import database.CustomerDao;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("register")){
            register(req,resp);
        } else if (action.equals("delete")) {
            delete(req, resp);
        }
    }
    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email_address");
        String phone = req.getParameter("number_phone");
        CustomerDao cusDao = new CustomerDao();
        if(!cusDao.checkUsername(username)){
            cusDao.insert(new Customer(username, password, name, email, phone));
            req.getRequestDispatcher("/customerManager.jsp").forward(req, resp);
        }else {
            username = (username==null) ? "" : username;
            password = (password==null) ? "" : password;
            name = (name == null) ? "" : name;
            email = (email==null) ? "" : email;
            phone = (phone==null) ? "" : phone;
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("phone", phone);
            req.setAttribute("error_username", "Tài khoản đã tồn tại ");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
        CustomerDao cusDAO = new CustomerDao();
        Customer cus = cusDAO.selectByUsername(username).get(0);
        if (  cusDAO.delete(cus) > 0) {
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("error");
        }
    }
}
