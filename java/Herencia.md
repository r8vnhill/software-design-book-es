# Herencia

Una de las principales caracteristicas de los lenguajes orientados a objetos, es su poderosa habilidad de crear nuevos tipos y extenderlos como se desee. Es importante en este punto dejar de considerar un "tipo" algo simple como un `int`, `boolean` o `float`. Una clase tambien representa un tipo, y un tipo muchas veces viene asociado de operaciones y super tipos de los cuales depende. Por ejemplo, en Java `String` es una clase, no un tipo primitivo, por lo que tiene operaciones disponibles. En el caso de una lista, `List` representa el tipo, pero entre `List` y el objeto final tenemos tenemos varias clases que van aumentando el poder de la anterior.

## Jerarquia de clases

La jerarquia de clases comunmente se imagina como cajitas. Cada cajita apunta a otra mas arriba y se forma una especie de dependencia lineal en una direccion. Aqui entra en ayuda un lenguaje orientado al modelamiento de clases y objetos, [UML](https://en.wikipedia.org/wiki/Unified_Modeling_Language).

![Un ejemplo de jerarquia](http://yuml.me/44ce26da.png)

En Java es importante notar que todas las clases que implementen, siempre su clase superior sera `Object`, es decir, todas la clases heredan de `Object`. Por que? Bueno, ya vimos los constructores, que eran para iniciar variables y estados de cada clase. Sin embargo, los constructores que implementamos nosotros basicamente hacen super poco para el sistema mismo, asignan variables y eso, pero donde se reserva la memoria, se guardan los valores, se crean los objetos? Todo eso y mas lo hace el constructor de la clase `Object`, esta es la clase responsable de hacer toda la parte de *bajo nivel*.

## Interfaces

Las interfaces en Java definen un contrato con el compilador y la maquina virtual de Java. Eso no dice nada por si mismo. Las interfaces no tienen implementaciones, solo los encabezados de las funciones.
Muchos pensaran que esto no sirve de nada, y la verdad es que desde el punto de vista **funcional**, es verdad. Las interfaces no proveen mas funcionalidad en tiempo de ejecucion. ***Pero***, son increiblemente importantes, veamos por que.

Una interfaz define un nuevo **tipo**. Este tipo esta definido por distintas operaciones que este acepta o puede hacer. La interfaz es quien dice, inicialmente, los mensajes que los objetos que la implementen entienden. Si saben C, probablemente habran visto alguna vez los archivos de encabezado `.h`. Esto es parecido, en C los `.h` son archivos arbitrarios, pero generalmente se usan para declarar funciones y variables, comunmente no hay funcionalidad aqui. En Java se hace lo mismo con las interfaces, en ellas definimos metodos que seran implementados por quieren implementen el tipo, pero no hay implementaciones explicitas en la interfaz.

Una interfaz se define de la siguiente manera:

```java
public interface SerVivo {
    void alimentarse(Alimento alimento);
    void moverse();
    int edad();
}
```

Y se usan en una clase como sigue:

```java
public class Humano implements SerVivo {
    public void alimentarse(Alimento alimento) {
        ...
    }
    public void moverse() {
        ...
    }
    public int edad() {
        ...
    }
}
```

Si no implementamos todos los metodos definidos en la interfaz, estamos obligados a convertir nuestra clase `Humano` en una [*clase abstracta*](#clases-abstractas).

Un ejemplo de una interfaz es el tipo `List`. [`List` en Java es una interfaz](http://developer.classpath.org/doc/java/util/List-source.html), no una clase. Aqui es definen varios metodos, entre ellos `add`, `get`, `isEmpty`, `size`, entre otros. Pero no hay ninguna implementacion a la vista. Bueno, resulta que hay varias formas de implementar una lista, podemos implementarla como un arreglo con `ArrayList`, como un vector con `Vector`, como una lista enlazada con `LinkedList`, como... entienden a idea. Y a pesar de que todas estas clases implementan la lista de forma distinta, todas comparten los metodos basicos que estan definidos en `List`. Esto nos permite crear metodos o variables, condiciones, etc, que dependan de que exista una lista, pero no importa **que** tipo de lista, con que sea una lista basta.

Hay una cosa bien interesante de las interfaces, y es que como representan un tipo, podemos tener varios tipos. Esto significa que una clase puede implementar multiples interfaces, lo que se traduce en tener multiples tipos. Imaginen tenemos un `Humano` que es un `Medico`, el `Medico` tiene varios metodos especificos, como sanar personas o accesos especiales dentro de un hospital. Un `Musico` puede tocar algun instrumento y presentarse en un escenario. Nuestro `Medico` tambien puede ser un `Musico`, en un contexto puede comportarse como `Medico`, en otro como `Musico`, no hay limitaciones en este aspecto.

## Clases abstractas

> una clase solo puede extender una sola otra clase. Si quieres tipos -> interfaces

> no se pueden instanciar, son incompletas. Fuera de eso son como cualquier otra clase, pueden tener metodos, variables y constructores. Puede tener metodos con abstract, diciendo que las subclases los implementaran. Podemos tener una clase abstracta sin metodos abstract.

> no usar como tipo, porque no lo son. Java lo permite, pero no lo hagan

> son abstracciones -> funcionalidades genericas, cosas comunes entre todas las subclases

## Polimorfismo

Ver [FAQ](FAQ#polimorfirmo)

## Principio de Liskov

> si una propiedad se cumple para un supertipo, se tiene que cumplir para un subtipo

> Es decir, si tu funcion recibe SeresVivos, tambien le puedes pasar Humanos. Pero si tu funcion recibe Humanos, no tiene porque cumplirse para SeresVivos.

## Usos - Por que necesitamos esto

### Polimorfismo, again

> List l = new ArrayList()

### Reutilizacion de funcionalidades

> heredar de Hashmap para tener acceso a get y put esta mal

> heredar de abstractList, o de ArrayList porque queremos mejorar como se almacenan los objetos, como se implementan los metodos, pero nos justaria mantener la intefaz y lo que ya esta implementado

### Especializacion de clases

> Estamos modelando animales. Tenemos una clase Animal que define varios metodos que todos los animales poseen, como comer, moverse, hacer sonidos, etc. Ahora, en el mundo no existe un "animal", existen perros, aves, peces, pero no "animal". Entonces podemos extender de Animal y hacer nuestra clase Pez, que redefine algunos metodos como comer y moverse, y ademas agrega metodos como nadar. En las Aves agregamos el metodo volar. Y en ese estilo vamos "agregando" cosas a nuestra clase inicial Animal.

> Que tal esto? Esto es lo que se conoce como "class specialization", porque tenemos una clase base Animal, y le vamos agregando cosas, pero no cualquier cosa, cosas que tienen sentido. En este caso, estoy seguro que a tod@s nos hace sentido la composicion de jerarquia que creamos. No estamos reutilizando el codigo de Animal, lo estamos extendiendo.

## Conceptos avanzados (TODO: no lo necesitan para el C1)

### Extendiendo interfaces

### Interfaces vacias

### Metodos `default` en interfaces
