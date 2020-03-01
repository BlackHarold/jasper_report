package ru.ase.ec.beans;

import java.util.List;

public class DataBean {

    private String regContr;
    private String teamLead;
    private String depLead;
    private String leadProjEng;
    private String chiefArch;
    private String doc;
    private String revision;
    private String code;
    private List<SubReportBean> subReportBeanList;

    public DataBean(String regContr, String chiefArch, String teamLead, String depLead, String leadProjEng, String doc, String revision, String code, List<SubReportBean> subReportBeanList) {
        this.regContr = regContr;
        this.doc = doc;
        this.revision = revision;
        this.code = code;
        this.subReportBeanList = subReportBeanList;
        this.teamLead = teamLead;
        this.depLead = depLead;
        this.leadProjEng = leadProjEng;
        this.chiefArch = chiefArch;
    }

    public String getRegContr() {
        return regContr;
    }

    public void setRegContr(String regContr) {
        this.regContr = regContr;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(String teamLead) {
        this.teamLead = teamLead;
    }

    public String getDepLead() {
        return depLead;
    }

    public void setDepLead(String depLead) {
        this.depLead = depLead;
    }

    public String getLeadProjEng() {
        return leadProjEng;
    }

    public void setLeadProjEng(String leadProjEng) {
        this.leadProjEng = leadProjEng;
    }

    public String getChiefArch() {
        return chiefArch;
    }

    public void setChiefArch(String chiefArch) {
        this.chiefArch = chiefArch;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<SubReportBean> getSubReportBeanList() {
        return subReportBeanList;
    }

    public void setSubReportBeanList(List<SubReportBean> subReportBeanList) {
        this.subReportBeanList = subReportBeanList;
    }
}
