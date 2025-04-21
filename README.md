# 📄 Projet Génie Logiciel - Application Passosyf

## 🎓 Module : Génie Logiciel

**Projet** : Passosyf
**Étudiant responsable** : **Chedly CHAHED**

---

## 🧩 Modifications apportées - Classe `AppelOffresControlleur.java`

### ✅ Objectif :

Améliorer l'organisation du code selon les principes **SOLID**, les patrons **GoF** (*Command*), les **patrons GRASP**, ainsi que garantir l'intégrité métier avec des **contraintes OCL**.

---

## ⛔ Avant modification

### Classe concernée : `AppelOffresControlleur.java` méthode `addCommissionToAppelOffres()`

```java
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "AppelOffres")
public class AppelOffresControlleur {
    // code avant...

    //méthode concernée
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
    // reste du code
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
    log.info("⏳ Calling Service... (from AppelOffresControlleur)");
    appelOffresService.addCommissionToAppelOffres(commissionId, appelOffreId); // Délégation complète
    return ResponseEntity.ok().build();
}
```

- ✅ Le contrôleur délègue désormais **toute la logique métier** au service.
- ✅ Respect du **principe de GRASP - Contrôleur**.

---

### ✔ Service : `AppelOffresServiceImpl.java`

```java
@Service
public class AppelOffresServiceImpl implements AppelOffresService {
    @Autowired
    CommissionService commissionService;
    @Override
    public void addCommissionToAppelOffres(int commissionId, int appelOffreId) {
        log.info("🔄 Adding commission with ID: {} to AppelOffres with ID: {} (from AppelOffresServiceImpl)", commissionId, appelOffreId);
        // Création et exécution de la commande
        AddCommissionToAppelOffresCommand command = new AddCommissionToAppelOffresCommand(commissionId, appelOffreId,this, commissionService);
        command.execute();
    }
    // Reste du code...
}
```

- ✅ Utilisation du **patron de comportement GoF - Command** pour encapsuler l'action dans une classe dédiée.
- ✅ Meilleure modularité, testabilité, réutilisabilité.

---

### ✔ Interface Commande : `Command.java`

```java
public interface Command {
    void execute();
}
```

- ✅ Cette interface définit le contrat de toutes les commandes exécutables.
- ✅ Elle permet d'unifier l'exécution d'actions complexes, tout en respectant le **principe d'ouverture/fermeture (OCP)**.
- ✅ Utile pour intégrer un **invocateur**, un historique d'annulation (Undo/Redo), ou une file d'attente de commandes, si nécessaire.

---

### ✔ Classe Commande : `AddCommissionToAppelOffresCommand.java`

```java
public class AddCommissionToAppelOffresCommand implements Command {
    private final int commissionId;
    private final int appelOffreId;
    private final AppelOffresService appelOffresService;
    private final CommissionService commissionService;
    private static final Logger log = LoggerFactory.getLogger(AddCommissionToAppelOffresCommand.class);

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
        log.info("⚙️ Executing... (from AddCommissionToAppelOffresCommand)");
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
- ✅ Respect du **patron de comportement GoF - Command** : encapsulation d'une action comme objet.

---

### 🖥️ Résultat d'exécution (console Spring Boot)

```plaintext
2025-04-21 01:25:02.399  INFO 15364 --- [] c.x.p.s.AppelOffresServiceImpl           : ⏳ Calling Service... (from AppelOffresControlleur)
2025-04-21 01:25:02.399  INFO 15364 --- [] c.x.p.s.AppelOffresServiceImpl           : 🔄 Adding commission with ID: 4 to AppelOffres with ID: 3 (from AppelOffresServiceImpl)
2025-04-21 01:25:02.404  INFO 15364 --- [] .x.p.c.AddCommissionToAppelOffresCommand : ⚙️ Executing... (from AddCommissionToAppelOffresCommand)
```

---

### ✅ Explication du résultat

- `⏳ Calling Service... (from AppelOffresControlleur)` → Ce log est émis par le contrôleur `AppelOffresControlleur`, indiquant qu'une méthode du service `AppelOffresServiceImpl` a été invoquée pour traiter la demande. Cela correspond à l'appel au service où une commission doit être ajoutée à un appel d'offres.
- `🔄 Adding commission with ID: 4 to AppelOffres with ID: 3 (from AppelOffresServiceImpl)` → Ici, le service `AppelOffresServiceImpl` affiche un message pour indiquer que l'ajout d'une commission (ID 4) à un appel d'offres (ID 3) est en cours. Cela reflète la logique métier derrière l'ajout de la commission.
- `⚙️ Executing... (from AddCommissionToAppelOffresCommand)` → Log émis par la commande `AddCommissionToAppelOffresCommand`, signalant que la commande pour ajouter la commission à l'appel d'offres est en cours d'exécution. Cette étape exécute la logique spécifique à l'ajout de la commission et enregistre les modifications dans la base de données.

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
    if (this.appelOffreCoutEstime <= 0) {
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
    if (this.appelOffreNbrLots <= 0) {
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

| Élément                   | Détail                                                                                      |
|---------------------------|---------------------------------------------------------------------------------------------|
| 🔧 Classe modifiée         | `AppelOffresControlleur.java` : logique métier supprimée, délégation vers le service       |
| 🔧 Classe modifiée         | `AppelOffresServiceImpl.java` : utilise une commande dédiée pour encapsuler l'action       |
| 🔧 Classe modifiée         | `AppelOffres.java` : validations OCL via `@PrePersist` / `@PreUpdate`                       |
| ➕ Nouvelle classe          | `AddCommissionToAppelOffresCommand.java` : implémente l'interface `Command`                |
| ✅ Patron de comportement GoF              | **Command** : encapsulation d'une requête comme objet (`AddCommissionToAppelOffresCommand`) |
| ✅ Patron GRASP            | **Contrôleur** : délégation métier vers le service (`AppelOffresControlleur`)              |
| ✅ Principes SOLID         | **SRP** : chaque classe a une responsabilité unique <br> &nbsp;&nbsp;&nbsp;&nbsp;• `AppelOffresControlleur` : uniquement rôle de routeur <br> &nbsp;&nbsp;&nbsp;&nbsp;• `AddCommissionToAppelOffresCommand` : encapsule une seule action métier <br> **OCP** : ajout d'une nouvelle commande sans modifier le contrôleur ou le service (`AppelOffresServiceImpl`) |
| ✅ Contraintes OCL         | 3 invariants ajoutés dans `AppelOffres` : coût estimé > 0, nombre de lots > 0, commissions sans doublon |

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
