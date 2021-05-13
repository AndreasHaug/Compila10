# Tests
The tests are written as junit tests and are located in
[app/src/test/](app/src/test/). They are there for testing of lexing, parsing and
semantic analysis. These tests can be run with
```shell
gradle test
```
(if gradle installed)
or
```shell
./gradlew test
```
or
```shell
make test
```
The tests will also generate AST-representation located in app/src/test/resources.


As the output from the runme.cmp it is listed as
follows:
```shell
[andreas@Andreas:Compiler/bin]$ ./Compila runme.cmp
6.48074
7
TestNavn
Real 4.0
Imag 6.0
skriv v1
9
skriv v2
4
Storst 9
Real 1.0
Imag 2.0
DONE
```
For the plog.cmp:
```shell
[andreas@Andreas:Compiler/bin]$ ./Compila plog.cmp
X        X
 X      X
  X    X
   X  X
    XX
```
euclid.cmp:
```shell
[andreas@Andreas:Compiler/bin]$ ./Compila euclid.cmp
1
3
37
```

