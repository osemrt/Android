Up to now, we have assumed that every declaration of a variable causes
the compiler to allocate memory for the variable. However, memory allo cation is produced by only one type of declaration, called a definition.
Global variables permit a second type of declaration, which we call an
allusion. An allusion looks just like a definition, but instead of allocating
memory for a variable, it informs the compiler that a variable of the speci-
fied type exists but is defined elsewhere. In fact, we have already used allu-
sions in some of our examples to declare functions defined elsewhere. For
example,

```C
main()
{
extern int f(); /* Allusion to f() */
extern float g(); /* Allusion to g() */
.
.
.
```

Global variables follow the same rules as functions. Whenever you
want to use global variables defined in another file , you need to declare
them with allusions. For example, the following program contains allu-
sions to j and array_ofJ[].

```C
void func()
{
extern int j; /* An allusion */
extern float array_of_f[l; /* An allusion */
.
.
.
```

The extern keyword tells the compiler that the variables are defined
elsewhere. The purpose of the allusion is to enable the compiler to perform
type checking. For any global variable, there may be any number of allusions 
but only one definition among the source files making up the program. The 
rules for creating definitions and allusions are one of the least
standardized features of the C language because they involve not just the
C compiler, but the linker and loader as well. This section describes the
ANSI rules. The shaded box on page 224 describes two other common
strategies. To define a global variable according to the ANSI Standard, you need
to make a declaration with an initializer outside a function. The presence
or absence of the extern keyword has no effect. For instance, the following
code defines two global variables and one local variable, and alludes to
one global variable:

```C
int j=O; /* Global Definition */
extern float x = 1.0; /* Global Definition */
func()
{
int k = 0; /* Local Definition */
extern int j; /* Allusion to global variable */
.
.
.
```

If you omit an initializer, the compiler produces either an allusion (if
extern is specified) or a tentative definition (if extern is not present). A
tentative definition is a declaration that can become either a definition or
an allusion depending on what the remainder of the source file contains. If
no real definition for the variable occurs (i.e., one with an initializer) in the
remainder of the source file, the tentative definition becomes a real defini-
tion, initialized to zero. Otherwise, if there is a real definition in the source
file, the tentative definition becomes an allusion. In the following example,
j is a tentative definition that becomes an allusion, and k is a tentative
definition that becomes a real definition.

```C
int j; /* Tentative Definition */
int k; /* Tentative Definition */
f()
{
int j 1; /* Real definition of j makes the
	  * tentative definition an allusion.
	  * There is no real definition of k,
	  * so the tentative definition becomes
  	  * a real definition.
	  */

```

Typically, you put all allusions in a header file, which can be included
in other source files. This ensures that all source files use consistent allu-
sions. Any change to a declaration in a header file is automatically propa-
gated to all source files that include that header file.
