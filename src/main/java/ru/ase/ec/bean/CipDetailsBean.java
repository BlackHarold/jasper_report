package ru.ase.ec.bean;

public class CipDetailsBean extends PlainBean {

    private String code;

    public CipDetailsBean(int id, String code) {
        super.setId(id);
        super.setType("CipDetailsBean");
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CipDetailsBean{" +
                "id=" + super.getId() +
                ", code='" + code + '\'' +
                '}';
    }
}
