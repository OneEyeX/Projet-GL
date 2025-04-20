package com.xtensus.passosyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// @Service : classe métier qui encapsule une logique fonctionnelle (initialisation ici)
@Service
public class StartupService {

	// 🔸 AVANT : Aucun logger ou traçabilité dans la logique métier
	// 🔸 APRÈS : Logger dédié à la classe → respect du SRP + observabilité
	// renforcée
	private static final Logger log = LoggerFactory.getLogger(StartupService.class);

	// 🔸 AVANT : Logique de démarrage non définie ou incluse directement dans
	// PassosyfApplication
	// 🔸 APRÈS : Externalisation dans un service testable et modulaire
	public void executeStartupLogic() {
		log.info("✅ Startup logic executed (from Service)"); // Journalisation de l'exécution de la logique
																// d'initialisation
	}
}
