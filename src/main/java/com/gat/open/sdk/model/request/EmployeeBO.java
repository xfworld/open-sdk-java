package com.gat.open.sdk.model.request;

/**
 * @author wenbin
 * @date 2017/12/8
 */
public class EmployeeBO {

    private String enterpriseCode;
    private String corpCode;
    private String name;
    private Integer gender;
    private Integer cardType;
    private Integer sendInvite;
    private String cardNo;
    private String email;
    private String mobile;
    private String remark;
    private String deptCode;
    private String level;
    /**
     * 格式: yyyy-MM-dd
     */
    private String birthDay;
    /**
     * 格式: yyyy-MM-dd
     */
    private String entryDay;

    public EmployeeBO() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getSendInvite() {
        return sendInvite;
    }

    public void setSendInvite(Integer sendInvite) {
        this.sendInvite = sendInvite;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEntryDay() {
        return entryDay;
    }

    public void setEntryDay(String entryDay) {
        this.entryDay = entryDay;
    }

    @Override
    public String toString() {
        return "EmployeeBO{" +
                "enterpriseCode='" + enterpriseCode + '\'' +
                ", corpCode='" + corpCode + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", cardType=" + cardType +
                ", sendInvite=" + sendInvite +
                ", cardNo='" + cardNo + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", remark='" + remark + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", level='" + level + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", entryDay='" + entryDay + '\'' +
                '}';
    }
}
