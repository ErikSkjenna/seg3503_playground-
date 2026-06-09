````md
# SEG3503 - Laboratoire 2

## Description du laboratoire

Ce laboratoire porte sur les tests logiciels appliqués à une application d'inscription d'utilisateur.  
Le but principal est de documenter les cas de test, comparer les résultats attendus avec les résultats obtenus, et exécuter des tests automatisés avec JUnit.

Le travail est divisé en deux exercices :

- **Exercise 1** : tests manuels de l'application.
- **Exercise 2** : tests automatisés avec JUnit et tests paramétrés.

Ce fichier README résume le travail effectué afin de faciliter la correction.

---

# Exercise 1

## Objectif

L'objectif de l'exercice 1 est d'exécuter manuellement plusieurs cas de test sur l'application **User Registration**.

Pour chaque cas de test, le résultat attendu est comparé avec le résultat réel obtenu dans l'application.  
Un verdict est ensuite donné : **Pass**, **Fail** ou **Inconclusive**.

---

## Tableau des résultats - Exercise 1

| Test Case | Expected Results | Actual Results / Screenshot | Verdict |
|---|---|---|---|
| 1 | accepted | <!-- Ajouter l'image du test case 1 ici --> | Pass |
| 2 | accepted | <!-- Ajouter l'image du test case 2 ici --> | Pass |
| 3 | accepted | <!-- Ajouter l'image du test case 3 ici --> | Pass |
| 4 | Err1 | <!-- Ajouter l'image du test case 4 ici --> | Fail |
| 5 | Err1 | <!-- Ajouter l'image du test case 5 ici --> | Fail |

---

## Notes sur les résultats de l'exercice 1

Les trois premiers cas de test ont été acceptés comme prévu, donc ils sont considérés comme réussis.

Les cas de test 4 et 5 ont échoué parce que le résultat obtenu ne correspond pas exactement au résultat attendu.  
Dans ces cas, le système a retourné plus d'erreurs que prévu, ce qui explique le verdict **Fail**.

---

## Captures d'écran - Exercise 1

### Screenshot général de l'exercice 1

<!-- Ajouter une capture d'écran générale de l'exercice 1 ici -->

Exemple :

```md
![Exercise 1](assets/nom-image.png)
````

### Test Case 1

<!-- Ajouter l'image du test case 1 ici -->

### Test Case 2

<!-- Ajouter l'image du test case 2 ici -->

### Test Case 3

<!-- Ajouter l'image du test case 3 ici -->

### Test Case 4

<!-- Ajouter l'image du test case 4 ici -->

### Test Case 5

<!-- Ajouter l'image du test case 5 ici -->

---

# JUnit Parameterized Runner

## Objectif

Cette partie du laboratoire utilise JUnit afin d'automatiser l'exécution des tests.

Les tests paramétrés permettent de tester plusieurs entrées différentes avec une seule structure de test.
Cela permet de réduire la répétition dans le code et de rendre les tests plus faciles à maintenir.

---

# Exercise 2

## Objectif

L'objectif de l'exercice 2 est d'exécuter des tests automatisés avec JUnit.

Les tests couvrent différents types de scénarios :

* les cas valides;
* les cas invalides;
* les cas qui ne doivent pas générer d'exception;
* les cas qui doivent générer une exception;
* les tests paramétrés.

---

## Tableau des captures d'écran - Exercise 2


# Organisation du projet

| Fichier / Dossier | Description                            |
| ----------------- | -------------------------------------- |
| `README.md`       | Résumé du laboratoire et des résultats |
| `assets/`         | Dossier contenant les captures d'écran |
| `src/`            | Code source de l'application           |
| `test/`           | Tests JUnit                            |
| `lib/`            | Librairies nécessaires pour JUnit      |
| `bin/`            | Fichiers compilés                      |

---

# Comment ajouter les images

Les captures d'écran doivent être placées dans le dossier `assets`.

Exemple de structure :

```txt
Lab2/
│
├── README.md
├── assets/
│   ├── image1.png
│   ├── image2.png
│   ├── image3.png
│
├── src/
├── test/
├── lib/
└── bin/
```

Pour insérer une image dans le README, utilisez le format suivant :

```md
![Description de l'image](assets/nom-image.png)
```

Exemple :

```md
![Test Case 1](assets/test-case-1.png)
```

---

# Commandes utilisées

## Compilation du code source

```bash
javac -d bin src/*.java
```

## Compilation des tests

```bash
javac -cp "bin;lib/*" -d bin test/*.java
```

## Exécution des tests JUnit

```bash
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path bin --scan-classpath --details tree
```

---

# Résumé des résultats

| Partie     | Résultat général                                                                      |
| ---------- | ------------------------------------------------------------------------------------- |
| Exercise 1 | Les tests manuels ont été exécutés et documentés                                      |
| Exercise 2 | Les tests JUnit ont été exécutés                                                      |
| README     | Les résultats sont résumés avec des tableaux et des espaces pour les captures d'écran |

---

# Conclusion

Ce laboratoire a permis de pratiquer les tests manuels et les tests automatisés.

L'exercice 1 montre comment comparer les résultats attendus avec les résultats obtenus dans une application réelle.
L'exercice 2 montre comment utiliser JUnit pour automatiser l'exécution des tests.

Les tableaux Markdown et les captures d'écran rendent le travail plus clair, plus structuré et plus facile à corriger.

```
```
