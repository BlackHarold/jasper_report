package ru.ase.ec.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBeanList {
    public ArrayList<DataBean> getDataBeanList() {

        // Create sub report data
        SubReportBean subBean1 = new SubReportBean("link1", "Mock на английском значит «имитация», «подделка». Модуль с таким названием помогает сильно упростить тесты модулей на Питоне." +
                "Принцип его работы простой: если нужно тестировать фуMock на английском значит «имитация», «подделка». Модуль с таким названием помогает сильно упростить тесты модулей на Питоне." +
                "Принцип его работы простой: если нужно тестировать функцию, то всё, что не относится к ней самой (например, чтение с диска или из сети), можно подменить макетами-пустышками. При этом " +
                "тестируемые функции не нужно адаптировать для тестов: Mock подменяет объекты в других модулях, даже если код не принимает их в виде параметров. То есть, тестировать можно вообще без " +
                "адаптации под тесты.\n", "note1");
        SubReportBean subBean2 = new SubReportBean("link2", "description2", "note2");
        SubReportBean subBean3 = new SubReportBean("link3", "description3", "note3");


        ArrayList<DataBean> dataBeanList = new ArrayList<>();
        // Create master report data
        dataBeanList.add(produce("regContr", "teamLead", "depLead", "leadProjEng", "chiefArch", "FH1.&&&&.1.E", "01", "code1",
                Arrays.asList(subBean3, subBean1, subBean2, subBean1, subBean2, subBean3, subBean1, subBean2, subBean1, subBean2, subBean3, subBean1, subBean1)));

        return dataBeanList;
    }

    /**
     * This method returns a DataBean object,
     * bean data set in it.
     */
    private DataBean produce(String regContr, String teamLead, String depLead, String leadProjEng, String chiefArch, String doc, String revision, String code, List<SubReportBean> subBean) {
//  <field name="   teamLead               " class="java.lang.String"/>
//	<field name="   depLead                " class="java.lang.String"/>
//	<field name="   leadProjEng                " class="java.lang.String"/>
//	<field name="   chiefArch              " class="java.lang.String"/>
        DataBean dataBean = new DataBean(regContr,teamLead, depLead, leadProjEng, chiefArch, doc, revision, code, subBean);

        return dataBean;
    }
}
