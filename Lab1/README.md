| ## SEG3503 Lab1                                      |                                                        |
| ------------------------------------------------- | ------------------------------------------------------ |
| ## 300273106                                      | ## Erik Skjenna                                        |

# Laboratoire Java Newmath

Ce projet est un laboratoire Java simple qui sert à tester une classe `Newmath` en utilisant JUnit.

## Structure du projet

| Dossier/Fichier                                    | Description                                            |
| ------------------------------------------------- | ------------------------------------------------------ |
| `src/`                                            | Contient le code source Java principal                 |
| `src/Newmath.java`                                | Contient la classe `Newmath` et ses méthodes           |
| `test/`                                           | Contient les fichiers de test JUnit                    |
| `test/NewmathTest.java`                           | Contient les tests unitaires pour la classe `Newmath`  |
| `bin/`                                            | Contient les scripts exécutables                       |
| `bin/run`                                         | Compile et exécute le programme principal             |
| `bin/test`                                        | Compile et exécute les tests JUnit                    |
| `lib/`                                            | Contient les bibliothèques externes `.jar`             |
| `lib/junit-platform-console-standalone-6.1.0.jar` | Lanceur de console JUnit standalone utilisé pour les tests |
| `dist/`                                           | Contient les fichiers `.class` compilés après l'exécution des scripts |

## Prérequis

| Prérequis | Version/Description                                                       |
| --------- | ------------------------------------------------------------------------- |
| Java JDK  | Java doit être installé et accessible à partir du terminal                |
| JUnit     | Le fichier `.jar` JUnit Platform Console Standalone doit être dans le dossier `lib/` |
| Git Bash  | Recommandé pour exécuter `bin/run` et `bin/test` sur Windows              |

## Comment compiler et exécuter

Pour exécuter le programme :

```bash
bin/run
````

Pour exécuter les tests :

```bash
bin/test
```

## Tests

Ce projet utilise JUnit pour tester la classe `Newmath`.

| Test                | Résultat attendu                |
| ------------------- | ------------------------------- |
| `Newmath.div(4, 2)` | Retourne `2`                    |
| `Newmath.div(4, 0)` | Lance une `ArithmeticException` |

## Exemple de `bin/test`

```bash
#!/bin/bash
set -e

mkdir -p dist

JUNIT_JAR="lib/junit-platform-console-standalone-6.1.0.jar"

javac -cp "$JUNIT_JAR:src" -d dist src/Newmath.java test/NewmathTest.java

java -jar "$JUNIT_JAR" execute --class-path dist --scan-class-path
```

## Notes

Si les tests affichent `0 tests found`, cela signifie généralement que le fichier de test n'a pas été compilé correctement ou que JUnit n'a pas été inclus dans le classpath.

Si vous voyez une erreur comme :

```text
package org.junit.jupiter.api does not exist
```

assurez-vous que le fichier `.jar` de JUnit existe dans le dossier `lib/` et que le script `bin/test` pointe vers le bon nom de fichier.
