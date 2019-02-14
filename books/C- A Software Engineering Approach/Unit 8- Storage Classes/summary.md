
## The Dual Meanings of static
One of the most confusing aspects about storage-class declarations in C
i that the static keyword seems to have twO effects depending on where
it appears. In a declaration within a block, static gives a variable fixed
duration instead of automatic duration. Outside a function, on the
other hand, static has nothing to do with duration. Rather, it controls
the scope of a variable, giving it file cope instead of program scope.
One way of reconciling these dual meanings is to think of static as
signifying both file scoping and fixed duration. Within a block, the
stricter block scoping rules override static's file scoping, so fixed dura-
tion is the only manifest result. Outside a function, duration i already
fixed, so file scoping is the only manifest result.

## Using Variables with Fixed Duration
A common use of fixed variables is to keep track of how many times a
function is invoked and to change the function's execution at regular in-
tervals. As an example, suppose you have a program that formats an input
text file and writes the formatted output to another file. One of the func-
tions in the program is print_header(), called at the beginning of each new
page. However, you want it to write a different header depending on
whether the page is even-numbered or odd-numbered. The following ver-
sion shows a possible solution that makes use of a fixed variable.

```C
#define ODD 0
#define EVEN 1
print_header( char *chap_title ){

  static char page_type = ODD ;
  
  if (page_type == ODD){
  printf ( n\t\t\t\t\s\n\n", chap_title);
  page_type = EVEN;}
  
  else
  {
  printf ( "\5\n\n" , chap_title);
  page_type = ODD;}
  
 }

```

The variable page_type acts as a toggle switch, alternating between ODD and EVEN. When the page number is odd, the function prints the
string pointed to by chap _title on the right side of the page; when the page is even, the chap_title string appears on the left side. Note that the program depends on page_type having fixed duration. If page_type had automatic duration, it would get reinitialized to zero with each invocation and the function would always print odd-numbered headers.


## differences between automatic and fixed duration

* an automatic variable, when declared with an initializer, is reinitialized every time its block is reentered; a fixed variable is initialized only once at program start-up time.

* automatic and fixed variables is that automatic variables are not initialized by default whereas fixed variables get a default initial value of zero.

-----

- A variable declared within a block has block scope. Such a variable is also called a local variable and is only visible within the block
- The goto label has function scope, which means that it is visible through the whole block of the function within which the label is placed. No two goto labels share the same name within a function block.
- A variable declared with the static specifier outside a function has file scope, which means that it is visible throughout the entire source file in which the variable is declared.
- A variable declared outside a function is said to have program scope. Such a variable is also called a global variable. A global variable is visible in all source files that make up an executable program.
- A variable with block scope has the most limited visibility. On the other hand, a variable with program block is the most visible through all files, functions, and other blocks that make up the program.
- The storage class of a variable refers to the combination of its spatial and temporal regions (that is, its scope and duration.)
- By default, a variable with block scope has an auto duration, and its memory storage is temporary.
- A variable declared with the static specifier has permanent memory storage, even though the function in which the variable is declared has been called and the function scope has exited.
- A variable declared with the register specifier may be stored in a register to speed up the performance of a program; however, the compiler can ignore the specifier if there is no register available or if some other restrictions have to apply.
- You can also allude to a global variable defined elsewhere by using the extern specifier from the current source file.
- To make sure the value saved by a variable cannot be changed, you can declare the variable with the const modifier.
- If you want to let the compiler know that the value of a variable can be changed without an explicit assignment statement, declare the variable with the volatile modifier so that the compiler will turn off optimizations on expressions involving the variable.
- In the next lesson you'll learn about function declarations and prototypes in C.
- function parameters have block scope. They are treated as if they are the first declarations in the top-level block.
- The C language allows you to give two variables the same name, provided they have different scopes. For example, the two functions below both use a variable called j, but because they are declared in different blocks, they do not conflict.

```C
func1 ()
  {
  int j;
  .
  .
  .}
func2 ()
  {
  int j;
  .
  .
  .}
```

- It is also possible for variables with the same name to have different scopes that overlap. In this event, the variable with the smaller scope temporarily "hides" the other variable

```C
int j=10; /* Program scope */
int main( void)
{
int j; /* Block scope hides j at program scope */
for (j=O; j < 5; ++j)
  printf( "j: \n", j); // 0 1 2 3 4 
} // The j with program scope retains its value of 10.
```

## Q&A


Q Can a global variable be hidden by a local variable with block scope?

A Yes. If a local variable shares the same name with a global variable, the global

variable can be hidden by the local variable for the scope of the block within which the local variable is defined with block scope. However, outside the block, the local variable cannot be seen, but the global variable becomes visible again.

Q Why do you need the static specifier?

A In many cases, the value of a variable is needed, even if the scope of the block, in which the variable is declared, has exited. By default, a variable with block scope has a temporary memory storage—that is, the lifetime of the variable starts when the block is executed and the variable is declared, and ends when the execution is finished. Therefore, to declare a variable with permanent duration, you have to use the static specifier to indicate to the compiler that the memory location of the variable and the value stored in the memory location should be retained after the execution of the block.

Q Does using the register specifier guarantee to improve the performance of a program?

A Not really. Declaring a variable with the register specifier only suggests to the compiler that the variable be stored in a register. But there is no guarantee that the variable will be stored in a register. The compiler can ignore the request based on the availability of registers or other restrictions.

Q When you declare a variable with the extern specifier, do you define the variable or allude to a global variable elsewhere?

A When a variable is declared with the extern specifier, the compiler considers the declaration of the variable as an allusion rather than a definition. The compiler will therefore look somewhere else to find a global variable to which the variable with extern alludes.
