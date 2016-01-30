package mytags;

import javax.servlet.jsp.tagext.TagSupport;

public class MyChooseTag extends TagSupport {

    /* Set to 'true' if a child tag has already evaluated */
    private boolean childInvoked;

    public void notifyChildInvoked() {
        childInvoked = true;
    }

    public boolean isChildInvoked() {
        return childInvoked;
    }

    public int doStartTag() {
        childInvoked = false;
        return EVAL_BODY_INCLUDE;
    }
}
