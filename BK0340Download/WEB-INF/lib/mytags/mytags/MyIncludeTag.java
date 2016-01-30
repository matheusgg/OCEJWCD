package mytags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspException;
import javax.servlet.*;

public class MyIncludeTag extends TagSupport {

    // Let TagSupport take care of the standard implementation

    /* Invocation-specific 'page' attribute state */
    private String page;

    /**
     * Set the 'page' attribute for this invocation.
     */
    public void setPage(String page) {
        this.page = page;
    }

    public int doStartTag() {
        /* Body is always empty - always skip */
        return SKIP_BODY;
     }

    public int doEndTag() throws JspException {
        /* Note that the code below could also
           appear in the doStartTag() method */

        /* We catch any IO or ServletExceptions and rethrow a JspException */
        try {
            /* CANNOT Use RequestDispatcher mechanism */
            //ServletRequest req = pageContext.getRequest();
            //RequestDispatcher rd = req.getRequestDispatcher(page);

            /* 'rd' could be null, if 'page' is invalid - if so, this line 
               will throw a NullPointerException which we catch and handle */

            /* Note: if we simply call rd.include(), we copy the contents to the
               response stream; we actually want to write to the 'out' implicit object. */
            /* This method contains inherent error-handling in case the resource isn't available */
            pageContext.include(page);	//req, pageContext.getResponse());
        } //catch(NullPointerException npe) {
          //  throw new JspException("Invalid resource path: " + page);
        //} 
          catch(Exception excp) {
            /* Catches IO and ServletExceptions and wraps them */
            throw new JspException(excp);
        }

        /* Reset the local 'page' attribute */
        page = null;

        /* We always evaluate the page. If an exception was thrown,
           the calling page will either handle it (e.g. using <c:catch>),
           or propagate it to other pages or the container. */
        return EVAL_PAGE;
    }
}