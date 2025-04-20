# 📄 Projet Génie Logiciel - Application Passosyf

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

## 📋 Répartition des responsabilités

| Membre           | Tâche prise en charge                                                                                             |
|------------------|-------------------------------------------------------------------------------------------------------------------|
| **Chedly CHAHED** | ✅ Refactoring de `PassosyfApplication` <br> ✅ Implémentation de `StartupService` <br> ✅ Ajout de `StartupFacade` <br> ✅ Application des principes **SOLID** (*SRP*), des patrons **GoF** (Création - *Singleton*, Structure - *Façade*) et **GRASP** (*Contrôleur*) |

---

### 💡 Avantages des modifications

#### **1. Application du principe SOLID - SRP (Single Responsibility Principle)**

- **Avantage** : Chaque classe a une **responsabilité unique** et clairement définie. Le refactoring permet de séparer la logique de démarrage du code d'exécution de l'application, améliorant ainsi la lisibilité et la maintenabilité du code.

#### **2. Application du patron de conception GoF - Singleton**

- **Avantage** : Le logger est désormais instancié une seule fois par classe et réutilisé à chaque fois, assurant une gestion efficace de la mémoire et des ressources tout en respectant le principe **Single Instance**.

#### **3. Application du patron GoF - Façade**

- **Avantage** : La façade `StartupFacade` simplifie l'accès aux services métiers en centralisant l'appel aux logiques d'initialisation. Cela permet une **extensibilité facile** et une meilleure organisation du code en réduisant les dépendances directes entre la classe `PassosyfApplication` et la logique métier.

#### **4. Application du patron GRASP - Contrôleur**

- **Avantage** : En déléguant la logique métier à une classe `StartupService`, nous appliquons le principe de **contrôle** (controller) de manière à centraliser et organiser l'initialisation du système, rendant la gestion du processus plus claire et moins sujette aux erreurs.

#### **5. Meilleure testabilité**

- **Avantage** : La structure du code rend plus facile l'écriture de tests unitaires grâce à la séparation claire des responsabilités entre `PassosyfApplication`, `StartupService` et `StartupFacade`.

---

## 📚 Références utilisées

- *Design Patterns: Elements of Reusable Object-Oriented Software* — GoF
- *Clean Code* — Robert C. Martin
- *Applying UML and Patterns* — Craig Larman
