package garnerpress;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NoCommitmentResponseWrapper extends HttpServletResponseWrapper {

    /* Storage for our writers */
    // We use this as the main output stream for both types of stream
    private ByteArrayOutputStream out;

    private ServletOutputStream outBytes;
    private PrintWriter outWriter;

    /* ServletOutputStream is abstract – we need our own class */
    private class MyServletOutputStream extends ServletOutputStream {

        /* In order to provide an output stream, we require that 'out'
           is already initialised */
        public void write(int b) {
            /* Make use of the NoCommitmentResponseWrapper's 'out' */
            out.write(b);
        }

    }

    public NoCommitmentResponseWrapper(HttpServletResponse wrap) {
        super(wrap);
    }

    public void flushBuffer() {
        // Do nothing
    }

    public PrintWriter getWriter() {
        if(outWriter != null) {
            return outWriter;
        }

        /* If 'outBytes' is non-null, then getOutputStream() was already called */
        if(outBytes != null) {
            throw new IllegalStateException("getOut() already invoked");
        }

        /* Otherwise create and return a new PrintWriter */
        out = new ByteArrayOutputStream();
        outWriter = new PrintWriter(out);
        return outWriter;
    }

    public ServletOutputStream getOutputStream() {
        if(outBytes != null) {
            return outBytes;
        }
        /* If 'outWriter' is non-null, then getWriter() was already called */
        if(outWriter != null) {
            throw new IllegalStateException("getWriter() was invoked");
        }

        /* Otherwise create and return a new ServletOutputStream */
        out = new ByteArrayOutputStream();
        /* Note that MyServletOutputStream is an instance inner-class;
           it is backed by 'out' which must be non-null at this point */
        outBytes = new MyServletOutputStream();
        return outBytes;
    }

    /**
     * This custom method returns the enclosed output stream,
     * which is written to by either of the
     * Writer or ServletOutputStream streams.
     */
    public ByteArrayOutputStream getOut() {
        /* This flush is required or the data never gets moved from the PrintWriter into 'out' */
        if(outWriter != null) {
            outWriter.flush();
        }
        return out;
    }

    /**
     * Resets the data in our internal buffer.
     */
    public void resetBuffer() {
        if(outWriter != null) {
            outWriter.flush();
        }
        if(out != null) {
            out.reset();
        }
    }
}
