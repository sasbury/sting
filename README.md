Sting
=====

Sting is an interpreted stack-based programming language with an intermediate format designed for use
in genetic programming. Sting is based on languages like Forth, Postscript and Push. Sting programs consist of a serious of operations that manipulate the data stack or one of the built in data dictionaries. Internally, the Sting interpreter uses two stacks. The data stack which is manipulated by the operations and the execution stack
which is manipulated by the interpreter to execute a program.

All operations that cannot complete do to an inappropriate stack are treated as a no-op. All operations that access indexed memory will be floor'ed and modulo'ed to fit the available choices.

Before execution a program is compiled or created as an array of integers. Each integer encodes two pieces of information, an operation index and a depth. The operation indexes are created during compile time by assigning a unique index for each operation in the program. Terminals - or constants - are implemented as a simple push operation, so they two are indexed in this way.

Procedures are compiled in-line but have a depth setting 1 greater than the level they are defined in. So,

    1 1 add
    {
        1 1 minus
    }
    1 1 times

the second line is compiled to 3 operations, two that push the value of 1 onto the stack and one that subtracts. These all have a depth of 1. The other operations, 6 of them, have a depth of 0.

This intermediate format is designed to make it easy to perform genetic programming on a Sting program.

When asked to interpret a compiled program, the interpreter pushes the array of integers onto the execution stack. Then the interpreter begins taking a single element from the stack and executing it. The interpreter performs this operation at a specied depth, 0 for the main program. When integers at a "deeper" depth are encountered, they are collecting into an array, converted to a Procedure object and pushed on the data stack. When a procedure is executed, the interpreter is set to its depth so procedures can contain other procedures.

## Syntax ##

Sting uses white space to separate operations and values, but does not care about the white space specifically.
For example "a b" is equivalent to "a       b".

Procedures in Sting are distinguished by { and } as in Postscript and other languages. Arrays are indicated by [ and ].

## Data Types ##

Sting provides the following built in data types:

 * Number - a single precision floating point number
 * String - a string of characters
 * Array - an array of arrays, strings or floating point numbers, to be used as a vector or matrix
 * Procedure - a collection of statements used in a loop or conditional
 * IndexedMemory - number slots that can contain the other data types

*String and array are not fully implemented yet*

## Indexed Memory ##

Sting provides the following built in IndexMemory instances:

 * Input -  the input into a program
 * Output - the intended output from a program
 * Working - working data used by the program

## Operations ##

Sting provides the following extensible set of operations:

 * dup - duplicate the top item on the stack
 * swap - swap the top two items on the stack
 * pop - pop the top item off the stack
 * roll - (... n i roll) - rolls the previous n items on the stack i times, so (a b c 3 1 roll) -> (c a b)
 * copy - (... n copy) - copies the last N items on the stack, (a b c 2 copy) -> (a b c b c)
 * mark - creates a mark for the current stack size
 * cleartomark - clears the stack up to the last mark
 * plus - (a b plus) - adds two numbers, a+b
 * minus - (a b minus) - subtracts two numbers, a-b
 * times - (a b times) - multiplies two numbers, a*b
 * divide - (a b divide) - divides two numbers, a/b
 * modulo - (a b modulo) - takes the modulo of two numbers, a % b
 * floor - (a floor) - takes one number and finds the closest integer smaller than it
 * ceil - (a ceil) - takes one number and finds the closest integer bigger than it
 * abs - (a abs) - takes the absolute value of a number
 * neg - (a neg) - pops a number and pushes the negative of it
 * and - (a b and) - takes two numbers and returns 1 if they are both >0 and -1 if not (optimized)
 * or - (a b or) - takes two numbers and returns 1 if they either or both are >0 and -1 if not
 * xor - (a b xor) - takes two numbers and returns 1 if they either but not both is >0 and -1 if not
 * not - (a not) - takes one number and returns 1 if it is <=0 and -1 if not
 * input - puts the input indexed memory on the stack
 * output - puts the output indexed memory on the stack
 * working - puts the working indexed memory on the stack
 * read - (i mem read) - reads the i'th element in indexed memory or array instance mem and puts it on the stack
 * write - (b i mem read) - buts b in the i'th slot in an indexed memory or array
 * add - (b mem read) - adds b to the a new slot at the end of memory or array
 * clear - (i mem clear) - clear the i'th slot in memory or an array
 * size - (mem size) - pushes the number of slots in mem onto the stack
 * lock - (mem lock) - locks mem- fixing the size
 * unlock - (mem unlock) - unlocks mem
 * null - (null) - places a null value on the stack, generally for adding to indexed memory
 * ifeq - (a proc1 proc2 ifeq) - if a is equal to zero then proc1 is executed, otherwise proc2 is executed
 * ifgt - (a proc1 proc2 ifgt) - if a is greater than zero then proc1 is executed, otherwise proc2 is executed
 * loop - (a b proc loop) - loops over an index starting at a and ending at b (inclusive), executing proc for each loop
 * forall - (array proc forall) - loops over array pushing each element in turn onto the stack and executing proc, if proc is a noop, elements accumulate on the stack, for index memory the key and value are pushed onto the stack<\li>
 * index - push the current index for a loop on the stack, pushes 0 if not in a loop
 * noop - places a noop procedure on the stack
 * exec - (proc exec) - executes a procedure

## Compile/Use ##

To compile sting, you can use the ant build.xml file. But you will need to put junit.jar in a lib folder, or update the build.xml appropriately for your system.

To use String, you can compile and execute a program as follows:

	StingProgram program = new StingProgram(getProgram());
	ExecutionContext context = program.execute();

	... do something with the results ... context.getStack()

