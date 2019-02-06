::This is the batch file that compiles all java files, and runs the java
::Driver file Builder.java with the four provided .micro files

javac Builder.java
java Builder ../inputs/sqrt.micro
java Builder ../inputs/fibonacci.micro
java Builder ../inputs/loop.micro
java Builder ..//inputs/nested.micro

cmd /k