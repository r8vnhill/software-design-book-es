# Requerimientos del curso

Para el curso necesitaran recordar Java (o aprender si son una generacion muy nueva). En esta pagina encontraran lo basico que deben saber sobre la sintaxis de Java, como se estructura un programa y un repaso de las estructuras de datos que vieron en Algoritmos.

## Java

Java es un lenguaje orientado a objetos, que se adhiere a la programacion orientada a objetos (OOP en ingles). En Java todo lo que programen debe estar dentro de una clase, y las operaciones se llaman metodos en vez de funciones. Para ver mas de esto leer aqui

### Java vs Python

Python es un lenguaje multi-paradigma. Esto significa que puede ser usado orientado a objetos, u otras orientaciones. Java por el contrario es orientado a objetos, lo que enfuerza un estilo de programacion (esto puede ser una ventaja o desventaja dependiendo de como lo miren).

Comparando Python estructuralmente con Java podemos hacer a las siguientes observaciones:
En Python ustedes pueden hacer clases si lo desean, pero esto no es un requerimiento. En Java si lo es.

|                              Java                               |                        Python                         |
| :-------------------------------------------------------------: | :---------------------------------------------------: |
|               todo debe estar dentro de una clase               |        basta con que este dentro de un archivo        |
| archivos deben tener el mismo nombre que la clase que contienen |    archivos pueden tener el nombre que uno quiera     |
|               extension de lo archivos es `.java`               |          extension de los archivos es `.py`           |
|    para ejecutar una clase esta debe tener un metodo `main`     | para ejecutar un archivo se corre en orden sequencial |
|          archivo de compilarse a `.class` manualmente           |        se crea archivo `.pyc` automaticamente         |

### Sintaxis de Java

Java es conocido por ser un lenguaje _verboso_. Esto significa que uno debe escribir mucho para hacer cualquier cosa. Es por esto que se recomienda utilizar algun IDE para el curso. El IDE puede ayudarlos a autocompletar el nombre de los metodos y variables.

Ser verboso no es necesariamente algo negativo. Cuantas veces han visto un codigo en Python sin entender lo que hace. En Java como por convencion cada nombre de clase y metodo es autoexplicativo, mirando un trozo de codigo rapidamente entenderan lo que se esta haciendo.

#### Clases

En Java todo debe ser una clase. Imaginen una clase como un contenedor de funcionalidades y variables, que potencialmente puede ser reutilizado varias veces.

Para crear una clase, debemos crear un archivo con el mismo nombre, con extension `.java`. Una clase se ve de la siguiente forma:

```java
public class MiPrimeraClase {
    ...
}
```

Para que esta clase sea valida, debe estar contenida en un archivo llamado `MiPrimeraClase.java`.

#### Metodos

En Java los metodos corresponden a las operaciones propias de cada uno de los objetos que podemos crear a partir de las clases. Los metodos tienen la siguiente sintaxis `<modificador> <tipo de retorno> <nombre>(<parametros>)`. Los parametros del metodo tambien deben tener los tipos de cada una de las variables que se le estan pasando. Aqui un ejemplo.

```java
public class MiPrimeraClase {
    ...
    public float unMetodo(int parametroEntero, String parametroString) {
        ...
        return 0.1;
    }
}
```

Un metodo debe terminar su ejecucion con el keyword `return`, retornando el valor como resultado de haber ejecutado el metodo. En caso de que un metodo no tenga un valor de retorno, por ejemplo imprimir algo en pantalla, se le dice que tiene tipo `void` y no necesita tener un `return`.

```java
public class MiPrimeraClase {
    ...
    public void metodoVoid(...) {
        System.out.println("Esto solo imprime en pantalla");
    }
}
```

#### Variables

Para crear variables en Java deben usar la siguiente sintaxis `<modificador> <tipo de la variable> <nombre>`. Es decir, a diferencia de Python, deben indicar quien puede ver la variable (esto lo veremos mas a fondo mas adelante en el curso), y tambien de que tipo es la variable (`int`, `double`, `String`, etc).
Agrandemos nuestro clase anterior:

```java
public class MiPrimeraClase {
    public int estoEsUnEntero = 10;
    private String estoEsUnString;
    ...
}
```

Aqui podemos ver que tenemos nuestra variable `estoEsUnEntero` ya definida como `10`, pero nuestra variable `estoEsUnString` no esta inicializada. Por defecto los String (y cualquier objeto, son inicializados como `null`).

Tambien podemos definir variables locales para cada una de los metodos que tengamos, por ejemplo aqui definimos la variable `variableEnMetodo` de tipo `double` dentro del metodo `miPrimerMetodo`.

```java
public class MiPrimeraClase {
    ...
    public void int unMetodo() {
        double variableEnMetodo = 100.1;
        return 10;
    }
}
```

Si queremos definir el valor de una de estas variables cuando creamos el objeto, debemos usar un Constructor.

#### Constructores

Como hemos visto, Java necesita de una clase para funcionar. Ademas, cada clase puede tener variables y metodos dentro de ella.
Las clases por si solas solo definen algo asi como el esqueleto de nuestros objetos. Digamos que nos gustaria definir una clase que represente a una persona:

```java
public class Persona {
    private String nombre;
    ...
}
```

Es claro que no todas las personas no se llaman igual, entonces de algura manera debemos personalizar nuestra clase. Para esto usamos los constructores. Los constructores se encargan de inicializar variables al momento de crear un objeto (entre otras cosas).
La sintaxis de los constructores es similar a la de los metodos, pero el nombre debe ser identico al nombre de la clase, y no tiene el tipo de retorno.

```java
public class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }
    ...
}
```

Aqui estamos inicializando el la variable `nombre` de `Persona`, con el nombre que le asignemos. Ignoren el `this`, esto es materia del curso que no necesitan saber inmediatamente.

#### Objetos

Como hemos dicho, si las clases son _esqueletos_, entonces como creamos objetos. En Java todo objeto debe ser creado usando el keyword `new` de la siguiente forma.

```java
...
Persona unaPersona = new Persona("Pedrito");
...
```

En este caso estamos haciendo uso de la clase `Persona` que hicimos antes, y la estamos iniciando con el nombre `Pedrito`.

#### Ejecutar una clase

Hasta ahora hemos visto como declarar y programar, pero, como se ejecutan los programas en Java?
En Java se necesita de un metodo especial, llamado `main`, que debe tener la siguiente firma `public static void main(String[] argv)`. Durante el curso veremos que significa cada uno de estas palabras, pero por mientras veamos simplemente como imprimir algo en pantalla:

```java
public class ClaseParaImprimir {
    public static void main(String[] argv) {
        System.out.println("Estoy imprimiendo en pantalla!");
    }
}
```

----

## Estructuras de datos

En el curso se asume que ya saben estructuras de datos basicas. Esto porque uno de los requisitos de CC3002 es precisamente CC3001 - Algoritmos y estructuras de datos.

Estamos interesados en que sepan cuando corresponde aplicar cada una de ellas, mas que los detalles de implementacion y optimizacion. Principalmente se necesita que entiendan las listas y los mapas.
Para los controles no nos interesa que se aprenda los metodos de cada una de estas estructuras de memoria, sino que privilegiamos que sepa cuando usarlos y cuales existen. Por ejemplo, si no recuerda que existe el metodo `get()`, es suficiente que diga `obtener()`.
Para las tareas, sin embargo, si necesita utilizar los metodos correspondientes ya que necesitamos que el programa funcione.

### Listas

Las listas sirven principalmente para almacenar informacion, comunmente secuencial (pero sin requerir que lo sea), de forma que se tenga una coleccion de elementos sobre los cuales se pueda iterar o recorrer para hacer operaciones sobre estos.

En Java las listas estan diferenciadas en su declaracion e implementacion. Tenemos primero `List`, que es una interfaz que declara los metodos comunes entre todas las implementaciones de listas y define el tipo. Las impleentaciones de cada lista puede buscarlas en la documentacion oficial, pero para efectos del curso basta con que use `ArrayList`.

A continuacion puede ver como se crea una lista y los distintos metodos que esta tiene.

```java
...
// Creamos una lista con ArrayList como implementacion
List<Integer> listaDeEnteros = new ArrayList<>();
// Agregamos elementos con add(elemento)
listaDeEnteros.add(10);
// Obtenemos elementos con get(indice)
listaDeEnteros.get(0);
// Si pedimos un indice que no existe obtenemos un ArrayIndexOutOfBoundsException
listaDeEnteros.get(100); // -> error
// Si queremos saber el tamaño de una lista, size()
listaDeEnteros.size();
// Usamos remove(indice) si queremos eliminar un elemento de la lista
listaDeEnteros.remove(1);
```

Lo que ve entre `<>` en el codigo se conoce como operador diamante, y se usa para indicarle al compilador que tipo de elementos tendra la lista. Para efectos del curso puede no ponerlo y el compilador lo inferira por usted.

Puede encontrar un ejemplo de como usar listas en el siguiente enlace que lo llevara a una de las carpetas del repositorio: [datastruct/ArrayListEx.java](https://github.com/juanpablos/ExercisesInJava/blob/master/src/main/java/com/cc3002/datastruct/ArrayListEx.java);

### Mapas o Diccionarios

Los diccionarios (o mapas) son estructuras de datos que nos permiten, asi como las listas, guardar elementos de forma ordenada. Sin embargo, los mapas se distinguen de las listas en que el orden mas que representar el orden de inserción, representa la correspondencia entre 2 elementos. Imaginen una tabla en Excel con 2 columnas. En la primera columna tenemos el nombre de una persona (un `String`) y en la segunda columna tenemos su edad (un `int`). De esta forma mantenemos una asociación de 2 elementos. Al primer elemento (en este caso el nombre), se le llama la _llave_ o `key`, y al segundo valor (la edad) se le llama _valor_ o `value`.

Las implementaciones de los mapas no son relevantes para el curso, por lo que basta con que use `Hashmap` para sus tareas.

A continuacion puede ver como se crea un mapa y los distintos metodos que este tiene.

```java
...
// Creamos una lista con ArrayList como implementacion
Map<String, Integer> mapaConStringEnteros = new Hashmap<>();
// Agregamos elementos con put(llave, valor)
mapaConStringEnteros.put("Pedro", 10);
// Obtenemos elementos con get(llave)
mapaConStringEnteros.get("Pedro"); // -> 10
// Si pedimos una llave que no existe obtenemos un valor null, NO un error
mapaConStringEnteros.get("Josefa"); // -> null
// Si queremos saber el numero de elementos dentro del mapa usamos size()
mapaConStringEnteros.size();
// Usamos remove(llave) si queremos eliminar un elemento del mapa
mapaConStringEnteros.remove("Pedro");
```

Puede encontrar un ejemplo de como usar mapas en el siguiente enlace que lo llevara a una de las carpetas del repositorio: [datastruct/HashMapEx.java](https://github.com/juanpablos/ExercisesInJava/blob/master/src/main/java/com/cc3002/datastruct/HashMapEx.java).
