package mysimpletags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagAdapter;
import javax.servlet.jsp.JspException;

public class MyOtherwiseTag extends SimpleTagSupport {

    public void doStartTag() throws JspException, java.io.IOException {
        /* Obtain the parent (should be <choose>). */
        JspTag parent = getParent();

        // No need for TagAdapter unwrapping

        if(parent instanceof mytags.MyChooseTag) {
            /* If a sibling has already been invoked, don't execute this tag */
            if( ((mytags.MyChooseTag)parent).isChildInvoked() ) {
                return;
            } 

            /* Otherwise, execute and notify the parent */
            ((mytags.MyChooseTag)parent).notifyChildInvoked();
            getJspBody().invoke(null);
            return;
        } else if(parent instanceof mysimpletags.MyChooseTag) {
            /* If a sibling has already been invoked, don't execute this tag */
            if( ((mysimpletags.MyChooseTag)parent).isChildInvoked() ) {
                return;
            }

            /* Otherwise, execute and notify the parent */
            ((mysimpletags.MyChooseTag)parent).notifyChildInvoked();
            getJspBody().invoke(null);
            return;
        } else {
            /* If the parent isn't an instance of MyChooseTag and
               isn't the simple tag version mysimpletags.MyChooseTag,
               throw exception */
            throw new JspException("otherwise must have choose parent");
        }
    }
}