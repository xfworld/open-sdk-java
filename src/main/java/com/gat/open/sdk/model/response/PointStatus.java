package com.gat.open.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author xin.hua
 * @date 2017/7/18
 */
public class PointStatus {

    private BigDecimal amount;
    @JsonProperty("corp_code")
    private String corpCode;
    private String externalCode;

    /**
     * 1:失败;2:完成;3:取消;4:延时
     */
    private int status;
    @JsonProperty("time_assign")
    private String timeAssign;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

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

    public String getTimeAssign() {
        return timeAssign;
    }

    public void setTimeAssign(String timeAssign) {
        this.timeAssign = timeAssign;
    }
}
