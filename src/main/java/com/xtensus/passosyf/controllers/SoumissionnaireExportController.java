package com.xtensus.passosyf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xtensus.passosyf.services.SoumissionnaireService;


//Nouveau contrôleur dédié aux exports
@Controller
@RequestMapping("/api/soumissionnaires/export")
public class SoumissionnaireExportController {
 
 @Autowired
 SoumissionnaireService soumissionnaireService;

 @GetMapping
 public ResponseEntity<byte[]> exportSoumissionnaires(@RequestParam String format) {
   try {
       byte[] fileContent = soumissionnaireService.exportListeSoumissionnaires(format);
       String contentType = format.equalsIgnoreCase("pdf") ? "application/pdf" : "text/csv";
       
       return ResponseEntity.ok()
           .contentType(MediaType.parseMediaType(contentType))
           .header("Content-Disposition", "attachment; filename=soumissionnaires." + format)
           .body(fileContent);
   } catch (Exception e) {
       return ResponseEntity.badRequest().build();
   }
}
}
