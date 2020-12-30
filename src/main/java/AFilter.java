import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AFilter")
public class AFilter implements Filter {
    public void destroy() {
        System.out.println("过滤器挂了！");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器拦截你");
        chain.doFilter(req, resp);
        System.out.println("过滤器放行");

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器出生了");

    }

}
