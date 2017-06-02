package yona.filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeaderCustomizer extends HttpServletFilter {
    private String headerName;
    private String headerValue;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        headerName = filterConfig.getInitParameter("headerName");
        headerValue = filterConfig.getInitParameter("headerValue");
    }

    @Override
    void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setHeader(headerName, headerValue);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 特に解放するリソースはない
    }
}
