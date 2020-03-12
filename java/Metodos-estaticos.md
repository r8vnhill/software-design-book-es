# Metodos estaticos

Los metodos estaticos, a diferencia de los metodos de instancia, son metodos asociados a una clase, **NO** a un objeto. Esto, por supuesto, pone restricciones acerca de las cosas que uno puede ejecutar dentro del metodo.

## Como se declaran

Para declarar un metodo como estatico, basta con que antepongamos el keyword `static` en la declaracion del metodo, asi:

```java
class EjemploStatic {
    public static int retorna10() {
        return 10;
    }
}
```

En el ejemplo tenemos un metodo `retorna10` que es estatico, por lo que puede ser usado sin la necesidad de un objeto. Para llamar este metodo es un poco distinto a como llamamos un metodo tradicionalmente. Normalmente primero debemos instanciar una clase (crear un objeto), para luego enviarle un mensaje mediante un metodo. Con los metodos estaticos no tenemos la necesidad de usar un objeto para esto, basta con que indiquemos la clase donde se encuentra el metodo y lo llamemos, asi:

```java
EjemploStatic.retorna10() // llama al metodo retorna10 de EjemploStatic
```

Por supuesto, como el metodo corresponde a la clase, y un objeto es solo la instancia de esta, el objeto tambien tiene acceso al metodo:

```java
EjemploStatic.retorna10() // valido
new EjemploStatic().retorna10() // creamos objeto EjemploStatic y llamamos al metodo
```

## Para que sirven

Como ya sabemos, podemos tener variables y metodos estaticos. Luego, a finales del curso, veremos que tambien podemos tener clases estaticas, pero en esta seccion nos dedicaremos exclusivamente a los metodos estaticos.

Estos metodos cumplen con la funcion de ejecutar acciones generales, no dependientes de un objeto. Un metodo estatico es lo mas similar a una funcion como la conocemos, en Java, sin embargo, aun asi es distinto. Como es distinto? Consideremos el siguiente ejemplo de un arbol binario. Para no sobrecargar esta pagina resumiremos las clases como sigue:

```java
class Node {
    private Node left, right;
    private int value;
    public Node(int value) {
        this.value = value;
    }
    // getters and seters
}

class Tree {
    private Node root;

    ...

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getValue());
            traverseInOrder(node.getRight());
        }
    }
}
```

Tenemos una clase `Node` que representa un nodo un arbol, este posee un valor y una rama a la izquierda y derecha. Luego tenemos nuestra clase `Tree`, que representa un arbol, el cual tiene un nodo que considera como raiz. En la clase `Tree` tenemos una implementacion tradicional para imprimir nuestro arbol en pantalla, en el metodo `traverseInOrder`, que recibe un nodo y luego recorre sus ramas _in order_. Que opina de esto? Tiene sentido que `traverseInOrder` sea un metodo de instancia? Tiene sentido que el metodo `traverseInOrder` se encuentre dentro de la clase `Tree`?

Para responder estas preguntas primero debemos pensar a que corresponde `traverseInOrder`. Es un metodo que imprime un arbol. Si lo pusieramos en otra clase, podria seguir funcionando, pero tendria sentido la posición? Lo que se quiere decir es que, el metodo `traverseInOrder` esta correctamente posicionado, porque el metodo en si tiene relacion con la clase `Tree`, si estuviera en cualquier otra parte, estariamos generando algun tipo de dependencia externa con nuestra clase.

Sobre la segunda pregunta, esta bien que sea un metodo de instancia? La respuesta es que _no esta mal_, pero podriamos hacerlo mejor. Actualmente si queremos usar este metodo estamos obligados a crear un objeto `Tree` solo para poder usarlo:

```java
...
Node conjuntoDeNodos = ...;
// tenemos que instanciar un Tree para usar el metodo
new Tree().traverseInOrder(conjuntoDeNodos);
```

Instanciar una clase para solamente llamar un metodo y luego desecharla no es una practica muy bien recibida. El metodo `traverseInOrder` usa absolutamente nada de la clase `Tree`, no requiere acceso a ninguna variable ni metodo de instancia. No seria mejor hacerlo un metodo estatico? Pues si, en este caso, tendria mucho mas sentido hacer el metodo `traverseInOrder` un metodo de la clase `Tree` mas que un metodo de instancia, de esta forma podemos usarlo sin crear objetos de forma innecesaria, y el metodo no tendra la restriccion de que tenga que existir un objeto para usarlo. Entonces ahora tenemos esto:

```java
class Tree {
    ...
    public static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getValue());
            traverseInOrder(node.getRight());
        }
    }
}

...

Node conjuntoDeNodos = ...;
// Podemos usar el metodo directamente
Tree.traverseInOrder(conjuntoDeNodos);
```

## Restricciones

Como los metodo estaticos son partes de la clase y no requieren de un objeto para ser usados, tienen restricciones asociadas a la existencia de objetos. Considere el siguiente extracto de codigo, que corresponde a la clase `Persona` con metodos para saber si es mayor de edad:

```java
class Persona {
    private int edad;
    ...

    public boolean mayorDe18() {
        return edad >= 18;
    }

    public static boolean staticMayorDe18() {
        return edad >= 18;
    }
}
```

Tenemos 2 metodos que hacen lo mismo, `mayorDe18` y `staticMayorDe18`, con la diferencia que uno es estatico. El metodo `mayorDe18` es algo que ya conocemos, es un metodo de instancia y no hay problema con el. Sin embargo, el metodo `staticMayorDe18` no es valido. El codigo anterior no compila porque los metodos estaticos no pueden acceder a variables de instancia del objeto. La razon de esto es que si no se crea un instancia de `Persona`, entonces la variable `edad` no existiria.

Ahora considere el siguiente codigo, que es algo que probablemente muchos de ustedes han hecho.

```java
class Persona {
    // no importa para que sirve esto
    // reemplazen getNumber por algo util
    public int getNumber() {
        return 10;
    }

    public static void main(String[] args) {
        int miNumero = getNumber();
    }
}
```

Ve algun error en el codigo anterior? El codigo no compila. La razon es que `main` es un metodo estatico, los metodos estaticos estan asociados a la clase y no al objeto, y por lo tanto no pueden acceder a las caracteristicas particulares de un objeto, como sus metodos y variables de instancia. El siguiente codigo si funciona:

```java
class Persona {
    // no importa para que sirve esto
    // reemplazen getNumber por algo util
    public int getNumber() {
        return 10;
    }

    public static void main(String[] args) {
        int miNumero = new Persona().getNumber();
    }
}
```

Aqui estamos creando un objeto `Persona`, y ahora si podemos usar el metodo `getNumber`.

En resumen, recuerde que [se antepone `this` a todo lo que no tiene `super`](Objectos#referencia-por-defecto). La restriccion que tienen los metodos estaticos es que no tienen una referencia de quien es `this` ni `super`, ya que como no son metodos de instancia, no se necesita la existencia de un objeto, y por lo tanto las variables `this` y `super` no necesariamente exiten dentro del cuerpo del metodo estatico, entonces, no se pueden usar. Luego, si ni `this` ni `super` existen, `this.variable` o `this.metodo()` tampoco existen. Por lo tanto, lo que se quiere decir es que dentro de un metodo estatico, no se puede acceder a nada de instancia, ni `this` ni `super` ni metodos ni variables de instancia, se necesita un objeto para poder hacerlo. Por su puesto, es posible pasar un objeto como argumento a un metodo estatico y acceder a las variables y metodos de instancia del objeto, pero eso es distinto a que *existan* dentro del metodo estatico.

## Usos

Despues de esas restricciones tan grandes, por que alguien querria un metodo estatico. Bueno, si bien es una desventaja no tener una instancia de la clase con la que trabajar, muchas acciones no requieren de esta. De hecho, muchas veces es un problema que esas acciones **necesiten** de una instancia para poder ejecutarse.

Consideren los siguientes ejemplos:

### El metodo `main`

Como hemos visto varias veces, el metodo `main` es un metodo estatico. Este corresponde al punto de entrada del programa, es decir, de donde partira. Antes que exista cualquiera de nuestros objetos, el programa debe saber de donde partir, entonces seria ilogico tener la necesidad de iniciar el programa para poder iniciar el programa...

El metodo `main` no puede depender de un objeto, sino no podriamos comenzar con la ejecucion.

### Acciones generales o genericas

Recuerde el ejemplo de la seccion de [para que sirven los metodos estaticos](#para-que-sirven). Tenemos un metodo `traverseInOrder` que recorre un arbol y lo imprime en pantalla.

```java
class Tree {
    ...
    public static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getValue());
            traverseInOrder(node.getRight());
        }
    }
}
```

Este metodo no necesita de una instancia para funcionar, porque de hecho no interactua con el objeto al que pertenece, si no que interactua con el objeto que recibe como argumento. En este caso, que `traverseInOrder` sea un metodo de instancia es un problema, porque estariamos creando objetos innecesarios solo para poder acceder a la funcionalidad.

### Acciones o funciones

Imagine en otro lenguaje lo que haria con una funcion. Por ejemplo, podriamos tener una funcion que nos muestre donde iria un punto en una curva:

```python
def poly(x: int) -> int:
    return x**2 + 10*x + 4
```

Tenemos una funcion que si le damos un `x`, nos dara un `y` que es donde iria nuestro punto en un grafico. Tendria sentido esto como metodo de intancia? Que tal otro ejemplo:

```python
def abs(number: int) -> int:
    return number if number >= 0 else -number

def sumList(aList: List[int]) -> int:
    valueSum = 0
    for element in aList:
        valueSum = valueSum + element

    return valueSum
```

Aqui tenemos 2 funciones mas. Una que retorna el valor absoluto de un entero, `abs`, y otra que suma los elementos de una lista de enteros `sumList`. Nuevamente, tiene sentido si esto fueran metodos de instancia?

La respuesta a ambas preguntas es: puede ser, pero probablemente no. Que respuesta mas insatisfactoria, pero asi son las buenas practicas, no son reglas ni obligaciones, son guias que ayudan pero que es mal visto no seguirlas.

Dicho lo anterior, es poco probable que algun vez necesiten declarar las funciones anteriores como metodos de instancia. Cuando tengan una funcion en otro lenguaje y quieran reimplementarla en Java, probablemente esta funcion se convertira en un metodo estatico, ya que es lo mas similar a uno. Como ejemplo, [mire la clase `Math` de Java](http://developer.classpath.org/doc/java/lang/Math-source.html), **TODO** es estatico. Incluso el constructor es `private` para que nadie nunca pueda llamarlo (veremos esto en topicos avanzados cuando hablemos de patrones), que significa que no existan objetos `Math`. En la clase `Math` todo en otros lenguajes seria una funcion, como en Java eso no existe, se declaran como metodos de la clase, o metodos estaticos. Estos metodos no necesitan de un objeto para cumplir con su ejecucion.
