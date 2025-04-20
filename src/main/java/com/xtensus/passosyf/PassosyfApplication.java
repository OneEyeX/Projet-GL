package com.xtensus.passosyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication : point d'entrée principal de l'application Spring Boot
@SpringBootApplication
public class PassosyfApplication implements CommandLineRunner {

	// 🔸 AVANT : Logger basé sur une classe non cohérente (ex: Document.class)
	// 🔸 APRÈS : Logger correctement associé à la classe actuelle → respect du SRP
	// et traçabilité cohérente
	private static final Logger log = LoggerFactory.getLogger(PassosyfApplication.class);

	// 🔸 AVANT : Appel direct à un service (StartupService) dans run()
	// 🔸 APRÈS : Injection de StartupFacade → respect du patron GoF Facade +
	// meilleure séparation des responsabilités
	@Autowired
	private StartupFacade startupFacade;

	public static void main(String[] args) {
		SpringApplication.run(PassosyfApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// 🔸 AVANT : Méthode vide, sans logique d'exécution
		// 🔸 APRÈS : Ajout d'un log de démarrage + délégation vers la façade de
		// démarrage
		log.info("🚀 Passosyf is starting...(from Main)");
		startupFacade.initialize(); // Utilisation du patron GoF - Facade pour centraliser la logique de démarrage
	}
}
