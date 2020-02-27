package ru.ase.ec.data;

public class DataBean {

//    from CIP bean
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
    private String addr; //TODO add after the attribute created

//    from Document bean
    private String numOfChanges;
    private String docSetCode;

//    from CIP Issue bean

    private String link;
    private String description;

//    from CIP Details bean
    private String code;


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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getNumOfChanges() {
        return numOfChanges;
    }

    public void setNumOfChanges(String numOfChanges) {
        this.numOfChanges = numOfChanges;
    }

    public String getDocSetCode() {
        return docSetCode;
    }

    public void setDocSetCode(String docSetCode) {
        this.docSetCode = docSetCode;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "regContr='" + regContr + '\'' +
                ", cipYear='" + cipYear + '\'' +
                ", teamLead='" + teamLead + '\'' +
                ", leadProjEng='" + leadProjEng + '\'' +
                ", depLead='" + depLead + '\'' +
                ", chiefArch='" + chiefArch + '\'' +
                ", note='" + note + '\'' +
                ", madeChanges='" + madeChanges + '\'' +
                ", madeUp='" + madeUp + '\'' +
                ", chiefProjEng='" + chiefProjEng + '\'' +
                ", appr='" + appr + '\'' +
                ", addr='" + addr + '\'' +
                ", numOfChanges='" + numOfChanges + '\'' +
                ", docSetCode='" + docSetCode + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
