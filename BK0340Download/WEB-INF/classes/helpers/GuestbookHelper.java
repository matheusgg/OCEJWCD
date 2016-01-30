package helpers;

import java.util.*;

public class GuestbookHelper {

    /** This data is likely to have been captured from a database */
    public Map<Date,String> getEntries() {
        /* To get a sample date, subtract some random number of milliseconds from the current time */
        Random rand = new Random();

        Map<Date, String> guestdata = new Hashtable<Date, String>();

        /* The masks on the random longs ensures that they are milliseconds in the last year or so */
        guestdata.put(new Date(System.currentTimeMillis() - (rand.nextLong() & 0x7FFFFFFFFL)), "This site is rubbish, uninformative and boring");
        guestdata.put(new Date(System.currentTimeMillis() - (rand.nextLong() & 0x7FFFFFFFFL)), "This site is rubbish and boring");
        guestdata.put(new Date(System.currentTimeMillis() - (rand.nextLong() & 0x7FFFFFFFFL)), "Totally uninformative pages");
        guestdata.put(new Date(System.currentTimeMillis() - (rand.nextLong() & 0x7FFFFFFFFL)), "Just so boring to read");

        return guestdata;
    }

    /** A more scalable design is storage of this data in a file (e.g. XML),
        reading it in dynamically when requested */
    public Map<String, String> getSwearDictionary() {
        /* Dictionary: */
        Map<String, String> sweardictionary = new Hashtable<String, String>();

        /* Note that we use "\\*" instead of "*" because our replacement tag uses the regex
           replacements methods, and * is a reserved regex character. We could also build this
           escapement into the tag handler; note that "-" does not require escaping since it is 
           not reserved in regex outside character classes. */
        sweardictionary.put("rubbish", "ru\\*\\*\\*sh");
        sweardictionary.put("uninformative", "unin\\*\\*\\*\\*ative");
        sweardictionary.put("boring", "bo--ng");

        return sweardictionary;
    }
}