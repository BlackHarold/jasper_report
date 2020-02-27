package ru.ase.ec.bean;

public class DocBean extends PlainBean {

    private String revision;

    public DocBean(String name, String revision) {
        super.setType("DocBean");
        super.setName(name);
        this.revision = revision;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }
}
