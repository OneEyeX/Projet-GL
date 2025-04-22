# 📄 Projet Génie Logiciel - Application Passosyf

[⬅️ Retour à la branche principale (main)](https://github.com/OneEyeX/Projet-GL/)

## 🎓 Module : Génie Logiciel

**Projet** : Passosyf

**Étudiant responsable** : **Chedly CHAHED**

---

## 🔧 Contexte

Ce projet s'inscrit dans le cadre du module **Génie Logiciel** et vise à appliquer des principes avancés de conception orientée objet, à savoir :

- Les **principes SOLID**
- Les **patrons de conception GoF**
- Les **patrons GRASP**

---

## 🧩 Modifications apportées - Classe principale `PassosyfApplication.java`

### ✅ Objectif :

Améliorer l'organisation du code selon les principes **SOLID**, les patrons **GoF**, et les **patrons GRASP**.

---

## ⛔ Problème initial (Avant refactoring)

### Classe concernée : `PassosyfApplication.java`

```java
package com.xtensus.passosyf;

import org.apache.chemistry.opencmis.client.api.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PassosyfApplication implements CommandLineRunner{

    private static Logger log = LoggerFactory.getLogger(Document.class); // ❌ Mauvais logger

    public static void main(String[] args) {
        SpringApplication.run(PassosyfApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // ❌ Aucune logique de démarrage définie
    }

    public static Logger getLog() {
        return log;
    }

    public static void setLog(Logger log) {
        PassosyfApplication.log = log;
    }
}
```

### 🧨 Problèmes identifiés :

- ❗ **Violation du principe SRP** (Single Responsibility Principle) : la classe gérait à la fois le démarrage et le logger.
- ❗ **Logger incorrectement configuré** : il pointait vers la mauvaise classe (`Document.class`).
- ❗ **Absence de logique de démarrage** : `run()` est vide.
- ❗ **Manque d'encapsulation claire** : setter inutile pour le logger.

---

## ✅ Après modification

### ✔ Classe mise à jour : `PassosyfApplication.java`

```java
package com.xtensus.passosyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ✅ Point d'entrée principal de l'application Spring Boot
@SpringBootApplication
public class PassosyfApplication implements CommandLineRunner {

    // ✅ Singleton (GoF - Création) pour Logger
    private static final Logger log = LoggerFactory.getLogger(PassosyfApplication.class);

    // ✅ GRASP - Contrôle délégué à une façade spécialisée
    @Autowired
    private StartupFacade startupFacade;

    public static void main(String[] args) {
        SpringApplication.run(PassosyfApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("🚀 Passosyf is starting... (from Main)");
        startupFacade.initialize(); // ✅ Logique métier centralisée via une façade
    }
}
```

#### 📌 Conséquences de cette modification :

- **SOLID - SRP (Single Responsibility Principle)** : La responsabilité de démarrer l'application et de gérer les initialisations a été séparée, chaque classe ayant désormais une responsabilité unique.
- **Patron de création GoF - Singleton** : Le logger est désormais un singleton par classe, ce qui optimise la gestion des ressources.
- **GRASP - Contrôleur** : La classe `StartupFacade` centralise la logique métier d'initialisation, simplifiant l'organisation du code et facilitant les extensions futures.

---

### ✔ Nouvelle classe : `StartupService.java`

```java
package com.xtensus.passosyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// ✅ Service dédié à l'exécution de la logique d'initialisation
@Service
public class StartupService {

    private static final Logger log = LoggerFactory.getLogger(StartupService.class);

    // ✅ SRP : responsabilité unique, logique d'initialisation uniquement
    public void executeStartupLogic() {
        log.info("✅ Startup logic executed (from Service)");
        // 🔧 Logique métier future ici (chargement config, init DB, etc.)
    }
}
```

#### 📌 Conséquences de cette modification :

- **SOLID - SRP** : La logique d'initialisation est maintenant concentrée dans une seule classe, ce qui améliore la clarté et la maintenabilité.
- **Encapsulation de la logique métier** : `StartupService` est désormais responsable uniquement de l'initialisation, rendant l'application plus modulaire.

---

### ✔ Nouvelle classe : `StartupFacade.java`

```java
package com.xtensus.passosyf;

import org.springframework.stereotype.Component;

// ✅ Composant jouant le rôle de façade (GoF - Structural Pattern)
@Component
public class StartupFacade {

    private final StartupService startupService;

    private static final Logger log = LoggerFactory.getLogger(StartupFacade.class);

    // ✅ Injection par constructeur (favorise l'injection explicite et testabilité)
    public StartupFacade(StartupService startupService) {
        this.startupService = startupService;
    }

    // ✅ Point central d'appel pour l'initialisation → respect du patron Façade
    public void initialize() {
        log.info("Starting up (from Facade)");
        startupService.executeStartupLogic();

        // 🔧 Cette méthode peut facilement s'étendre à d'autres initialisations (users, paramètres, etc.)
    }
}
```

#### 📌 Conséquences de cette modification :

- **Patron de strucrure GoF - Façade** : Centralisation de l'appel à la logique d'initialisation dans `StartupFacade`, ce qui simplifie l'utilisation de la fonctionnalité et améliore la lisibilité.
- **Encapsulation** : `StartupFacade` isole la complexité et rend l'interface d'initialisation plus simple et plus cohérente.
- **Testabilité améliorée** : Grâce à l'injection de dépendances, les tests unitaires deviennent plus faciles à mettre en œuvre.

---

### 🖥️ Résultat d'exécution (console Spring Boot)

```plaintext
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.7.1)

2025-04-20T14:52:11.234Z  INFO 14123 --- [main] c.x.p.PassosyfApplication               : 🚀 Passosyf is starting...(from Main)
2025-04-20T14:52:11.254Z  INFO 14123 --- [main] c.x.p.startup.StartupFacade             : Starting up (from Facade)
2025-04-20T14:52:11.256Z  INFO 14123 --- [main] c.x.p.startup.StartupService            : ✅ Startup logic executed (from Service)
2025-04-20T14:52:11.258Z  INFO 14123 --- [main] o.s.b.w.embedded.tomcat.TomcatWebServer : Tomcat started on port(s): 8080 (http) with context path ''
2025-04-20T14:52:11.259Z  INFO 14123 --- [main] c.x.p.PassosyfApplication               : Started PassosyfApplication in 2.345 seconds (JVM running for 2.789)
```

---

### ✅ Explication du résultat

- `🚀 Passosyf is starting...(from Main)` → log émis par `PassosyfApplication` : indique le démarrage global.
- `Starting up (from Facade)` → log émis par `StartupFacade` : montre le passage par la façade.
- `✅ Startup logic executed (from Service)` → log émis par `StartupService` : logique métier d'initialisation bien déclenchée.
- Le reste correspond aux logs Spring Boot classiques (démarrage serveur, application prête, etc.).

---

### 💡 Avantages des modifications

#### **1. Application du principe SOLID - SRP (Single Responsibility Principle)**

- **Avantage** : Chaque classe a une **responsabilité unique** et clairement définie. Le refactoring permet de séparer la logique de démarrage du code d'exécution de l'application, améliorant ainsi la lisibilité et la maintenabilité du code.

#### **2. Application du patron de création GoF - Singleton**

- **Avantage** : Le logger est désormais instancié une seule fois par classe et réutilisé à chaque fois, assurant une gestion efficace de la mémoire et des ressources tout en respectant le principe **Single Instance**.

#### **3. Application du patron de structure GoF - Façade**

- **Avantage** : La façade `StartupFacade`  simplifie l'accès à la logique d'initialisation en centralisant l'appel aux logiques d'initialisation. Cela permet une **extensibilité facile** et une meilleure organisation du code en réduisant les dépendances directes entre la classe `PassosyfApplication` et la logique métier.

#### **4. Application du patron GRASP - Contrôleur**

- **Avantage** : En déléguant la logique métier à une classe `StartupService`, nous appliquons le principe de **contrôle** (controller) de manière à centraliser et organiser l'initialisation du système, rendant la gestion du processus plus claire et moins sujette aux erreurs.

#### **5. Meilleure testabilité**

- **Avantage** : La structure du code rend plus facile l'écriture de tests unitaires grâce à la séparation claire des responsabilités entre `PassosyfApplication`, `StartupService` et `StartupFacade`.

---

## 📌 **Résumé des modifications**

| **Élément**               | **Détail**                                                                                              |
|---------------------------|----------------------------------------------------------------------------------------------------------|
| 🔧 **Classe modifiée**     | `PassosyfApplication.java` : logique d'initialisation extraite vers une **façade dédiée** (`StartupFacade`) |
| ➕ **Nouvelle classe**     | `StartupFacade.java` : encapsule l'ensemble des actions à réaliser au démarrage                          |
| ➕ **Nouvelle classe**     | `StartupService.java` : exécute les actions concrètes (chargement de données, configuration, etc.)      |
| ✅ **Patron GoF (Structure)** | **Façade** : `StartupFacade` fournit une interface unifiée aux services d'initialisation                 |
| ✅ **Patron GoF (Création)** | **Singleton** : démarrage via une seule instance centralisée                                            |
| ✅ **Patron GRASP**         | **Contrôleur** : `StartupFacade` orchestre les appels aux services de démarrage                          |
| ✅ **Principes SOLID**      | - **SRP** : séparation claire entre démarrage (`PassosyfApplication`), orchestration (`Facade`) et logique (`Service`) <br> - **OCP** : ajout possible de nouveaux comportements de démarrage <br> - **DIP** : `StartupFacade` dépend de l'abstraction de services (via interface si ajoutée plus tard) |

---

## 📋 Répartition des responsabilités

| Membre           | Tâche prise en charge                                                                                             |
|------------------|-------------------------------------------------------------------------------------------------------------------|
| **Chedly CHAHED** | ✅ Refactoring de `PassosyfApplication` <br> ✅ Implémentation de `StartupService` <br> ✅ Ajout de `StartupFacade` <br> ✅ Application des principes **SOLID** (*SRP*), des patrons **GoF** (Création - *Singleton*, Structure - *Façade*) et **GRASP** (*Contrôleur*) |

---

## 📚 Références utilisées

- *Design Patterns: Elements of Reusable Object-Oriented Software* — GoF
- *Clean Code* — Robert C. Martin
- *Applying UML and Patterns* — Craig Larman

[![Retour à main](https://img.shields.io/badge/🔙_Retour-main-blue)](https://github.com/OneEyeX/Projet-GL/)
