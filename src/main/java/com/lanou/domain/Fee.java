package com.lanou.domain;

import java.util.Date;

/**
 * Created by dllo on 17/12/19.
 */
public class Fee {
    private int costId;
    private String name;
    private int baseDuration;
    private int baseCost;
    private int unitCost;
    private String status;
    private Date creatime;
    private Date startime;
    private char costType;
    private String descr;

    public Fee() {
    }

    public Fee(int costId, String name, int baseDuration, int baseCost,
               int unitCost, String status, Date creatime, Date startime,char costType) {
        this.costId = costId;
        this.name = name;
        this.baseDuration = baseDuration;
        this.baseCost = baseCost;
        this.unitCost = unitCost;
        this.status = status;
        this.creatime = creatime;
        this.startime = startime;
        this.costType = costType;
    }

    public Fee(String name, char costType,int baseCost, int unitCost, int baseDuration, String descr) {
        this.name = name;
        this.baseDuration = baseDuration;
        this.baseCost = baseCost;
        this.unitCost = unitCost;
        this.costType = costType;
        this.descr = descr;
    }

    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(int baseDuration) {
        this.baseDuration = baseDuration;
    }

    public int getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(int baseCost) {
        this.baseCost = baseCost;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatime() {
        return creatime;
    }

    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    public Date getStartime() {
        return startime;
    }

    public void setStartime(Date startime) {
        this.startime = startime;
    }

    public char getCostType() {
        return costType;
    }

    public void setCostType(char costType) {
        this.costType = costType;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "costId=" + costId +
                ", name='" + name + '\'' +
                ", baseDuration=" + baseDuration +
                ", baseCost=" + baseCost +
                ", unitCost=" + unitCost +
                ", status='" + status + '\'' +
                ", creatime=" + creatime +
                ", startime=" + startime +
                ", costType='" + costType + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
