package com.sportwear.servlet.admin.address;

import com.sportwear.entity.Address;
import com.sportwear.entity.Brand;
import com.sportwear.service.AddressService;
import com.sportwear.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add-address")
public class AddAddressServlet extends HttpServlet {

    private AddressService addressService = new AddressService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String pageBrand = "/jsp/admin/manager/address/add-get-delete.jsp";
        request.getRequestDispatcher(pageBrand).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        Address address = new Address();
        address.setCountry(request.getParameter("country"));
        address.setCity(request.getParameter("city"));
        address.setStreet(request.getParameter("street"));

        addressService.add(address);
        response.sendRedirect("/admin/address-index");
    }
}
