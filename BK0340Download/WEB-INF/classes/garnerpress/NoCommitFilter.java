package garnerpress;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class NoCommitFilter implements Filter {

    /* We'll store this anyway, but in this implementation we don't use it */
    private FilterConfig config;

    public void init(FilterConfig conf) {
        this.config = conf;
    }

    /* Empty implementation */
    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        /* Create a new wrapper for the response */
        NoCommitmentResponseWrapper wrap = new NoCommitmentResponseWrapper((HttpServletResponse)resp);

        /* Pass wrapper to the next filter in the chain */
        chain.doFilter(req, wrap);

        /* 
         * Once chain.doFilter() returns, we'll be here. Either
         * the components will have forced the response to be committed
         * (e.g. by calling the HTTP sendError(...)), or the output
         * stream will be full and requires buffering to the client
         */
        if(wrap.isCommitted()) {
            /* 
             * Then the original response has been committed
             * (e.g. by sendError(...)). We don't need to do anything
             * if commitment has already occurred 
             */
            return;
        }

        /* Otherwise we need to copy the wrapper's buffer to the actual response */
        if(wrap.getOut() != null) {
            wrap.getOut().writeTo(resp.getOutputStream());
        }
    }
}