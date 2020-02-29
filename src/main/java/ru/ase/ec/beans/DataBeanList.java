package ru.ase.ec.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBeanList {
    public ArrayList<DataBean> getDataBeanList() {

        // Create sub report data
        SubReportBean subBean1 = new SubReportBean( "link1","description1", "note1");
        SubReportBean subBean2 = new SubReportBean("link2","description2",  "note2");
        SubReportBean subBean3 = new SubReportBean("link3","description3",  "note3");


        ArrayList<DataBean> dataBeanList = new ArrayList<>();
        // Create master report data
        dataBeanList.add(produce("FH1.&&&&.1.E","01", "code1", Arrays.asList(subBean1, subBean2, subBean3, subBean1, subBean2, subBean3)));
        dataBeanList.add(produce("FH1.&&&&.2.E","02", "code2", Arrays.asList(subBean2, subBean1, subBean2, subBean3)));
        dataBeanList.add(produce("FH1.&&&&.3.E","03", "code3", Arrays.asList(subBean1, subBean2, subBean3)));

        return dataBeanList;
    }

    /**
     * This method returns a DataBean object,
     * bean data set in it.
     */
    private DataBean produce(String doc, String revision, String code, List<SubReportBean> subBean) {
        DataBean dataBean = new DataBean(doc, revision, code, subBean);

        return dataBean;
    }
}
