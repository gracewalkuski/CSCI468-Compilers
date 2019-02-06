::This is the batch file that compiles all java files, and runs the java
::Driver file Builder.java with the four provided .micro files
java -jar ../lib/antlr-4.7.2-complete.jar LittleGrammar.g4

javac LittleGrammar*.java
javac Builder.java

java Builder ../inputs/sqrt.micro sqrt
java Builder ../inputs/fibonacci.micro fibonacci
java Builder ../inputs/loop.micro loop
java Builder ..//inputs/nested.micro nested

cmd /k