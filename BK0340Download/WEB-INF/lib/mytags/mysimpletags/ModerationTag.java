package mysimpletags;

import java.util.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.JspException;

/**
 * Takes five attributes: 'data' is required and is a Map of
 * Date keys against String text, 'replace' (required) is a dictionary of
 * rude words (keys) against their replacements (values).
 * 'datevar' and 'textvar' are both optional.
 * 'swearlimit' is optional (with default value 5);
 * if declared, any entry which exceeds this limit
 * is ignored (i.e. not copied to the output).
 */
public class ModerationTag extends SimpleTagSupport {

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

    private void sync(Date currentDate) {
        if(datevar != null) {
            getJspContext().setAttribute(datevar, currentDate);
        }
        if(textvar != null) {
            getJspContext().setAttribute(textvar, data.get(currentDate));            
        }
    }

    public void doTag() throws JspException, java.io.IOException {
        /* Set 'swearlimit' to the default 5 if it wasn't initialised */
        if(swearlimit < 0) {
            swearlimit = 5;
        }

        /* Iterate through each 'sortedIter' entry */
        while(sortedIter.hasNext()) {
            /* Resynchronise the variables, then call processBody(),
               which re-invokes the fragment using the new variable values */
            sync(sortedIter.next());
            processBody();
        }

        /* Remove scoped attributes */
        if(datevar != null) {
            getJspContext().removeAttribute(datevar);
        }
        if(textvar != null) {
            getJspContext().removeAttribute(textvar);            
        }

        /* Instances never pooled - no need for clean-up/reset code */
    }

    public void processBody() throws JspException, java.io.IOException {
        /* Simple tags use a JspFragment and not a BodyContent */
        JspFragment body = getJspBody();

        /* In order to parse the contents, we must invoke the fragment,
           and direct the evaluation into an internal buffer (not the 'out' stream) */
        java.io.StringWriter strWriter = new java.io.StringWriter();
        body.invoke(strWriter);
        String bufferContents = strWriter.toString();

        int cumulativeSwearing = 0;
        for(String replaceKey : replace.keySet()) {
            cumulativeSwearing += getOccurrences(bufferContents, replaceKey);
            bufferContents = bufferContents.replaceAll(replaceKey, replace.get(replaceKey));
        }

        /* Only write the body out if cumulativeSwearing <= 'swearlimit' attribute 
           (default 5); otherwise suppress it completely. */
        if(cumulativeSwearing <= swearlimit) {
            /* Write 'bufferContents' to the 'out' stream; note that we don't catch the
               IOException, since doTag() is permitted to throw that exception */
            getJspContext().getOut().write(bufferContents);
        }
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
}