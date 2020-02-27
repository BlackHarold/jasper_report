package ru.ase.ec.bean;

import java.util.List;

public class CipBean extends PlainBean {

    private List<CipIssueBean> cipIssueBeans;
    private int docBeanId;
    private int cipDetailsBeanId;
    private String regContr;
    private String cipYear;
    private String teamLead;
    private String leadProjEng;

    private String depLead;
    private String chiefArch;

    private String note;

    private String madeChanges;
    private String madeUp;
    private String chiefProjEng;
    private String appr;

    public CipBean(int id) {
        super.setId(id);
        super.setType("CipBean");
    }

    public List<CipIssueBean> getCipIssueBeans() {
        return cipIssueBeans;
    }

    public void setCipIssueBeans(List<CipIssueBean> cipIssueBeans) {
        this.cipIssueBeans = cipIssueBeans;
    }

    public int getDocBeanId() {
        return docBeanId;
    }

    public void setDocBeanId(int docBeanId) {
        this.docBeanId = docBeanId;
    }

    public int getCipDetailsBeanId() {
        return cipDetailsBeanId;
    }

    public void setCipDetailsBeanId(int cipDetailsBeanId) {
        this.cipDetailsBeanId = cipDetailsBeanId;
    }

    public String getRegContr() {
        return regContr;
    }

    public void setRegContr(String regContr) {
        this.regContr = regContr;
    }

    public String getCipYear() {
        return cipYear;
    }

    public void setCipYear(String cipYear) {
        this.cipYear = cipYear;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(String teamLead) {
        this.teamLead = teamLead;
    }

    public String getLeadProjEng() {
        return leadProjEng;
    }

    public void setLeadProjEng(String leadProjEng) {
        this.leadProjEng = leadProjEng;
    }

    public String getDepLead() {
        return depLead;
    }

    public void setDepLead(String depLead) {
        this.depLead = depLead;
    }

    public String getChiefArch() {
        return chiefArch;
    }

    public void setChiefArch(String chiefArch) {
        this.chiefArch = chiefArch;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMadeChanges() {
        return madeChanges;
    }

    public void setMadeChanges(String madeChanges) {
        this.madeChanges = madeChanges;
    }

    public String getMadeUp() {
        return madeUp;
    }

    public void setMadeUp(String madeUp) {
        this.madeUp = madeUp;
    }

    public String getChiefProjEng() {
        return chiefProjEng;
    }

    public void setChiefProjEng(String chiefProjEng) {
        this.chiefProjEng = chiefProjEng;
    }

    public String getAppr() {
        return appr;
    }

    public void setAppr(String appr) {
        this.appr = appr;
    }
}


