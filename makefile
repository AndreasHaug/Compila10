all:
	./gradlew build
	unzip app/build/distributions/app.zip -d Compiler/
	mv Compiler/app/bin/app Compiler/app/bin/Compila
	cp app/src/test/resources/fullprograms/runme.cmp Compiler/app/bin/
	cp app/src/test/resources/fullprograms/euclid.cmp Compiler/app/bin/
	cp app/src/test/resources/fullprograms/plog.cmp Compiler/app/bin/
	cp app/src/test/resources/fullprograms/fib.cmp Compiler/app/bin/

clean:
	./gradlew clean
