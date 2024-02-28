package jpa.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Formatter {
    
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());

    private  SimpleDateFormat getFormatter() {
        return this.formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }

    public static SimpleDateFormat getFormatterInstance() {
        Formatter f = new Formatter();
        return f.getFormatter();
    }

}
