# 📄 README - Projet Génie Logiciel - Application Passosyf

## 🎓 Module : Génie Logiciel

**Projet** : Passosyf  
**Étudiant responsable** : **Chedly CHAHED**

---

## 🧩 Modifications apportées - Classe `AppelOffresControlleur.java`

### ✅ Objectif :

Améliorer l'organisation du code selon les principes **SOLID**, les patrons **GoF** (*Command*), et les **patrons GRASP**.

---

## ⛔ Avant modification

### Classe concernée : `AppelOffresControlleur.java`

```java
@PostMapping("/addCommissionToAppelOffres/{commissionId}/{appelOffreId}")
public ResponseEntity<?> addCommissionToAppelOffres(@PathVariable int commissionId, @PathVariable int appelOffreId) {
    AppelOffres appelOffres = appelOffresService.getAppelOffresById(appelOffreId);
    if (appelOffres == null) return ResponseEntity.notFound().build();

    Commission commission = commissionService.getCommissionById(commissionId);
    if (commission == null) return ResponseEntity.notFound().build();

    appelOffres.getCommissions().add(commission);
    commission.getAppelOffres().add(appelOffres);

    appelOffresService.saveAppelOffres(appelOffres);
    return ResponseEntity.ok().build();
}
```

### Problèmes :

- Violation du **SRP** (Single Responsibility Principle) : logique métier incluse dans le contrôleur.
- Aucun usage de **patrons de conception** pour isoler la commande métier.
- Le contrôleur devient difficile à tester, maintenir et faire évoluer.

---

## ✅ Après modification

### ✔ Contrôleur allégé : `AppelOffresControlleur.java`

```java
@PostMapping("/addCommissionToAppelOffres/{commissionId}/{appelOffreId}")
public ResponseEntity<?> addCommissionToAppelOffres(@PathVariable int commissionId,
                                                    @PathVariable int appelOffreId) {
    appelOffresService.addCommissionToAppelOffres(commissionId, appelOffreId); // Délégation complète
    return ResponseEntity.ok().build();
}
```

- Le contrôleur délègue désormais **toute la logique métier** au service.
- Respect du **principe de GRASP - Contrôleur**.

---

### ✔ Service : `AppelOffresServiceImpl.java`

```java
@Override
public void addCommissionToAppelOffres(int commissionId, int appelOffreId) {
    AddCommissionToAppelOffresCommand command =
        new AddCommissionToAppelOffresCommand(commissionId, appelOffreId, this, commissionService);
    command.execute();
}
```

- Utilisation du **patron GoF - Command** pour encapsuler l'action dans une classe dédiée.
- Meilleure modularité, testabilité, réutilisabilité.

---

### ✔ Classe Commande : `AddCommissionToAppelOffresCommand.java`

```java
public class AddCommissionToAppelOffresCommand implements Command {
    private final int commissionId;
    private final int appelOffreId;
    private final AppelOffresService appelOffresService;
    private final CommissionService commissionService;

    public AddCommissionToAppelOffresCommand(int commissionId, int appelOffreId,
                                             AppelOffresService appelOffresService,
                                             CommissionService commissionService) {
        this.commissionId = commissionId;
        this.appelOffreId = appelOffreId;
        this.appelOffresService = appelOffresService;
        this.commissionService = commissionService;
    }

    @Override
    public void execute() {
        AppelOffres appelOffres = appelOffresService.getAppelOffresById(appelOffreId);
        if (appelOffres == null) throw new ResourceNotFoundException("Appel d'offres non trouvé");

        Commission commission = commissionService.getCommissionById(commissionId);
        if (commission == null) throw new ResourceNotFoundException("Commission non trouvée");

        appelOffres.getCommissions().add(commission);
        commission.getAppelOffres().add(appelOffres);
        appelOffresService.saveAppelOffres(appelOffres);
    }
}
```

- Respect du **principe SRP** : chaque classe a une responsabilité claire.
- Respect du **patron GoF - Command** : encapsulation d'une action comme objet.

---

## 📌 Résumé des modifications

| Élément              | Détail                                                                 |
|----------------------|------------------------------------------------------------------------|
| 🔧 Classe modifiée    | `AppelOffresControlleur.java`                                          |
| 🔧 Classe modifiée    | `AppelOffresServiceImpl.java`                                          |
| ➕ Nouvelle classe     | `AddCommissionToAppelOffresCommand.java` (implémente `Command`)        |
| ✅ Patron GoF         | **Command** : encapsulation d'une requête comme objet                 |
| ✅ Patron GRASP       | **Contrôleur** : délégation au service                                |
| ✅ Principe SOLID     | **SRP** : séparation claire des responsabilités                       |

---

## 📋 Répartition des responsabilités

| Membre            | Tâche prise en charge                                                                                           |
|-------------------|-----------------------------------------------------------------------------------------------------------------|
| **Chedly CHAHED** | ✅ Refactoring `AppelOffresControlleur` et `AppelOffresServiceImpl` <br> ✅ Implémentation de `AddCommissionToAppelOffresCommand` |

---

## 📚 Références utilisées

- *Design Patterns* - GoF (Gamma, Helm, Johnson, Vlissides)  
- *Clean Code* - Robert C. Martin  
- *Applying UML and Patterns* - Craig Larman

---

✅ Les mêmes principes (GRASP, SOLID, GoF) peuvent être appliqués à d'autres cas d'usage similaires dans l'application, notamment pour les entités telles que `CahierCharges`, `Commission`, `Critere`, etc. Chaque action métier importante (ex. : lier un critère à un cahier des charges, affecter une commission à un appel d'offres, etc.) peut être encapsulée dans une commande dédiée, ce qui garantit une architecture robuste, modulaire et facilement testable.
