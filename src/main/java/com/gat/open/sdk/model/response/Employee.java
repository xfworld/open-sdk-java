package com.gat.open.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xin.hua
 * @date 2017/7/19
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    @JsonProperty("corp_code")
    private String corpCode;
    private String name;
    private int gender;

    @JsonProperty("card_type")
    private int cardType;

    @JsonProperty("card_no")
    private String cardNo;
    private String email;
    private String mobile;

    @JsonProperty("dept_code")
    private String deptCode;

    @JsonProperty("dept_name")
    private String deptName;
    private String level;
    private String remark;

    @JsonProperty("send_invite")
    private Integer sendInvite;

    @JsonProperty("birth_day")
    private String birthDay;

    @JsonProperty("entry_day")
    private String entryDay;

    @JsonProperty("time_created")
    private String timeCreated;

    @JsonProperty("time_active")
    private String timeActive;

    public Employee() {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
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

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSendInvite() {
        return sendInvite;
    }

    public void setSendInvite(Integer sendInvite) {
        this.sendInvite = sendInvite;
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

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeActive() {
        return timeActive;
    }

    public void setTimeActive(String timeActive) {
        this.timeActive = timeActive;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "corpCode='" + corpCode + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", cardType=" + cardType +
                ", cardNo='" + cardNo + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", level='" + level + '\'' +
                ", remark='" + remark + '\'' +
                ", sendInvite=" + sendInvite +
                ", birthDay='" + birthDay + '\'' +
                ", entryDay='" + entryDay + '\'' +
                ", timeCreated='" + timeCreated + '\'' +
                ", timeActive='" + timeActive + '\'' +
                '}';
    }
}
