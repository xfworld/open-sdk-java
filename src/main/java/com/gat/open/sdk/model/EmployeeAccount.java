package com.gat.open.sdk.model;

import java.math.BigDecimal;

/**
 * Created by xin.hua on 2017/7/19.
 */
public class EmployeeAccount {

    private String account_openid;
    private String name;
    private int type;
    private BigDecimal balance;
    private int status;

    public String getAccount_openid() {
        return account_openid;
    }

    public void setAccount_openid(String account_openid) {
        this.account_openid = account_openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeAccount{" +
                "account_openid='" + account_openid + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
