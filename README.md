# jmh
Playing around with jmh

# Build

    git clone https://github.com/jeremyrixon/jmh.git
    cd jmh/test
    mvn clean package

# Run
    
    java -jar target/benchmarks.jar 
    
Fewer iterations for the impatient:

    java -jar target/benchmarks.jar -wi 3 -f 3 -i 5
    
Try turning off JIT optimisations. For example, turn **OFF** UseSuperWord:

    java -XX:+UseSuperWord -jar target/benchmarks.jar

Try logging asm (needs hsdis built for your arch).
(See https://github.com/AdoptOpenJDK/jitwatch/wiki/Building-hsdis)
    
    java -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation -XX:+PrintAssembly  -jar target/benchmarks.jar -wi 3 -f 3 -i 5

# JITWatch

JITWatch makes it easier.

    git clone https://github.com/AdoptOpenJDK/jitwatch.git
    cd jitwatch
    mvn clean compile exec:java

Because reasons, create a new log file for jitwatch using zero forks:

    java -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation -XX:+PrintAssembly  -jar target/benchmarks.jar -wi 3 -f 0 -i 5

Hit the "Config" button to add source and class files for the benchmark project.
Hit the "Open Log" button to read the log.
Hit the "Start" button to go.

# This project was created using the following maven archetype:

    $ mvn archetype:generate \
          -DinteractiveMode=false \
          -DarchetypeGroupId=org.openjdk.jmh \
          -DarchetypeArtifactId=jmh-java-benchmark-archetype \
          -DgroupId=org.rixon \
          -DartifactId=test \
          -Dversion=1.0


# Related links:

http://java-performance.info/jmh/

http://openjdk.java.net/projects/code-tools/jmh/

http://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html

