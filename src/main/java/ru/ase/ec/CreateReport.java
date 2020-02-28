package ru.ase.ec;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.sf.jasperreports.engine.*;
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

        String masterReportFileName = properties.getProperty("main_template");
        String subReportFileName = properties.getProperty("template");
        String destFileName = properties.getProperty("file_name");
        System.out.println("=== properties ===");
        System.out.println(masterReportFileName);
        System.out.println(subReportFileName);
        System.out.println(destFileName);
        System.out.println("=== properties ===");

        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

        try {
            /* Compile the master and sub report */
            JasperReport jasperMasterReport = JasperCompileManager.compileReport(masterReportFileName);
            JasperReport jasperSubReport = JasperCompileManager.compileReport(subReportFileName);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("subreportParameter", jasperSubReport);
            JasperPrint jasperMainPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, beanColDataSource);

            view(jasperMainPrint);// viewer component for jasper report
            JasperExportManager.exportReportToPdfFile(jasperMainPrint, properties.getProperty("file_name"));
//            JasperFillManager.fillReportToFile(jasperMasterReport, destFileName, parameters, beanColDataSource);

        } catch (JRException e) {

            e.printStackTrace();
        }
        System.out.println("Done filling ...");
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
