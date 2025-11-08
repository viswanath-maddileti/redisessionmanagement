package com.viswa.redisessionmanagement.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(CorrelationIdFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String correlationId = request.getHeader("X-Correlation-ID");
        if (correlationId == null) {
            correlationId = UUID.randomUUID().toString();
        }
        MDC.put("correlationId", correlationId);
        response.setHeader("X-Correlation-ID", correlationId);
        try {
            logger.info("➡️ Incoming Request: [{}] {} {}", correlationId, request.getMethod(), request.getRequestURI());
            filterChain.doFilter(request, response);
            logger.info("⬅️ Outgoing Response: [{}] Status {}", correlationId, response.getStatus());
        } finally {
            MDC.remove("correlationId");
        }
    }
}
