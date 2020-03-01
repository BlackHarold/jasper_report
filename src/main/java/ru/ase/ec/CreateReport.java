package ru.ase.ec;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import org.apache.log4j.Logger;
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

    //    private static final Logger LOG = Logger.getLogger(CreateReport.class);
    private static final Logger LOG = Logger.getLogger("blackLogger");

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
        String bodyReportFromName = properties.getProperty("body_template");
        String bodyReportToName = properties.getProperty("bodyreport_path");

        try {

            /* Compile the sub report */
            JasperCompileManager.compileReportToFile(subReportFromName, subReportToName);
            /* Compile the body report */
            JasperCompileManager.compileReportToFile(bodyReportFromName,bodyReportToName);

            /* Compile the master */
            String masterReportFileName = properties.getProperty("master_template");
            JasperReport jasperMasterReport = JasperCompileManager.compileReport(masterReportFileName);

            /* fill parameters to the master */
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("subreport_path", subReportToName);
            parameters.put("body_path", bodyReportToName);
            parameters.put("cip", "CIP-000001");
            parameters.put("doc", "FH1.&&&&&&&&&&&&&.1.E");
            JasperPrint preparedJasperReportPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, beanColDataSource);

            /* viewer component for jasper report */
            view(preparedJasperReportPrint);

            /* export prepared report to pdf file */
            String file_name = properties.getProperty("file_name");
            JasperExportManager.exportReportToPdfFile(preparedJasperReportPrint, file_name);

        } catch (JRException jre) {
            LOG.error("master report error compile");
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
