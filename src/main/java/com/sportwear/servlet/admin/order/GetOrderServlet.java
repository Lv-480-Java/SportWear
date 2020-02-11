package com.sportwear.servlet.admin.order;

import com.sportwear.service.ColorService;
import com.sportwear.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/order-index")
public class GetOrderServlet extends HttpServlet {

    private OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("orders", orderService.getAllOrder());
        request.getRequestDispatcher("/jsp/admin/manager/order/add-get-delete.jsp").forward(request, response);
    }
}
