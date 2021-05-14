# Compila10
Compila is a small language running on JVM.

# Building
   This is a Gradle project and with Gradle installed it can be build with
   ```bash
   gradle build
   ```
   Note: Gradle version > 7 will not work at the moment.
   
   Without Gradle, build with the wrapper script
   ```bash
   ./gradlew build
   ```
   The provided makefile can also be used to build with
   ```bash
   make
   ```
   The make command will also for convenience put the executable named
   Compila in Compiler/bin/ together with some code testfiles. The
   compiler can from here be run with
   ```bash
   ./Compila <filename>
   ```

# Tests
[Tests](/TESTS.md)
# Code structure
[Code structure](/CODESTRUCTURE.md)
