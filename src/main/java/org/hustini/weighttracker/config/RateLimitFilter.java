package org.hustini.weighttracker.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RateLimitFilter implements Filter {

    private static final int MAX_REQUESTS_PER_MINUTE = 5;
    private final Map<String, Map.Entry<AtomicInteger, Long>> requestCounts = new ConcurrentHashMap<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String clientIp = httpRequest.getRemoteAddr();
        requestCounts.putIfAbsent(clientIp, new AbstractMap.SimpleEntry<>(new AtomicInteger(0), System.nanoTime()));
        int currentCount = requestCounts.get(clientIp).getKey().incrementAndGet();
        Long timeStampOfTheFirstRequest = requestCounts.get(clientIp).getValue();

        System.out.println("Current request count: " + currentCount);
        System.out.println("Current request time: " + timeStampOfTheFirstRequest);

        long oneMinuteInNanos = 60_000_000_000L;
        if (currentCount > MAX_REQUESTS_PER_MINUTE && timeStampOfTheFirstRequest + oneMinuteInNanos > System.nanoTime()) {
            httpResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            httpResponse.getWriter().write("Too many requests. Please try again later.");
            return;
        } else if (currentCount > MAX_REQUESTS_PER_MINUTE && timeStampOfTheFirstRequest + oneMinuteInNanos < System.nanoTime()) {
            requestCounts.remove(clientIp);
        }

        chain.doFilter(request, response);
    }
}