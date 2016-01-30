package mytags;

import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.PageContext;

public class MyConditionalTag implements Tag {

    // STANDARD IMPLEMENTATION:

    private PageContext pageContext;
    private Tag parent;

    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    public void setParent(Tag t) {
        parent = t;
    }

    public Tag getParent() {
        return parent;
    }

    public void release() {
        // No resources to release
    }

    // CUSTOM IMPLEMENTATION:

    /* Invocation-specific 'test' attribute state */
    private boolean test;

    /**
     * Set the 'test' attribute for this invocation.
     */
    public void setTest(boolean test) {
        this.test = test;
    }

    public int doStartTag() {
        /* Only include the body if 'test' is true */
        return test ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }

    public int doEndTag() {
        /* No processing required */
        return EVAL_PAGE;
    }
}