## What's this ##

Primary purpose of this document is to use lib illustrate JVM crash, we also use a very simple HelloWorld c language to show how to use java code call c method.

## Prerequisite ##

* JAVA_HOME setting correct
* JBoss install correct

## Step for run com.kylin.jvm.jni.HelloJNI ##

* compile HelloJNI.c to libhello.so via gcc
    gcc -I"/usr/java/jdk1.6.0_31/include" -I"/usr/java/jdk1.6.0_31/include/linux" -shared -o libhello.so HelloJNI.c
* run java application
    java -cp ./target/classes -Djava.library.path=/home/kylin/work/project/JVM/sandbox/lab-crash/native com.kylin.jvm.jni.HelloJNI

## Step for run com.kylin.jvm.lab.TestClassRunner ##

* compile TestJniImpl.c to libTestJniImpl.so
    gcc -I"/usr/java/jdk1.6.0_31/include" -I"/usr/java/jdk1.6.0_31/include/linux" -shared -o libTestJniImpl.so TestJniImpl.c

* run java application
    java -cp ./target/classes -Djava.library.path=/home/kylin/work/project/JVM/sandbox/lab-crash/native com.kylin.jvm.lab.TestClassRunner

## Step to show JBoss crash ##

* use maven build lab-crash project

* deploy war to JBoss
    cp ./target/jvm-lab-crash-1.0.war /home/kylin/work/eap/jboss-eap-5.1/jboss-as/server/default/deploy

* modify run.conf add 
     -Djava.library.path=/home/kylin/work/project/JVM/sandbox/lab-crash/native

* start JBoss, log to http://localhost:8080/jvm-lab-crash-1.0, click submit button.

* the following info will show:
    #
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGFPE (0x8) at pc=0xb6a0648f, pid=14386, tid=1357376368
#
# JRE version: 6.0_31-b04
# Java VM: Java HotSpot(TM) Server VM (20.6-b01 mixed mode linux-x86 )
# Problematic frame:
# C  [libTestJniImpl.so+0x48f]  Java_com_kylin_jvm_lab_TestClass_printHello+0x17
#
# An error report file with more information is saved as:
# /home/kylin/work/eap/jboss-eap-5.1/jboss-as/bin/hs_err_pid14386.log
#
# If you would like to submit a bug report, please visit:
#   http://java.sun.com/webapps/bugreport/crash.jsp
# The crash happened outside the Java Virtual Machine in native code.
# See problematic frame for where to report the bug.
#
./run.sh: line 284: 14386 Aborted                 (core dumped) "/usr/java/jdk1.6.0_31/bin/java" -Dprogram.name=run.sh -server -Xms1303m -Xmx1303m -XX:MaxPermSize=256m -Djava.library.path=/home/kylin/work/project/JVM/sandbox/lab-crash/native -Dorg.jboss.resolver.warning=true -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.dgc.server.gcInterval=3600000 -Dsun.lang.ClassLoader.allowArraySyntax=true -Djava.net.preferIPv4Stack=true -Djava.endorsed.dirs="/home/kylin/work/eap/jboss-eap-5.1/jboss-as/lib/endorsed" -classpath "/home/kylin/work/eap/jboss-eap-5.1/jboss-as/bin/run.jar:/usr/java/jdk1.6.0_31/lib/tools.jar" org.jboss.Main -c default

