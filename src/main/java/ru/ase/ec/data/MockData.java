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
        docs.add(new DocBean("FH1.A.R000.&.&&&&&&.&&&&&&.000.QC.0001.E", "02"));
        dataBeanList.add(docs);

        cipDetails = new ArrayList<>();
        cipDetails.add(new CipDetailsBean(11, "11 code"));
        dataBeanList.add(cipDetails);

        System.out.println("dataBeanList: " + dataBeanList);
        return dataBeanList;

    }

    public ArrayList<DataBean> getDataBeans() {

        List<List<PlainBean>> rawDataBeansList = getDataBeanList();
        ArrayList<DataBean> dataBeanList = new ArrayList<>();
        int counter = 0;

        DataBean dataBean = new DataBean();

        for (List<PlainBean> rawList : rawDataBeansList) {

            for (PlainBean obj : rawList) {

                if (obj instanceof CipIssueBean) {

                    String description = dataBean.getDescription() != null ? dataBean.getDescription() : "";
                    dataBean.setDescription((description + "\n\n\n" + ((CipIssueBean) obj).getDescription()));
                    String link = dataBean.getLink() != null ? dataBean.getLink() : "";
                    dataBean.setLink(link + "\n\n\n" + ((CipIssueBean) obj).getLink());

                } else if (obj instanceof CipBean) {
//                    dataBean.setRegContr(((CipBean) obj).getRegContr());
                    dataBean.setRegContr("Контролев В. ");
//                    dataBean.setCipYear(((CipBean) obj).getCipYear());
                    dataBean.setCipYear("CIP-000001_2020");

//                    dataBean.setTeamLead(((CipBean) obj).getTeamLead());
                    dataBean.setTeamLead("Начальников Д." + counter);
//                    dataBean.setLeadProjEng(((CipBean) obj).getLeadProjEng());
                    dataBean.setLeadProjEng("Ведунов А." + counter);

//                    dataBean.setDepLead(((CipBean) obj).getDepLead());
                    dataBean.setDepLead("Отдельников А." + counter);
//                    dataBean.setChiefArch(((CipBean) obj).getChiefArch());
                    dataBean.setChiefArch("ГАП_" + counter);

//                    dataBean.setNote(((CipBean) obj).getNote());
                    dataBean.setNote("{note_" + counter + "}");

//                    dataBean.setMadeChanges(((CipBean) obj).getMadeChanges());
                    dataBean.setMadeChanges("Изменяев К. ");
//                    dataBean.setMadeUp(((CipBean) obj).getMadeUp());
                    dataBean.setMadeUp("Составилов Р.");
//                    dataBean.setChiefProjEng(((CipBean) obj).getChiefProjEng());
                    dataBean.setChiefProjEng("Гиппопатамов И. " + counter);
//                    dataBean.setAppr(((CipBean) obj).getAppr());
                    dataBean.setAppr("Утвердилов Л.");

                } else if (obj instanceof DocBean) {
                    dataBean.setNumOfChanges(((DocBean) obj).getRevision());
                    dataBean.setDocSetCode(obj.getName());

                } else if (obj instanceof CipDetailsBean) {
                    dataBean.setCode(((CipDetailsBean) obj).getCode());
                }
                counter++;
            }
        }
        dataBeanList.add(dataBean);

        return dataBeanList;
    }
}
