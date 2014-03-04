JVM Crash Use Cases
-------------------

| **Example Name** | **Description** |
|:-----------|:-----------|
|[JVM's GC thread cause JVM crash](hs_err_pid7292.log)|The crash is in the JVM's garbage collector thread and there are not native libraries loaded other than JDK and OS ones. This means the problem can only be a bug in the JVM (more likely) or the OS (less likely). There is not enough information to make any determination of any potential JDK bugs, all that we can really tell is that is crashed in GC-related code.|
