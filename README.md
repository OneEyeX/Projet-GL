# 📄 README - Projet Génie Logiciel - Application Passosyf

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

@SpringBootApplication
public class PassosyfApplication implements CommandLineRunner {

    // ✅ Singleton (GoF) pour Logger : instancié une fois, partagé dans la classe
    private static final Logger log = LoggerFactory.getLogger(PassosyfApplication.class);

    // ✅ GRASP - Contrôle délégué à une classe spécialisée
    @Autowired
    private StartupService startupService;

    public static void main(String[] args) {
        SpringApplication.run(PassosyfApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("🚀 Passosyf is starting...");
        startupService.executeStartupLogic(); // ✅ Logique métier extraite dans une classe dédiée
    }
}
```

---

### ✔ Nouvelle classe : `StartupService.java`

```java
package com.xtensus.passosyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StartupService {

    private static final Logger log = LoggerFactory.getLogger(StartupService.class);

    // ✅ Responsabilité unique : contient uniquement la logique de démarrage
    public void executeStartupLogic() {
        log.info("✅ Startup logic executed");
        // 🔧 Future logique métier initiale ici (connexion, chargement config, etc.)
    }
}
```

---

## 📌 Résumé des améliorations

| Élément              | Détail                                                                 |
|----------------------|------------------------------------------------------------------------|
| 🔧 Classe modifiée    | `PassosyfApplication.java`                                             |
| ➕ Classe ajoutée     | `StartupService.java`                                                  |
| ✅ Patron GoF         | **Singleton** (Logger instancié une seule fois par classe)             |
| ✅ Patron GRASP       | **Contrôleur** (StartupService gère la logique métier de démarrage)    |
| ✅ Principe SOLID     | **SRP (Responsabilité unique)** : chaque classe a une responsabilité   |

---

## 📋 Répartition des responsabilités

| Membre                 | Tâche prise en charge                                                                                           |
|------------------------|-----------------------------------------------------------------------------------------------------------------|
| **Chedly CHAHED**       | ✅ Refactoring de `PassosyfApplication` <br> ✅ Implémentation de `StartupService` <br> ✅ Application SRP, Singleton, GRASP |

---

## 📚 Références utilisées

- *Design Patterns: Elements of Reusable Object-Oriented Software* - GoF
- *Clean Code* - Robert C. Martin
- *Applying UML and Patterns* - Craig Larman
