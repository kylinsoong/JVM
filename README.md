How to use CustomizedTools analysing Java thread dump?
======================================================

* clone CustomizedTools from https://github.com/kylinsoong/CustomizedTools
* build CustomizedTools according to CustomizedTools root `How to Build` docs
* navigate to `dist` (build generated), execute:
----
./cts.sh
----

select `samurai` tool, as below:

Select a tool:
  1. jarClassSearcher - search class from jar file
  2. fileSearcher - search file from defined folder
  3. fileChangeMonitor - monitor defined folder
  4. dbConnectionTester - test database connection
  5. samurai - Thread dump & gc log analysing tools
  6. jmsConnectionTester - test JMS connection
  7. smartAnalyser - can analyser JBoss log, configuring file, JVM gc log, thread dump, heap dump

Select: 1. jarClassSearcher 2. fileSearcher 3. fileChangeMonitor 4. dbConnectionTester 5. samurai 6. jmsConnectionTester 7. smartAnalyser 
[1]
5
You selected samurai, yes/no 
[yes]

then `samurai` UI will be pop out
