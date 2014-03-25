JVM Crash Use Cases
-------------------

| **Name** | **Description** |
|:-----------|:-----------|
|[JVM's GC thread cause JVM crash](samples/hs_err_pid001)|The crash is in the JVM's garbage collector thread and there are not native libraries loaded other than JDK and OS ones. This means the problem can only be a bug in the JVM (more likely) or the OS (less likely). There is not enough information to make any determination of any potential JDK bugs, all that we can really tell is that is crashed in GC-related code.|
[JVM crash without more output log](samples/hs_err_pid002)|It's a JVM crash with no 3rd party DLLs loaded, which means it's almost certainly a JVM bug of some sort. It's always crashing in a HTTP thread, and with no dlls, that probably means either memory corruption or a JIT bug (generared not in the JIT compiler, there are no active compile tasks). The thread stack is corrupted, so that's no use. The problem is that the way the crash occurs, it is corrupting the thread information, so that it cannot be printed out. |
|[JVM crash due to Native memory allocation](samples/hs_err_pid003)|coming soon. |
