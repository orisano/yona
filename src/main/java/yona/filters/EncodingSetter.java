package yona.filters;


import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;


public class EncodingSetter implements Filter {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private String encoding = DEFAULT_ENCODING;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String customEncoding = filterConfig.getInitParameter("encoding");
        if (customEncoding != null) {
            this.encoding = customEncoding;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 開放するリソース等は無い
    }
}
