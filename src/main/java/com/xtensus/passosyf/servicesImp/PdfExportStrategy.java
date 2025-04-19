package com.xtensus.passosyf.servicesImp;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.xtensus.passosyf.entities.Soumissionnaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdfExportStrategy implements ExportStrategy {
    @Override
    public byte[] exporter(List<Soumissionnaire> soumissionnaires) throws FileNotFoundException, JRException {
        File file = ResourceUtils.getFile("classpath:jasper/soum.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(soumissionnaires);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Title", "Liste des Soumissionnaires");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}