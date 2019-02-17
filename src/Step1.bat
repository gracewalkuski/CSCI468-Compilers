::This is the batch file that compiles all java files, and runs the java
::Driver file Step1.java with the four provided .micro files
SET CLASSPATH=.;../lib/antlr-4.7.2-complete.jar;%CLASSPATH%
java -jar ../lib/antlr-4.7.2-complete.jar -o ../gen LittleGrammar.g4

javac -d ../gen Step1.java ../gen/LittleGrammar*.java

cd ../gen

java Step1 ../inputs/sqrt.micro sqrt
java Step1 ../inputs/fibonacci.micro fibonacci
java Step1 ../inputs/loop.micro loop
java Step1 ../inputs/nested.micro nested

cmd /k
