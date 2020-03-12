# Objetos

Como ya hemos dicho, Java es un lenguaje orientado a objetos, por lo que claro, posee objetos. En esta pagina explicaremos que es realmente y como deberia entenderse.

## Que son

La respuesta corta y simple es: la instancia de una clase. Pero con una respuesta asi seguramente uno queda donde mismo.

Una forma de explicar que es un objeto es compararlo con lo que ya conocemos como tipos primitivos. Sabemos que los tipos primitivos representan una sola clase de informacion, algo muy simple. Contrastando con eso, un objeto no es solo una muestra pura de informacion, este esta compuesto por:

* **Campos**: las variables de nuestro objeto. En ingles se conocen como _fields_, _data_, _attributes_, _properties_. Basicamente los campos definen el estado del objeto. Cada objeto tiene su propio estado interno.
* **Metodos**: las acciones que puede realizar un objeto. Los metodos definen los mensajes que un objeto entiende y por lo tanto es su forma de comunicarse con el mundo.
* **Herencia**: el conjunto de jerarquia que corresponde al objeto mismo. Puede leer mas en [Herencia](Herencia).

Con esto podemos ver que un objeto es mas que solo una forma de almacenar informacion. Un objeto posee su propio estado interno mediante sus atributos, y define su propia forma de comunicarse con el mundo usando los metodos.

## Entendiendo los objetos

Considerando que es un objeto, lo mas simple es intentar describirlo usando sus sub-unidades. Imaginen lo siguiente:

* Un objeto es un sustantivo. Un `Perro` por ejemplo.
* Los atributos o campos de un objeto son sus adjetivos. Un `Perro` tiene `colorDePelo` y `peso`, entre otras caracteristicas.
* Los metodos de un objeto representan un verbo. Un `Perro` puede `ladrar` y `comer`.

## Cosas en que fijarse

1. Los objetos se crean usando el keyword `new`.
2. Los objetos son una instancia de una clase.
3. Los objetos se comparan usando `equals`, no `==`. Mas detalles en [`==` vs `.equals()`](FAQ#-vs-equals).

## `this` y `super`

Hay 2 conceptos referentes a `this` y `super` que deben conocer en estos momentos. El primero corresponde a la autoreferencia de `this`, y el otro es el rol desambiguador de estas variables.

### `this` autoreferente

Es muy comun en un programa querer retornar el mismo objeto en que se esta actualmente. Los usos varian desde crear interfaces fluidas hasta referencias futuras para *callbacks*, y es una caracteristica presente en todos los lenguajes orientados a objetos.

En lenguajes como Python y Smalltalk se usa `self`, en Java, C++, y C# se usa `this`. El uso de `this` en Java se puede ver en el siguiente ejemplo.

```java
class Printer {
    public void print(Persona persona) {
        ...
    }
}

class Persona {
    private Printer printer = new Printer();

    public void print() {
        printer.print(this);
    }

    public Persona getSelf() {
        return this;
    }
}
```

En el ejemplo mostramos las 2 aplicaciones. La primera es pasar `this` como argumento a otro metodo, en este caso `print` de la clase `Printer`. Tambien podemos retornar `this`, donde en este caso el tipo de retorno del metodo `getSelf` es `Person` porque efectivamente retorna una instancia de si mismo.

### A quien referencia `this` y `super`

Ya sabemos que `this` es el "objeto mismo", pero, quien es `super`? La verdad, ambos son el mismo objeto. `this` y `super` referencian ambos al mismo objeto, que corresponde al objeto que recibio el mensaje. No hay mucho mas que esto, salvo sus diferencias, que puede leerlas mas profundamente en [Lookup](Lookup).

### Como desambiguadores

En Java tenemos varias [convenciones](Convenciones) que nos ayudan a programar de una forma mas estructurada y que esto resulte en un codigo mas legible para todos, incluido nosotros despues de unos meses sin ver el codigo. Una de las convenciones y buenas practicas bien adoptadas en Java es el uso de nombres descriptivos para variables y metodos, de forma que el solo nombre sea autoexplicativo con el uso o representacion que tiene la variable. Basicamente esto quiere decir que no usamo variables como `a`, `t`, `c`, porque por si solas no significan nada y no nos porta en nada para entender que hace el programa con ellas.

Los nombres descriptivos, sin embargo, tienen un pequeño detalle. Tomemos el siguiente ejemplo:

```java
class Persona {
    private String nombre;
}
```

Tenemos una clase `Persona`, que tiene una variable con el identificador `nombre`. Nada extraño hasta aqui, de hecho suena super razonable. Digamos ahora queremos hacer un metodo que cambie el valor de nombre y lo reemplace por el indicado en el argumento del metodo:

```java
class Persona {
    private String nombre;

    public void setNombre(String nombre) { ... }
}
```

Tambien suena razonable, el argumento del metodo tiene identificador `nombre`, que hace sentido porque especificamente eso es lo que representa. Hay un detalle, como reemplazamos el `nombre` de nuestra clase con el `nombre` del metodo? Podriamos hacer algo como `nombre = nombre`, pero como que no sabemos muy bien a cual `nombre` nos referimos. Aqui entra `this` al rescate, podemos anteponer `this` a la variable `nombre` de `Persona` para desambiguar a cual nos referimos. Este seria el codigo completo:

```java
class Persona {
    private String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
```

## Referencia por defecto

Hemos visto algunos usos de `this` y `super`. En la siguiente pagina de [Constructores](Constructores) vera comportamientos por defecto del compilador de Java, usando `super` para completar el inicio de las super clases cuando el programador olvida hacerlo. Resulta que el compilador rellena nuestro codigo con un detalle mas, que entendera y produndizara en la seccion de [Lookup](Lookup).

Cuando programamos algo como lo siguiente:

```java
class Persona {
    private int edad;
    // en el constructor iniciamos la variable a algun valor
    ...
    public void print(String cosaImprimir) {
        System.out.println(cosaImprimir);
    }

    public boolean mayor18() {
        return edad >= 18;
    }

    public void imprimirSiMayor18() {
        print(Boolean.toString(mayor18()));
    }
}
```

Es claro que hacer un codigo asi en la vida real no tiene mucha utilidad, pero por brevedad usaremos este ejemplo. Estoy seguro todos entendemos lo que esta haciendo el codigo. El metodo `print` escribe en pantalla lo que le pasan como argumento. El metodo `mayor18` retorna un valor de verdad sobre si la persona es o no mayor de edad. El metodo `imprimirSiMayor18` simplemente combina los 2, llamando el metodo `print` con el resultado en `String` del metodo `mayor18`. Esto es todo entendible para nosotros y no nos genera dudas, pero resulta que el compilador no quiere ambiguedades y, a lo que no le antepongamos `super`, el compilador le pondra `this`. Entonces, el codigo anterior para el compilador se ve de la siguiente manera:

```java
class Persona {
    private int edad;
    // en el constructor iniciamos la variable a algun valor
    ...
    public void print(String cosaImprimir) {
        System.out.println(cosaImprimir);
    }

    public boolean mayor18() {
        return this.edad >= 18;
    }

    public void imprimirSiMayor18() {
        this.print(Boolean.toString(this.mayor18()));
    }
}
```

Esto es parecido a como en Python tienen que anteponer `self` a las variables y metodos de intancia.
