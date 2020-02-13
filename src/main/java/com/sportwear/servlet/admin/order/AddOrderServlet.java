package com.sportwear.servlet.admin.order;

import com.sportwear.entity.Order;
import com.sportwear.service.order.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/admin/add-order")
public class AddOrderServlet extends HttpServlet {

    private OrderService orderService = new OrderService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String pageBrand = "/jsp/admin/manager/order/add-get-delete.jsp";
        request.getRequestDispatcher(pageBrand).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        Order order = new Order();
        order.setLocalDate(LocalDate.parse(request.getParameter("date")));
        order.setCount(Long.parseLong(request.getParameter("count")));
        order.setUser_id(Long.parseLong(request.getParameter("user_id")));
        order.setIs_buy(Boolean.parseBoolean(request.getParameter("is_buy")));

        orderService.add(order);
        response.sendRedirect("/admin/order-index");
    }
}
