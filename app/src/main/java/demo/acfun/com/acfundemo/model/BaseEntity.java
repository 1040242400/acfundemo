package demo.acfun.com.acfundemo.model;

import java.io.Serializable;

/**
 * Created by chen on 16/6/15.
 */
public class BaseEntity implements Serializable {

    /**
     * code : 200
     * message : OK
     */

    public int code;
    public String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
