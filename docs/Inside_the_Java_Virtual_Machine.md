## What is a Java Virtual Machine? 

To understand the Java virtual machine you must first be aware that you may be talking about any of three different things when you say "Java virtual machine." You may be speaking of: 

* the abstract specification
* a concrete implementation
* a runtime instance

The abstract specification is a concept, described in detail in the book: The Java Virtual Machine Specification, by Tim Lindholm and Frank Yellin. Concrete implementations, which exist on many platforms and come from many vendors, are either all software or a combination of hardware and software. A runtime instance hosts a single running Java application. 

## The Lifetime of a Java Virtual Machine

A runtime instance of the Java virtual machine has a clear mission in life: to run one Java application. When a Java application starts, a runtime instance is born. When the application completes, the instance dies. If you start three Java applications at the same time, on the same computer, using the same concrete implementation, you'll get three Java virtual machine instances. Each Java application runs inside its own Java virtual machine. 

A Java virtual machine instance starts running its solitary application by invoking the main() method of some initial class. The main() method must be public, static, return void, and accept one parameter: a String array. Any class with such a main() method can be used as the starting point for a Java application. 

For example, consider an application that prints out its command line arguments: 
~~~
class Echo {

    public static void main(String[] args) {
        int len = args.length;
        for (int i = 0; i < len; ++i) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }
}
~~~

## The Architecture of the Java Virtual Machine

In the Java virtual machine specification, the behavior of a virtual machine instance is described in terms of subsystems, memory areas, data types, and instructions. These components describe an abstract inner architecture for the abstract Java virtual machine. The purpose of these components is not so much to dictate an inner architecture for implementations. It is more to provide a way to strictly define the external behavior of implementations. The specification defines the required behavior of any Java virtual machine implementation in terms of these abstract components and their interactions.

The below figure shows a block diagram of the Java virtual machine that includes the major subsystems and memory areas described in the specification, each Java virtual machine has a class loader subsystem: a mechanism for loading types (classes and interfaces) given fully qualified names. Each Java virtual machine also has an execution engine: a mechanism responsible for executing the instructions contained in the methods of loaded classes. 

The internal architecture of the Java virtual machine:
![The internal architecture of the Java virtual machine](img/fig1-1.gif)

When a Java virtual machine runs a program, it needs memory to store many things, including bytecodes and other information it extracts from loaded class files, objects the program instantiates, parameters to methods, return values, local variables, and intermediate results of computations. The Java virtual machine organizes the memory it needs to execute a program into several runtime data areas. 

Although the same runtime data areas exist in some form in every Java virtual machine implementation, their specification is quite abstract. Many decisions about the structural details of the runtime data areas are left to the designers of individual implementations. 

Different implementations of the virtual machine can have very different memory constraints. Some implementations may have a lot of memory in which to work, others may have very little. Some implementations may be able to take advantage of virtual memory, others may not. The abstract nature of the specification of the runtime data areas helps make it easier to implement the Java virtual machine on a wide variety of computers and devices. 

Some runtime data areas are shared among all of an application's threads and others are unique to individual threads. Each instance of the Java virtual machine has one method area and one heap. These areas are shared by all threads running inside the virtual machine. When the virtual machine loads a class file, it parses information about a type from the binary data contained in the class file. It places this type information into the method area. As the program runs, the virtual machine places all objects the program instantiates onto the heap. See below figure for a graphical depiction of these memory areas.

Runtime data areas shared among all threads:
![Runtime data areas shared among all threads](img/fig1-2.gif)

As each new thread comes into existence, it gets its own pc register (program counter) and Java stack. If the thread is executing a Java method (not a native method), the value of the pc register indicates the next instruction to execute. A thread's Java stack stores the state of Java (not native) method invocations for the thread. The state of a Java method invocation includes its local variables, the parameters with which it was invoked, its return value (if any), and intermediate calculations. The state of native method invocations is stored in an implementation-dependent way in native method stacks, as well as possibly in registers or other implementation-dependent memory areas. 

The Java stack is composed of stack frames (or frames). A stack frame contains the state of one Java method invocation. When a thread invokes a method, the Java virtual machine pushes a new frame onto that thread's Java stack. When the method completes, the virtual machine pops and discards the frame for that method. 

The Java virtual machine has no registers to hold intermediate data values. The instruction set uses the Java stack for storage of intermediate data values. This approach was taken by Java's designers to keep the Java virtual machine's instruction set compact and to facilitate implementation on architectures with few or irregular general purpose registers. In addition, the stack-based architecture of the Java virtual machine's instruction set facilitates the code optimization work done by just-in-time and dynamic compilers that operate at run-time in some virtual machine implementations. 

See below figure for a graphical depiction of the memory areas the Java virtual machine creates for each thread. These areas are private to the owning thread. No thread can access the pc register or Java stack of another thread. 

Runtime data areas exclusive to each thread:
![Runtime data areas exclusive to each thread](img/fig1-3.gif)

Above figure shows a snapshot of a virtual machine instance in which three threads are executing. At the instant of the snapshot, threads one and two are executing Java methods. Thread three is executing a native method. In the figure, the stacks are shown growing downwards. The "top" of each stack is shown at the bottom of the figure. Stack frames for currently executing methods are shown in a lighter shade. For threads that are currently executing a Java method, the pc register indicates the next instruction to execute. In above figure, such pc registers (the ones for threads one and two) are shown in a lighter shade. Because thread three is currently executing a native method, the contents of its pc register--the one shown in dark gray--is undefined.

## Data Types

The Java virtual machine computes by performing operations on certain types of data. Both the data types and operations are strictly defined by the Java virtual machine specification. The data types can be divided into a set of primitive types and a reference type. Variables of the primitive types hold primitive values, and variables of the reference type hold reference values. Reference values refer to objects, but are not objects themselves. Primitive values, by contrast, do not refer to anything. They are the actual data themselves. You can see a graphical depiction of the Java virtual machine's families of data types in below figure.

Data types of the Java virtual machine:
![Data types of the Java virtual machine](img/fig1-4.gif)

All the primitive types of the Java programming language are primitive types of the Java virtual machine. Although boolean qualifies as a primitive type of the Java virtual machine, the instruction set has very limited support for it. When a compiler translates Java source code into bytecodes, it uses ints or bytes to represent booleans. In the Java virtual machine, false is represented by integer zero and true by any non-zero integer. Operations involving boolean values use ints. Arrays of boolean are accessed as arrays of byte, though they may be represented on the heap as arrays of byte or as bit fields. 

The primitive types of the Java programming language other than boolean form the numeric types of the Java virtual machine. The numeric types are divided between the integral types: byte, short, int, long, and char, and the floating- point types: float and double. As with the Java programming language, the primitive types of the Java virtual machine have the same range everywhere. A long in the Java virtual machine always acts like a 64-bit signed twos complement number, independent of the underlying host platform. 

The Java virtual machine works with one other primitive type that is unavailable to the Java programmer: the returnAddress type. This primitive type is used to implement finally clauses of Java programs. 

The reference type of the Java virtual machine is cleverly named reference. Values of type reference come in three flavors: the class type, the interface type, and the array type. All three types have values that are references to dynamically created objects. The class type's values are references to class instances. The array type's values are references to arrays, which are full-fledged objects in the Java virtual machine. The interface type's values are references to class instances that implement an interface. One other reference value is the null value, which indicates the reference variable doesn't refer to any object. 

The Java virtual machine specification defines the range of values for each of the data types, but does not define their sizes. The number of bits used to store each data type value is a decision of the designers of individual implementations. The ranges of the Java virtual machines data type's are shown in below table.

| **Type** | **Range** |
|:-----------|:-----------|
|byte          |8-bit signed two's complement integer (-27 to 27 - 1, inclusive)    |
|short         |16-bit signed two's complement integer (-215 to 215 - 1, inclusive) |
|int           |32-bit signed two's complement integer (-231 to 231 - 1, inclusive) |
|long          |64-bit signed two's complement integer (-263 to 263 - 1, inclusive  |
|char          |16-bit unsigned Unicode character (0 to 216 - 1, inclusive)         |
|float         |32-bit IEEE 754 single-precision float                              |
|double        |64-bit IEEE 754 double-precision float                              |
|returnAddress |address of an opcode within the same method                         |
|reference     |reference to an object on the heap, or null                         |

## Word Size

The basic unit of size for data values in the Java virtual machine is the word--a fixed size chosen by the designer of each Java virtual machine implementation. The word size must be large enough to hold a value of type byte, short, int, char, float, returnAddress, or reference. Two words must be large enough to hold a value of type long or double. An implementation designer must therefore choose a word size that is at least 32 bits, but otherwise can pick whatever word size will yield the most efficient implementation. The word size is often chosen to be the size of a native pointer on the host platform. 

The specification of many of the Java virtual machine's runtime data areas are based upon this abstract concept of a word. For example, two sections of a Java stack frame--the local variables and operand stack-- are defined in terms of words. These areas can contain values of any of the virtual machine's data types. When placed into the local variables or operand stack, a value occupies either one or two words. 

As they run, Java programs cannot determine the word size of their host virtual machine implementation. The word size does not affect the behavior of a program. It is only an internal attribute of a virtual machine implementation. 

## The Method Area

Inside a Java virtual machine instance, information about loaded types is stored in a logical area of memory called the method area. When the Java virtual machine loads a type, it uses a class loader to locate the appropriate class file. The class loader reads in the class file--a linear stream of binary data--and passes it to the virtual machine. The virtual machine extracts information about the type from the binary data and stores the information in the method area. Memory for class (static) variables declared in the class is also taken from the method area. 

[http://www.artima.com/insidejvm/ed2/jvm5.html]http://www.artima.com/insidejvm/ed2/jvm5.html()
 
