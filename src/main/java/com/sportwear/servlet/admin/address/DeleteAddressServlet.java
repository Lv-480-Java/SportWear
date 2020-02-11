package com.sportwear.servlet.admin.address;

import com.sportwear.service.AddressService;
import com.sportwear.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete-address")
public class DeleteAddressServlet extends HttpServlet {

    private AddressService addressService = new AddressService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(request.getParameter("id"));
        addressService.remove(id);
        response.sendRedirect("/admin/address-index");
    }
}
