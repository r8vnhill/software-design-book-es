# Java

Java es un lenguaje orientado a objetos basado en clases que es de uso general. Basado en clases implica el hecho de que tengamos que hacer una clase para todo, ya que las clases son la base en si del lenguaje.

Si bien Java se presenta como un lenguaje orientado a objetos, este no es de caracter puro (como Smalltalk), ya que posee tipos primitivos (tipos que no representan objetos).

## Tipos Primitivos

Java no es un lenguaje orientado a objetos puro ya que contiene tipos primitivos. Estos corresponden a los tipos basicos que conocemos, estos son: `boolean`, `byte`, `char`, `short`, `int`, `long`, `float`,y `double`. Entre estos 8 tipos, podemos agregar el tipo que representa la ausencia `void`. Estos tipos representan no representan un concepto, sino mas bien informacion pura.

Los tipos primitivos permiten el uso de _operadores_, como `+`, `-`, `*`, etc, y son los unicos tipos que permiten este tipo de acciones. Los tipos primitivos **NO** reciben mensajes, ya que no son objetos, solo representan informacion.

Para crear tipos primitivos basta con escribirlo, no es necesario usar `new`.

```java
int unEntero = 10;
char unCaracter = 'a';
double puntoFlotante = 5.1;
```

## Objetos

Los objetos son las intancias de una clase. Es decir, son el concepto especifico, concreto, que quiere representar una clase.

En Java todos los objetos tienen una clase asociada, y para ser instanciados esto debe hacerse con el keyword `new`:

```java
MiClase objeto = new MiClase();
```

Tambien, un objeto puede tener varios tipos, para ello una clase puede extender otras clases (`extends`), o puede implementar interfaces (`implements`). Los detalles de esto se veran en el transcurso del curso.

Encontrara mayores detalles respecto a objetos en la pagina de [Objetos](Objetos), y sobre los keywords `extends` e `implements` en la pagina de [Herencia](Herencia).

## Mensajes

En los lenguajes orientados a objetos no hablamos de _llamar funciones__, sino mas bien enviar/mandar mensajes. Java es un lenguaje donde los mensajes **siempre** son entendidos. Esto significa que, a diferencia de Python por ejemplo, si llamamos un metodo de un objeto, el programa nunca se caera porque ese metodo no existe; el compilador atrapara todos esos problemas antes de que el programa siquiera se ejecute.

Esto es lo que se llama un lenguaje _tipado_, o de tipos estaticos. El compilador mira los tipos que nosotros declaramos y hace una revision de si lo que escribimos tiene sentido. Si no lo tiene (llamamos un metodo de la clase `String` a una lista por ejemplo), el programa no compilara. Esto es lo que se llama un lenguaje _safe_.

## Variables y Metodos estaticos

En Java ya sabemos que los objetos pueden tener metodos y variables. Por defecto estos metodos y variables estan asociadas acada objeto especifico, por lo que cada objeto tiene sus propios metodos y variables.
Existe el concepto de metodo y variable estatica, que significa que en vez de estar asociado a un metodo, esta asociado a la clase. Esto es lo mas similar que podemos llegar a una _funcion_ en Java.

Los metodos y variables que no son estaticas se llaman _"de instancia"_. Para declarar variables o metodos como estaticos se antepone el keyword `static`:

```java
public class UnaClase {
    private static int variableEstatica = 10;
    private int variableDeInstancia = 100;

    public static void metodoEstatico() {
        System.out.println("Estoy en un metodo de la clase!");
    }

    public void metodoDeInstancia() {
        System.out.println("Estoy en un metodo del objeto!");
    }
}
```

Mas detalles respecto a esto lo encontrara en la pagina de [Metodo Estaticos](Metodos-estaticos).

## Paquetes

Probablemente hasta ahora, cada vez que programaban algo dejaban sus archivos en a misma carpeta, lo cual no era mucho problema porque seguramente eran pocos en numero. Cuando los programas crecen el numero de archivos puede crecen a miles, y teniendo todo junto no es la mejor forma de organizar y estructurar un proyecto. Cada lenguaje provee su propia forma de solucionar este problema, con librerias, modulos, paquetes, etc. Java permite usar paquetes para organizar el codigo y los archivos. Esto se representa en el sistema de archivos como carpetas.

Para usar paquetes debe escribir en la primera linea del archivo: `package el-paquete-al-que-pertenece`. Los paquete se separan con un punto (`.`), indicando que es un _subpaquete_. Si utiliza un IDE, luego de escribir ese encabezado puede pedirle que le mueva el archivo a la carpeta que corresponda.

Esto programaticamente se ve asi:

```java
package cc3002.wiki;

public class EjemploPaquetes {
    ...
}
```

Aqui estamos diciendo que nuestra clase `EjemploPaquetes` esta en el paquete `cc3002.wiki`, que se traduce en carpetas a `cc3002/wiki`.
