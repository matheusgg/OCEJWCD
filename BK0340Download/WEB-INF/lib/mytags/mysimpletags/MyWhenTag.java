package mysimpletags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagAdapter;
import javax.servlet.jsp.JspException;

public class MyWhenTag extends SimpleTagSupport {

    /* Invocation-specific 'test' attribute state */
    private boolean test;

    /**
     * Set the 'test' attribute for this invocation.
     */
    public void setTest(boolean test) {
        this.test = test;
    }

    public void doTag() throws JspException, java.io.IOException {
        /* Obtain the parent (should be <choose>). */
        JspTag parent = getParent();

        // No need for TagAdapter unwrapping

        if(parent instanceof mytags.MyChooseTag) {
            /* If a sibling has already been invoked, or if 'test' is false,
               don't execute this tag */
            if( ((mytags.MyChooseTag)parent).isChildInvoked() ) {
                return;
            } else if(test) {
                /* Otherwise, if this test is true, notify the parent */
                ((mytags.MyChooseTag)parent).notifyChildInvoked();
                getJspBody().invoke(null);
                return;
            }
        } else if(parent instanceof mysimpletags.MyChooseTag) {
            /* If a sibling has already been invoked, or if 'test' is false,
               don't execute this tag */
            if( ((mysimpletags.MyChooseTag)parent).isChildInvoked() ) {
                return;
            } else if(test) {
                /* Otherwise, if this test is true, notify the parent */
                ((mysimpletags.MyChooseTag)parent).notifyChildInvoked();
                getJspBody().invoke(null);
                return;
            }
        } else {
            /* If the parent isn't an instance of MyChooseTag and
               isn't the simple tag version mysimpletags.MyChooseTag,
               throw exception */
            throw new JspException("when must have choose parent");
        }
    }
}