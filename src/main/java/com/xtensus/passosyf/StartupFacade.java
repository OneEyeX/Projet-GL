package com.xtensus.passosyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// @Component : classe déclarée comme composant Spring, jouant le rôle de façade
@Component
public class StartupFacade {
    private static final Logger log = LoggerFactory.getLogger(StartupFacade.class);

    private final StartupService startupService;

    // 🔸 AVANT : Appels multiples potentiels dans PassosyfApplication
    // 🔸 APRÈS : Centralisation via une façade → respect du patron de conception
    // GoF - Facade
    public StartupFacade(StartupService startupService) {
        this.startupService = startupService;
    }

    // 🔸 AVANT : Aucune méthode dédiée à l'initialisation centralisée
    // 🔸 APRÈS : Encapsulation des appels de démarrage (possibilité d'extension)
    public void initialize() {
        log.info("Starting up (from Facade)");
        startupService.executeStartupLogic();

        // ⤴️ Cette méthode peut facilement être étendue pour inclure :
        // ex: userInitService.initialize(), paramService.loadDefaultParams()...
    }
}
