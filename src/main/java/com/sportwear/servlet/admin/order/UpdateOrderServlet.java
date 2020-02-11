package com.sportwear.servlet.admin.order;

import com.sportwear.entity.Color;
import com.sportwear.entity.Order;
import com.sportwear.service.ColorService;
import com.sportwear.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/admin/update-order")
public class UpdateOrderServlet extends HttpServlet {

    private OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        Order order = orderService.getOneOrder(Long.valueOf(id));
        req.setAttribute("order", order);

        req.getRequestDispatcher("/jsp/admin/manager/order/update.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final LocalDate date = LocalDate.parse(req.getParameter("date"));
        final Long count = Long.valueOf(req.getParameter("count"));
        final Long user_id = Long.valueOf(req.getParameter("user_id"));
        final Boolean is_buy = Boolean.valueOf(req.getParameter("is_buy"));
        Order order = new Order();
        order.setId(Long.valueOf(req.getParameter("id")));
        order.setLocalDate(date);
        order.setCount(count);
        order.setUser_id(user_id);
        order.setIs_buy(is_buy);

        Long id = Long.valueOf(req.getParameter("id"));

        orderService.update(order, id);

        resp.sendRedirect("/admin/order-index");
    }
}
