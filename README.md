# 📄 README - Projet Génie Logiciel - Application Passosyf

## 🎓 Module : Génie Logiciel

**Projet** : Passosyf

**Étudiant responsable** : **Chedly CHAHED**

---

## 🧩 Modifications apportées - Classe `AppelOffresControlleur.java`

### ✅ Objectif :

Améliorer l'organisation du code selon les principes **SOLID**, les patrons **GoF**, et les **patrons GRASP**.

---

## ⛔ Avant modification

### Classe concernée : `AppelOffresControlleur.java`

```java
package com.xtensus.passosyf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xtensus.passosyf.entities.AppelOffres;
import com.xtensus.passosyf.services.AppelOffresService;
import com.xtensus.passosyf.services.CommissionService;

@RestController
@RequestMapping("/api/appeloffres")
public class AppelOffresControlleur {

    @Autowired
    private AppelOffresService appelOffresService; // Service utilisé ici pour la logique métier
    @Autowired
    private CommissionService commissionService; // Service utilisé pour récupérer la commission

    @PostMapping("/addCommissionToAppelOffres/{commissionId}/{appelOffreId}")
    public ResponseEntity<?> addCommissionToAppelOffres(@PathVariable int commissionId, @PathVariable int appelOffreId) {
        // Problème : Logique métier présente directement dans le contrôleur (pas une bonne pratique)
        AppelOffres appelOffres = appelOffresService.getAppelOffresById(appelOffreId);
        if (appelOffres == null) return ResponseEntity.notFound().build();

        Commission commission = commissionService.getCommissionById(commissionId);
        if (commission == null) return ResponseEntity.notFound().build();

        appelOffres.getCommissions().add(commission); // Logique métier dans le contrôleur
        commission.getAppelOffres().add(appelOffres); // Logique métier dans le contrôleur

        appelOffresService.saveAppelOffres(appelOffres); // Appel de service pour sauvegarder l'entité
        return ResponseEntity.ok().build(); // Réponse HTTP
    }
}
```

### Problème dans le code ci-dessus :

- Le contrôleur contient une logique métier (`getAppelOffresById`, ajout de la commission à l'appel d'offres, et mise à jour dans la base de données).
- Le contrôleur devrait uniquement gérer les requêtes HTTP et déléguer la logique métier à un service, ce qui viole le principe **Single Responsibility Principle (SRP)** du **SOLID**.

---

## ✅ Après modification

### ✔ Classe mise à jour : `AppelOffresControlleur.java`

```java
package com.xtensus.passosyf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xtensus.passosyf.services.AppelOffresService; // Service où la logique métier est déplacée

@RestController
@RequestMapping("/api/appeloffres")
public class AppelOffresControlleur {

    @Autowired
    private AppelOffresService appelOffresService; // Injection du service pour déléguer la logique métier

    @PostMapping("/addCommissionToAppelOffres/{commissionId}/{appelOffreId}")
    public ResponseEntity<?> addCommissionToAppelOffres(@PathVariable int commissionId, @PathVariable int appelOffreId) {
        appelOffresService.addCommissionToAppelOffres(commissionId, appelOffreId); // Délégation de la logique métier au service
        return ResponseEntity.ok().build(); // Réponse HTTP
    }
    // Le contrôleur ne fait plus que gérer la requête et déléguer la logique métier au service
}
```

### Solution :

- La logique métier est maintenant déplacée dans la classe `AppelOffresService`, ce qui suit le principe **Single Responsibility Principle (SRP)** du **SOLID**.

- Le contrôleur devient beaucoup plus léger et se concentre uniquement sur la gestion de la requête HTTP.

---

### ✔ Classe mise à jour : `AppelOffresService.java`

```java
package com.xtensus.passosyf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.AppelOffres;
import com.xtensus.passosyf.entities.Commission;
import com.xtensus.passosyf.dao.AppelOffresDao;
import com.xtensus.passosyf.services.CommissionService;

@Service
public class AppelOffresService {

    @Autowired
    private AppelOffresDao appelOffresDao; // Accès à la base de données des Appels d'Offres
    @Autowired
    private CommissionService commissionService; // Service pour récupérer les commissions

    // Déplacement de la logique métier ici
    @Override
    public void addCommissionToAppelOffres(int commissionId, int appelOffreId) {
        AppelOffres appelOffres = getAppelOffresById(appelOffreId);
        if (appelOffres == null) {
            throw new ResourceNotFoundException("Appel d'offres non trouvé");
        }
        Commission commission = commissionService.getCommissionById(commissionId);
        if (commission == null) {
            throw new ResourceNotFoundException("Commission non trouvée");
        }
        appelOffres.getCommissions().add(commission);
        commission.getAppelOffres().add(appelOffres);
        appelOffresDao.save(appelOffres);
    }
    // Le service gère la logique métier pour maintenir une séparation claire des responsabilités
}
```

### Solution :

- La logique métier est maintenant entièrement déplacée dans le service `AppelOffresService`, permettant au contrôleur de se concentrer uniquement sur la gestion des requêtes HTTP.

- Le service s'occupe de la gestion des entités `AppelOffres` et `Commission`, ce qui suit les principes **SRP** (Single Responsibility Principle) et **GoF - Command** (délégation de la logique métier).

### Résumé des Modifications :

- **Avant** : La logique métier était incluse dans le contrôleur, ce qui rendait le code moins modulaire et violait le principe **SRP** (Single Responsibility Principle).

- **Après** : La logique métier a été déplacée dans le service, permettant ainsi de mieux séparer les responsabilités et de respecter les principes **SOLID**. Le contrôleur est simplifié et devient plus facile à maintenir.

---

## 📌 Explication des modifications

| Élément              | Détail                                                                 |
|----------------------|------------------------------------------------------------------------|
| 🔧 Classe modifiée    | `AppelOffresControlleur.java`                                             |
| 🔧 Classe modifiée     | `AppelOffresService.java`                                                  |
| ✅ Patron GoF         | **Singleton**  (Gestion unique des services)             |
| ✅ Patron GRASP       | **Contrôleur** (Le contrôleur délègue la logique métier à `AppelOffresService`)    |
| ✅ Principe SOLID     | **SRP (Responsabilité unique)** : chaque classe a une responsabilité unique   |

---

## 📋 Répartition des responsabilités

| Membre                 | Tâche prise en charge                                                                                           |
|------------------------|-----------------------------------------------------------------------------------------------------------------|
| **Chedly CHAHED**       | ✅ Refactoring de `AppelOffresControlleur` (GRASP - Controller) <br> ✅ Implémentation de la logique dans `AppelOffresService` |

---

## 📚 Références utilisées

- *Design Patterns* - GoF (Gamma, Helm, Johnson, Vlissides)
- *Clean Code* - Robert C. Martin
- *Applying UML and Patterns* - Craig Larman

---

✅ Les modifications ci-dessus seront complétées par des sections similaires pour les autres classes impactées (ex. `PassosyfApplication`) avec l'historique **avant/après**, les **principes appliqués** et les **rôles GRASP/GoF/SOLID** identifiés.
