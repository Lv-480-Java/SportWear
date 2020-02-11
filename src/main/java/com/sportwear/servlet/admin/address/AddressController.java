package com.sportwear.servlet.admin.address;

import com.sportwear.entity.Address;
import com.sportwear.service.AddressService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/admin/")
//public class AddressController extends HttpServlet {
//    private static final String pageAddress = "/jsp/add-get-delete.jsp";
//    private AddressService addressService = new AddressService();
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.getRequestDispatcher(pageAddress).forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF8");
//        final String country = request.getParameter("country");
//        final String city = request.getParameter("city");
//        final String street = request.getParameter("street");
//
//        Address address = new Address();
//        address.setCountry(country);
//        address.setCity(city);
//        address.setStreet(street);
//        addressService.add(address);
//        doGet(request, response);
////        response.sendRedirect("/homepage");
//    }
//
//}
