package com.unipampa.sete.services;

import com.unipampa.sete.dto.InternshipDTO;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.web.util.WebHtmlResourceHandler;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class TceService {

    public void buildDocument(InternshipDTO internship) throws JRException {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", internship);
        parameters.put("district", internship);
        parameters.put("city", internship);
        parameters.put("zipCode", internship);
        parameters.put("uf", internship);
        parameters.put("phoneNumber", internship);
        parameters.put("address", internship);
        parameters.put("nameCompany", internship);
        parameters.put("addressCompany", internship);
        parameters.put("cityCompany", internship);
        parameters.put("ufCompany", internship);
        parameters.put("telCompany", internship);
        parameters.put("districtCompany", internship);
        parameters.put("zipCodeCompany", internship);
        parameters.put("nameLegalRepresentative", internship);
        parameters.put("officeLegalRepresentative", internship);
        parameters.put("nameSupervisor", internship);
        parameters.put("officeSupervisor", internship);

        JasperFillManager.fillReportToFile("reports/TCE.jasper", parameters,
                new JREmptyDataSource(1));

    }

    public String getHtmlReportAsString() throws JRException {
        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(new SimpleExporterInput("reports/Blank_A4.jrprint"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        SimpleHtmlExporterOutput htmlOutput = new SimpleHtmlExporterOutput(baos);
        htmlOutput.setImageHandler(new WebHtmlResourceHandler("https://resourcesrpvi.s3.sa-east-1.amazonaws.com/assinatura_visual_unipampa_vertical_cor.jpg"));
        exporter.setExporterOutput(htmlOutput);
        exporter.exportReport();
        return baos.toString();
    }

}
