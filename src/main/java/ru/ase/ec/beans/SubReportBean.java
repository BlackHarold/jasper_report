package ru.ase.ec.beans;

public class SubReportBean {

//    private String revision;
    private String link;
    private String description;
    private String code;
    private String note;

    public SubReportBean(String link, String description, String note) {
        this.link = link;
        this.description = description;
        this.code = code;
        this.note = note;
    }

//    public String getRevision() {
//        return revision;
//    }
//
//    public void setRevision(String revision) {
//        this.revision = revision;
//    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
