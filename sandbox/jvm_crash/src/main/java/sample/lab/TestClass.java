package sample.lab;

public class TestClass {
    static {
        System.loadLibrary("TestJniImpl");
    }

    public TestClass() {
    }

    public static native void printHello();
}
