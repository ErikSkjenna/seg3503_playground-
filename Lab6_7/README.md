# SEG3503 – Laboratoires 6 et 7  

**Nom :** Erik Skjenna  
**Cours :** SEG3503  
**#Etudiant :** 300273106 \n
**Laboratoire :** Lab 06_07 

Lien du dépôt GitHub :  
https://github.com/ErikSkjenna/seg3503_playground-/edit/main/Lab6_7

Lien des images : 
https://github.com/ErikSkjenna/seg3503_playground-/tree/main/Lab6_7/Images


## Tests d’acceptation automatisés avec Selenium WebDriver

## Table des matières

1. [Description](#description)
2. [Objectifs](#objectifs)
3. [Technologies utilisées](#technologies-utilisées)
4. [Structure du projet](#structure-du-projet)
5. [Installation et configuration](#installation-et-configuration)
6. [Compilation du projet](#compilation-du-projet)
7. [Génération du fichier JAR](#génération-du-fichier-jar)
8. [Démarrage de l’application](#démarrage-de-lapplication)
9. [Présentation de l’application](#présentation-de-lapplication)
10. [Tests automatisés](#tests-automatisés)
11. [Exécution des tests](#exécution-des-tests)
12. [Résultats](#résultats)
13. [Difficultés rencontrées](#difficultés-rencontrées)
14. [Conclusion](#conclusion)

---

## Description

Ce projet a été réalisé dans le cadre des laboratoires 6 et 7 du cours **SEG3503**.

L’objectif principal du laboratoire était de se familiariser avec les tests d’acceptation automatisés à l’aide de **Selenium WebDriver**.

L’application utilisée est une librairie Web appelée **YAMAZONE BookStore**. Elle est exécutée localement à l’aide de Spring Boot et d’un serveur Tomcat intégré.

Les tests automatisés permettent notamment de :

- démarrer l’application;
- ouvrir Google Chrome automatiquement;
- accéder à la page principale;
- trouver des éléments HTML;
- vérifier le titre de l’application;
- changer la langue de l’interface;
- vérifier les résultats avec des assertions JUnit;
- fermer le navigateur après chaque test.

---

## Objectifs

Les principaux objectifs de ce laboratoire étaient les suivants :

- utiliser Maven pour gérer un projet Java;
- compiler et générer une application Java;
- configurer Selenium WebDriver;
- configurer ChromeDriver avec WebDriverManager;
- automatiser les interactions avec un navigateur;
- localiser des éléments HTML;
- exécuter des actions utilisateur automatiquement;
- valider les résultats avec JUnit;
- produire des preuves visuelles de l’exécution de l’application et des tests.

---

## Technologies utilisées

Le projet utilise les technologies suivantes :

- Java 21
- Apache Maven 3.9.16
- JUnit 5
- Selenium WebDriver
- WebDriverManager
- Google Chrome
- ChromeDriver
- Spring Boot
- Apache Tomcat
- Base de données H2
- Visual Studio Code
- Windows 10

---

## Structure du projet

La structure principale du projet est la suivante :

```text
Lab6_7/
├── BookstoreApp/
│   ├── .settings/
│   ├── bin/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── App.java
│   │   └── test/
│   │       └── java/
│   │           ├── ExampleTest.java
│   │           └── selenium/
│   │               └── ExampleSeleniumTest.java
│   ├── target/
│   │   └── BookstoreApp-0.1.0.jar
│   ├── bookstore5.jar
│   └── pom.xml
├── images/
│   ├── Lab6_7_CompileSuccess.PNG
│   ├── Lab6_7_LocalHost(1).PNG
│   ├── Lab6_7_LocalHostAdmin.PNG
│   ├── Lab6_7_LocalHostFR.PNG
│   ├── Lab6_7_Packages.PNG
│   ├── Lab6_7_TestWork.PNG
│   └── Lab6_7_ToutesPlusVersions.PNG
├── bookStoreRequirements.pdf
├── SEG3503_lab06_07_selenium.pdf
└── Submission_example.pdf
```

Les tests Selenium sont placés dans le dossier suivant :

```text
BookstoreApp/src/test/java/selenium/
```

Le fichier principal contenant les tests Selenium est :

```text
ExampleSeleniumTest.java
```

---

## Installation et configuration

### Prérequis

Avant d’exécuter le projet, les logiciels suivants doivent être installés :

- Java JDK;
- Apache Maven;
- Google Chrome;
- un environnement de développement comme Visual Studio Code, Eclipse ou IntelliJ IDEA.

### Vérification de Java

La version de Java peut être vérifiée avec la commande suivante :

```powershell
java -version
```

Version utilisée pour ce projet :

```text
Java 21.0.8 LTS
```

### Vérification de Maven

La version de Maven peut être vérifiée avec :

```powershell
mvn -version
```

Version utilisée pour ce projet :

```text
Apache Maven 3.9.16
```

### Environnement utilisé

```text
Java version : 21.0.8 LTS
Maven version : 3.9.16
Système d’exploitation : Windows 10
Architecture : 64 bits
Encodage : UTF-8
```

![Versions de Java et Maven](images/Lab6_7_ToutesPlusVersions.PNG)

---

## Compilation du projet

Pour compiler le projet, il faut ouvrir PowerShell dans le dossier contenant le fichier `pom.xml`.

```powershell
cd "C:\Users\ttvpu\OneDrive\Documents\GitHub\seg3503_playground-\Lab6_7\BookstoreApp"
```

La commande suivante nettoie les anciens fichiers générés et compile le projet :

```powershell
mvn clean compile
```

Maven effectue alors les étapes suivantes :

1. analyse le fichier `pom.xml`;
2. supprime l’ancien dossier `target`;
3. compile les fichiers Java;
4. place les fichiers compilés dans `target/classes`;
5. affiche le résultat de la compilation.

La compilation s’est terminée correctement avec le message :

```text
BUILD SUCCESS
```

![Compilation réussie](images/Lab6_7_CompileSuccess.PNG)

---

## Génération du fichier JAR

Le fichier JAR du projet peut être généré avec la commande suivante :

```powershell
mvn package -DskipTests
```

L’option `-DskipTests` permet de générer le fichier JAR sans exécuter les tests pendant cette étape.

Après l’exécution de la commande, le fichier suivant est produit :

```text
target/BookstoreApp-0.1.0.jar
```

Le contenu du dossier `target` peut être vérifié avec :

```powershell
dir .\target
```

![Fichier JAR généré](images/Lab6_7_Packages.PNG)

---

## Démarrage de l’application

L’application principale peut être démarrée directement à partir du fichier fourni :

```powershell
java -jar .\bookstore5.jar
```

Lors du démarrage, Spring Boot initialise notamment :

- le serveur Tomcat;
- le contexte Web;
- la base de données H2;
- Hibernate;
- Spring Data;
- Spring Security.

Lorsque le démarrage est terminé, le terminal affiche un résultat semblable à :

```text
Tomcat started on port(s): 8080 (http)
Started Bookstore1Application
```

L’application devient alors accessible à l’adresse suivante :

```text
http://localhost:8080
```

Le terminal dans lequel le serveur est exécuté doit rester ouvert pendant l’utilisation de l’application.

Pour arrêter le serveur, il suffit d’utiliser :

```text
Ctrl + C
```

---

## Présentation de l’application

### Page d’accueil

La page principale est accessible à l’adresse suivante :

```text
http://localhost:8080
```

Elle contient notamment :

- le logo de YAMAZONE;
- le titre de la librairie;
- un champ de recherche par catégorie;
- un bouton de recherche;
- un sélecteur de langue;
- un message de bienvenue.

![Page d’accueil de YAMAZONE](images/Lab6_7_LocalHost%281%29.PNG)

### Interface administrateur

L’interface administrateur est accessible à l’adresse suivante :

```text
http://localhost:8080/admin
```

Lorsqu’un utilisateur non authentifié tente d’accéder à cette page, Spring Security le redirige vers :

```text
http://localhost:8080/login
```

La page de connexion contient :

- un champ pour le nom d’utilisateur;
- un champ pour le mot de passe;
- un bouton de connexion;
- un sélecteur de langue.

![Page de connexion administrateur](images/Lab6_7_LocalHostAdmin.PNG)

### Interface en français

L’application permet de changer la langue de l’interface grâce à la liste déroulante.

Lorsque le français est sélectionné, l’adresse contient le paramètre suivant :

```text
?lang=fr-CA
```

Plusieurs éléments sont alors traduits, notamment :

- `YAMAZONE BookStore` devient `Librairie Y'AMAZONE`;
- `Category` devient `Catégorie`;
- `Search` devient `Recherche`;
- `Change the language` devient `Changez la langue`;
- le message d’accueil est affiché en français.

![Interface française](images/Lab6_7_LocalHostFR.PNG)

---

## Tests automatisés

Les tests Selenium se trouvent dans le fichier :

```text
src/test/java/selenium/ExampleSeleniumTest.java
```

### Configuration du serveur

Avant l’exécution des tests, le serveur de l’application est démarré à l’aide de `ProcessBuilder` :

```java
@BeforeAll
public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb =
        new ProcessBuilder("java", "-jar", "bookstore5.jar");

    server = pb.start();
}
```

La méthode annotée avec `@BeforeAll` est exécutée une seule fois avant tous les tests de la classe.

### Configuration de ChromeDriver

Avant chaque test, WebDriverManager configure automatiquement une version compatible de ChromeDriver :

```java
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
```

Cette approche évite d’avoir à télécharger et configurer manuellement le fichier `chromedriver.exe`.

### Ouverture de l’application

Après le démarrage de Chrome, Selenium accède à l’application :

```java
driver.get("http://localhost:8080/");
```

### Attente du chargement

Une attente est utilisée afin de laisser le temps à l’application de charger son contenu :

```java
driver.manage()
      .timeouts()
      .implicitlyWait(10, TimeUnit.SECONDS);
```

Une attente explicite vérifie également que le titre est visible :

```java
WebDriverWait wait = new WebDriverWait(driver, 60);

wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("title"))
);
```

### Fermeture du navigateur

Après chaque test, le navigateur est fermé :

```java
@AfterEach
public void tearDown() {
    driver.close();
}
```

Après tous les tests, le serveur est arrêté :

```java
@AfterAll
public static void tearDownAfterClass() throws Exception {
    server.destroy();
}
```

---

## Scénarios automatisés

### Test 1 — Vérification du titre

Le premier test vérifie que le titre principal de l’application correspond au texte attendu.

```java
@Test
void test1() {
    WebElement element = driver.findElement(By.id("title"));

    String expected = "YAMAZONE BookStore";
    String actual = element.getText();

    assertEquals(expected, actual);
}
```

Le test effectue les opérations suivantes :

1. trouve l’élément ayant l’identifiant `title`;
2. récupère le texte affiché;
3. compare ce texte à `YAMAZONE BookStore`;
4. réussit si les deux valeurs sont identiques.

### Test 2 — Vérification du changement de langue

Le deuxième test vérifie que l’interface peut être changée de l’anglais vers le français.

```java
@Test
public void test2() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));

    String expected = "Welcome";
    String actual = welcome.getText();

    assertEquals(expected, getWords(actual)[0]);

    WebElement langSelector =
        driver.findElement(By.id("locales"));

    langSelector.click();

    WebElement frSelector =
        driver.findElement(By.cssSelector("option:nth-child(3)"));

    frSelector.click();

    welcome = driver.findElement(By.cssSelector("p"));

    expected = "Bienvenu";
    actual = welcome.getText();

    assertEquals(expected, getWords(actual)[0]);
}
```

Le test effectue les opérations suivantes :

1. récupère le message d’accueil;
2. vérifie que son premier mot est `Welcome`;
3. trouve le sélecteur de langue avec l’identifiant `locales`;
4. ouvre la liste déroulante;
5. sélectionne l’option française;
6. récupère le nouveau message d’accueil;
7. vérifie que son premier mot est maintenant `Bienvenu`.

### Méthode de séparation des mots

La méthode suivante est utilisée pour diviser le texte en mots :

```java
private String[] getWords(String s) {
    return s.split("\\s+");
}
```

Cela permet au test de comparer seulement le premier mot du message d’accueil.

---

## Exécution des tests

Les tests peuvent être exécutés depuis le dossier `BookstoreApp` avec :

```powershell
mvn test
```

Pendant l’exécution :

1. Maven analyse le projet;
2. le code principal est compilé;
3. les fichiers de tests sont compilés;
4. le test JUnit `ExampleTest` est exécuté;
5. l’application BookstoreApp est démarrée;
6. ChromeDriver ouvre Google Chrome;
7. Selenium effectue les interactions;
8. les assertions JUnit vérifient les résultats;
9. Chrome est fermé;
10. Maven affiche le résumé final.

---

## Résultats

L’exécution finale a produit les résultats suivants :

```text
Tests run: 3
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

La suite exécutée comprend :

- un test JUnit dans `ExampleTest`;
- deux tests Selenium dans `ExampleSeleniumTest`.

Les deux tests Selenium ont validé :

- le titre principal de l’application;
- le changement de langue de l’anglais vers le français.

Tous les tests se sont terminés sans échec ni erreur.

![Résultats des tests Selenium](images/Lab6_7_TestWork.PNG)

---

## Avertissement SLF4J

Pendant l’exécution des tests, les messages suivants peuvent apparaître :

```text
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation logger implementation.
```

Ces messages sont des avertissements liés au système de journalisation SLF4J.

Ils ne représentent pas un échec des tests et n’empêchent pas Selenium ou ChromeDriver de fonctionner.

Le résultat important est le résumé Maven :

```text
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

## Difficultés rencontrées

### Maven non reconnu

Au début du laboratoire, la commande suivante n’était pas reconnue :

```powershell
mvn
```

Le problème a été réglé en installant Apache Maven et en ajoutant son dossier `bin` à la variable d’environnement `PATH`.

La configuration finale utilisée est :

```text
Apache Maven 3.9.16
```

### Port 8080 déjà utilisé

Lors du premier lancement, le port 8080 était déjà utilisé par un serveur Apache nommé `httpd`.

Au lieu de l’application YAMAZONE, le navigateur affichait une page EDB Postgres avec le message :

```text
Server is up and running.
```

Le processus utilisant le port a été identifié avec :

```powershell
Get-NetTCPConnection -LocalPort 8080 -State Listen
```

La commande a retourné le PID du processus.

Le programme correspondant a ensuite été identifié avec :

```powershell
Get-Process -Id <PID>
```

Le processus détecté était :

```text
httpd
```

Après avoir arrêté ce processus, le port 8080 est devenu disponible pour BookstoreApp.

### Sortie du processus enfant non visible

Le fichier `App.java` démarre `bookstore5.jar` avec `ProcessBuilder` :

```java
ProcessBuilder pb =
    new ProcessBuilder("java", "-jar", "bookstore5.jar");

Process p = pb.start();
```

Cependant, la sortie du processus enfant n’était pas automatiquement affichée dans le terminal.

Le programme affichait seulement :

```text
Press Enter to stop server
```

Pour vérifier correctement le démarrage de Spring Boot, le fichier `bookstore5.jar` a donc été lancé directement :

```powershell
java -jar .\bookstore5.jar
```

Cette méthode a permis de voir les messages de Tomcat et de confirmer que le serveur écoutait sur le port 8080.

### Compatibilité de ChromeDriver

Une ancienne version de ChromeDriver n’était pas compatible avec la version installée de Google Chrome.

L’utilisation de WebDriverManager a réglé le problème :

```java
WebDriverManager.chromedriver().setup();
```

WebDriverManager télécharge et configure automatiquement une version de ChromeDriver compatible avec le navigateur.

### Délai de démarrage du serveur

Spring Boot nécessite quelques secondes pour initialiser :

- Tomcat;
- Hibernate;
- la base de données H2;
- Spring Security;
- les contrôleurs Web.

Si Selenium tente d’accéder immédiatement à `localhost:8080`, une erreur semblable à la suivante peut apparaître :

```text
net::ERR_CONNECTION_REFUSED
```

Il faut donc s’assurer que le serveur est complètement démarré avant de lancer les interactions Selenium.

---

## Commandes principales

### Vérifier Java

```powershell
java -version
```

### Vérifier Maven

```powershell
mvn -version
```

### Aller dans le dossier du projet

```powershell
cd "C:\Users\ttvpu\OneDrive\Documents\GitHub\seg3503_playground-\Lab6_7\BookstoreApp"
```

### Compiler le projet

```powershell
mvn clean compile
```

### Générer le fichier JAR

```powershell
mvn package -DskipTests
```

### Afficher le contenu du dossier target

```powershell
dir .\target
```

### Démarrer l’application

```powershell
java -jar .\bookstore5.jar
```

### Exécuter les tests

```powershell
mvn test
```

### Vérifier le port 8080

```powershell
Get-NetTCPConnection -LocalPort 8080 -State Listen
```

### Identifier un processus

```powershell
Get-Process -Id <PID>
```

---

## Conclusion

Ce laboratoire a permis de mettre en pratique les tests d’acceptation automatisés avec Selenium WebDriver.

Le projet a permis de :

- configurer un environnement Java et Maven;
- compiler un projet Maven;
- générer un fichier JAR;
- démarrer une application Spring Boot;
- utiliser un serveur Tomcat intégré;
- configurer ChromeDriver avec WebDriverManager;
- ouvrir automatiquement Google Chrome;
- localiser des éléments avec `By.id()` et `By.cssSelector()`;
- cliquer sur des éléments de l’interface;
- sélectionner une langue;
- récupérer le texte affiché dans une page;
- vérifier les résultats avec des assertions JUnit;
- exécuter automatiquement les tests avec Maven.

L’exécution finale a confirmé que les tests présents dans le projet fonctionnaient correctement :

```text
Tests run: 3
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

Les résultats démontrent que Selenium WebDriver a pu ouvrir l’application, vérifier son titre et valider le changement de langue de l’anglais vers le français.
