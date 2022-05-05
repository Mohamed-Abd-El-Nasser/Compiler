# java-compiler

## Project description
The objective of this project is to take a java file and then generate an intermediate java file with injected java statements, when running this file it prints out which blocks are executed and which are not, another output is an HTML for the input java file with highlighted green parts indicating the executed code and highlighted red parts indicating the code that does not execute.

## Starting rule

```antlr
compilationUnit
: packageDeclaration? importDeclaration* typeDeclaration*
| moduleDeclaration EOF
;
```

## Example program

```java

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

```

## Parse tree

![Parse tree](/images/parseTree.png)

## Complete example

## Test1 code

```java

package Test;
public class Test1 {
    public static void main(String[] args) throws Exception{
        int x=1;
        int y=2;
        if (x>0) {
            if (x == 2)
                System.out.println("IF Block");
        }
        else
                if (y==2)
                    System.out.println("IF Block");
        switch(x) {
            case 5:
                System.out.println("This is a 5");
                break;
            case 1:
                System.out.println("This is a 10");
                break;
        }
        for(int i = 0 ; i<5;i++) {
            for (int j = 0; j < 5; j++)
                if (x > 0)
                    System.out.println("If operations");
                else {
                    System.out.println("Else block");
                }
        }
        int z = 0;
        while (z < 5) {
            if(y==5)
                System.out.println("While loop");
            z++;
        }
    }
}

```

## Intermediate java code

![Intermediate java code](/images/intermediateCode.png)

## Output text file with executed blocks

![Output text file](/images/outputText.png)

## Highlighted HTML output

![Highlighted HTML output](/images/htmlOutput.png)
