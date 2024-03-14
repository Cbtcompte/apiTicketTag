package jpa;

public class ResponseJpa {
    private int codeStatus;
    private String message;
    private Object data;


    public ResponseJpa(int codeStatus, String message, Object data) {
        this.codeStatus = codeStatus;
        this.message = message;
        this.data = data;
    }


    public int getCodeStatus() {
        return this.codeStatus;
    }

    public void setCodeStatus(int codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
