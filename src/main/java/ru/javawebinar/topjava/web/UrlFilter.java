package ru.javawebinar.topjava.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UrlFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/meals/delete/")) {
            String toReplace = requestURI.substring(requestURI.indexOf("/delete/"), requestURI.lastIndexOf("/") + 1);
            String newURI = requestURI.replace(toReplace, "");
            req.getRequestDispatcher(newURI).forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        //
    }
}