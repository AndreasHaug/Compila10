all:
	gradle build
	unzip app/build/distributions/app.zip -d Compiler/
	cp app/src/test/resources/fullprograms/runme.cmp Compiler/app/bin/
	cp app/src/test/resources/fullprograms/euclid.cmp Compiler/app/bin/
	cp app/src/test/resources/fullprograms/plog.cmp Compiler/app/bin/

clean:
	gradle clean
