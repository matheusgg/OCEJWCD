package mytags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagAdapter;
import javax.servlet.jsp.JspException;
import mysimpletags.MyChooseTag;

public class MyOtherwiseTag extends TagSupport {

    public int doStartTag() throws JspException {
        /* Obtain the parent (should be <choose>). */
        JspTag parent = getParent();

        /* If the parent is the simple tag version, must unwrap adapter */
        if(parent instanceof TagAdapter) {
            parent = ((TagAdapter)parent).getAdaptee();
        }

        if(parent instanceof mytags.MyChooseTag) {
            /* If a sibling has already been invoked, don't execute this tag */
            if( ((mytags.MyChooseTag)parent).isChildInvoked() ) {
                return SKIP_BODY;
            } 

            /* Otherwise, execute and notify the parent */
            ((mytags.MyChooseTag)parent).notifyChildInvoked();
            return EVAL_BODY_INCLUDE;
        } else if(parent instanceof mysimpletags.MyChooseTag) {
            /* If a sibling has already been invoked, don't execute this tag */
            if( ((mysimpletags.MyChooseTag)parent).isChildInvoked() ) {
                return SKIP_BODY;
            }

            /* Otherwise, execute and notify the parent */
            ((mysimpletags.MyChooseTag)parent).notifyChildInvoked();
            return EVAL_BODY_INCLUDE;
        } else {
            /* If the parent isn't an instance of MyChooseTag and
               isn't the simple tag version mysimpletags.MyChooseTag,
               throw exception */
            throw new JspException("otherwise must have choose parent");
        }

        /* Execution will never get here */
    }
}