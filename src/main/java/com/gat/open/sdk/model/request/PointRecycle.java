package com.gat.open.sdk.model.request;

import java.math.BigDecimal;

/**
 * @author Stanley Shen
 * @version 1.0.0
 * @date 2018/4/28 13:03
 */
public class PointRecycle {

    /**
     * 集团必填,企业不填
     */
    private String enterpriseCode;
    private String corpCode;
    private BigDecimal amount;
    private String reason;
    private String externalCode;

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }
}
