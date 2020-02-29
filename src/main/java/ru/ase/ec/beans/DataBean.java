package ru.ase.ec.beans;

import java.util.List;

public class DataBean {

    private String revision;
    private String code;
    private List<SubReportBean> subReportBeanList;

    public DataBean(String revision, String code, List<SubReportBean> subReportBeanList) {
        this.revision = revision;
        this.code = code;
        this.subReportBeanList = subReportBeanList;
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
