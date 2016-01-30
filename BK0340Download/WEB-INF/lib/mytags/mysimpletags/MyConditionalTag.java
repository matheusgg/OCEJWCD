package mysimpletags;

import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;

public class MyConditionalTag implements SimpleTag {

    // STANDARD IMPLEMENTATION:

    private JspFragment body;
    private JspTag parent;
    private JspContext context;

    public void setParent(JspTag parent) {
        this.parent = parent;
    }

    public JspTag getParent() {
        return parent;
    }

    public void setJspContext(JspContext context) {
        this.context = context;
    }

    public void setJspBody(JspFragment fragment) {
        body = fragment;
    }

    // CUSTOM IMPLEMENTATION:

    /* Instance- (rather than invocation-) specific 'test' attribute state */
    private boolean test;

    /**
     * Set the 'test' attribute for this instance (not invocation).
     */
    public void setTest(boolean test) {
        this.test = test;
    }

    public void doTag() throws JspException, java.io.IOException {
        /* Only execute ('invoke') the body if 'test' is true */
        if(test) {
            /* Using an argument of null directs output to 
               the 'out' implicit object by default */
            body.invoke(null);
        }
    }
}