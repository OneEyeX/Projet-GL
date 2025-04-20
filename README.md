# 📄 README - Projet Génie Logiciel - Application Passosyf

## 🎓 Module : Génie Logiciel

**Projet** : Passosyf  
**Étudiant responsable** : **Chedly CHAHED**

---

## 🧩 Modifications apportées - Classe `AppelOffresControlleur.java`

### ✅ Objectif :

Améliorer l'organisation du code selon les principes **SOLID**, les patrons **GoF** (*Command*), les **patrons GRASP**, ainsi que garantir l'intégrité métier avec des **contraintes OCL**.

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

- ❌ Violation du **SRP** (Single Responsibility Principle) : logique métier incluse dans le contrôleur.
- ❌ Aucun usage de **patrons de conception** pour isoler la commande métier.
- ❌ Le contrôleur devient difficile à tester, maintenir et faire évoluer.

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

- ✅ Le contrôleur délègue désormais **toute la logique métier** au service.
- ✅ Respect du **principe de GRASP - Contrôleur**.

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

- ✅ Utilisation du **patron GoF - Command** pour encapsuler l'action dans une classe dédiée.
- ✅ Meilleure modularité, testabilité, réutilisabilité.

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

- ✅ Respect du **principe SRP** : chaque classe a une responsabilité claire.
- ✅ Respect du **patron GoF - Command** : encapsulation d'une action comme objet.

---

## 🔒 Contraintes OCL - Entité `AppelOffres`

Dans le cadre de la validation métier, des contraintes OCL (*Object Constraint Language*) ont été intégrées afin de garantir la cohérence et l'intégrité des données au sein de l'entité `AppelOffres`.

---

### ✅ Contrainte 1 : Coût estimé strictement positif

- **OCL (formelle)** :

```ocl
context AppelOffres
inv CoutEstimePositif: self.appelOffreCoutEstime > 0
```

- **Java (implémentation)** :

```java
private void validateCoutEstime() {
    if (appelOffreCoutEstime <= 0) {
        throw new IllegalArgumentException("Le coût estimé doit être strictement positif.");
    }
}
```

---

### ✅ Contrainte 2 : Nombre de lots strictement positif

- **OCL (formelle)** :

```ocl
context AppelOffres
inv NombreLotsPositif: self.appelOffreNbrLots > 0
```

- **Java (implémentation)** :

```java
private void validateNombreLots() {
    if (appelOffreNbrLots <= 0) {
        throw new IllegalArgumentException("Le nombre de lots doit être strictement positif.");
    }
}
```

---

### ✅ Contrainte 3 : Références de commissions uniques dans un appel d'offres

- **OCL (formelle)** :

```ocl
context AppelOffres
inv CommissionsUniques: self.commissions->isUnique(c | c.commissionReference)
```

- **Java (implémentation)** :

```java
private void validateCommissionsUniques() {
    Set<Integer> references = new HashSet<>();
    for (Commission c : commissions) {
        if (c.getCommissionReference() != null && !references.add(c.getCommissionReference())) {
            throw new IllegalStateException("Doublon détecté dans la liste des commissions.");
        }
    }
}
```

---

### 🧪 Validation automatique via JPA

L'ensemble des contraintes est déclenché **automatiquement** avant chaque persistance ou mise à jour en base de données grâce à l'annotation JPA :

```java
@PrePersist
@PreUpdate
private void validateOCLConstraints() {
    validateCoutEstime();
    validateNombreLots();
    validateCommissionsUniques();
}
```

---

### 🎯 Objectif

Ces contraintes OCL renforcent la **cohérence métier** au niveau du modèle de domaine, garantissant que les règles métiers essentielles sont systématiquement respectées, indépendamment de la couche applicative.

---

## 📌 Résumé des modifications

| Élément              | Détail                                                                 |
|----------------------|------------------------------------------------------------------------|
| 🔧 Classe modifiée    | `AppelOffresControlleur.java`                                          |
| 🔧 Classe modifiée    | `AppelOffresServiceImpl.java`                                          |
| 🔧 Classe modifiée    | `AppelOffres.java` (ajout des validations OCL via `@PrePersist`/`@PreUpdate`) |
| ➕ Nouvelle classe     | `AddCommissionToAppelOffresCommand.java` (implémente `Command`)        |
| ✅ Patron GoF         | **Command** : encapsulation d'une requête comme objet                 |
| ✅ Patron GRASP       | **Contrôleur** : délégation au service                                |
| ✅ Principe SOLID     | **SRP** : séparation claire des responsabilités                       |
| ✅ Contraintes OCL    | **3 invariants ajoutés** à `AppelOffres` : coût > 0, lots > 0, commissions uniques |

---

## 📋 Répartition des responsabilités

| Membre            | Tâche prise en charge                                                                                           |
|-------------------|-----------------------------------------------------------------------------------------------------------------|
| **Chedly CHAHED** | ✅ Refactoring `AppelOffresControlleur` et `AppelOffresServiceImpl` <br> ✅ Implémentation de `AddCommissionToAppelOffresCommand` <br> ✅ Ajout des contraintes OCL dans `AppelOffres` |

---

## 📚 Références utilisées

- *Design Patterns* - GoF (Gamma, Helm, Johnson, Vlissides)  
- *Clean Code* - Robert C. Martin  
- *Applying UML and Patterns* - Craig Larman  
- *OCL Specification* - OMG
