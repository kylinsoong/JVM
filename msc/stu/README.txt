1. How to build?
  mvn clean dependency:copy-dependencies install 
  ant

2. How to run?
  java -jar jboss-modules-1.1.2.GA.jar -mp "/home/kylin/work/project/JVM/msc/helloworld/build/helloworld/modules" com.kylin.msc.boot
