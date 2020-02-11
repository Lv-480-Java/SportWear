package com.sportwear.servlet.admin.order;

import com.sportwear.entity.Order;
import com.sportwear.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

//@WebServlet("/order")
//public class OrderController extends HttpServlet {
//    private static final String pageOrder = "/jsp/order.jsp";
//    private OrderService orderService = new OrderService();
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.getRequestDispatcher(pageOrder).forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF8");
//
//        final LocalDate date = LocalDate.parse(request.getParameter("date"));
//        final Long count = Long.parseLong(request.getParameter("count"));
//        final Boolean is_buy = Boolean.parseBoolean(request.getParameter("is_buy"));
//
//        Order order = new Order();
//        order.setLocalDate(date);
//        order.setCount(count);
//        order.setIs_buy(is_buy);
//        orderService.add(order);
//        response.sendRedirect("/homepage");
//    }
//}
