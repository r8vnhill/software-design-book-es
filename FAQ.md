# Preguntas frecuentes y dudas

## Polimorfirmo

Basicamente responde a lo que naturalmente nosotros entendemos como correspondencia de tipos. Por ejemplo: una casa es una construccion, un edificio es una construccion, una persona no es una construccion. La casa y el departamento se parecen porque tienen murallas y vive gente en ellos, pero aun asi son distintos ya que cada uno se especializa de distinta forma.

Otro ejemplo muy clasico somos nosotros mismos. Tenemos un tipo superior, `Seres Vivos`. Los seres vivos, naturalmente, pueden morir. Bajo los `Seres Vivos` tenemos los `Animales`, `Plantas`, `Insectos`, etc. Dentro de los `Animales` estamos los `Humanos`. Dentro de los `Humanos` tenemos mas cosas, `Estudiantes`, `Trabajadores`, `Bebes`, etc. Todos pueden ser considerados `Seres Vivos`, a pesar de tambien ser `Humanos`. Un `Estudiante` puede ser tratado como `Humano` ademas de ser un `Estudiante`. Hay acciones y caracteristicas comunes para todos.
Por ejemplo los `Humanos` pueden _alimentarse_ al igual que las `Plantas`. La forma en que lo hacen es distinta, pero bajo cierto contexto, las `Plantas`, `Insectos` y `Humanos` pueden considerarse como lo mismo para hablar de algo mas general, como un `Ser Vivo`.

Formalmente el polimorfirmo se define de la siguiente forma: **_Es la capacidad de un tipo A, de verse y poder usarse como otro tipo B_**.

## Clase vs Objetos

Una clase define es esqueleto de un objeto. Piensen en la clase como un cortador de galletas. La forma seguramente sera la misma, pero el sabor de la masa, el color y las decoraciones seran potencialmente distintas. Aun asi, todas estas galletas seran, pues, galletas, a pesar de que sean distintas, todas comparten la misma forma y caracteristicas generales.

Mas formalmente, una clase define los datos y procedimientos disponibles par aun cierto tipo o "clase de objeto". Mientras que un objeto corresponde a la __instancia de una clase__.

## Metodo vs Funcion

Hay unas diferencias bien sutiles en el uso del lenguaje en la programacion orientada a objetos, y en particular en nuestro contexto en Java. En Java nosotros tenemos metodos, no funciones.

En los lenguajes orientados a objetos tenemos, bueno, objetos. Los objetos tienen metodos, que son distintos a una funcion.
Las funciones en lenguajes como Python, C, y amigos, son trozos de codigo que modifican el estado del programa. Son subrutinas que estan desasociadas de las estructuras o datos sobre que actuan. Estan ahi sueltas y reciben cosas, luego hacen lo que saben hacer y retornan. Los metodos no son asi, los metodos son subrutinas asociadas al objeto mismo y funcionan a nivel de objeto, no del programa, pueden acceder al estado interno de los objetos, y sus valores de salida, flujos de operacion y resultados pueden variar completamente dependiendo del estado interno del objeto en cuestion, independiente del estado global del sistema.

Basicamente cada objeto tiene sus propias operaciones que se llaman metodos, las funciones son cosas a nivel del programa.

## Mensajes

Los mensaje comunmente se confunden con lo que tanto conocemos como "llamar funciones", "invocar funciones", "hacer una llamada", etc. pero en verdad son un poquito mas que eso en los lenguajes orientados a objetos (como Java).

Entonces, que es eso de mandar un mensaje? Cada objeto tiene formas de comunicarse con el mundo, que serian los metodos. Entonces cuando nosotros queremos comunicarnos con un objeto, le enviamos un mensaje, ese mensaje es una llamada a un metodo. No le invocamos una funcion, sino que le enviamos un mensaje para que el objeto vea como lo interpreta y vea como actuar.

Suena a lo mismo? Son parecidos, pero imagina con herencia. Si estuvieras "llamando una funcion", es una funcion especifica, el objeto no decide, tu decides que funcion llamas. No queremos eso (no regularmente al menos), entonces le mandamos un mensaje diciendole que queremos ejecutar cierto metodo. Luego el objeto ve que metodo invoca, porque pudo haber un metodo en la super clase y ahora lo esta sobrescribiendo, por decir algo. La diferencia mas notoria esta en que una funcion corresponde a una accion que tu manualmente estas ejecutando y llamando. Un metodo corresponde a un mensaje que se le envia a un objeto, para que este determine como actuar al recibir esa "orden", podria incluso hacer nada en caso de que asi haya sido configurado.

## Referencia vs Puntero

Esta respuesta es un poco mas tecnica respecto al uso de memoria dentro del diseño del lenguaje.

En lenguajes donde se permite el manejo manual de memoria, como C, un puntero se refiere a una direccion de memoria donde se encuentra un valor. No al valor en si, sino mas bien donde esta guardado ese valor. Fijarse en la terminologia, un **valor**. Este puntero puede apuntar a cualquier cosa, ya que en verdad a este no le importa lo que haya dentro de esa direccion de memoria.

Una referencia en cambio apunta solo a objetos. Los objetos no son cualquier cosa, son estructuras complejas compuestas de metodos, variables, datos de herencia, configuraciones y mas referencias.

## Modelar un objeto en C

Independiente de lo dicho en la respuesta de [Referencia vs Puntero](#referencia-vs-puntero), uno puede simular un objeto en C mediante `struct`s. Por su puesto, esto no es lo mismo, pero es una simulacion.

```C
struct person {
    int (*eat)(void *);
};
struct person onePerson;

onePerson.eat(apple)
```

Aqui tenemos una estructura `person`, que tiene un puntero a una funcion `eat` que recibe 1 parametro, que es un puntero a "cualquier cosa". Luego podemos llamar a la funcion `eat` como si `onePerson` fuera un objeto, pasando alguna variable `apple`.

Las desventajas de esto son claramente que la funcion `eat` no esta definida dentro de `person`, `person` solo contiene un puntero a esta.

## `==` vs `.equals()`

Construyendo sobre que ya entiende el concepto de referencia, la diferencia es la siguiente: `==` compara referencias, que si los trozos de memoria definidos por lo objetos comparados son la misma. En cambio `.equals()` llama al metodo `equals` definido en la clase `Object`. Por defecto, `Object` hace exactamente `==` entre los objetos comparados. Pero como sabemos, si es un metodo, podemos especializarlo. En este caso, hacemos un _Override_ de `equals` y definimos las condiciones explicitas en las cuales consideramos que un objeto es igual a otro. Puede ver un ejemplo de esto en el siguiente link del repositorio: [java/objects](https://github.com/juanpablos/ExercisesInJava/tree/master/src/main/java/com/cc3002/java/objects).

Recuerde que se pide expresamente que si se hace _override_ a `equals`, este debe ir acompañado de un _override_ a `hascode`. Este ultimo metodo se usa para encontrar la representacion del objeto al momento de insertarlo en algun mapa o representacion de _hash_. Si no define esto, puede caer en bugs del estilo:

```java
...
Map<CustomObject, Integer> mapa = new Hashmap<>();
CustomObject object1 = new CustomObject();
CustomObject object2 = new CustomObject();

System.out.println(object1.equals(object2)) // -> retornaria true

mapa.put(object1, 100); // se agrega object1
mapa.put(object2, 1000); // se agrega object2
// se supone que ambos objetos son el "mismo" objeto (definido por nosotros), pero...
System.out.println(mapa.get(object1)) // -> retornaria 100
System.out.println(mapa.get(object2)) // -> retornaria 1000
```

Como puede ver el valor no se reemplazo. Esto puede ser intensional, pero en caso de no serlo, es un bug que en un software grande y complejo, es casi imposible de diagnosticar y puede causar gigantes dolores de cabeza.

## Tipos primitivos como objetos

Como sabemos los tipos primitivos no son objetos, sino mas bien informacion pura del tipo en cuestion. Sin embargo, en caso de que queramos indicar que una lista contiene enteros, lo siguiente no funciona:

```java
// esto no funciona
List<int> lista = new ArrayList<>();
```

 La razon es que el operador diamante recibe solo objetos como indicadores. Pero si un `int` no es un objeto como podemos indicar esto?
 En Java todos los tipos primitivos tienen su equivalente en objetos para este tipo de cosas: un `int` se representa como objeto como la clase `Integer`. Un `double` como `Double`, `char` como `Char`, y asi. Luego, ahora podemos hacer esto que si es valido:

 ```java
 List<Integer> lista = new ArrayList<>();
 ```

## `this` vs `super`

`this` y `super` son de esas variables que salen en todos lados y tienen mil y un usos. En Java, estas palabras tienen 3 usos bien definidos que son explorados en mayor detenimiento en su respectiva pagina. Aqui sus usos:

* **Pseudovariables**: `this` y `super` cumplen su funcion como pseudovariables al actuar como referencias al hacer el lookup de metodos y variables. Puede leer mas sobre esto en las pagina de [Lookup](Lookup).
* **Constructores**: `this` y `super` tambien son usados como constructores, para referirse a otro constructor de la misma clase, o al de la super clase, respectivamente. Puede leer mas sobre esto en la pagina de [Constructores](Constructores).
* **Identificacion de si mismo**: puede usar `this` para referirse al objeto que recibio el mensaje. Puede usar esto para retornarse a si mismo, o pasarse a si mismo como parametro. Esto lo puede ver en uso en [Objetos](Objetos).
* **Desambiguacion**: similar a su uso como pseudovariables para el lookup, pero con variables. `this` corresponde a las varibles partiendo la busqueda desde la clase donde llego el mensaje, y `super` comienza buscando en la superclase de la clase donde esta `super`. Dentro de un constructor, uno puede desambiguar la variable que esta asignando usando `this` o `super`. Por ejemplo considere el siguiente codigo, donde los nombres de los argumentos son los mismos de la variable a donde los queremos asignar. Puede leer mas en [Objetos](Objetos), [Herencia](Herencia) y [Constructores](Constructores).

```java
class Persona {
    private String nombre;
    public Persona(String nombre) {
        // tenemos que el argumento `nombre` tiene el mismo identificador que la variable `nombre`
        // para desambiguar el uso de `nombre = nombre`, se usa `this` para referirse a la variable
        // del objeto. Tambien funciona con `super` para asignar a una superclase, pero no se recomienda
        // usarlo, porque una mejor practica es simplemente llamar al constructor de la superclase.
        this.nombre = nombre;
    }
}
```

Recuerde que `this` y `super` referencian al mismo objeto, y ese objeto corresponde al objeto que recibio el mensaje.

## Que es la firma de un metodo

La firma de un metodo corresponde a un conjunto de cosas, primero es importante entender las partes de la declaracion de un metodo.

```java
public String int2String(int valor) { ... }
```

* `public` corresponde al "modificador de visibilidad" o simplemente "modificador" del metodo.
* `String`, en este caso, corresponde al valor de retorno del metodo.
* `int2String` corresponde al nombre de nuestro metodo.
* `int valor` es el argumento del metodo, pueden haber mas de 1.

La *firma* de un metodo se define como el conjunto de `nombre + lista de parametros`, donde lista de parametros es una coleccion de tipos. Entonces en este caso, la firma de nuestro metodo es `int2String + [int]`. Consideremos los siguientes 2 metodos:

```java
// este hace print del resultado
public void int2String(int valor) { ... }
// este hace print del resultado en output
public void int2String(int valor, PrintStream output) { ... }
```

Entre estos 2 metodo nuevos, el primero no compila. La razon es que la firma del metodo es la misma, y Java no permite que esto sea posible (que tiene sentido, no hay como saber cual de los 2 se llama).
Veamos la firma de ambos metodos. Los 3 metodos tienen el mismo nombre. El primer metodo que tenemos (el original) tiene firma `int2String + [int]`, nuestro primer metodo nuevo tambien tiene firma `int2String + [int]`. Si bien el tipo de retorno es distinto, esto no se incluye en la firma asi que no es suficiente para diferenciar 2 metodos. Nuestro segundo metodo nuevo tiene firma `int2String + [int, PrintStream]`, que es distinta al resto, asi que es valido.

Otro factor que influye es el orden en que aparecen los argumentos:

```java
// este hace print del resultado
public void ejemplo(int valor1, String valor2) { ... }
// este hace print del resultado en output
public void ejemplo(String valor1, int valor2) { ... }
```

Esto es valido porque la firma de ambos metodos es distinta, uno tiene `ejemplo + [int, String]` y el otro `ejemplo + [String, int]`.

## Overloading

Primero lea sobre [que es la firma de un metodo](#que-es-la-firma-de-un-metodo).

El *Overloading* corresponde a declarar metodos con el mismo nombre, pero distinta firma, es decir, variar el orden, tipos o cantidad de argumentos del metodo. La finalidad de hacer esto es discutible, pero se usa regularmente para disminuir la poblacion del espacio de nombre de una clase (cada nuevo metodo agrega un nuevo que recordar), y para crear la ilusion de una interfaz "maestra" que permite usar el mismo nombre y hacer distintas operaciones.

A cambio de esto, el *Overloading* tiene severas desventajas que se ilustran en los [ejercicios](Ejercicios#overloading), que pueden resultar en *bugs* casi imposibles de detectar que pueden hacer perder millones de dolares a una empresa.

## Overriding

Primero lea sobre [que es la firma de un metodo](#que-es-la-firma-de-un-metodo).

El *Overriding* corresponde a declarar un nuevo metodo con la misma firma, pero en una subclase, no puede ser la misma clase porque sino no compila. Esto es una de las bases de la herencia, donde se tiene un metodo que describe el funcionamiento general o particular de la clase padre, y la subclase redefine el metodo (hace *overriding*) para cambiar la funcionalidad del metodo.

## TODO: all todos

> por que ejercicio de lookup private

> por que metodos estaticos, se buscan?
