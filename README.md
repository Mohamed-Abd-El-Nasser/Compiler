# java-compiler

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
