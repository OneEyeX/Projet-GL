package com.xtensus.passosyf.servicesImp;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Soumissionnaire;

import net.sf.jasperreports.engine.JRException;

@Service
public class CsvExportStrategy implements ExportStrategy {
    @Override
    public byte[] exporter(List<Soumissionnaire> soumissionnaires) {
        String csvHeader = "ID,Raison Sociale,Matricule,Etat\n";
        String csvContent = soumissionnaires.stream()
            .map(s -> s.getSoumissionnaireAdresseSiegeSocial() + "," 
                    + s.getSoumissionnaireRaisonSociale() + ","
                    + s.getSoumissionnaireMatriculeFiscal() + ","
                    + s.getSoumissionnaireEtatCompte().getEtatId())
            .collect(Collectors.joining("\n"));
        return (csvHeader + csvContent).getBytes();
    }

	
}