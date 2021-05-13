all:
	./gradlew build
	unzip app/build/distributions/app.zip -d Compiler/
	mv Compiler/app/bin/app Compiler/app/bin/Compila
	cp -r Compiler/app/* Compiler/
	rm -rf Compiler/app/
	cp app/src/test/resources/fullprograms/runme.cmp Compiler/bin/
	cp app/src/test/resources/fullprograms/euclid.cmp Compiler/bin/
	cp app/src/test/resources/fullprograms/plog.cmp Compiler/bin/
	cp app/src/test/resources/fullprograms/fib.cmp Compiler/bin/

clean:
	./gradlew clean
