package com.tuxdev.kontaweb.domain.request;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by j.sanchez.chaves on 4/25/2018.
 *
 * KONTA-pom
 */
public class RequestBean implements Serializable {
    private Map<String,Object> payload;

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
}
