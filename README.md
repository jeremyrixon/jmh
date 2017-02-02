# jmh
Playing around with jmh

# Build and run

    git clone https://github.com/jeremyrixon/jmh.git
    cd jmh/test
    mvn clean install && java -jar target/benchmarks.jar

Try turning off JIT optimisations. For example:

    mvn clean install && java -XX:+UseSuperWord -jar target/benchmarks.jar

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

