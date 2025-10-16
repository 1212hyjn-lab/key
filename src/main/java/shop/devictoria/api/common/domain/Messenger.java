package shop.devictoria.api.common.domain;

  
public class Messenger {
    private int code;
    private String message;
    
   public int getCode() {
        return code;
    }
    
    public String getMessage() {
        return message;
    }
    
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}