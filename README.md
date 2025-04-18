# 📄 README - Projet Génie Logiciel - Application Passosyf

## 🎓 Module : Génie Logiciel

**Projet** : Passosyf

**Étudiant responsable** : **Chedly CHAHED**

---

## 🧩 Modifications apportées - Classe principale `PassosyfApplication.java`

### ✅ Objectif :

Améliorer l'organisation du code selon les principes **SOLID**, les patrons **GoF**, et les **patrons GRASP**.

---

## ⛔ Avant modification

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
        // ❌ Vide
    }

    public static Logger getLog() {
        return log;
    }

    public static void setLog(Logger log) {
        PassosyfApplication.log = log;
    }
}
```

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

    // ✅ Application du patron Singleton pour Logger
    private static final Logger log = LoggerFactory.getLogger(PassosyfApplication.class);

    // ✅ GRASP - Contrôleur délégué à une classe dédiée
    @Autowired
    private StartupService startupService;

    public static void main(String[] args) {
        SpringApplication.run(PassosyfApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("🚀 Passosyf is starting...");
        startupService.executeStartupLogic(); // 🧠 Logique extraite
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

    public void executeStartupLogic() {
        log.info("✅ Startup logic executed");
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
| **Chedly CHAHED**       | ✅ Implémentation de `StartupService` (GRASP) <br> ✅ Refactoring de `PassosyfApplication` selon SRP et Singleton |

---

## 📚 Références utilisées

- *Design Patterns* - GoF (Gamma, Helm, Johnson, Vlissides)
- *Clean Code* - Robert C. Martin
- *Applying UML and Patterns* - Craig Larman

---

✅ Les modifications ci-dessus seront complétées par des sections similaires pour les autres classes impactées (ex. `AppelOffresControlleur`, `AppelOffresService`, etc.) avec l'historique **avant/après**, les **principes appliqués** et les **rôles GRASP/GoF/SOLID** identifiés.
