# Inicializando los objetos

Los objetos deben iniciar sus variables e iniciar a sus super clases. En particular, todo objeto es una instancia de la clase `Object`. Es importante entender que un objeto no es solo definido por lo implementado en la clase especificamente, sino que tambien viene definido por su herencia, mas detalles de esto se vera en otra pagina.

Un ejemplo muy burdo de esto podria ser que para que usted naciera (existiera), primero debieron haber nacido sus padres, y asi sucesivamente. Con un objeto es algo similar. Antes de que un objeto se inicie, primero se inician sus clases padres, o super clases.

## Por que se necesitan

Bueno, todas las clases necesitan inicializarse, por lo que todas necesitan de un constructor. Ademas, si tenemos una clase, esto significa que esta es subclase de `Object`, como un hijo no puede nacer sin sus padres, necesitamos inicializarlo tambien. Finalmente, si tenemos variables dentro de la clase, necesitamos inicializarlas en alguna "parte", esta "parte" es un constructor.

## Como se hace

Similar a un metodo, pero con el nombre de la clase como nombre. Consideremos una clase Persona que tiene un `nombre` y `edad`.

```java
class Persona {
    private int edad;
    private String nombre;

    public Persona() {
        ...
    }
}
```

Para llamar usamos el keyword `new`.

```java
Persona unaPersona = new Persona();
```

En caso de que tuvieramos:

```java
class Persona {
    ...
    public Persona(String nombre) {
        ...
    }
}
```

Lo que hicimos antes para crear nuestro objeto ya no funciona. Esto porque no existe un constructor que no reciba parametros. En este caso tendriamos que hacerlo:

```java
Persona unaPersona = new Persona("John");
```

## Multiples constructores

Tener [Overloading](FAQ#overloading) de constructores.

```java
class Persona {
    ...
    public Persona() {
        ...
    }

    public Persona(String nombre) {
        ...
    }

    public Persona(String nombre, int edad) {
        ...
    }
}
```

Aqui podemos hacer cualquiera de las siguientes y todas funcionan:

```java
Persona unaPersona = new Persona();
Persona otraPersona = new Persona("John");
Persona otraOtraPersona = new Persona("Juan", 25);
```

Un constructor representa como iniciamos nuestro objeto, por lo que no queremos dejar ignoradas nuestras variables de `edad` y `nombre`, pero tampoco repetir tanto codigo. Por ejemplo, para que nuestra clase funcione hasta ahora estamos haciendo lo siguiente, considerando valores por defecto de `nombre` como `S/N` y `edad` como 0.

```java
class Persona {
    private int edad;
    private String nombre;

    public Persona() {
        this.edad = 0;
        this.nombre = "S/N";
    }

    public Persona(String nombre) {
        this.edad = 0;
        this.nombre = nombre;
    }

    public Persona(String nombre, int edad) {
        this.edad = edad;
        this.nombre = nombre;
    }
}
```

Podemos hacer mejor que esto, estamos repitiendo codigo super simple, solo estamos asignando variables, y si tuvieramos no solo 2, sino que 100, seria mucho trabajo innecesario. Podemos reutilizar los constructores haciendo que se llamen entre si:

```java
class Persona {
    private int edad;
    private String nombre;

    public Persona() {
        this("S/N", 0);
    }

    public Persona(String nombre) {
        this(nombre, 0);
    }

    public Persona(String nombre, int edad) {
        this.edad = edad;
        this.nombre = nombre;
    }
}
```

Aqui usamos `this` para llamar a otro constructor de la clase, y solo delegamos la tarea de asignar las variables a uno de estos.

## Llamando a la superclase

Como ya hemos dicho, los objetos no estan definidos por si solos, tambien tienen una jerarquia que debe iniciarse cada vez que creamos un objeto que "dependa" de ellos. Para esto usamos `super`. Al igual que `this`, le pasamos parametros correspondientes al constructor en cuestion.

```java
class SerVivo {
    ...
    public SerVivo() {
        ...
    }
}

class Persona extends SerVivo {
    ...
    public Persona() {
        super();
    }
}
```

En este ejemplo tenemos nuestra clase `Persona` que es subclase de `SerVivo` (detalles sobre herencia se explicaran en [Herancia](Herencia)). El constructor de `Persona` esta llamando a `super()`, es decir, el constructor sin argumentos de su superclase, que en este caso corresponde a `SerVivo`.

Considere al siguiente cambio:

```java
class SerVivo {
    ...
    // Ahora SerVivo tiene un constructor con argumentos
    public SerVivo(Especie especie) {
        ...
    }
}

class Persona extends SerVivo {
    ...
    public Persona() {
        super();
    }
}
```

En este caso el programa no compila. Esto porque nuestro constructor de `Persona` esta llamando al constructor sin argumentos de `SerVivo`, pero `SerVivo` no tiene aquel constructor. Para que el programa compile tenemos 2 opciones: agregamos el parametro que el constructor de `SerVivo` espera, o agregamos un constructor sin argumentos en `SerVivo`.

## Iniciales por defecto

Hemos dicho que las subclases deben inicial sus superclases. Esto podemos hacerlo manualmente llamando a `super` como ya hemos visto. Sin embargo, si olvidamos hacerlo, el compilador nos agrega una llamada a `super` sin argumentos. Es decir:

```java
class Persona {
    ...
    public Persona(String nombre, int edad) {
        // aqui el compilador no agrega un super()
        // super();
        this.edad = edad;
        this.nombre = nombre;
    }
}
```

Pero en casos donde hacemos una llamada a `this` esta llamada no se hace, y se le delega a quien no delegue mas llamadas:

```java
class Persona {
    private int edad;
    private String nombre;

    public Persona() {
        // no hay llamada a super
        this("S/N", 0);
    }

    public Persona(String nombre) {
        // no hay llamada a super
        this(nombre, 0);
    }

    public Persona(String nombre, int edad) {
        // se agrega super()
        this.edad = edad;
        this.nombre = nombre;
    }
}
```

En caso de que en la superclase no exista el constructor sin argumentos el programa no compilara. En estos casos debemos manualmente hacer un llamado a `super` con los argumentos necesarios para inicial la superclase.

## Constructor por defecto

Si no agregan un constructor manualmente, el compilador les agrega uno vacio, que solo llama al constructor de la super clase sin argumentos.

```java
class Persona {
}
```

Se convierte en:

```java
class Persona {
    public Persona() {
    }
}
```

Que como vimos, se convierte en:

```java
class Persona {
    public Persona() {
        super();
    }
}
```

## **IMPORTANTE**: Los constructores no se heredan

Considere el siguiente ejemplo:

```java
class SerVivo {
    ...
    public SerVivo() {
        ...
    }
}

class Persona extends SerVivo {
    ...
    public Persona(String nombre) {
        super();
        this.nombre = nombre;
    }
}
```

Aqui tenemos que nuestra `Persona` es tambien un `SerVivo`. `SerVivo` tiene un constructor sin argumentos, mientras `Persona` necesita de un `nombre`. No hay problema con esto. Pero mire el siguiente codigo:

```java
Persona unaPesona = new Persona("Alejandra"); // -> funciona, ningun problema
Persona otraPesona = new Persona(); // -> NO funciona
```

La segunda linea `new Persona()` no funciona, el programa no compilara. La razon es que `Persona` solo tiene el constructor que requiere un argumento. Que `SerVivo` tenga un constructor sin argumentos no tiene nada que ver, ya que los constructores no se heredan.
