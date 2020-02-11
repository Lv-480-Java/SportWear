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

@WebServlet("/admin/update-address")
public class UpdateAddressServlet extends HttpServlet {

    private AddressService addressService = new AddressService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        Address address = addressService.getOneAddress(Long.valueOf(id));
        req.setAttribute("address", address);

        req.getRequestDispatcher("/jsp/admin/manager/address/update.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final String country = req.getParameter("country");
        final String city = req.getParameter("city");
        final String street = req.getParameter("street");
        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        address.setStreet(street);
        final Long id = Long.valueOf(req.getParameter("id"));

        addressService.update(address, id);

        resp.sendRedirect("/admin/address-index");
    }
}
