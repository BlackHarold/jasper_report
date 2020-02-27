package ru.ase.ec.bean;

public class CipIssueBean extends PlainBean {


    private String link;
    private String description;
    private int cipDetailsId;
    private int cipBeanId;

    public CipIssueBean(int id) {
        super.setId(id);
        super.setType("CipIssueBean");
    }

    public CipIssueBean(int id, String link, String description, int cipDetailsId, int cipBeanId) {
        super.setId(id);
        super.setType("CipIssueBean");
        this.link = link;
        this.description = description;
        this.cipDetailsId = cipDetailsId;
        this.cipBeanId = cipBeanId;
    }

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

    public int getCipDetailsId() {
        return cipDetailsId;
    }

    public void setCipDetailsId(int cipDetailsId) {
        this.cipDetailsId = cipDetailsId;
    }

    public int getCipBeanId() {
        return cipBeanId;
    }

    public void setCipBeanId(int cipBeanId) {
        this.cipBeanId = cipBeanId;
    }

    @Override
    public String toString() {
        return "CipIssueBean{" +
                "id=" + super.getId() +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", cipDetailsId=" + cipDetailsId +
                ", cipBeanId=" + cipBeanId +
                '}';
    }
}
