package com.gat.open.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author xin.hua
 * @date 2017/7/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LimitStatus {

    private String externalCode;
    private int status;

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
