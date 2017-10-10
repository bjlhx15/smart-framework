package com.lhx.chapter2.controller;

import com.lhx.chapter2.model.Customer;
import com.lhx.chapter2.service.CustomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private CustomService customService;
    @Override
    public void init() throws ServletException {
        customService = new CustomService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = customService.getCustomerList("");
        req.setAttribute("customerList",customerList);
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req,resp);
    }
}
