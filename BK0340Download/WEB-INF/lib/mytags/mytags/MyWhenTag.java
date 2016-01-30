package mytags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagAdapter;
import javax.servlet.jsp.JspException;
import mysimpletags.MyChooseTag;


public class MyWhenTag extends TagSupport {

    /* Invocation-specific 'test' attribute state */
    private boolean test;

    /**
     * Set the 'test' attribute for this invocation.
     */
    public void setTest(boolean test) {
        this.test = test;
    }

    public int doStartTag() throws JspException {
        /* Obtain the parent (should be <choose>). */
        JspTag parent = getParent();

        /* If the parent is the simple tag version, must unwrap adapter */
        if(parent instanceof TagAdapter) {
            parent = ((TagAdapter)parent).getAdaptee();
        }

        if(parent instanceof mytags.MyChooseTag) {
            /* If a sibling has already been invoked, or if 'test' is false,
               don't execute this tag */
            if( ((mytags.MyChooseTag)parent).isChildInvoked() ) {
                return SKIP_BODY;
            } else if(test) {
                /* Otherwise, if this test is true, notify the parent */
                ((mytags.MyChooseTag)parent).notifyChildInvoked();
                return EVAL_BODY_INCLUDE;
            }
        } else if(parent instanceof mysimpletags.MyChooseTag) {
            /* If a sibling has already been invoked, or if 'test' is false,
               don't execute this tag */
            if( ((mysimpletags.MyChooseTag)parent).isChildInvoked() ) {
                return SKIP_BODY;
            } else if(test) {
                /* Otherwise, if this test is true, notify the parent */
                ((mysimpletags.MyChooseTag)parent).notifyChildInvoked();
                return EVAL_BODY_INCLUDE;
            }
        } else {
            /* If the parent isn't an instance of MyChooseTag and
               isn't the simple tag version mysimpletags.MyChooseTag,
               throw exception */
            throw new JspException("when must have choose parent");
        }

        return SKIP_BODY;
    }
}