package com.project.example.filters;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

@Component
@Order(0)
public class AuthFilter implements Filter {

    private final String[] excludedEndpoints = new String[] { "/auth", "/auth/*", };

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        boolean shouldNotFilter = Arrays.stream(this.excludedEndpoints)
                .anyMatch(e -> new AntPathMatcher().match(e, req.getServletPath()));

        if (shouldNotFilter == false) {
            // jwt logic
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        filterchain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterconfig) throws ServletException {
    }

}
