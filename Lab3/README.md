# SEG3503 - Laboratoire 3

| Groupe   | Numéro étudiant                  | Nom          |
| -------- | -------------------------------- | ------------ |
| Groupe 7 | 300273106 | Erik Skjenna |

---

## Description du laboratoire

Ce laboratoire porte sur les tests unitaires, les tests de cas limites et l'analyse de couverture de code avec **JaCoCo**.

Le programme testé est une classe `Date`, qui permet de représenter une date valide et de calculer la date du lendemain avec la méthode `nextDate()`.

L'objectif principal du laboratoire est de vérifier que la classe fonctionne correctement pour plusieurs types de dates, incluant :

* les dates normales;
* les fins de mois;
* les fins d'année;
* les années bissextiles;
* les années non bissextiles;
* les dates invalides;
* les exceptions du constructeur.

---

## Structure du projet

```text
.
├── src
│   └── Date.java
│
├── test
│   ├── DateTest.java
│   ├── DateExceptionTest.java
│   ├── DateNextDateOkTest.java
│   └── DateNextDateExceptionTest.java
│
├── lib
│   ├── junit-platform-console-standalone-1.7.1.jar
│   ├── jacocoagent.jar
│   └── jacococli.jar
│
├── bin
│   ├── main
│   └── test
│
├── coverage
│   ├── jacoco.exec
│   └── html
│
└── README.md
```

---

## Fichiers principaux

| Fichier                          | Description                                                         |
| -------------------------------- | ------------------------------------------------------------------- |
| `Date.java`                      | Classe principale qui valide les dates et calcule la date suivante. |
| `DateTest.java`                  | Tests unitaires généraux pour la classe `Date`.                     |
| `DateExceptionTest.java`         | Tests qui vérifient les exceptions lancées par le constructeur.     |
| `DateNextDateOkTest.java`        | Tests paramétrés pour les dates valides avec `nextDate()`.          |
| `DateNextDateExceptionTest.java` | Tests paramétrés pour les dates invalides.                          |
| `README.md`                      | Rapport du laboratoire et instructions d'exécution.                 |

---

## Fonctionnalités testées

Les tests couvrent les fonctionnalités suivantes :

1. Création d'une date valide.
2. Rejet d'un jour invalide.
3. Rejet d'un mois invalide.
4. Rejet d'une année invalide.
5. Validation des mois de 30 jours.
6. Validation des mois de 31 jours.
7. Validation du mois de février.
8. Gestion des années bissextiles.
9. Gestion des années non bissextiles.
10. Passage au mois suivant.
11. Passage à l'année suivante.
12. Calcul de la date suivante avec `nextDate()`.

---

## Cas de test importants

| Cas testé                              | Exemple                  | Résultat attendu |
| -------------------------------------- | ------------------------ | ---------------- |
| Date normale                           | `new Date(15, 6, 2024)`  | Date acceptée    |
| Jour zéro                              | `new Date(0, 1, 2024)`   | Exception        |
| Jour négatif                           | `new Date(-1, 1, 2024)`  | Exception        |
| Jour trop grand                        | `new Date(32, 1, 2024)`  | Exception        |
| Mois zéro                              | `new Date(1, 0, 2024)`   | Exception        |
| Mois trop grand                        | `new Date(1, 13, 2024)`  | Exception        |
| Année négative                         | `new Date(1, 1, -2024)`  | Exception        |
| 31 avril                               | `new Date(31, 4, 2024)`  | Exception        |
| 31 juin                                | `new Date(31, 6, 2024)`  | Exception        |
| 31 septembre                           | `new Date(31, 9, 2024)`  | Exception        |
| 31 novembre                            | `new Date(31, 11, 2024)` | Exception        |
| 30 février                             | `new Date(30, 2, 2024)`  | Exception        |
| 29 février année bissextile            | `new Date(29, 2, 2024)`  | Date acceptée    |
| 29 février année non bissextile        | `new Date(29, 2, 2023)`  | Exception        |
| 29 février année siècle non bissextile | `new Date(29, 2, 1900)`  | Exception        |
| 29 février année siècle bissextile     | `new Date(29, 2, 2000)`  | Date acceptée    |

---

## Exemples de tests `nextDate()`

| Date initiale | Date attendue |
| ------------- | ------------- |
| 14/6/2024     | 15/6/2024     |
| 31/1/2024     | 1/2/2024      |
| 30/4/2024     | 1/5/2024      |
| 28/2/2023     | 1/3/2023      |
| 28/2/2024     | 29/2/2024     |
| 29/2/2024     | 1/3/2024      |
| 31/12/2024    | 1/1/2025      |

---

## Compilation du projet

Avant de compiler, il faut créer les dossiers de sortie :

```powershell
rmdir /s /q bin
mkdir bin\main
mkdir bin\test
```

Compilation de la classe principale :

```powershell
javac -d bin\main src\Date.java
```

Compilation des tests :

```powershell
javac -cp "bin\main;lib\junit-platform-console-standalone-1.7.1.jar" -d bin\test test\DateTest.java test\DateExceptionTest.java test\DateNextDateOkTest.java test\DateNextDateExceptionTest.java
```

---

## Exécution des tests

Pour exécuter tous les tests avec JUnit :

```powershell
java -jar lib\junit-platform-console-standalone-1.7.1.jar --class-path "bin\main;bin\test" --scan-class-path --details tree
```

Les tests vérifient que la classe `Date` accepte les dates valides et rejette correctement les dates invalides avec des exceptions.

---

## Exécution des tests avec JaCoCo

Pour générer le fichier de couverture `jacoco.exec` :

```powershell
rmdir /s /q coverage
mkdir coverage
```

```powershell
java -javaagent:lib\jacocoagent.jar=destfile=coverage\jacoco.exec -jar lib\junit-platform-console-standalone-1.7.1.jar --class-path "bin\main;bin\test" --scan-class-path --details tree
```

---

## Génération du rapport HTML JaCoCo

Pour générer le rapport HTML en incluant seulement la classe principale `Date` :

```powershell
java -jar lib\jacococli.jar report coverage\jacoco.exec --classfiles bin\main --sourcefiles src --html coverage\html
```

Le rapport peut ensuite être ouvert avec le fichier suivant :

```text
coverage/html/index.html
```

---

## Résultats de couverture

Le rapport JaCoCo montre que la classe principale `Date` est entièrement couverte.

| Élément | Couverture des instructions | Couverture des branches | Lignes manquées | Méthodes manquées |
| ------- | --------------------------: | ----------------------: | --------------: | ----------------: |
| `Date`  |                       100 % |                   100 % |               0 |                 0 |

---

## Résultat global observé dans le premier rapport

Dans un premier rapport JaCoCo, les classes de test étaient aussi incluses dans la couverture. Cela donnait le résultat global suivant :

| Élément                     | Couverture des instructions | Couverture des branches |
| --------------------------- | --------------------------: | ----------------------: |
| Total avec les tests inclus |                        94 % |                   100 % |
| `DateTest`                  |                        79 % |                     n/a |
| `DateExceptionTest`         |                        85 % |                     n/a |
| `DateNextDateExceptionTest` |                        97 % |                     n/a |
| `DateNextDateOkTest`        |                       100 % |                     n/a |
| `Date`                      |                       100 % |                   100 % |

Ce résultat global de 94 % ne représente pas uniquement la couverture du code principal. Il inclut aussi les fichiers de tests, ce qui explique pourquoi certaines lignes générées par les lambdas dans les tests apparaissaient comme non couvertes.

La ligne importante pour le laboratoire est donc la ligne suivante :

```text
Date    100 % instructions    100 % branches
```

---

## Explication des lambdas dans JaCoCo

Certaines lignes comme celles-ci peuvent apparaître dans le rapport :

```text
lambda$constructeur_jourZero_lanceException$0()
lambda$constructeur_jourNegatif_lanceException$1()
lambda$constructeur_jourPlusGrandQue31_lanceException$2()
```

Ces éléments ne viennent pas de la classe `Date`. Ils viennent plutôt des expressions lambda utilisées dans les tests avec `assertThrows`.

Exemple :

```java
assertThrows(IllegalArgumentException.class, () -> {
    new Date(0, 1, 2024);
});
```

JaCoCo transforme cette lambda en méthode interne. Si les fichiers de test sont inclus dans le rapport, ces méthodes apparaissent dans la couverture. Cependant, elles ne font pas partie du code principal à tester.

Pour cette raison, le rapport final doit être généré avec seulement les fichiers compilés de la classe principale dans `bin\main`.

---

## Analyse des résultats

La classe `Date` obtient une couverture de :

* 100 % pour les instructions;
* 100 % pour les branches;
* 0 ligne manquée;
* 0 méthode manquée.

Cela signifie que tous les chemins importants de la classe principale ont été exécutés au moins une fois par les tests.

Les tests couvrent autant les cas valides que les cas invalides. Les exceptions du constructeur sont aussi testées afin de vérifier que les dates impossibles sont bien refusées.

---

## Conclusion

Ce laboratoire a permis de vérifier le bon fonctionnement de la classe `Date` avec des tests unitaires et des tests paramétrés. Les cas normaux, les cas limites et les cas d'erreur ont tous été testés.

Le rapport JaCoCo confirme que la classe principale `Date` possède une couverture complète de 100 % pour les instructions et de 100 % pour les branches.

La différence entre le rapport global de 94 % et la couverture réelle de 100 % vient du fait que le premier rapport incluait aussi les classes de test. Lorsque le rapport est généré seulement avec la classe principale `Date`, la couverture du code testé est bien de 100 %.
