package com.tuxdev.kontaweb.domain.response;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by j.sanchez.chaves on 4/25/2018.
 *
 * KONTA-pom
 */
public class ServiceResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * ResponseStatus object
     */
    private String  responseCode;

    private Map<String,Object> responseDescription;



    public ServiceResponse(){
        responseCode="SUCCESS";
    }



    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Map<String,Object> getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(Map<String,Object> responseDescription) {
        this.responseDescription = responseDescription;
    }
}
