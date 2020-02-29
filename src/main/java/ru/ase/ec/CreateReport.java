package ru.ase.ec;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseFont;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import ru.ase.ec.beans.DataBean;
import ru.ase.ec.beans.DataBeanList;

import javax.swing.*;

public class CreateReport {

    public static void main(String[] args) {

        new CreateReport().create();
    }

    public void create() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
        }

        String masterReportFileName = properties.getProperty("master_template");
        String subReportFileName = properties.getProperty("template");
        String destFileName = properties.getProperty("file_name");

        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);


        JasperReport jasperSubReport = null;
        try {
            /* Compile sub report */
            jasperSubReport = JasperCompileManager.compileReport(subReportFileName);

        } catch (JRException jre) {
            System.out.println("sub report error compile");
            jre.printStackTrace();
        }

        JasperReport jasperMasterReport;
        try {
            /* Compile the master */
            jasperMasterReport = JasperCompileManager.compileReport(masterReportFileName);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("subreportParameter", jasperSubReport);
            parameters.put("cip", "CIP-000001");
            parameters.put("doc", "FH1.&&&&&&&&&&&&&.1.E");

            JasperPrint jasperMainPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, beanColDataSource);

            view(jasperMainPrint);// viewer component for jasper report
            JasperExportManager.exportReportToPdfFile(jasperMainPrint, destFileName);

        } catch (JRException jre) {
            System.out.println("master report error compile");
            jre.printStackTrace();
        }
    }

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
