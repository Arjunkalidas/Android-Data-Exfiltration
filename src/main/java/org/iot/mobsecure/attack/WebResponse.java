package org.iot.mobsecure.attack;

import java.util.Map;

public class WebResponse {

    private final long id;
    private String filedata;
    private final String message;
    private Map<String, String> parameters;

    public WebResponse(long id, String filedata, String message, Map<String,String> parameters) {
        this.id = id;
        this.filedata = filedata;
        this.message = message;
        this.parameters = parameters;
    }

    public WebResponse(long id,String message) {
        this.id = id ;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getFiledata() {
        return filedata;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}
