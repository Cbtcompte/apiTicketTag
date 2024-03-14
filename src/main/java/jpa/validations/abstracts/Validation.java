package jpa.validations.abstracts;

import java.util.*;

public abstract class Validation<T> {
    protected Boolean error = false;
    protected Map<String, String> messages = new HashMap<String, String>();

    public Boolean isError() {
        return this.error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Map<String, String> getMessages() {
        return this.messages;
    }


    public abstract void rules(T t);
}
