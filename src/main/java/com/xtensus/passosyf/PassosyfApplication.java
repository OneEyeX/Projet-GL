package com.xtensus.passosyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication : point d'entrée principal de l'application
@SpringBootApplication
public class PassosyfApplication implements CommandLineRunner {

	// AVANT : Logger était basé sur une classe externe comme Document.class
	// APRÈS : Respect du principe SRP (Single Responsibility Principle) et cohérence → Logger associé à la classe actuelle
	private static final Logger log = LoggerFactory.getLogger(PassosyfApplication.class);

	// AJOUTÉ : Respect du principe de GRASP → Delegation
	// La logique de démarrage est déléguée à un service spécialisé : StartupService
	@Autowired
	private StartupService startupService;

	public static void main(String[] args) {
		// Lancement de l'application Spring Boot
		SpringApplication.run(PassosyfApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// AJOUTÉ : Meilleure traçabilité pour le monitoring et les logs système
		log.info("🚀 Passosyf is starting...");
		
		// AVANT : aucune action définie à l'exécution
		// APRÈS : Appel explicite d'une logique de démarrage externalisée → meilleur respect de SRP
		startupService.executeStartupLogic();
	}
}
