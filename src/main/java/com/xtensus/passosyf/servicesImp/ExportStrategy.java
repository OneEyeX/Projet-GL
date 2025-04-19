package com.xtensus.passosyf.servicesImp;

import com.xtensus.passosyf.entities.Soumissionnaire;
import java.io.FileNotFoundException;
import java.util.List;
import net.sf.jasperreports.engine.JRException;

public interface ExportStrategy {
    byte[] exporter(List<Soumissionnaire> soumissionnaires) throws FileNotFoundException, JRException;
}