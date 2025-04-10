package com.example.chatserver.common.auth;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest reqeust, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(reqeust, response);
    }
}
