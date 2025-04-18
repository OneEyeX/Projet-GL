package com.xtensus.passosyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// @Service : Annotation Spring pour désigner une classe de service métier
@Service
public class StartupService {

	// Logger associé à la classe actuelle, respecte SRP et permet une traçabilité efficace
	private static final Logger log = LoggerFactory.getLogger(StartupService.class);

	// Fonction principale de démarrage (appelée depuis PassosyfApplication)
	public void executeStartupLogic() {
		// Message de log clair, utile pour observer l'état du système à l'exécution
		log.info("✅ Startup logic executed");
	}
}
