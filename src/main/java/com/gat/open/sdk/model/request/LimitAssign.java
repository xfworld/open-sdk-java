package com.gat.open.sdk.model.request;

import java.math.BigDecimal;

/**
 * @author Stanley Shen
 * @version 1.0.0
 * @date 2017/12/18 20:07
 */
public class LimitAssign {

    /**
     * 必填: 额度标识
     */
    private String limitOpenid;
    /**
     * 集团必填,企业不填: 公司编码
     */
    private String enterpriseCode;
    /**
     * 必填: 工号
     */
    private String corpCode;
    /**
     * 必填: 额度金额
     */
    private BigDecimal amount;
    /**
     * 必填: 发放原因
     */
    private String remark;
    /**
     * 选填: 发放备注
     */
    private String comment;
    /**
     * 必填: 交易号
     */
    private String externalCode;

    public String getLimitOpenid() {
        return limitOpenid;
    }

    public void setLimitOpenid(String limitOpenid) {
        this.limitOpenid = limitOpenid;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }
}
