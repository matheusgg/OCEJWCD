package mytags;

import java.util.*;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspException;
import java.io.IOException;

/**
 * Takes five attributes: 'data' is required and is a Map of
 * Date keys against String text, 'replace' (required) is a dictionary of
 * rude words (keys) against their replacements (values).
 * 'datevar' and 'textvar' are both optional.
 * 'swearlimit' is optional (with default value 5);
 * if declared, any entry which exceeds this limit
 * is ignored (i.e. not copied to the output).
 */
public class ModerationTag extends BodyTagSupport {

    /* 'data' attribute - has Date keys with String values */
    private Map<Date, String> data;

    /* 'replace' attribute - String keys and values */
    private Map<String, String> replace;

    /* 'swearlimit' attribute - initialised to -1, meaning undeclared */
    private int swearlimit = -1;

    /* 'datevar' attribute - or null if not used */
    private String datevar;

    /* 'textvar' attribute - or null if not used */
    private String textvar;

    /* An Iterator for the Date keys, sorted in ascending order */
    private Iterator<Date> sortedIter;


    /* 'data' attribute */
    public void setData(Map<Date, String> data) {
        this.data = data;

        /* Construct the sortedDates - we use the natural sorting of elements
           and allow TreeSet (a SortedSet impl.) to do the sorting for us */
        sortedIter = new TreeSet<Date>(data.keySet()).iterator();
    }

    /* 'replace' attribute */
    public void setReplace(Map<String, String> replace) {
        this.replace = replace;
    }

    /* 'swearlimit' attribute */
    public void setSwearlimit(int swearlimit) {
        this.swearlimit = swearlimit;
    }

    /* 'datevar' attribute */
    public void setDatevar(String datevar) {
        this.datevar = datevar;
    }

    /* 'textvar' attribute */
    public void setTextvar(String textvar) {
        this.textvar = textvar;
    }

    public int doStartTag() {
        /* Set 'swearlimit' to the default 5 if it wasn't initialised */
        if(swearlimit < 0) {
            swearlimit = 5;
        }

        /* At least 1 entry, so synchronise and evaluate body */
        if(sortedIter.hasNext()) {
            sync(sortedIter.next());
            return EVAL_BODY_BUFFERED;
        }

        /* Otherwise, no entries in the iterator, so skip body */
        return SKIP_BODY;
    }

    private void sync(Date currentDate) {
        if(datevar != null) {
            pageContext.setAttribute(datevar, currentDate);
        }
        if(textvar != null) {
            pageContext.setAttribute(textvar, data.get(currentDate));            
        }
    }

    public void doInitBody() {
        /* Do nothing - we could add preclude data here if we wanted */
    }

    public int doAfterBody() throws JspException {
        /* We (a) parse the contents in the last buffer, 
              (b) update the Iterator and variable sync. */

        BodyContent body = getBodyContent();
        String bufferContents = body.getString();

        int cumulativeSwearing = 0;
        for(String replaceKey : replace.keySet()) {
            cumulativeSwearing += getOccurrences(bufferContents, replaceKey);
            bufferContents = bufferContents.replaceAll(replaceKey, replace.get(replaceKey));
        }

        /* Clear the body buffer */
        body.clearBody();

        /* Only write the body out if cumulativeSwearing <= 'swearlimit' attribute 
           (default 5); otherwise suppress it completely. */
        if(cumulativeSwearing <= swearlimit) {
            /* Retrieve the enclosing JspWriter (usually either the 'out' response 
               stream or a parent action's BodyContent) */
            try {
                body.getEnclosingWriter().write(bufferContents);
            } catch(IOException ioe) {
                throw new JspException(ioe);
            }
        }

        /* Go to the next entry */
        if(!sortedIter.hasNext()) {
            return SKIP_BODY;
        }

        /* Otherwise, update and sychronise */
        sync(sortedIter.next());
        return EVAL_BODY_AGAIN;
    }

    /** Returns the number of times that 'word' appears in 'text' */
    private static int getOccurrences(String text, String word) {
        int counter = 0;
        /* Finds first occurrence (from position 0), only iterates if posn >= 0,
           finds next occurrence (from position 'posn + 1') */
        for(int posn=text.indexOf(word); posn >= 0; posn=text.indexOf(word, posn+1)) {
            counter++;
        }
        return counter;
    }

    public int doEndTag() {
        /* Remove scoped attributes */
        if(datevar != null) {
            pageContext.removeAttribute(datevar);
        }
        if(textvar != null) {
            pageContext.removeAttribute(textvar);            
        }

        /* Reset all instance variables which store attribute state, 
           ready for next invocation of tag */
        data = null;
        replace = null;
        swearlimit = -1;
        datevar = textvar = null;
        sortedIter = null;

        return EVAL_PAGE;
    }
}