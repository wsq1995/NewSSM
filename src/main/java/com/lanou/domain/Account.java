package com.lanou.domain;

import java.util.Date;

/**
 * Created by dllo on 17/12/23.
 */
public class Account {
    private int accountId;
    private int recommId;
    private String logName;
    private String logPwd;
    private char status;
    private Date createDate;
    private Date pauseDate;
    private Date closeDate;
    private String realName;
    private char idcard;
    private Date birthday;
    private char gender;
    private String occupation;
    private String telephone;
    private String email;
    private String mailAddress;
    private char zipCode;
    private String qq;
    private Date lastLoginTime;
    private String lastLoginIp;

    public Account() {
    }

    public Account(int accountId, int recommId, String logName,
                   String logPwd, char status, Date createDate,
                   Date pauseDate, Date closeDate, String realName,
                   char idcard, Date birthday, char gender, String occupation,
                   String telephone, String email, String mailAddress, char zipCode,
                   String qq, Date lastLoginTime, String lastLoginIp) {
        this.accountId = accountId;
        this.recommId = recommId;
        this.logName = logName;
        this.logPwd = logPwd;
        this.status = status;
        this.createDate = createDate;
        this.pauseDate = pauseDate;
        this.closeDate = closeDate;
        this.realName = realName;
        this.idcard = idcard;
        this.birthday = birthday;
        this.gender = gender;
        this.occupation = occupation;
        this.telephone = telephone;
        this.email = email;
        this.mailAddress = mailAddress;
        this.zipCode = zipCode;
        this.qq = qq;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getRecommId() {
        return recommId;
    }

    public void setRecommId(int recommId) {
        this.recommId = recommId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogPwd() {
        return logPwd;
    }

    public void setLogPwd(String logPwd) {
        this.logPwd = logPwd;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(Date pauseDate) {
        this.pauseDate = pauseDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public char getIdcard() {
        return idcard;
    }

    public void setIdcard(char idcard) {
        this.idcard = idcard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public char getZipCode() {
        return zipCode;
    }

    public void setZipCode(char zipCode) {
        this.zipCode = zipCode;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", recommId=" + recommId +
                ", logName='" + logName + '\'' +
                ", logPwd='" + logPwd + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", pauseDate=" + pauseDate +
                ", closeDate=" + closeDate +
                ", realName='" + realName + '\'' +
                ", idcard=" + idcard +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", occupation='" + occupation + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", zipCode=" + zipCode +
                ", qq='" + qq + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                '}';
    }
}
