package ru.ase.ec.data;

import ru.ase.ec.bean.*;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    private List<PlainBean> cipIssues;
    private List<PlainBean> cips;
    private List<PlainBean> docs;
    private List<PlainBean> cipDetails;

    private List<List<PlainBean>> getDataBeanList() {

        List<List<PlainBean>> dataBeanList = new ArrayList<>();

        cipIssues = new ArrayList<>();
        cipIssues.add(new CipIssueBean(11111, "link1", "issue1 description", 11, 111));
        cipIssues.add(new CipIssueBean(22222, "link2", "issue2 description", 11, 111));
        cipIssues.add(new CipIssueBean(33333, "link3", "issue3 description", 11, 111));
        dataBeanList.add(cipIssues);

        cips = new ArrayList<>();
        cips.add(new CipBean(111));
        dataBeanList.add(cips);

        docs = new ArrayList<>();
        docs.add(new DocBean("FH1.***.E", "01"));
        dataBeanList.add(docs);

        cipDetails = new ArrayList<>();
        cipDetails.add(new CipDetailsBean(11, "details 11 code"));
        dataBeanList.add(cipDetails);

        return dataBeanList;

    }

    public ArrayList<DataBean> getDataBeans() {
        List<List<PlainBean>> rawDataBeansList = getDataBeanList();
        ArrayList<DataBean> dataBeanList = new ArrayList<>();

        for (List<PlainBean> rawList : rawDataBeansList) {
            DataBean dataBean = new DataBean();
            for (PlainBean obj : rawList) {

                if (obj instanceof CipIssueBean) {
                    System.out.println("CIPISSUE: " + rawList);
                    dataBean.setDescription(((CipIssueBean) obj).getDescription());
                    dataBean.setLink(((CipIssueBean) obj).getLink());

                } else if (obj instanceof CipBean) {
                    System.out.println("CIPBEAN: " + rawList);
                    dataBean.setRegContr(((CipBean) obj).getRegContr());
                    dataBean.setCipYear(((CipBean) obj).getCipYear());

                    dataBean.setTeamLead(((CipBean) obj).getTeamLead());
                    dataBean.setLeadProjEng(((CipBean) obj).getLeadProjEng());

                    dataBean.setDepLead(((CipBean) obj).getDepLead());
                    dataBean.setChiefArch(((CipBean) obj).getChiefArch());

                    dataBean.setNote(((CipBean) obj).getNote());

                    dataBean.setMadeChanges(((CipBean) obj).getMadeChanges());
                    dataBean.setMadeUp(((CipBean) obj).getMadeUp());
                    dataBean.setChiefProjEng(((CipBean) obj).getChiefProjEng());
                    dataBean.setAppr(((CipBean) obj).getAppr());
                } else if (obj instanceof CipDetailsBean) {
                    System.out.println("CIPDETAILSBEAN: " + rawList);

                }
            }
        }

        return dataBeanList;
    }
}
