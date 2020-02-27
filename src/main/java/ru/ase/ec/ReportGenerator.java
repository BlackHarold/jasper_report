package ru.ase.ec;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperCompileManager;

import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import ru.ase.ec.bean.PlainBean;
import ru.ase.ec.data.DataBean;
import ru.ase.ec.data.MockData;

import javax.swing.*;

public class ReportGenerator {
    private final String REPORT_pattern = "/src/main/resources/jrxml/first_report.jrxml";

    public void create() {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
        }


        ArrayList<DataBean> dataBeanList = new MockData().getDataBeans();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
        Map<String, Object> parameters = new HashMap();
        parameters.put("DATE", new Date());

        File reportPattern = new File(properties.getProperty("template"));
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(reportPattern);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);

            view(jasperPrint);// viewer component for jasper report

            JasperExportManager.exportReportToPdfFile(jasperPrint, properties.getProperty("file_name"));
        } catch (JRException jre) {
            jre.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("Начало генерации отчёта");
        try {
            new ReportGenerator().create();
            System.out.println("Генерация отчёта завершена");
        } catch (Exception e) {
            System.err.println("Во время генерации возникла ошибка: " + e);
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
