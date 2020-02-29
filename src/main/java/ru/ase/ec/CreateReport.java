package ru.ase.ec;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import ru.ase.ec.beans.DataBean;
import ru.ase.ec.beans.DataBeanList;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CreateReport {

    public static void main(String[] args) {

        new CreateReport().create();
    }

    public void create() {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

        String subReportFromName = properties.getProperty("sub_template");
        String subReportToName = properties.getProperty("subreport_path");

        try {

            /* Compile the subreport */
            JasperCompileManager.compileReportToFile(subReportFromName, subReportToName);

            /* Compile the master */
            String masterReportFileName = properties.getProperty("master_template");
            JasperReport jasperMasterReport = JasperCompileManager.compileReport(masterReportFileName);

            /* fill parameters to the master */
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("subreport_path", subReportToName);
            parameters.put("cip", "CIP-000001");
            parameters.put("doc", "FH1.&&&&&&&&&&&&&.1.E");
            JasperPrint preparedJasperReportPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, beanColDataSource);

            /* viewer component for jasper report */
            view(preparedJasperReportPrint);

            /* export prepared report to pdf file */
            String file_name = properties.getProperty("file_name");
            JasperExportManager.exportReportToPdfFile(preparedJasperReportPrint, file_name);

        } catch (JRException jre) {
            System.out.println("master report error compile");
            jre.printStackTrace();
        }
    }

    /**
     * The utility method
     * allows to view prepared report in Jasper Report Frame utilit.
     *
     * @param jasperPrint
     */
    public void view(JasperPrint jasperPrint) {
        JRViewer jv = new JRViewer(jasperPrint);
        JFrame reportFrame = new JFrame();
        reportFrame.getContentPane().add(jv);

        reportFrame.validate();
        reportFrame.setTitle("Jasper report generator");
        reportFrame.setSize(jasperPrint.getPageWidth(), jasperPrint.getPageHeight());

        reportFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        reportFrame.setVisible(true);

    }
}
