| SEG3503 Lab1                                      |                                                        |
| ------------------------------------------------- | ------------------------------------------------------ |
| 300273106                                         | Erik Skjenna                                           |

# Newmath Java Lab

This project is a simple Java lab for testing a `Newmath` class using JUnit.

## Project Structure

| Folder/File                                       | Purpose                                                |
| ------------------------------------------------- | ------------------------------------------------------ |
| `src/`                                            | Contains the main Java source code                     |
| `src/Newmath.java`                                | Contains the `Newmath` class and its methods           |
| `test/`                                           | Contains the JUnit test files                          |
| `test/NewmathTest.java`                           | Contains unit tests for the `Newmath` class            |
| `bin/`                                            | Contains executable scripts                            |
| `bin/run`                                         | Compiles and runs the main program                     |
| `bin/test`                                        | Compiles and runs the JUnit tests                      |
| `lib/`                                            | Contains external `.jar` libraries                     |
| `lib/junit-platform-console-standalone-6.1.0.jar` | JUnit standalone console launcher used for testing     |
| `dist/`                                           | Contains compiled `.class` files after running scripts |

## Requirements

| Requirement | Version/Description                                                       |
| ----------- | ------------------------------------------------------------------------- |
| Java JDK    | Java must be installed and available from the terminal                    |
| JUnit       | JUnit Platform Console Standalone `.jar` must be inside the `lib/` folder |
| Git Bash    | Recommended for running `bin/run` and `bin/test` on Windows               |

## How to Compile and Run

To run the program:

```bash
bin/run
```

To run the tests:

```bash
bin/test
```

## Testing

This project uses JUnit to test the `Newmath` class.

| Test                | Expected Result              |
| ------------------- | ---------------------------- |
| `Newmath.div(4, 2)` | Returns `2`                  |
| `Newmath.div(4, 0)` | Throws `ArithmeticException` |

## Example `bin/test`

```bash
#!/bin/bash
set -e

mkdir -p dist

JUNIT_JAR="lib/junit-platform-console-standalone-6.1.0.jar"

javac -cp "$JUNIT_JAR:src" -d dist src/Newmath.java test/NewmathTest.java

java -jar "$JUNIT_JAR" execute --class-path dist --scan-class-path
```

## Notes

If the tests show `0 tests found`, it usually means the test file did not compile correctly or JUnit was not included in the classpath.

If you see an error like:

```text
package org.junit.jupiter.api does not exist
```

make sure the JUnit `.jar` file exists inside the `lib/` folder and that the `bin/test` script points to the correct file name.
