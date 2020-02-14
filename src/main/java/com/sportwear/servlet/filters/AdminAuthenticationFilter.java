package com.sportwear.servlet.filters;

import com.sportwear.entity.User;
import com.sportwear.entity.UserRole;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminAuthenticationFilter implements Filter {
    private Logger logger = Logger.getLogger(AdminAuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("AdminAuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

       if (user == null){
            resp.sendRedirect("/signUp");
        } else if (user.getUserRole() == (UserRole.ROLE_ADMIN)) {
           filterChain.doFilter(servletRequest, servletResponse);
       }
    }

    @Override
    public void destroy() {

    }
}